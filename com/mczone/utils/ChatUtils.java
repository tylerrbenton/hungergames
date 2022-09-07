/*    */ package com.mczone.utils;
/*    */ 
/*    */ import com.mczone.hungergames.Hungergames;
/*    */ import org.bukkit.Bukkit;
/*    */ import org.bukkit.ChatColor;
/*    */ import org.bukkit.entity.Player;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ChatUtils
/*    */ {
/*    */   public static String format(String string) {
/* 16 */     return ChatColor.translateAlternateColorCodes('&', string);
/*    */   }
/*    */ 
/*    */   
/*    */   public static void announce(String message, Boolean console, Boolean players) {
/* 21 */     if (console.booleanValue()) {
/* 22 */       Hungergames.getHungergames().getServer().getConsoleSender().sendMessage(message);
/*    */     }
/* 24 */     if (players.booleanValue()) {
/* 25 */       for (Player everyone : Bukkit.getOnlinePlayers())
/* 26 */         everyone.sendMessage(message); 
/*    */     } else {
/* 28 */       for (Player everyone : Bukkit.getOnlinePlayers()) {
/* 29 */         if (everyone.hasPermission(Perms.owner) || everyone.hasPermission(Perms.admin)) {
/* 30 */           everyone.sendMessage(message);
/*    */         }
/*    */       } 
/*    */     } 
/*    */   }
/*    */   
/*    */   public String colorName(Player p) {
/* 37 */     if (p.hasPermission(Perms.owner)) {
/* 38 */       return String.format(format("&c&l%s"), new Object[] { p.getName() });
/*    */     }
/*    */     
/* 41 */     if (p.hasPermission(Perms.developer)) {
/* 42 */       return String.format(format("%s"), new Object[] { p.getName() });
/*    */     }
/*    */     
/* 45 */     if (p.hasPermission(Perms.admin)) {
/* 46 */       return String.format(format("&4&l%s"), new Object[] { p.getName() });
/*    */     }
/*    */     
/* 49 */     if (p.hasPermission(Perms.srmod)) {
/* 50 */       return String.format(format("&4%s"), new Object[] { p.getName() });
/*    */     }
/*    */     
/* 53 */     if (p.hasPermission(Perms.mod)) {
/* 54 */       return String.format(format("&c%s"), new Object[] { p.getName() });
/*    */     }
/*    */     
/* 57 */     if (p.hasPermission(Perms.vip)) {
/* 58 */       return String.format(format("&5&l%s"), new Object[] { p.getName() });
/*    */     }
/*    */     
/* 61 */     if (p.hasPermission(Perms.builder)) {
/* 62 */       return String.format(format("&d%s"), new Object[] { p.getName() });
/*    */     }
/*    */     
/* 65 */     if (p.hasPermission(Perms.quantum)) {
/* 66 */       return String.format(format("&a%s"), new Object[] { p.getName() });
/*    */     }
/*    */     
/* 69 */     if (p.hasPermission(Perms.platinum)) {
/* 70 */       return String.format(format("&b%s"), new Object[] { p.getName() });
/*    */     }
/*    */     
/* 73 */     if (p.hasPermission(Perms.diamond)) {
/* 74 */       return String.format(format("&3%s"), new Object[] { p.getName() });
/*    */     }
/*    */     
/* 77 */     if (p.hasPermission(Perms.gold)) {
/* 78 */       return String.format(format("&6%s"), new Object[] { p.getName() });
/*    */     }
/* 80 */     return String.format(format("&2%s"), new Object[] { p.getName() });
/*    */   }
/*    */   
/*    */   public String consolePrefix() {
/* 84 */     return format("&8&l[&6MC&fZone&8&l]&f ");
/*    */   }
/*    */   
/*    */   public String errorPrefix() {
/* 88 */     return format("&c&lERROR ");
/*    */   }
/*    */ }


/* Location:              /home/tyler/Downloads/jar files/Hungergames.jar!/com/mczone/utils/ChatUtils.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */