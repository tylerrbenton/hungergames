/*    */ package com.mczone.listeners;
/*    */ 
/*    */ import com.mczone.hungergames.GameState;
/*    */ import org.bukkit.event.EventHandler;
/*    */ import org.bukkit.event.Listener;
/*    */ import org.bukkit.event.entity.EntityDamageEvent;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class EntityDamage
/*    */   implements Listener
/*    */ {
/*    */   @EventHandler
/*    */   public void onDamage(EntityDamageEvent e) {
/* 15 */     if (GameState.isState(GameState.LOBBY) || GameState.isState(GameState.ENDGAME))
/* 16 */       e.setCancelled(true); 
/*    */   }
/*    */ }


/* Location:              /home/tyler/Downloads/jar files/Hungergames.jar!/com/mczone/listeners/EntityDamage.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */