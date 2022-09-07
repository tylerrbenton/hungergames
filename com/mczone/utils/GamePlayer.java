/*    */ package com.mczone.utils;
/*    */ 
/*    */ import java.util.UUID;
/*    */ import org.bukkit.Bukkit;
/*    */ import org.bukkit.entity.Player;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class GamePlayer
/*    */ {
/*    */   private boolean isBountied;
/* 18 */   private Integer amount = Integer.valueOf(0);
/* 19 */   private Integer enemiesKilled = Integer.valueOf(0);
/* 20 */   private Integer position = Integer.valueOf(0);
/*    */   private UUID uuid;
/*    */   private String name;
/*    */   
/*    */   public GamePlayer(UUID uuid, String name) {
/* 25 */     this.uuid = uuid;
/* 26 */     this.name = name;
/* 27 */     this.isBountied = false;
/*    */   }
/*    */   
/*    */   public boolean isBountied() {
/* 31 */     return this.isBountied;
/*    */   }
/*    */   
/*    */   public void setBountied(boolean b) {
/* 35 */     this.isBountied = b;
/*    */   }
/*    */   
/*    */   public Integer getAmount() {
/* 39 */     return this.amount;
/*    */   }
/*    */   
/*    */   public void setAmount(Integer amount) {
/* 43 */     this.amount = Integer.valueOf(this.amount.intValue() + amount.intValue());
/*    */   }
/*    */   
/*    */   public Integer getEnemiesKilled() {
/* 47 */     return this.enemiesKilled;
/*    */   }
/*    */   
/*    */   public void setEnemiesKilled(Integer e) {
/* 51 */     this.enemiesKilled = e;
/*    */   }
/*    */   
/*    */   public Integer getPosition() {
/* 55 */     return this.position;
/*    */   }
/*    */   
/*    */   public void setPosition(Integer p) {
/* 59 */     this.position = p;
/*    */   }
/*    */   
/*    */   public UUID getUUID() {
/* 63 */     return this.uuid;
/*    */   }
/*    */   
/*    */   public String getName() {
/* 67 */     return this.name;
/*    */   }
/*    */   
/*    */   public Player getPlayer() {
/* 71 */     return Bukkit.getPlayer(this.uuid);
/*    */   }
/*    */ }


/* Location:              /home/tyler/Downloads/jar files/Hungergames.jar!/com/mczone/utils/GamePlayer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */