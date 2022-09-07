/*    */ package com.mczone.utils;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Time
/*    */ {
/*    */   public String scoreboardTimer(int seconds) {
/* 10 */     return String.format("%2d:%02d", new Object[] { Integer.valueOf(seconds / 60), Integer.valueOf(seconds % 60) });
/*    */   }
/*    */   
/*    */   public int secondsToMinutes(int seconds) {
/* 14 */     return seconds / 60;
/*    */   }
/*    */ }


/* Location:              /home/tyler/Downloads/jar files/Hungergames.jar!/com/mczone/utils/Time.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */