/*    */ package com.mczone.listeners;
/*    */ 
/*    */ import org.bukkit.event.EventHandler;
/*    */ import org.bukkit.event.Listener;
/*    */ import org.bukkit.event.block.BlockIgniteEvent;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class BlockIgnite
/*    */   implements Listener
/*    */ {
/*    */   @EventHandler
/*    */   public void onIgnite(BlockIgniteEvent e) {
/* 14 */     if (e.getCause() != BlockIgniteEvent.IgniteCause.FLINT_AND_STEEL)
/* 15 */       e.setCancelled(true); 
/*    */   }
/*    */ }


/* Location:              /home/tyler/Downloads/jar files/Hungergames.jar!/com/mczone/listeners/BlockIgnite.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */