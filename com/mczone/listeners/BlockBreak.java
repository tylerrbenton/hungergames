/*    */ package com.mczone.listeners;
/*    */ 
/*    */ import com.mczone.hungergames.GameState;
/*    */ import org.bukkit.Effect;
/*    */ import org.bukkit.GameMode;
/*    */ import org.bukkit.Material;
/*    */ import org.bukkit.block.Block;
/*    */ import org.bukkit.event.EventHandler;
/*    */ import org.bukkit.event.Listener;
/*    */ import org.bukkit.event.block.BlockBreakEvent;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class BlockBreak
/*    */   implements Listener
/*    */ {
/*    */   @EventHandler
/*    */   public void onBreak(BlockBreakEvent e) {
/* 19 */     Block b = e.getBlock();
/*    */     
/* 21 */     b.getDrops().clear();
/*    */     
/* 23 */     if (e.getPlayer().isOp() && e.getPlayer().getGameMode() == GameMode.CREATIVE) {
/*    */       return;
/*    */     }
/*    */     
/* 27 */     if (GameState.isState(GameState.LOBBY)) {
/* 28 */       b.getWorld().playEffect(b.getLocation().add(0.0D, 1.5D, 0.0D), Effect.SMOKE, 4);
/* 29 */       e.setCancelled(true);
/*    */       
/*    */       return;
/*    */     } 
/* 33 */     if (b.getType() == Material.LONG_GRASS || b.getType() == Material.LEAVES || b.getType() == Material.LEAVES_2 || b
/* 34 */       .getType() == Material.VINE || b.getType() == Material.DOUBLE_PLANT) {
/*    */       return;
/*    */     }
/* 37 */     b.getWorld().playEffect(b.getLocation().add(0.0D, 1.5D, 0.0D), Effect.SMOKE, 4);
/* 38 */     e.setCancelled(true);
/*    */   }
/*    */ }


/* Location:              /home/tyler/Downloads/jar files/Hungergames.jar!/com/mczone/listeners/BlockBreak.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */