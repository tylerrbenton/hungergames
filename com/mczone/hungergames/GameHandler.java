/*    */ package com.mczone.hungergames;
/*    */ 
/*    */ import com.mczone.utils.GamePlayer;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import java.util.UUID;
/*    */ import org.bukkit.Location;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class GameHandler
/*    */ {
/*    */   private static String currentArena;
/*    */   private static boolean forceStart = false;
/*    */   private static boolean frozen = false;
/*    */   private static boolean paused = false;
/*    */   private static Location spawn;
/* 24 */   private static List<GamePlayer> players = new ArrayList<>();
/* 25 */   private static List<UUID> spectators = new ArrayList<>();
/* 26 */   private static List<UUID> playersPassed = new ArrayList<>();
/*    */   
/*    */   public String getCurrentArena() {
/* 29 */     return currentArena;
/*    */   }
/*    */   
/*    */   public void setCurrentArena(String name) {
/* 33 */     currentArena = name;
/*    */   }
/*    */   
/*    */   public boolean isForceStart() {
/* 37 */     return forceStart;
/*    */   }
/*    */   
/*    */   public void setForceStart(boolean f) {
/* 41 */     forceStart = f;
/*    */   }
/*    */   
/*    */   public boolean isFrozen() {
/* 45 */     return frozen;
/*    */   }
/*    */   
/*    */   public void setFrozen(boolean f) {
/* 49 */     frozen = f;
/*    */   }
/*    */   
/*    */   public boolean isPaused() {
/* 53 */     return paused;
/*    */   }
/*    */   
/*    */   public void setPaused(boolean p) {
/* 57 */     paused = p;
/*    */   }
/*    */   
/*    */   public List<GamePlayer> getPlayers() {
/* 61 */     return players;
/*    */   }
/*    */   
/*    */   public List<UUID> getSpectators() {
/* 65 */     return spectators;
/*    */   }
/*    */   
/*    */   public List<UUID> getPlayersPassed() {
/* 69 */     return playersPassed;
/*    */   }
/*    */   
/*    */   public Location getSpawn() {
/* 73 */     return spawn;
/*    */   }
/*    */   
/*    */   public void setSpawn(Location l) {
/* 77 */     spawn = l;
/*    */   }
/*    */ }


/* Location:              /home/tyler/Downloads/jar files/Hungergames.jar!/com/mczone/hungergames/GameHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */