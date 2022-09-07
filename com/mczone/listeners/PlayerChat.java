/*    */ package com.mczone.listeners;
/*    */ 
/*    */ import com.mczone.hungergames.GameHandler;
/*    */ import com.mczone.hungergames.GameState;
/*    */ import com.mczone.managers.StatsManager;
/*    */ import com.mczone.utils.ChatUtils;
/*    */ import com.mczone.utils.GamePlayer;
/*    */ import com.mczone.utils.Perms;
/*    */ import java.util.UUID;
/*    */ import org.bukkit.Bukkit;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.event.EventHandler;
/*    */ import org.bukkit.event.Listener;
/*    */ import org.bukkit.event.player.AsyncPlayerChatEvent;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PlayerChat
/*    */   implements Listener
/*    */ {
/*    */   @EventHandler
/*    */   public void onChat(AsyncPlayerChatEvent e) {
/* 26 */     ChatUtils chatUtils = new ChatUtils();
/* 27 */     GameHandler gameHandler = new GameHandler();
/* 28 */     StatsManager statsManager = new StatsManager();
/*    */     
/* 30 */     Player p = e.getPlayer();
/*    */     
/* 32 */     statsManager.getStats(p);
/*    */     
/* 34 */     Integer position = null;
/* 35 */     for (GamePlayer gamePlayer : gameHandler.getPlayers()) {
/* 36 */       if (gamePlayer.getUUID() != p.getUniqueId()) {
/*    */         continue;
/*    */       }
/* 39 */       position = gamePlayer.getPosition();
/*    */     } 
/*    */ 
/*    */ 
/*    */     
/* 44 */     if (p.hasPermission(Perms.owner) || p.hasPermission(Perms.developer) || p.hasPermission(Perms.admin) || p.hasPermission(Perms.srmod) || p.hasPermission(Perms.mod)) {
/* 45 */       if (GameState.isState(GameState.LOBBY)) {
/* 46 */         e.setFormat(String.format(ChatUtils.format("&8&l[&a%d&8&l]%s&8| &b%s"), new Object[] { statsManager.points, chatUtils.colorName(p), e.getMessage() })); return;
/*    */       } 
/* 48 */       if (gameHandler.getSpectators().contains(p.getUniqueId())) {
/* 49 */         for (UUID uuid : gameHandler.getSpectators()) {
/* 50 */           Bukkit.getPlayer(uuid).sendMessage(String.format(ChatUtils.format("&8&l[&a%d&8&l]&4&lSPEC&8|%s&8| &b%s"), new Object[] { statsManager.points, chatUtils.colorName(p), e.getMessage() }));
/*    */         } 
/* 52 */         e.setCancelled(true);
/*    */         return;
/*    */       } 
/* 55 */       e.setFormat(String.format(ChatUtils.format("&8&l[&a%d&8&l]&c%d&8|%s&8| &b%s"), new Object[] { statsManager.points, position, chatUtils.colorName(p), e.getMessage() }));
/*    */ 
/*    */       
/*    */       return;
/*    */     } 
/*    */     
/* 61 */     if (GameState.isState(GameState.LOBBY)) {
/* 62 */       e.setFormat(String.format(ChatUtils.format("&8&l[&a%d&8&l]%s&8| &f%s"), new Object[] { statsManager.points, chatUtils.colorName(p), e.getMessage() }));
/* 63 */     } else if (gameHandler.getSpectators().contains(p.getUniqueId())) {
/* 64 */       for (UUID uuid : gameHandler.getSpectators()) {
/* 65 */         Bukkit.getPlayer(uuid).sendMessage(String.format(ChatUtils.format("&8&l[&a%d&8&l]&4&lSPEC&8|%s&8| &f%s"), new Object[] { statsManager.points, chatUtils.colorName(p), e.getMessage() }));
/*    */       } 
/* 67 */       e.setCancelled(true);
/*    */     } else {
/* 69 */       e.setFormat(String.format(ChatUtils.format("&8&l[&a%d&8&l]&c%d&8|%s&8| &f%s"), new Object[] { statsManager.points, position, chatUtils.colorName(p), e.getMessage() }));
/*    */     } 
/*    */   }
/*    */ }


/* Location:              /home/tyler/Downloads/jar files/Hungergames.jar!/com/mczone/listeners/PlayerChat.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */