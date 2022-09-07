/*    */ package com.mczone.listeners;
/*    */ 
/*    */ import com.mczone.hungergames.GameState;
/*    */ import java.util.HashMap;
/*    */ import java.util.UUID;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.event.EventHandler;
/*    */ import org.bukkit.event.Listener;
/*    */ import org.bukkit.event.entity.EntityDamageByEntityEvent;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class EntityDamageByEntity
/*    */   implements Listener
/*    */ {
/* 20 */   private static HashMap<UUID, UUID> playerDamager = new HashMap<>();
/*    */   
/*    */   @EventHandler
/*    */   public void onDamage(EntityDamageByEntityEvent e) {
/* 24 */     if (GameState.isState(GameState.LOBBY) || GameState.isState(GameState.PREGAME) || GameState.isState(GameState.PREDEATHMATCH)) {
/* 25 */       if (e.getDamager() instanceof Player || e.getDamager() instanceof org.bukkit.entity.Arrow || e.getDamager() instanceof org.bukkit.entity.FishHook) {
/* 26 */         e.setCancelled(true);
/*    */       }
/*    */       
/*    */       return;
/*    */     } 
/* 31 */     if (e.getEntity() instanceof Player && e.getDamager() instanceof Player) {
/* 32 */       Player p = (Player)e.getEntity();
/* 33 */       Player d = (Player)e.getDamager();
/*    */       
/* 35 */       if (playerDamager.get(p.getUniqueId()) != d.getUniqueId()) {
/* 36 */         playerDamager.put(p.getUniqueId(), d.getUniqueId());
/*    */       }
/*    */     } 
/*    */   }
/*    */   
/*    */   static HashMap<UUID, UUID> getPlayerDamager() {
/* 42 */     return playerDamager;
/*    */   }
/*    */ }


/* Location:              /home/tyler/Downloads/jar files/Hungergames.jar!/com/mczone/listeners/EntityDamageByEntity.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */