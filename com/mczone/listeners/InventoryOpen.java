/*    */ package com.mczone.listeners;
/*    */ 
/*    */ import com.mczone.utils.Items;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.event.EventHandler;
/*    */ import org.bukkit.event.Listener;
/*    */ import org.bukkit.event.inventory.InventoryOpenEvent;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class InventoryOpen
/*    */   implements Listener
/*    */ {
/*    */   @EventHandler
/*    */   public void onOpen(InventoryOpenEvent e) {
/* 16 */     if (e.getPlayer() instanceof Player) {
/* 17 */       Player p = (Player)e.getPlayer();
/*    */       
/* 19 */       if (p.getItemInHand().getType() == Items.tier().getType())
/* 20 */         e.setCancelled(true); 
/*    */     } 
/*    */   }
/*    */ }


/* Location:              /home/tyler/Downloads/jar files/Hungergames.jar!/com/mczone/listeners/InventoryOpen.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */