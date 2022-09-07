/*    */ package com.mczone.utils;
/*    */ 
/*    */ import org.bukkit.Material;
/*    */ import org.bukkit.inventory.ItemStack;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Item
/*    */ {
/*    */   private int chance;
/*    */   private ItemStack item;
/*    */   
/*    */   public Item(Material material, Integer amount, Integer chance) {
/* 15 */     this.item = new ItemStack(material, amount.intValue());
/*    */     
/* 17 */     if (chance.intValue() != 0 && chance.intValue() <= 100)
/* 18 */     { this.chance = chance.intValue(); }
/* 19 */     else { throw new IllegalArgumentException("Chance must be less than or equal to 100 and more than 0."); }
/*    */   
/*    */   }
/*    */   public Integer getChance() {
/* 23 */     return Integer.valueOf(this.chance);
/*    */   }
/*    */   
/*    */   public ItemStack getItem() {
/* 27 */     return this.item;
/*    */   }
/*    */ }


/* Location:              /home/tyler/Downloads/jar files/Hungergames.jar!/com/mczone/utils/Item.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */