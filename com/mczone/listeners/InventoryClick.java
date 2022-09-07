/*    */ package com.mczone.listeners;
/*    */ 
/*    */ import com.mczone.hungergames.GameHandler;
/*    */ import com.mczone.hungergames.GameState;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.event.EventHandler;
/*    */ import org.bukkit.event.Listener;
/*    */ import org.bukkit.event.inventory.InventoryClickEvent;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class InventoryClick
/*    */   implements Listener
/*    */ {
/*    */   @EventHandler
/*    */   public void onClick(InventoryClickEvent e) {
/* 17 */     GameHandler gameHandler = new GameHandler();
/*    */     
/* 19 */     if (!(e.getWhoClicked() instanceof Player)) {
/*    */       return;
/*    */     }
/* 22 */     Player p = (Player)e.getWhoClicked();
/*    */     
/* 24 */     if (GameState.isState(GameState.LOBBY)) {
/*    */       return;
/*    */     }
/*    */     
/* 28 */     if (gameHandler.getSpectators().contains(p.getUniqueId()))
/* 29 */       e.setCancelled(true); 
/*    */   }
/*    */ }


/* Location:              /home/tyler/Downloads/jar files/Hungergames.jar!/com/mczone/listeners/InventoryClick.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */