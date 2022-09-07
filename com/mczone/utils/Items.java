/*    */ package com.mczone.utils;
/*    */ 
/*    */ import org.bukkit.Material;
/*    */ import org.bukkit.inventory.ItemStack;
/*    */ import org.bukkit.inventory.meta.ItemMeta;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Items
/*    */ {
/*    */   private static ItemStack item;
/*    */   
/*    */   public static ItemStack tier() {
/* 17 */     item = new ItemStack(Material.BLAZE_ROD, 1);
/* 18 */     ItemMeta meta = item.getItemMeta();
/* 19 */     meta.setDisplayName(ChatUtils.format("&6Tier Tool.."));
/* 20 */     item.setItemMeta(meta);
/* 21 */     return item;
/*    */   }
/*    */   
/*    */   public static ItemStack spawn() {
/* 25 */     item = new ItemStack(Material.IRON_AXE, 1);
/* 26 */     ItemMeta meta = item.getItemMeta();
/* 27 */     meta.setDisplayName(ChatUtils.format("&6Spawn Tool.."));
/* 28 */     item.setItemMeta(meta);
/* 29 */     return item;
/*    */   }
/*    */   
/*    */   public static ItemStack spec() {
/* 33 */     item = new ItemStack(Material.FIREWORK, 1);
/* 34 */     ItemMeta meta = item.getItemMeta();
/* 35 */     meta.setDisplayName(ChatUtils.format("&6Spectate.."));
/* 36 */     item.setItemMeta(meta);
/* 37 */     return item;
/*    */   }
/*    */ }


/* Location:              /home/tyler/Downloads/jar files/Hungergames.jar!/com/mczone/utils/Items.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */