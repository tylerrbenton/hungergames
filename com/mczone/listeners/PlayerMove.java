/*    */ package com.mczone.listeners;
/*    */ 
/*    */ import com.mczone.hungergames.GameHandler;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.event.EventHandler;
/*    */ import org.bukkit.event.Listener;
/*    */ import org.bukkit.event.player.PlayerMoveEvent;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PlayerMove
/*    */   implements Listener
/*    */ {
/*    */   @EventHandler
/*    */   public void onMove(PlayerMoveEvent e) {
/* 17 */     GameHandler gameHandler = new GameHandler();
/*    */     
/* 19 */     Player p = e.getPlayer();
/*    */     
/* 21 */     if (gameHandler.isFrozen())
/*    */     {
/* 23 */       if (e.getTo().getX() != e.getFrom().getX() || e.getTo().getZ() != e.getFrom().getZ())
/* 24 */         e.setTo(e.getFrom()); 
/*    */     }
/*    */   }
/*    */ }


/* Location:              /home/tyler/Downloads/jar files/Hungergames.jar!/com/mczone/listeners/PlayerMove.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */