/*     */ package com.mczone.commands;
/*     */ 
/*     */ import com.mczone.configs.Arenas;
/*     */ import com.mczone.configs.Config;
/*     */ import com.mczone.hungergames.GameHandler;
/*     */ import com.mczone.hungergames.GameState;
/*     */ import com.mczone.managers.SpawnManager;
/*     */ import com.mczone.utils.Messages;
/*     */ import com.mczone.utils.Perms;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.UUID;
/*     */ import org.bukkit.command.Command;
/*     */ import org.bukkit.command.CommandExecutor;
/*     */ import org.bukkit.command.CommandSender;
/*     */ import org.bukkit.entity.Player;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SpawnCommands
/*     */   implements CommandExecutor
/*     */ {
/*  24 */   private static Map<UUID, Integer> confirmSetSpawn = new HashMap<>();
/*     */   
/*  26 */   private static String arenaName = null;
/*     */ 
/*     */   
/*     */   public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
/*  30 */     GameHandler gameHandler = new GameHandler();
/*  31 */     Perms perms = new Perms();
/*  32 */     Messages msgs = new Messages();
/*  33 */     SpawnManager spawnManager = new SpawnManager();
/*     */ 
/*     */     
/*  36 */     if (cmd.getName().equalsIgnoreCase("setspawn")) {
/*  37 */       if (sender instanceof Player)
/*  38 */       { Player p = (Player)sender;
/*     */         
/*  40 */         if (p.hasPermission(Perms.setspawn))
/*  41 */         { if (args.length == 0) {
/*  42 */             setSpawn(p);
/*  43 */             p.sendMessage(msgs.spawnSaved());
/*  44 */             return true;
/*     */           } 
/*     */           
/*  47 */           if (args.length == 1)
/*  48 */           { if (GameState.isState(GameState.LOBBY))
/*  49 */             { if (!confirmSetSpawn.containsKey(p.getUniqueId()))
/*  50 */               { if (containsMap(p))
/*  51 */                 { if (gameHandler.getCurrentArena() != null)
/*     */                   
/*     */                   { try {
/*  54 */                       Integer spawnID = Integer.valueOf(Integer.parseInt(args[0]));
/*  55 */                       if (spawnID.intValue() < 24 && spawnID.intValue() >= 0)
/*  56 */                       { if (spawnManager.getSpawns().containsKey(spawnID)) {
/*  57 */                           confirmSetSpawn.put(p.getUniqueId(), spawnID);
/*  58 */                           p.sendMessage(msgs.spawnIDAlreadyExist(spawnID));
/*     */                         } else {
/*  60 */                           spawnManager.addSpawn(spawnID, p);
/*  61 */                           p.sendMessage(msgs.spawnIDAdded(spawnID));
/*     */                         }  }
/*  63 */                       else { p.sendMessage(msgs.setspawn()); }
/*     */                     
/*  65 */                     } catch (IllegalArgumentException iae) {
/*  66 */                       p.sendMessage(msgs.setspawn());
/*     */                     }  }
/*     */                   else
/*  69 */                   { p.sendMessage(msgs.pleaseLoadArenaFirst(arenaName)); }  }
/*  70 */                 else { p.sendMessage(msgs.pleaseCreateArena()); }  }
/*  71 */               else { p.sendMessage(msgs.confirmspawn()); }  }
/*  72 */             else { p.sendMessage(msgs.cannotAtThisTime()); }  }
/*  73 */           else { p.sendMessage(msgs.setspawn()); }  }
/*  74 */         else { p.sendMessage(msgs.needPermission(Perms.setspawn)); }  }
/*  75 */       else { sender.sendMessage(msgs.mustBePlayer()); }
/*     */     
/*     */     }
/*     */     
/*  79 */     if (cmd.getName().equalsIgnoreCase("delspawn")) {
/*  80 */       if (sender instanceof Player)
/*  81 */       { Player p = (Player)sender;
/*     */         
/*  83 */         if (p.hasPermission(Perms.delspawn))
/*  84 */         { if (args.length == 0) {
/*  85 */             return true;
/*     */           }
/*  87 */           if (args.length == 1); }
/*     */         else
/*     */         
/*  90 */         { p.sendMessage(msgs.needPermission(Perms.delspawn)); }  }
/*  91 */       else { sender.sendMessage(msgs.mustBePlayer()); }
/*     */     
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*  97 */     if (cmd.getName().equalsIgnoreCase("savespawns")) {
/*  98 */       if (sender instanceof Player)
/*  99 */       { Player p = (Player)sender;
/*     */         
/* 101 */         if (p.hasPermission(Perms.savespawns))
/* 102 */         { if (args.length == 0)
/* 103 */           { if (GameState.isState(GameState.LOBBY))
/* 104 */             { if (spawnManager.getSpawns().size() != 0)
/*     */               
/* 106 */               { spawnManager.saveSpawns();
/* 107 */                 p.sendMessage(msgs.allSpawnsSaved(Integer.valueOf(spawnManager.getSpawns().size()))); }
/*     */               else
/* 109 */               { p.sendMessage(msgs.noSpawnsToSave()); }  }
/* 110 */             else { p.sendMessage(msgs.cannotAtThisTime()); }  }
/* 111 */           else { p.sendMessage(msgs.savespawns()); }  }
/* 112 */         else { p.sendMessage(msgs.needPermission(Perms.savespawns)); }  }
/* 113 */       else { sender.sendMessage(msgs.mustBePlayer()); }
/*     */     
/*     */     }
/*     */     
/* 117 */     if (cmd.getName().equalsIgnoreCase("confirmspawn"))
/* 118 */       if (sender instanceof Player)
/* 119 */       { Player p = (Player)sender;
/*     */         
/* 121 */         if (p.hasPermission(Perms.confirmspawn))
/* 122 */         { if (GameState.isState(GameState.LOBBY))
/* 123 */           { if (confirmSetSpawn.containsKey(p.getUniqueId())) {
/*     */               
/* 125 */               spawnManager.addSpawn(confirmSetSpawn.get(p.getUniqueId()), p);
/* 126 */               p.sendMessage(msgs.spawnIDAdded(confirmSetSpawn.get(p.getUniqueId())));
/* 127 */               confirmSetSpawn.remove(p.getUniqueId());
/*     */             }  }
/*     */           else
/* 130 */           { p.sendMessage(msgs.cannotAtThisTime()); }  }
/* 131 */         else { p.sendMessage(msgs.needPermission(Perms.confirmspawn)); }  }
/* 132 */       else { sender.sendMessage(msgs.mustBePlayer()); }
/*     */        
/* 134 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean containsMap(Player player) {
/* 139 */     Arenas arenas = new Arenas();
/*     */     
/* 141 */     boolean containsMap = false;
/* 142 */     if (arenas.getArenasConfig().getConfigurationSection("arenas").getKeys(false).size() != 0) {
/* 143 */       for (String s : arenas.getArenasConfig().getConfigurationSection("arenas").getKeys(false)) {
/* 144 */         if (arenas.getArenasConfig().getString(String.format("arenas.%s.world", new Object[] { s })).equalsIgnoreCase(player.getWorld().getName())) {
/* 145 */           arenaName = s;
/* 146 */           containsMap = true;
/*     */           break;
/*     */         } 
/*     */       } 
/*     */     }
/* 151 */     return containsMap;
/*     */   }
/*     */ 
/*     */   
/*     */   private void setSpawn(Player p) {
/* 156 */     Config config = new Config();
/*     */     
/* 158 */     config.getConfig().set("config.spawn.world", p.getWorld().getName());
/* 159 */     config.getConfig().set("config.spawn.location", String.format("X:%.2f, Y:%d, Z:%.2f, Yaw:%.0f, Pitch:%.0f", new Object[] { Double.valueOf(p.getLocation().getBlockX() + 0.5D), Integer.valueOf(p.getLocation().getBlockY()), Double.valueOf(p.getLocation().getBlockZ() + 0.5D), 
/* 160 */             Float.valueOf(p.getLocation().getYaw()), Float.valueOf(p.getLocation().getPitch()) }));
/* 161 */     config.saveConfig();
/*     */   }
/*     */   
/*     */   public String getArenaName() {
/* 165 */     return arenaName;
/*     */   }
/*     */ }


/* Location:              /home/tyler/Downloads/jar files/Hungergames.jar!/com/mczone/commands/SpawnCommands.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */