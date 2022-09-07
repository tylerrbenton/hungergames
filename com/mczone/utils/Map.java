/*    */ package com.mczone.utils;
/*    */ 
/*    */ import com.mczone.configs.Arenas;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Map
/*    */ {
/*    */   private String mapName;
/*    */   private String arenaName;
/*    */   private String mapBuilder;
/*    */   private String mapDownload;
/* 15 */   private Integer numberOfVotes = Integer.valueOf(0);
/*    */ 
/*    */   
/*    */   public Map(String mName, String aName) {
/* 19 */     Arenas arenas = new Arenas();
/*    */     
/* 21 */     this.mapName = mName;
/* 22 */     this.arenaName = aName;
/*    */     
/* 24 */     this.mapBuilder = arenas.getArenasConfig().getString(String.format("arenas.%s.builder", new Object[] { this.arenaName }));
/* 25 */     this.mapDownload = arenas.getArenasConfig().getString(String.format("arenas.%s.download", new Object[] { this.arenaName }));
/*    */   }
/*    */   
/*    */   public String getWorldName() {
/* 29 */     return this.mapName;
/*    */   }
/*    */   
/*    */   public String getMapAuthor() {
/* 33 */     return this.mapBuilder;
/*    */   }
/*    */   
/*    */   public String getMapDownload() {
/* 37 */     return this.mapDownload;
/*    */   }
/*    */   
/*    */   public String getArenaName() {
/* 41 */     return this.arenaName;
/*    */   }
/*    */   
/*    */   public void setVotes(int votes) {
/* 45 */     this.numberOfVotes = Integer.valueOf(votes);
/*    */   }
/*    */   
/*    */   public int getNumberOfVotes() {
/* 49 */     return this.numberOfVotes.intValue();
/*    */   }
/*    */ }


/* Location:              /home/tyler/Downloads/jar files/Hungergames.jar!/com/mczone/utils/Map.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */