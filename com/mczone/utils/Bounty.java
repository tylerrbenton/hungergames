/*    */ package com.mczone.utils;
/*    */ 
/*    */ import java.util.UUID;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Bounty
/*    */ {
/*    */   private UUID mTarget;
/*    */   private UUID mSender;
/* 12 */   private Integer mAmount = Integer.valueOf(0);
/*    */   
/*    */   public Bounty(UUID target, UUID sender, Integer amount) {
/* 15 */     this.mTarget = target;
/* 16 */     this.mSender = sender;
/* 17 */     this.mAmount = amount;
/*    */   }
/*    */   
/*    */   public UUID getTarget() {
/* 21 */     return this.mTarget;
/*    */   }
/*    */   
/*    */   public UUID getSender() {
/* 25 */     return this.mSender;
/*    */   }
/*    */   
/*    */   public Integer getAmount() {
/* 29 */     return this.mAmount;
/*    */   }
/*    */ }


/* Location:              /home/tyler/Downloads/jar files/Hungergames.jar!/com/mczone/utils/Bounty.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */