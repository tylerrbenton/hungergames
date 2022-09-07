/*    */ package com.mczone.configs;
/*    */ 
/*    */ import com.mczone.hungergames.Hungergames;
/*    */ import java.io.File;
/*    */ import java.io.IOException;
/*    */ import org.bukkit.configuration.file.FileConfiguration;
/*    */ import org.bukkit.configuration.file.YamlConfiguration;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Arenas
/*    */ {
/*    */   private static FileConfiguration aConfig;
/*    */   private static File aFile;
/*    */   
/*    */   public void setup() {
/* 19 */     if (!Hungergames.getHungergames().getDataFolder().exists()) {
/* 20 */       Hungergames.getHungergames().getDataFolder().mkdir();
/*    */     }
/*    */     
/* 23 */     aFile = new File(Hungergames.getHungergames().getDataFolder(), "arenas.yml");
/*    */     
/* 25 */     if (!aFile.exists()) {
/*    */       try {
/* 27 */         aFile.createNewFile();
/* 28 */       } catch (IOException io) {
/* 29 */         Hungergames.getHungergames().getLogger().severe("Arenas.yml could not be created.");
/*    */       } 
/*    */     }
/* 32 */     aConfig = (FileConfiguration)YamlConfiguration.loadConfiguration(aFile);
/*    */     
/* 34 */     aConfig.addDefault("arenas.null", null);
/* 35 */     aConfig.options().copyDefaults(true);
/* 36 */     saveArenasConfig();
/*    */   }
/*    */   
/*    */   public FileConfiguration getArenasConfig() {
/* 40 */     return aConfig;
/*    */   }
/*    */   
/*    */   public void saveArenasConfig() {
/*    */     try {
/* 45 */       aConfig.save(aFile);
/* 46 */     } catch (IOException io) {
/* 47 */       Hungergames.getHungergames().getLogger().severe("Arenas.yml could not be saved.");
/*    */     } 
/*    */   }
/*    */ }


/* Location:              /home/tyler/Downloads/jar files/Hungergames.jar!/com/mczone/configs/Arenas.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */