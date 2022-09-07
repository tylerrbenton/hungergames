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
/*    */ public class Config
/*    */ {
/*    */   private static FileConfiguration cConfig;
/*    */   private static File cFile;
/*    */   
/*    */   public void setup() {
/* 19 */     if (!Hungergames.getHungergames().getDataFolder().exists()) {
/* 20 */       Hungergames.getHungergames().getDataFolder().mkdir();
/*    */     }
/* 22 */     cFile = new File(Hungergames.getHungergames().getDataFolder(), "config.yml");
/*    */     
/* 24 */     if (!cFile.exists()) {
/*    */       try {
/* 26 */         cFile.createNewFile();
/* 27 */       } catch (IOException io) {
/* 28 */         io.printStackTrace();
/*    */       } 
/*    */     }
/* 31 */     cConfig = (FileConfiguration)YamlConfiguration.loadConfiguration(cFile);
/*    */     
/* 33 */     cConfig.addDefault("arenas.null", null);
/* 34 */     cConfig.options().copyDefaults(true);
/* 35 */     saveConfig();
/*    */   }
/*    */   
/*    */   public FileConfiguration getConfig() {
/* 39 */     return cConfig;
/*    */   }
/*    */   
/*    */   public void saveConfig() {
/*    */     try {
/* 44 */       cConfig.save(cFile);
/* 45 */     } catch (IOException io) {
/* 46 */       io.printStackTrace();
/*    */     } 
/*    */   }
/*    */ }


/* Location:              /home/tyler/Downloads/jar files/Hungergames.jar!/com/mczone/configs/Config.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */