/*     */ package com.mczone.managers;
/*     */ 
/*     */ import com.mczone.configs.Arenas;
/*     */ import com.mczone.hungergames.GameHandler;
/*     */ import com.mczone.utils.GamePlayer;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import org.bukkit.Bukkit;
/*     */ import org.bukkit.Location;
/*     */ import org.bukkit.World;
/*     */ import org.bukkit.entity.Player;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SpawnManager
/*     */ {
/*  20 */   private static HashMap<Integer, String> spawns = new HashMap<>();
/*     */   
/*  22 */   private static List<Location> locations = new ArrayList<>();
/*     */ 
/*     */   
/*     */   public void addSpawn(Integer spawnID, Player player) {
/*  26 */     String loc = String.format("X:%.2f, Y:%.2f, Z:%.2f, Yaw:%.0f, Pitch:%.0f", new Object[] { Double.valueOf(player.getLocation().getBlockX() + 0.5D), Double.valueOf(player.getLocation().getY()), 
/*  27 */           Double.valueOf(player.getLocation().getBlockZ() + 0.5D), Float.valueOf(player.getLocation().getYaw()), Float.valueOf(player.getLocation().getPitch()) });
/*  28 */     spawns.put(spawnID, loc);
/*     */   }
/*     */ 
/*     */   
/*     */   public void loadSpawns() {
/*  33 */     if (this.arenas.getArenasConfig().getConfigurationSection(String.format("arenas.%s.spawns", new Object[] { this.gameHandler.getCurrentArena() })).getKeys(false).size() == 0) {
/*     */       return;
/*     */     }
/*  36 */     for (String s : this.arenas.getArenasConfig().getConfigurationSection(String.format("arenas.%s.spawns", new Object[] { this.gameHandler.getCurrentArena() })).getKeys(false)) {
/*  37 */       Integer spawnID = Integer.valueOf(Integer.parseInt(s));
/*  38 */       spawns.put(spawnID, this.arenas.getArenasConfig().getString(String.format("arenas.%s.spawns.%s", new Object[] { this.gameHandler.getCurrentArena(), s })));
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void saveSpawns() {
/*  45 */     for (int counter = 0; counter <= spawns.size(); counter++) {
/*  46 */       this.arenas.getArenasConfig().set(String.format("arenas.%s.spawns.%d", new Object[] { this.gameHandler.getCurrentArena(), Integer.valueOf(counter) }), spawns.get(Integer.valueOf(counter)));
/*     */     } 
/*  48 */     this.arenas.saveArenasConfig();
/*     */   }
/*     */ 
/*     */   
/*     */   public void addSpawns() {
/*  53 */     Arenas arenas = new Arenas();
/*  54 */     VotingManager votingManager = new VotingManager();
/*     */     
/*  56 */     locations.clear();
/*     */     
/*  58 */     String aName = votingManager.getArenaName();
/*     */     
/*  60 */     World w = Bukkit.getWorld(votingManager.getMapName());
/*  61 */     for (String s : arenas.getArenasConfig().getConfigurationSection(String.format("arenas.%s.spawns", new Object[] { aName })).getKeys(false)) {
/*  62 */       String[] str = arenas.getArenasConfig().getString(String.format("arenas.%s.spawns.%s", new Object[] { aName, s })).split(", ");
/*     */       
/*  64 */       locations.add(new Location(w, Double.parseDouble(str[0].replaceAll("[^0-9-.]", "")), Double.parseDouble(str[1].replaceAll("[^0-9-.]", "")), 
/*  65 */             Double.parseDouble(str[2].replaceAll("[^0-9-.]", "")), Float.parseFloat(str[3].replaceAll("[^0-9-.]", "")), 
/*  66 */             Float.parseFloat(str[4].replaceAll("[^0-9-.]", ""))));
/*     */     } 
/*  68 */     if (locations.size() == 0) {
/*  69 */       throw new NullPointerException();
/*     */     }
/*     */   }
/*     */   
/*     */   public void warpPlayersForIngame() {
/*  74 */     int counter = 0;
/*  75 */     for (GamePlayer gamePlayer : this.gameHandler.getPlayers()) {
/*  76 */       gamePlayer.getPlayer().teleport(locations.get(counter));
/*  77 */       gamePlayer.setPosition(Integer.valueOf(counter + 1));
/*  78 */       counter++;
/*     */     } 
/*     */   }
/*     */   
/*     */   public void warpPlayersForDeathmatch() {
/*  83 */     int counter = 0;
/*  84 */     if (this.gameHandler.getPlayers().size() == 3) {
/*  85 */       for (GamePlayer gamePlayer : this.gameHandler.getPlayers()) {
/*  86 */         gamePlayer.getPlayer().teleport(locations.get(counter));
/*  87 */         counter += 6;
/*     */       } 
/*  89 */     } else if (this.gameHandler.getPlayers().size() == 2) {
/*  90 */       for (GamePlayer gamePlayer : this.gameHandler.getPlayers()) {
/*  91 */         gamePlayer.getPlayer().teleport(locations.get(counter));
/*  92 */         counter += 12;
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public Map<Integer, String> getSpawns() {
/*  98 */     return spawns;
/*     */   }
/*     */   
/*     */   public List<Location> getLocations() {
/* 102 */     return locations;
/*     */   }
/*     */   
/* 105 */   private Arenas arenas = new Arenas();
/* 106 */   private GameHandler gameHandler = new GameHandler();
/*     */ }


/* Location:              /home/tyler/Downloads/jar files/Hungergames.jar!/com/mczone/managers/SpawnManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */