/*    */ package com.mczone.listeners;
/*    */ 
/*    */ import org.bukkit.event.EventHandler;
/*    */ import org.bukkit.event.Listener;
/*    */ import org.bukkit.event.entity.CreatureSpawnEvent;
/*    */ import org.bukkit.event.entity.EntitySpawnEvent;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class EntitySpawn
/*    */   implements Listener
/*    */ {
/*    */   @EventHandler
/*    */   public void onSpawn(CreatureSpawnEvent e) {
/* 18 */     e.setCancelled(true);
/*    */   }
/*    */   
/*    */   @EventHandler
/*    */   public void onSpawn(EntitySpawnEvent e) {
/* 23 */     if (e.getEntity().isDead() || e.getEntity() instanceof org.bukkit.entity.Player || e.getEntity() instanceof org.bukkit.entity.Firework) {
/*    */       return;
/*    */     }
/* 26 */     e.setCancelled(true);
/*    */   }
/*    */ }


/* Location:              /home/tyler/Downloads/jar files/Hungergames.jar!/com/mczone/listeners/EntitySpawn.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */