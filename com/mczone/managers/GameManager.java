/*    */ package com.mczone.managers;
/*    */ 
/*    */ import com.mczone.hungergames.GameHandler;
/*    */ import com.mczone.utils.GamePlayer;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import java.util.concurrent.ThreadLocalRandom;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class GameManager
/*    */ {
/*    */   public GamePlayer getRandomWinner() {
/* 16 */     GameHandler gameHandler = new GameHandler();
/*    */     
/* 18 */     List<GamePlayer> gPlayers = new ArrayList<>();
/*    */     
/* 20 */     int mostKills = 0;
/* 21 */     for (GamePlayer gamePlayer : gameHandler.getPlayers()) {
/* 22 */       if (gamePlayer.getEnemiesKilled().intValue() < mostKills) {
/*    */         continue;
/*    */       }
/* 25 */       mostKills = gamePlayer.getEnemiesKilled().intValue();
/*    */     } 
/*    */     
/* 28 */     for (GamePlayer gamePlayer : gameHandler.getPlayers()) {
/* 29 */       if (gamePlayer.getEnemiesKilled().intValue() != mostKills) {
/*    */         continue;
/*    */       }
/* 32 */       gPlayers.add(gamePlayer);
/*    */     } 
/* 34 */     return gPlayers.get(ThreadLocalRandom.current().nextInt(0, gPlayers.size()));
/*    */   }
/*    */ }


/* Location:              /home/tyler/Downloads/jar files/Hungergames.jar!/com/mczone/managers/GameManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */