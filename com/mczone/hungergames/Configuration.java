/*    */ package com.mczone.hungergames;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Configuration
/*    */ {
/*  8 */   public final Integer MAXPLAYERS = Integer.valueOf(24);
/*  9 */   public final Integer MINPLAYERS = Integer.valueOf(6);
/*    */   
/* 11 */   private static Integer lobbyTime = Integer.valueOf(120);
/* 12 */   private static Integer pregameTime = Integer.valueOf(30);
/* 13 */   private static Integer ingameTime = Integer.valueOf(1200);
/* 14 */   private static Integer predeathmatchTime = Integer.valueOf(10);
/* 15 */   private static Integer deathmatchTime = Integer.valueOf(180);
/* 16 */   private static Integer endgameTime = Integer.valueOf(10);
/* 17 */   private static Integer cleanupTime = Integer.valueOf(15);
/*    */   
/*    */   public int getLobbyTime() {
/* 20 */     return lobbyTime.intValue();
/*    */   }
/*    */   
/*    */   public void setLobbyTime(int seconds) {
/* 24 */     lobbyTime = Integer.valueOf(seconds);
/*    */   }
/*    */   
/*    */   public int getPregameTime() {
/* 28 */     return pregameTime.intValue();
/*    */   }
/*    */   
/*    */   public int getPredeathmatchTime() {
/* 32 */     return predeathmatchTime.intValue();
/*    */   }
/*    */   
/*    */   public void setPredeathmatchTime(Integer seconds) {
/* 36 */     predeathmatchTime = seconds;
/*    */   }
/*    */   
/*    */   public void setDeathmatchTime(Integer seconds) {
/* 40 */     deathmatchTime = seconds;
/*    */   }
/*    */   
/*    */   public int getDeathmatchTime() {
/* 44 */     return deathmatchTime.intValue();
/*    */   }
/*    */   
/*    */   public int getEndgameTime() {
/* 48 */     return endgameTime.intValue();
/*    */   }
/*    */   
/*    */   public int getCleanupTime() {
/* 52 */     return cleanupTime.intValue();
/*    */   }
/*    */   
/*    */   public void setPregameTime(int seconds) {
/* 56 */     pregameTime = Integer.valueOf(seconds);
/*    */   }
/*    */   
/*    */   public int getIngameTime() {
/* 60 */     return ingameTime.intValue();
/*    */   }
/*    */   
/*    */   public void setIngameTime(int seconds) {
/* 64 */     ingameTime = Integer.valueOf(seconds);
/*    */   }
/*    */   
/*    */   public void setEndgameTime(Integer seconds) {
/* 68 */     endgameTime = seconds;
/*    */   }
/*    */   
/*    */   public void setCleanupTime(Integer seconds) {
/* 72 */     cleanupTime = seconds;
/*    */   }
/*    */ }


/* Location:              /home/tyler/Downloads/jar files/Hungergames.jar!/com/mczone/hungergames/Configuration.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */