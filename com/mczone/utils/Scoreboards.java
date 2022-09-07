/*     */ package com.mczone.utils;
/*     */ 
/*     */ import com.mczone.hungergames.Configuration;
/*     */ import com.mczone.hungergames.GameHandler;
/*     */ import com.mczone.hungergames.GameState;
/*     */ import java.text.SimpleDateFormat;
/*     */ import java.util.Date;
/*     */ import java.util.TimeZone;
/*     */ import org.bukkit.Bukkit;
/*     */ import org.bukkit.ChatColor;
/*     */ import org.bukkit.entity.Player;
/*     */ import org.bukkit.scoreboard.DisplaySlot;
/*     */ import org.bukkit.scoreboard.Objective;
/*     */ import org.bukkit.scoreboard.Score;
/*     */ import org.bukkit.scoreboard.Scoreboard;
/*     */ import org.bukkit.scoreboard.Team;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Scoreboards
/*     */ {
/*  22 */   private String displayName = null;
/*     */   
/*  24 */   private SimpleDateFormat sdf_1 = new SimpleDateFormat("d MMM yyyy");
/*  25 */   private SimpleDateFormat sdf_2 = new SimpleDateFormat("h:mm a z");
/*  26 */   private SimpleDateFormat sdf_3 = new SimpleDateFormat("MM.dd HH:mmz"); private static Scoreboard scoreboard; private Objective o; private Score you;
/*     */   private Score space_1;
/*     */   private Score time_1;
/*     */   private Score space_2;
/*     */   private Score server;
/*     */   private Score space_3;
/*     */   
/*     */   public Scoreboard setScoreboard(Player player) {
/*  34 */     this.sdf_3.setTimeZone(TimeZone.getTimeZone("Zulu"));
/*     */     
/*  36 */     setDisplayName();
/*     */     
/*  38 */     scoreboard = Bukkit.getScoreboardManager().getNewScoreboard();
/*  39 */     this.o = scoreboard.registerNewObjective("mczone", "dummy");
/*     */     
/*  41 */     this.o.setDisplayName(this.displayName);
/*  42 */     this.o.setDisplaySlot(DisplaySlot.BELOW_NAME);
/*     */     
/*  44 */     this.you = this.o.getScore(ChatUtils.format("&7»&f You"));
/*  45 */     this.you.setScore(13);
/*     */     
/*  47 */     this.name = scoreboard.registerNewTeam("name");
/*  48 */     this.name.addEntry(ChatColor.DARK_AQUA + "");
/*  49 */     this.name.setPrefix(ChatUtils.format("&f" + player.getName()));
/*  50 */     this.o.getScore(ChatColor.DARK_AQUA + "").setScore(12);
/*     */     
/*  52 */     this.space_1 = this.o.getScore(ChatColor.BOLD + "");
/*  53 */     this.space_1.setScore(11);
/*     */     
/*  55 */     this.time_1 = this.o.getScore(ChatUtils.format("&7»&f Time"));
/*  56 */     this.time_1.setScore(10);
/*     */     
/*  58 */     this.date = scoreboard.registerNewTeam("date");
/*  59 */     this.date.addEntry(ChatColor.AQUA + "");
/*  60 */     this.date.setPrefix(ChatUtils.format("&e" + this.sdf_1.format(new Date())));
/*  61 */     this.o.getScore(ChatColor.AQUA + "").setScore(9);
/*     */     
/*  63 */     this.time_2 = scoreboard.registerNewTeam("time_2");
/*  64 */     this.time_2.addEntry(ChatColor.DARK_GREEN + "");
/*  65 */     this.time_2.setPrefix(ChatUtils.format("&e" + this.sdf_2.format(new Date())));
/*  66 */     this.o.getScore(ChatColor.DARK_GREEN + "").setScore(8);
/*     */     
/*  68 */     this.time_3 = scoreboard.registerNewTeam("time_3");
/*  69 */     this.time_3.addEntry(ChatColor.GREEN + "");
/*  70 */     this.time_3.setPrefix(ChatUtils.format("&7" + this.sdf_3.format(new Date())));
/*  71 */     this.o.getScore(ChatColor.GREEN + "").setScore(7);
/*     */     
/*  73 */     this.space_2 = this.o.getScore(ChatColor.BLACK + "");
/*  74 */     this.space_2.setScore(6);
/*     */     
/*  76 */     this.server = this.o.getScore(ChatUtils.format("&7»&f Server"));
/*  77 */     this.server.setScore(5);
/*     */     
/*  79 */     this.serverProxy = scoreboard.registerNewTeam("serverProxy");
/*  80 */     this.serverProxy.addEntry(ChatColor.DARK_PURPLE + "");
/*  81 */     this.serverProxy.setPrefix(ChatUtils.format("&6US &e"));
/*  82 */     this.o.getScore(ChatColor.DARK_PURPLE + "").setScore(4);
/*     */     
/*  84 */     this.space_3 = this.o.getScore(ChatColor.LIGHT_PURPLE + "");
/*  85 */     this.space_3.setScore(3);
/*     */     
/*  87 */     this.players = this.o.getScore(ChatUtils.format("&7»&f Players"));
/*  88 */     this.players.setScore(2);
/*     */     
/*  90 */     this.playing = scoreboard.registerNewTeam("playing");
/*  91 */     this.playing.addEntry(ChatColor.DARK_RED + "");
/*  92 */     this.playing.setPrefix(ChatUtils.format("Playing: " + this.gameHandler.getPlayers().size()));
/*  93 */     this.o.getScore(ChatColor.DARK_RED + "").setScore(1);
/*     */     
/*  95 */     this.mczone = this.o.getScore(ChatUtils.format("&b&lMCZone.us"));
/*  96 */     this.mczone.setScore(0);
/*     */     
/*  98 */     if (!GameState.isState(GameState.LOBBY)) {
/*  99 */       addTeam(scoreboard, this.o);
/*     */     }
/*     */     
/* 102 */     return scoreboard;
/*     */   }
/*     */   private Score players; private Score mczone; private Team name; private Team date; private Team time_2; private Team time_3; private Team serverProxy; private Team playing; private Team watching;
/*     */   void updateScoreboard() {
/* 106 */     for (Player players : Bukkit.getOnlinePlayers()) {
/*     */       
/* 108 */       if (players.getScoreboard() == null) {
/*     */         
/* 110 */         players.setScoreboard(setScoreboard(players));
/*     */         continue;
/*     */       } 
/* 113 */       Scoreboard scoreboard = players.getScoreboard();
/* 114 */       Objective o = scoreboard.getObjective("mczone");
/*     */ 
/*     */       
/* 117 */       if (GameState.isState(GameState.PREGAME) && this.configuration.getPregameTime() == 30) {
/* 118 */         addTeam(scoreboard, o);
/*     */       }
/*     */       
/* 121 */       setDisplayName();
/* 122 */       o.setDisplayName(this.displayName);
/*     */       
/* 124 */       this.sdf_3.setTimeZone(TimeZone.getTimeZone("Zulu"));
/*     */       
/* 126 */       scoreboard.getTeam("date").setPrefix(ChatUtils.format("&e" + this.sdf_1.format(new Date())));
/* 127 */       scoreboard.getTeam("time_2").setPrefix(ChatUtils.format("&e" + this.sdf_2.format(new Date())));
/* 128 */       scoreboard.getTeam("time_3").setPrefix(ChatUtils.format("&7" + this.sdf_3.format(new Date())));
/* 129 */       scoreboard.getTeam("serverProxy").setPrefix(ChatUtils.format("&6US &e"));
/* 130 */       scoreboard.getTeam("playing").setPrefix(ChatUtils.format("Players: " + this.gameHandler.getPlayers().size()));
/*     */       
/* 132 */       if (scoreboard.getTeam("watching") != null) {
/* 133 */         scoreboard.getTeam("watching").setPrefix(ChatUtils.format("Watching: " + this.gameHandler.getSpectators().size()));
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void addTeam(Scoreboard scoreboard, Objective o) {
/* 141 */     for (String s : scoreboard.getEntries()) {
/* 142 */       if (o.getScore(s).getScore() > 0) {
/* 143 */         o.getScore(s).setScore(o.getScore(s).getScore() + 1);
/*     */       }
/*     */     } 
/*     */     
/* 147 */     if (scoreboard.getTeam("watching") == null) {
/* 148 */       this.watching = scoreboard.registerNewTeam("watching");
/*     */     }
/* 150 */     this.watching.addEntry(ChatColor.RED + "");
/* 151 */     this.watching.setPrefix(ChatUtils.format("Watching: " + this.gameHandler.getSpectators().size()));
/* 152 */     o.getScore(ChatColor.RED + "").setScore(1);
/*     */   }
/*     */   
/*     */   private void setDisplayName() {
/* 156 */     if (GameState.isState(GameState.LOBBY)) {
/* 157 */       this.displayName = ChatUtils.format("&aLobby&c " + this.time.scoreboardTimer(this.configuration.getLobbyTime()));
/*     */       return;
/*     */     } 
/* 160 */     if (GameState.isState(GameState.PREGAME)) {
/* 161 */       this.displayName = ChatUtils.format("&aPreGame&c " + this.time.scoreboardTimer(this.configuration.getPregameTime()));
/*     */       return;
/*     */     } 
/* 164 */     if (GameState.isState(GameState.INGAME)) {
/* 165 */       this.displayName = ChatUtils.format("&aLiveGame&c " + this.time.scoreboardTimer(this.configuration.getIngameTime()));
/*     */       return;
/*     */     } 
/* 168 */     if (GameState.isState(GameState.PREDEATHMATCH)) {
/* 169 */       this.displayName = ChatUtils.format("&aPreDeathmatch&c " + this.time.scoreboardTimer(this.configuration.getPredeathmatchTime()));
/*     */     }
/* 171 */     if (GameState.isState(GameState.DEATHMATCH)) {
/* 172 */       this.displayName = ChatUtils.format("&aDeathmatch&c " + this.time.scoreboardTimer(this.configuration.getDeathmatchTime()));
/*     */       return;
/*     */     } 
/* 175 */     if (GameState.isState(GameState.ENDGAME)) {
/* 176 */       this.displayName = ChatUtils.format("&aEndGame&c " + this.time.scoreboardTimer(this.configuration.getEndgameTime()));
/*     */     }
/* 178 */     if (GameState.isState(GameState.ROLLBACK)) {
/* 179 */       this.displayName = ChatUtils.format("&aCleanup&c " + this.time.scoreboardTimer(this.configuration.getCleanupTime()));
/*     */     }
/*     */   }
/*     */   
/* 183 */   private BungeeCord bungeeCord = new BungeeCord();
/* 184 */   private GameHandler gameHandler = new GameHandler();
/* 185 */   private Configuration configuration = new Configuration();
/* 186 */   private Time time = new Time();
/*     */ }


/* Location:              /home/tyler/Downloads/jar files/Hungergames.jar!/com/mczone/utils/Scoreboards.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */