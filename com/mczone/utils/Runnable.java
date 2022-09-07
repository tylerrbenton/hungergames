/*     */ package com.mczone.utils;
/*     */ 
/*     */ import com.mczone.hungergames.Configuration;
/*     */ import com.mczone.hungergames.GameHandler;
/*     */ import com.mczone.hungergames.GameState;
/*     */ import com.mczone.hungergames.Hungergames;
/*     */ import com.mczone.listeners.PlayerDeath;
/*     */ import com.mczone.managers.ChestManager;
/*     */ import com.mczone.managers.GameManager;
/*     */ import com.mczone.managers.MapManager;
/*     */ import com.mczone.managers.SpawnManager;
/*     */ import com.mczone.managers.StatsManager;
/*     */ import com.mczone.managers.VotingManager;
/*     */ import java.util.UUID;
/*     */ import org.bukkit.Bukkit;
/*     */ import org.bukkit.entity.Player;
/*     */ import org.bukkit.plugin.Plugin;
/*     */ import org.bukkit.scheduler.BukkitRunnable;
/*     */ 
/*     */ public class Runnable
/*     */ {
/*     */   public Runnable() {
/*  23 */     final Announce announce = new Announce();
/*  24 */     final BungeeCord bungeeCord = new BungeeCord();
/*  25 */     final ChatUtils chatUtils = new ChatUtils();
/*  26 */     final ChestManager chestManager = new ChestManager();
/*  27 */     final Configuration configuration = new Configuration();
/*  28 */     final GameHandler gameHandler = new GameHandler();
/*  29 */     final GameManager gameManager = new GameManager();
/*  30 */     final Fireworks fireworks = new Fireworks();
/*  31 */     PlayerDeath playerDeath = new PlayerDeath();
/*  32 */     final Scoreboards scoreboards = new Scoreboards();
/*  33 */     final SpawnManager spawnManager = new SpawnManager();
/*  34 */     final StatsManager statsManager = new StatsManager();
/*  35 */     final VotingManager votingManager = new VotingManager();
/*  36 */     final MapManager mapManager = new MapManager();
/*  37 */     final Messages msgs = new Messages();
/*     */     
/*  39 */     (new BukkitRunnable()
/*     */       {
/*     */         public void run()
/*     */         {
/*  43 */           scoreboards.updateScoreboard();
/*     */           
/*  45 */           if (gameHandler.isPaused()) {
/*     */             return;
/*     */           }
/*     */           
/*  49 */           if (GameState.isState(GameState.LOBBY)) {
/*     */             
/*  51 */             if (configuration.getLobbyTime() <= 10 && (
/*  52 */               gameHandler.getPlayers().size() >= configuration.MINPLAYERS.intValue() || gameHandler.isForceStart())) {
/*  53 */               announce.announceSecondsTilLobbyEnds(configuration.getLobbyTime());
/*     */             }
/*     */ 
/*     */             
/*  57 */             if (configuration.getLobbyTime() == 120 || configuration.getLobbyTime() == 90 || configuration.getLobbyTime() == 60 || configuration.getLobbyTime() == 30) {
/*  58 */               announce.announceVotes();
/*     */             }
/*     */             
/*  61 */             if (configuration.getLobbyTime() == 0) {
/*  62 */               if (gameHandler.getPlayers().size() < configuration.MINPLAYERS.intValue() && !gameHandler.isForceStart()) {
/*  63 */                 announce.announceVotes();
/*  64 */                 announce.announceNotEnoughPlayers(configuration.MINPLAYERS.intValue() - gameHandler.getPlayers().size());
/*  65 */                 configuration.setLobbyTime(120);
/*     */                 return;
/*     */               } 
/*  68 */               votingManager.chooseMap();
/*  69 */               mapManager.loadMap(votingManager.getMapName());
/*  70 */               spawnManager.addSpawns();
/*  71 */               spawnManager.warpPlayersForIngame();
/*  72 */               gameHandler.setFrozen(true);
/*  73 */               GameState.setCurrentState(GameState.PREGAME);
/*     */             } 
/*  75 */             configuration.setLobbyTime(configuration.getLobbyTime() - 1);
/*     */           } 
/*     */           
/*  78 */           if (GameState.isState(GameState.PREGAME)) {
/*  79 */             if (configuration.getPregameTime() == 30) {
/*  80 */               for (GamePlayer gamePlayer : gameHandler.getPlayers()) {
/*  81 */                 statsManager.update("UPDATE stats SET games_played = games_played + 1 WHERE uuid = ?", Bukkit.getPlayer(gamePlayer.getUUID()));
/*     */               }
/*  83 */               scoreboards.updateScoreboard();
/*  84 */               mapManager.setDefaults();
/*  85 */               ChatUtils.announce(msgs.mapCredits(votingManager.getMapName().replace('_', ' ').trim(), votingManager.getMapAuthor(), votingManager.getMapDownload()), Boolean.valueOf(false), Boolean.valueOf(true));
/*     */             } 
/*     */             
/*  88 */             if (configuration.getPregameTime() == 30 || configuration.getPregameTime() == 10 || configuration.getPregameTime() <= 5) {
/*  89 */               announce.announceSecondsTilGameStart(configuration.getPregameTime());
/*     */             }
/*     */             
/*  92 */             if (configuration.getPregameTime() == 30) {
/*  93 */               mapManager.setDefaults();
/*     */             }
/*     */             
/*  96 */             if (configuration.getPregameTime() == 0) {
/*  97 */               gameHandler.setFrozen(false);
/*  98 */               chestManager.addChests();
/*  99 */               chestManager.setEnderChests();
/* 100 */               GameState.setCurrentState(GameState.INGAME);
/*     */             } 
/* 102 */             configuration.setPregameTime(configuration.getPregameTime() - 1);
/*     */           } 
/*     */           
/* 105 */           if (GameState.isState(GameState.INGAME)) {
/*     */ 
/*     */             
/* 108 */             if (configuration.getIngameTime() <= 1800) {
/* 109 */               announce.announceMinutesTilDeathmatch(configuration.getIngameTime() / 60);
/*     */             }
/*     */             
/* 112 */             if (configuration.getIngameTime() == 1020) {
/* 113 */               chestManager.refillChests();
/* 114 */               StringBuilder passed = new StringBuilder();
/* 115 */               for (UUID uuid : gameHandler.getPlayersPassed()) {
/* 116 */                 passed.append(chatUtils.colorName(Bukkit.getPlayer(uuid))).append("&f, ");
/*     */               }
/* 118 */               ChatUtils.announce(msgs.chestsRestocked(passed.toString().trim()), Boolean.valueOf(false), Boolean.valueOf(true));
/*     */             } 
/*     */ 
/*     */             
/* 122 */             if (gameHandler.getPlayers().size() <= 3 && gameHandler.getPlayers().size() != 1) {
/* 123 */               if (configuration.getIngameTime() > 60) {
/* 124 */                 configuration.setIngameTime(60);
/*     */               }
/* 126 */               if (configuration.getIngameTime() == 0) {
/* 127 */                 spawnManager.warpPlayersForDeathmatch();
/* 128 */                 gameHandler.setFrozen(true);
/* 129 */                 GameState.setCurrentState(GameState.PREDEATHMATCH);
/*     */               } 
/* 131 */             } else if (gameHandler.getPlayers().size() == 1) {
/* 132 */               GameState.setCurrentState(GameState.ENDGAME);
/*     */             } 
/*     */           } 
/* 135 */           configuration.setIngameTime(configuration.getIngameTime() - 1);
/*     */           
/* 137 */           if (GameState.isState(GameState.PREDEATHMATCH)) {
/*     */             
/* 139 */             if (configuration.getPredeathmatchTime() == 10) {
/* 140 */               for (GamePlayer gamePlayer : gameHandler.getPlayers()) {
/* 141 */                 statsManager.update("UPDATE stats SET deathmatches_played = deathmatches_played + 1 WHERE uuid = ?", Bukkit.getPlayer(gamePlayer.getUUID()));
/*     */               }
/* 143 */               announce.announceLetPlayersLoadMap(Integer.valueOf(configuration.getPredeathmatchTime()));
/*     */             } 
/*     */ 
/*     */             
/* 147 */             if (configuration.getPredeathmatchTime() <= 5 && configuration.getPredeathmatchTime() != 0) {
/* 148 */               announce.announceSecondsTilDeathmatch(Integer.valueOf(configuration.getPredeathmatchTime()));
/*     */             }
/*     */ 
/*     */             
/* 152 */             if (configuration.getPredeathmatchTime() == 0) {
/* 153 */               gameHandler.setFrozen(false);
/* 154 */               announce.announceFightTilDeath();
/* 155 */               GameState.setCurrentState(GameState.DEATHMATCH);
/*     */             } 
/* 157 */             configuration.setPredeathmatchTime(Integer.valueOf(configuration.getPredeathmatchTime() - 1));
/*     */           } 
/*     */           
/* 160 */           if (GameState.isState(GameState.DEATHMATCH)) {
/*     */             
/* 162 */             if (configuration.getDeathmatchTime() <= 180) {
/* 163 */               announce.announceMinutesTilDeathmatchEnd();
/*     */             }
/*     */             
/* 166 */             if (gameHandler.getPlayers().size() == 1) {
/* 167 */               GameState.setCurrentState(GameState.ENDGAME);
/*     */             }
/*     */             
/* 170 */             if (configuration.getDeathmatchTime() == 0) {
/* 171 */               GameState.setCurrentState(GameState.ENDGAME);
/*     */             }
/* 173 */             configuration.setDeathmatchTime(Integer.valueOf(configuration.getDeathmatchTime() - 1));
/*     */           } 
/*     */           
/* 176 */           if (GameState.isState(GameState.ENDGAME)) {
/*     */             
/* 178 */             if (gameHandler.getPlayers().size() > 3) {
/*     */               return;
/*     */             }
/*     */             
/* 182 */             if (configuration.getEndgameTime() == 10) {
/* 183 */               if (gameHandler.getPlayers().size() >= 2) {
/* 184 */                 ChatUtils.announce(msgs.winner(chatUtils.colorName(gameManager.getRandomWinner().getPlayer())), Boolean.valueOf(false), Boolean.valueOf(true));
/* 185 */                 fireworks.playFireworks();
/* 186 */                 mapManager.setDefaults();
/*     */               } 
/*     */               
/* 189 */               if (gameHandler.getPlayers().size() == 1) {
/* 190 */                 ChatUtils.announce(msgs.winner(chatUtils.colorName(((GamePlayer)gameHandler.getPlayers().get(0)).getPlayer())), Boolean.valueOf(false), Boolean.valueOf(true));
/* 191 */                 fireworks.playFireworks();
/* 192 */                 mapManager.setDefaults();
/*     */               } 
/*     */             } 
/*     */ 
/*     */             
/* 197 */             if (configuration.getEndgameTime() == 0) {
/* 198 */               for (Player everyone : Bukkit.getOnlinePlayers()) {
/* 199 */                 bungeeCord.connectToHub(everyone);
/*     */               }
/* 201 */               GameState.setCurrentState(GameState.ROLLBACK);
/*     */             } 
/* 203 */             configuration.setEndgameTime(Integer.valueOf(configuration.getEndgameTime() - 1));
/*     */           } 
/*     */           
/* 206 */           if (GameState.isState(GameState.ROLLBACK)) {
/* 207 */             if (configuration.getCleanupTime() == 0) {
/* 208 */               mapManager.unloadMap(votingManager.getMapName());
/* 209 */               Bukkit.getServer().shutdown();
/*     */             } 
/* 211 */             configuration.setCleanupTime(Integer.valueOf(configuration.getCleanupTime() - 1));
/*     */           } 
/*     */         }
/* 214 */       }).runTaskTimer((Plugin)Hungergames.getHungergames(), 0L, 20L);
/*     */   }
/*     */ }


/* Location:              /home/tyler/Downloads/jar files/Hungergames.jar!/com/mczone/utils/Runnable.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */