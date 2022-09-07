/*    */ package com.mczone.listeners;
/*    */ 
/*    */ import com.mczone.hungergames.GameHandler;
/*    */ import com.mczone.hungergames.GameState;
/*    */ import com.mczone.managers.StatsManager;
/*    */ import com.mczone.utils.ChatUtils;
/*    */ import com.mczone.utils.GamePlayer;
/*    */ import com.mczone.utils.Messages;
/*    */ import org.bukkit.Bukkit;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.event.EventHandler;
/*    */ import org.bukkit.event.Listener;
/*    */ import org.bukkit.event.player.PlayerQuitEvent;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PlayerQuit
/*    */   implements Listener
/*    */ {
/*    */   @EventHandler
/*    */   public void onQuit(PlayerQuitEvent e) {
/* 26 */     ChatUtils chatUtils = new ChatUtils();
/* 27 */     GameHandler gameHandler = new GameHandler();
/* 28 */     Messages msgs = new Messages();
/* 29 */     StatsManager statsManager = new StatsManager();
/*    */     
/* 31 */     Player p = e.getPlayer();
/*    */     
/* 33 */     e.setQuitMessage(null);
/* 34 */     if (!GameState.isState(GameState.LOBBY));
/*    */ 
/*    */     
/* 37 */     if (GameState.isState(GameState.LOBBY) || GameState.isState(GameState.ENDGAME) || GameState.isState(GameState.ROLLBACK)) {
/* 38 */       for (Integer integer = Integer.valueOf(0); integer.intValue() < gameHandler.getPlayers().size(); integer1 = integer, integer2 = integer = Integer.valueOf(integer.intValue() + 1)) {
/* 39 */         Integer integer1; Integer integer2; if (((GamePlayer)gameHandler.getPlayers().get(integer.intValue())).getUUID() == p.getUniqueId()) {
/*    */           
/* 41 */           gameHandler.getPlayers().remove(gameHandler.getPlayers().get(integer.intValue()));
/* 42 */           ChatUtils.announce(String.format(ChatUtils.format("&2%s&6 has left&8."), new Object[] { chatUtils.colorName(p) }), Boolean.valueOf(false), Boolean.valueOf(true));
/*    */           
/*    */           break;
/*    */         } 
/*    */       } 
/*    */       
/*    */       return;
/*    */     } 
/* 50 */     Integer points = Integer.valueOf(statsManager.getPoints(p).intValue() / 10);
/* 51 */     if (EntityDamageByEntity.getPlayerDamager().containsKey(p.getUniqueId())) {
/* 52 */       statsManager.addPoints(points, Bukkit.getPlayer(EntityDamageByEntity.getPlayerDamager().get(p.getUniqueId())));
/*    */     }
/* 54 */     statsManager.removePoints(points, p);
/*    */     
/*    */     Integer counter;
/* 57 */     for (counter = Integer.valueOf(0); counter.intValue() < gameHandler.getPlayers().size(); ) {
/* 58 */       if (((GamePlayer)gameHandler.getPlayers().get(counter.intValue())).getUUID() != p.getUniqueId()) {
/*    */         Integer integer1 = counter, integer2 = counter = Integer.valueOf(counter.intValue() + 1); continue;
/*    */       } 
/* 61 */       gameHandler.getPlayers().remove(gameHandler.getPlayers().get(counter.intValue()));
/*    */     } 
/*    */ 
/*    */ 
/*    */     
/* 66 */     for (counter = Integer.valueOf(0); counter.intValue() < gameHandler.getSpectators().size(); ) {
/* 67 */       if (gameHandler.getSpectators().get(counter.intValue()) != p.getUniqueId()) {
/*    */         Integer integer1 = counter, integer2 = counter = Integer.valueOf(counter.intValue() + 1); continue;
/*    */       } 
/* 70 */       gameHandler.getSpectators().remove(gameHandler.getSpectators().get(counter.intValue()));
/*    */     } 
/*    */ 
/*    */     
/* 74 */     if (!GameState.isState(GameState.PREGAME) || !GameState.isState(GameState.DEATHMATCH)) {
/* 75 */       ChatUtils.announce(msgs.tributesRemaining(gameHandler.getPlayers().size()), Boolean.valueOf(false), Boolean.valueOf(true));
/* 76 */       ChatUtils.announce(msgs.specsWatching(gameHandler.getSpectators().size()), Boolean.valueOf(false), Boolean.valueOf(true));
/*    */     } 
/*    */     
/* 79 */     if (EntityDamageByEntity.getPlayerDamager().containsKey(p.getUniqueId())) {
/* 80 */       Bukkit.getPlayer(EntityDamageByEntity.getPlayerDamager().get(p.getUniqueId())).sendMessage(msgs.pointsGainedForKill(points.intValue(), p.getName()));
/*    */     }
/*    */     
/* 83 */     if (!gameHandler.getSpectators().contains(p.getUniqueId())) {
/* 84 */       p.getWorld().strikeLightningEffect(p.getLocation());
/* 85 */       ChatUtils.announce(String.format(ChatUtils.format("&2%s&6 has left&8."), new Object[] { chatUtils.colorName(p) }), Boolean.valueOf(true), Boolean.valueOf(true));
/*    */     } 
/*    */   }
/*    */ }


/* Location:              /home/tyler/Downloads/jar files/Hungergames.jar!/com/mczone/listeners/PlayerQuit.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */