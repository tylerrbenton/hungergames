/*    */ package com.mczone.listeners;
/*    */ 
/*    */ import com.mczone.hungergames.GameHandler;
/*    */ import com.mczone.hungergames.GameState;
/*    */ import com.mczone.managers.StatsManager;
/*    */ import com.mczone.utils.ChatUtils;
/*    */ import com.mczone.utils.GamePlayer;
/*    */ import com.mczone.utils.Scoreboards;
/*    */ import org.bukkit.Bukkit;
/*    */ import org.bukkit.GameMode;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.event.EventHandler;
/*    */ import org.bukkit.event.Listener;
/*    */ import org.bukkit.event.player.PlayerJoinEvent;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PlayerJoin
/*    */   implements Listener
/*    */ {
/*    */   @EventHandler
/*    */   public void onJoin(PlayerJoinEvent e) {
/* 27 */     ChatUtils chatUtils = new ChatUtils();
/* 28 */     GameHandler gameHandler = new GameHandler();
/* 29 */     Scoreboards scoreboards = new Scoreboards();
/*    */     
/* 31 */     Player p = e.getPlayer();
/* 32 */     p.setScoreboard(scoreboards.setScoreboard(p));
/* 33 */     clearInvetory(p);
/*    */     
/* 35 */     e.setJoinMessage(null);
/*    */     
/* 37 */     if (!this.statsManager.hasData(p)) {
/* 38 */       this.statsManager.addData(p);
/*    */     }
/*    */     
/* 41 */     if (GameState.isState(GameState.LOBBY)) {
/* 42 */       p.setGameMode(GameMode.SURVIVAL);
/* 43 */       p.setFoodLevel(20);
/*    */       
/* 45 */       p.teleport(gameHandler.getSpawn());
/* 46 */       ChatUtils.announce(String.format(ChatUtils.format("&2%s&6 has joined&8."), new Object[] { chatUtils.colorName(p) }), Boolean.valueOf(false), Boolean.valueOf(true));
/* 47 */       gameHandler.getPlayers().add(new GamePlayer(p.getUniqueId(), p.getName()));
/*    */       
/*    */       return;
/*    */     } 
/* 51 */     gameHandler.getSpectators().add(p.getUniqueId());
/* 52 */     p.setGameMode(GameMode.SPECTATOR);
/*    */     
/* 54 */     for (GamePlayer gamePlayer : gameHandler.getPlayers()) {
/* 55 */       Bukkit.getPlayer(gamePlayer.getUUID()).hidePlayer(p);
/*    */     }
/*    */   }
/*    */   
/*    */   private void clearInvetory(Player p) {
/* 60 */     p.getInventory().clear();
/* 61 */     p.getInventory().setArmorContents(null);
/*    */   }
/*    */   
/* 64 */   private StatsManager statsManager = new StatsManager();
/*    */ }


/* Location:              /home/tyler/Downloads/jar files/Hungergames.jar!/com/mczone/listeners/PlayerJoin.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */