/*    */ package com.mczone.listeners;
/*    */ 
/*    */ import com.mczone.hungergames.GameState;
/*    */ import com.mczone.utils.Items;
/*    */ import com.mczone.utils.Messages;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.event.EventHandler;
/*    */ import org.bukkit.event.Listener;
/*    */ import org.bukkit.event.player.PlayerRespawnEvent;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PlayerRespawn
/*    */   implements Listener
/*    */ {
/*    */   @EventHandler
/*    */   public void onRespawn(PlayerRespawnEvent e) {
/* 21 */     Messages msgs = new Messages();
/*    */     
/* 23 */     Player p = e.getPlayer();
/*    */     
/* 25 */     if (GameState.isState(GameState.LOBBY)) {
/*    */       return;
/*    */     }
/* 28 */     if (!PlayerDeath.getDeaths().containsKey(p.getUniqueId())) {
/*    */       return;
/*    */     }
/* 31 */     e.setRespawnLocation(PlayerDeath.getDeaths().get(p.getUniqueId()));
/* 32 */     p.getInventory().setItem(0, Items.spec());
/* 33 */     p.sendMessage(msgs.eliminated());
/* 34 */     p.sendMessage(msgs.youreAbleToSpec());
/* 35 */     PlayerDeath.getDeaths().remove(p.getUniqueId());
/*    */   }
/*    */ }


/* Location:              /home/tyler/Downloads/jar files/Hungergames.jar!/com/mczone/listeners/PlayerRespawn.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */