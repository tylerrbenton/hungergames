/*     */ package com.mczone.managers;
/*     */ 
/*     */ import com.mczone.configs.Arenas;
/*     */ import com.mczone.utils.Map;
/*     */ import com.mczone.utils.Messages;
/*     */ import com.mczone.utils.Perms;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.Random;
/*     */ import org.bukkit.entity.Player;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class VotingManager
/*     */ {
/*  20 */   private static List<Map> choices = new ArrayList<>();
/*     */   
/*  22 */   private static String mapName = null;
/*  23 */   private static String arenaName = null;
/*  24 */   private static String mapAuthor = null;
/*  25 */   private static String mapDownload = null;
/*     */ 
/*     */   
/*     */   public void addChoices() {
/*  29 */     Arenas arenas = new Arenas();
/*  30 */     Messages msgs = new Messages();
/*     */     
/*  32 */     List<Map> maps = new ArrayList<>();
/*     */ 
/*     */     
/*  35 */     if (arenas.getArenasConfig().getConfigurationSection("arenas").getKeys(false).size() == 0) {
/*  36 */       throw new NullPointerException(msgs.mustHaveAnArena());
/*     */     }
/*  38 */     for (String s : arenas.getArenasConfig().getConfigurationSection("arenas").getKeys(false)) {
/*  39 */       String wName = arenas.getArenasConfig().getString(String.format("arenas.%s.world", new Object[] { s }));
/*  40 */       maps.add(new Map(wName, s));
/*     */     } 
/*     */     
/*  43 */     while (choices.size() != 5 && 
/*  44 */       maps.size() != 0) {
/*     */ 
/*     */       
/*  47 */       Integer randomIndex = Integer.valueOf(this.random.nextInt(maps.size()));
/*     */       
/*  49 */       choices.add(maps.get(randomIndex.intValue()));
/*  50 */       maps.remove(maps.get(randomIndex.intValue()));
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void addVote(Player player, Integer choiceIndex) {
/*  56 */     if (player.hasPermission(Perms.owner)) {
/*  57 */       ((Map)choices.get(choiceIndex.intValue())).setVotes(((Map)choices.get(choiceIndex.intValue())).getNumberOfVotes() + 100);
/*     */       
/*     */       return;
/*     */     } 
/*  61 */     if (player.hasPermission(Perms.developer)) {
/*  62 */       ((Map)choices.get(choiceIndex.intValue())).setVotes(((Map)choices.get(choiceIndex.intValue())).getNumberOfVotes() + 20);
/*     */       
/*     */       return;
/*     */     } 
/*  66 */     if (player.hasPermission(Perms.admin)) {
/*  67 */       ((Map)choices.get(choiceIndex.intValue())).setVotes(((Map)choices.get(choiceIndex.intValue())).getNumberOfVotes() + 10);
/*     */       
/*     */       return;
/*     */     } 
/*  71 */     if (player.hasPermission(Perms.srmod)) {
/*  72 */       ((Map)choices.get(choiceIndex.intValue())).setVotes(((Map)choices.get(choiceIndex.intValue())).getNumberOfVotes() + 5);
/*     */       
/*     */       return;
/*     */     } 
/*  76 */     if (player.hasPermission(Perms.mod)) {
/*  77 */       ((Map)choices.get(choiceIndex.intValue())).setVotes(((Map)choices.get(choiceIndex.intValue())).getNumberOfVotes() + 3);
/*     */     } else {
/*  79 */       ((Map)choices.get(choiceIndex.intValue())).setVotes(((Map)choices.get(choiceIndex.intValue())).getNumberOfVotes() + 1);
/*     */     } 
/*     */   }
/*     */   
/*     */   public int getTotalVotes() {
/*  84 */     int votes = 0;
/*  85 */     for (Map m : choices) {
/*  86 */       votes += m.getNumberOfVotes();
/*     */     }
/*  88 */     return votes;
/*     */   }
/*     */ 
/*     */   
/*     */   public void chooseMap() {
/*  93 */     List<Map> maps = new ArrayList<>();
/*  94 */     int mostVotes = 0;
/*     */     
/*  96 */     for (Map m : choices) {
/*  97 */       if (m.getNumberOfVotes() <= mostVotes) {
/*     */         continue;
/*     */       }
/* 100 */       mostVotes = m.getNumberOfVotes();
/*     */     } 
/*     */     
/* 103 */     for (Map m : choices) {
/* 104 */       if (m.getNumberOfVotes() != mostVotes) {
/*     */         continue;
/*     */       }
/* 107 */       maps.add(m);
/*     */     } 
/* 109 */     int randomIndex = this.random.nextInt(maps.size());
/*     */     
/* 111 */     mapName = ((Map)maps.get(randomIndex)).getWorldName();
/* 112 */     arenaName = ((Map)maps.get(randomIndex)).getArenaName();
/* 113 */     mapAuthor = ((Map)maps.get(randomIndex)).getMapAuthor();
/* 114 */     mapDownload = ((Map)maps.get(randomIndex)).getMapDownload();
/*     */     
/* 116 */     maps.clear();
/*     */   }
/*     */   
/*     */   public List<Map> getChoices() {
/* 120 */     return choices;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getMapName() {
/* 126 */     return mapName;
/*     */   }
/*     */   
/*     */   String getArenaName() {
/* 130 */     return arenaName;
/*     */   }
/*     */   
/*     */   public String getMapAuthor() {
/* 134 */     return mapAuthor;
/*     */   }
/*     */   
/*     */   public String getMapDownload() {
/* 138 */     return mapDownload;
/*     */   }
/*     */   
/* 141 */   private Random random = new Random();
/*     */ }


/* Location:              /home/tyler/Downloads/jar files/Hungergames.jar!/com/mczone/managers/VotingManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */