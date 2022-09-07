/*    */ package com.mczone.listeners;
/*    */ 
/*    */ import com.mczone.hungergames.GameState;
/*    */ import com.mczone.utils.Messages;
/*    */ import org.bukkit.event.EventHandler;
/*    */ import org.bukkit.event.Listener;
/*    */ import org.bukkit.event.player.AsyncPlayerPreLoginEvent;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PlayerPreLogin
/*    */   implements Listener
/*    */ {
/*    */   @EventHandler
/*    */   public void onPreLogin(AsyncPlayerPreLoginEvent e) {
/* 16 */     Messages msgs = new Messages();
/*    */     
/* 18 */     if (!GameState.getState().isJoinable())
/* 19 */       e.disallow(AsyncPlayerPreLoginEvent.Result.KICK_FULL, msgs.cannotJoin()); 
/*    */   }
/*    */ }


/* Location:              /home/tyler/Downloads/jar files/Hungergames.jar!/com/mczone/listeners/PlayerPreLogin.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */