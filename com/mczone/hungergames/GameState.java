/*    */ package com.mczone.hungergames;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public enum GameState
/*    */ {
/*  8 */   LOBBY(true), PREGAME(false), INGAME(true), PREDEATHMATCH(false), DEATHMATCH(true), ENDGAME(false), ROLLBACK(false);
/*    */   
/*    */   private static GameState currentState;
/*    */   
/*    */   private boolean joinable;
/*    */   
/*    */   GameState(boolean joinable) {
/* 15 */     this.joinable = joinable;
/*    */   }
/*    */   
/*    */   public static GameState getState() {
/* 19 */     return currentState;
/*    */   }
/*    */   
/*    */   public static void setCurrentState(GameState state) {
/* 23 */     currentState = state;
/*    */   }
/*    */   
/*    */   public static boolean isState(GameState state) {
/* 27 */     return (currentState == state);
/*    */   }
/*    */   
/*    */   public boolean isJoinable() {
/* 31 */     return this.joinable;
/*    */   }
/*    */ }


/* Location:              /home/tyler/Downloads/jar files/Hungergames.jar!/com/mczone/hungergames/GameState.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */