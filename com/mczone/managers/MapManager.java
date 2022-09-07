/*    */ package com.mczone.managers;
/*    */ 
/*    */ import com.mczone.configs.Arenas;
/*    */ import com.mczone.configs.Config;
/*    */ import com.mczone.hungergames.GameHandler;
/*    */ import com.mczone.hungergames.GameState;
/*    */ import com.mczone.hungergames.Hungergames;
/*    */ import com.mczone.utils.Messages;
/*    */ import java.io.File;
/*    */ import org.bukkit.Bukkit;
/*    */ import org.bukkit.Difficulty;
/*    */ import org.bukkit.Location;
/*    */ import org.bukkit.World;
/*    */ import org.bukkit.WorldCreator;
/*    */ import org.bukkit.entity.Entity;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class MapManager
/*    */ {
/*    */   public boolean doesMapExist(String mName) {
/* 23 */     File worldFolder = new File(Bukkit.getWorldContainer().getParent(), mName);
/*    */     
/* 25 */     if (worldFolder.isDirectory()) {
/* 26 */       return true;
/*    */     }
/* 28 */     return false;
/*    */   }
/*    */ 
/*    */   
/*    */   public void loadMap(String mName) {
/* 33 */     World w = Bukkit.createWorld(new WorldCreator(mName));
/* 34 */     w.setAutoSave(false);
/*    */   }
/*    */ 
/*    */   
/*    */   public void unloadMap(String mName) {
/* 39 */     Bukkit.unloadWorld(mName, false);
/*    */   }
/*    */ 
/*    */   
/*    */   public void loadSpawn() {
/* 44 */     Config config = new Config();
/* 45 */     GameHandler gameHandler = new GameHandler();
/* 46 */     Messages msgs = new Messages();
/*    */     
/* 48 */     String mName = config.getConfig().getString("config.spawn.world");
/*    */     
/* 50 */     if (mName == null) {
/* 51 */       throw new NullPointerException(msgs.cannotLoadMap());
/*    */     }
/*    */     
/* 54 */     if (!doesMapExist(mName)) {
/* 55 */       throw new NullPointerException(msgs.cannotLoadMap(mName));
/*    */     }
/*    */     
/* 58 */     if (Hungergames.getHungergames().getServer().getWorld(mName) == null) {
/* 59 */       loadMap(mName);
/*    */     }
/*    */     
/* 62 */     String[] loc = config.getConfig().getString("config.spawn.location").split(", ");
/*    */ 
/*    */ 
/*    */     
/* 66 */     Location spawn = new Location(Hungergames.getHungergames().getServer().getWorld(config.getConfig().getString("config.spawn.world")), Double.parseDouble(loc[0].replaceAll("[^0-9.-]", "")), Double.parseDouble(loc[1].replaceAll("[^0-9.-]", "")), Double.parseDouble(loc[2].replaceAll("[^0-9.-]", "")), Float.parseFloat(loc[3].replaceAll("[^0-9.-]", "")), Float.parseFloat(loc[4].replaceAll("[^0-9.-]", "")));
/* 67 */     gameHandler.setSpawn(spawn);
/*    */     
/* 69 */     Bukkit.getWorld(config.getConfig().getString("config.spawn.world")).setDifficulty(Difficulty.PEACEFUL);
/*    */   }
/*    */ 
/*    */   
/*    */   public void setDefaults() {
/* 74 */     Arenas arenas = new Arenas();
/* 75 */     VotingManager votingManager = new VotingManager();
/*    */     
/* 77 */     for (Entity entity : Bukkit.getWorld(votingManager.getMapName()).getEntities()) {
/* 78 */       if (entity.isDead() || entity instanceof org.bukkit.entity.Player || entity instanceof org.bukkit.entity.Firework) {
/*    */         continue;
/*    */       }
/* 81 */       entity.remove();
/*    */     } 
/*    */     
/* 84 */     if (GameState.isState(GameState.PREGAME)) {
/* 85 */       long mTime = arenas.getArenasConfig().getLong(String.format("arenas.%s.time", new Object[] { votingManager.getArenaName() }));
/* 86 */       boolean mStorm = arenas.getArenasConfig().getBoolean(String.format("arenas.%s.storm", new Object[] { votingManager.getArenaName() }));
/*    */       
/* 88 */       Bukkit.getWorld(votingManager.getMapName()).setTime(mTime);
/* 89 */       if (mStorm) {
/* 90 */         Bukkit.getWorld(votingManager.getMapName()).setStorm(true);
/*    */       } else {
/* 92 */         Bukkit.getWorld(votingManager.getMapName()).setStorm(false);
/*    */       } 
/*    */       return;
/*    */     } 
/* 96 */     if (GameState.isState(GameState.ENDGAME))
/* 97 */       Bukkit.getWorld(votingManager.getMapName()).setTime(18000L); 
/*    */   }
/*    */ }


/* Location:              /home/tyler/Downloads/jar files/Hungergames.jar!/com/mczone/managers/MapManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */