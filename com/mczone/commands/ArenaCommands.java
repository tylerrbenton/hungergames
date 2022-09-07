/*     */ package com.mczone.commands;
/*     */ 
/*     */ import com.mczone.configs.Arenas;
/*     */ import com.mczone.hungergames.GameHandler;
/*     */ import com.mczone.hungergames.GameState;
/*     */ import com.mczone.managers.ChestManager;
/*     */ import com.mczone.managers.SpawnManager;
/*     */ import com.mczone.utils.Fireworks;
/*     */ import com.mczone.utils.Messages;
/*     */ import com.mczone.utils.Perms;
/*     */ import org.bukkit.command.Command;
/*     */ import org.bukkit.command.CommandExecutor;
/*     */ import org.bukkit.command.CommandSender;
/*     */ import org.bukkit.entity.Player;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ArenaCommands
/*     */   implements CommandExecutor
/*     */ {
/*  23 */   private String arenaName = null;
/*     */ 
/*     */   
/*     */   public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
/*  27 */     GameHandler gameHandler = new GameHandler();
/*  28 */     Messages msgs = new Messages();
/*  29 */     SpawnManager spawnManager = new SpawnManager();
/*  30 */     ChestManager chestManager = new ChestManager();
/*  31 */     Fireworks fireworks = new Fireworks();
/*     */ 
/*     */     
/*  34 */     if (cmd.getName().equalsIgnoreCase("createarena")) {
/*  35 */       if (sender instanceof Player)
/*  36 */       { Player p = (Player)sender;
/*  37 */         if (p.hasPermission(Perms.createarena))
/*  38 */         { if (args.length == 1)
/*  39 */           { String name = args[0];
/*  40 */             if (!containsMap(p))
/*     */             
/*  42 */             { createArena(name, p);
/*  43 */               p.sendMessage(msgs.arenaCreated(name)); }
/*     */             else
/*  45 */             { p.sendMessage(msgs.arenaAlreadyContainsMap(this.arenaName)); }  }
/*  46 */           else { p.sendMessage(msgs.createarena()); }  }
/*  47 */         else { p.sendMessage(msgs.needPermission(Perms.createarena)); }  }
/*  48 */       else { sender.sendMessage(msgs.mustBePlayer()); }
/*     */     
/*     */     }
/*     */     
/*  52 */     if (cmd.getName().equalsIgnoreCase("removearena")) {
/*  53 */       if (sender.hasPermission(Perms.removearena))
/*  54 */       { if (args.length == 1)
/*  55 */         { if (GameState.isState(GameState.LOBBY))
/*  56 */           { String name = args[0];
/*  57 */             if (!isNull(name))
/*     */             
/*  59 */             { removeArena(name);
/*  60 */               sender.sendMessage(msgs.arenaRemoved(name)); }
/*     */             else
/*  62 */             { sender.sendMessage(msgs.arenaDoesNotExist(name)); }  }
/*  63 */           else { sender.sendMessage(msgs.cannotAtThisTime()); }  }
/*  64 */         else { sender.sendMessage(msgs.removearena()); }  }
/*  65 */       else { sender.sendMessage(msgs.needPermission(Perms.removearena)); }
/*     */     
/*     */     }
/*     */     
/*  69 */     if (cmd.getName().equalsIgnoreCase("loadarena")) {
/*  70 */       if (sender instanceof Player)
/*  71 */       { Player p = (Player)sender;
/*  72 */         if (p.hasPermission(Perms.loadarena))
/*  73 */         { if (args.length == 1)
/*  74 */           { if (GameState.isState(GameState.LOBBY))
/*  75 */             { String name = args[0];
/*  76 */               if (!isNull(name))
/*     */               
/*  78 */               { gameHandler.setCurrentArena(name);
/*  79 */                 spawnManager.getSpawns().clear();
/*  80 */                 spawnManager.loadSpawns();
/*  81 */                 chestManager.getChests().clear();
/*  82 */                 chestManager.getEnderChests().clear();
/*  83 */                 chestManager.loadChests();
/*  84 */                 p.sendMessage(msgs.arenaLoaded(name)); }
/*     */               else
/*  86 */               { p.sendMessage(msgs.arenaDoesNotExist(name)); }  }
/*  87 */             else { p.sendMessage(msgs.cannotAtThisTime()); }  }
/*  88 */           else { p.sendMessage(msgs.loadarena()); }  }
/*  89 */         else { p.sendMessage(msgs.needPermission(Perms.loadarena)); }  }
/*  90 */       else { sender.sendMessage(msgs.mustBePlayer()); }
/*     */     
/*     */     }
/*     */     
/*  94 */     if (cmd.getName().equalsIgnoreCase("arena")) {
/*  95 */       if (sender instanceof Player)
/*  96 */       { Player p = (Player)sender;
/*  97 */         if (p.hasPermission(Perms.arena))
/*  98 */         { if (args.length == 0)
/*  99 */           { if (!GameState.isState(GameState.LOBBY))
/* 100 */             { if (playerMapInConfig(p))
/*     */               
/* 102 */               { p.sendMessage(msgs.arenaContainsThisWorld(this.arenaName));
/* 103 */                 fireworks.playFireworks(); }
/*     */               else
/*     */               
/* 106 */               { p.sendMessage(msgs.noArenaForMap(p.getWorld())); }  }
/* 107 */             else { p.sendMessage(msgs.cannotAtThisTime()); }  }
/* 108 */           else { p.sendMessage(msgs.arena()); }  }
/* 109 */         else { p.sendMessage(msgs.needPermission(Perms.arena)); }  }
/* 110 */       else { sender.sendMessage(msgs.mustBePlayer()); }
/*     */     
/*     */     }
/* 113 */     if (cmd.getName().equalsIgnoreCase("arenas"))
/* 114 */       if (sender.hasPermission(Perms.arenas))
/* 115 */       { if (args.length == 0)
/* 116 */         { if (this.arenas.getArenasConfig().getConfigurationSection("arenas").getKeys(false).size() != 0)
/*     */           
/* 118 */           { sender.sendMessage(msgs.currentArenas(getArenas())); }
/*     */           else
/* 120 */           { sender.sendMessage(msgs.noArenas()); }  }
/* 121 */         else { sender.sendMessage(msgs.arenas()); }  }
/* 122 */       else { sender.sendMessage(msgs.needPermission(Perms.arenas)); }
/*     */        
/* 124 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   private boolean containsMap(Player p) {
/* 129 */     boolean containsWorld = false;
/* 130 */     for (String s : this.arenas.getArenasConfig().getConfigurationSection("arenas").getKeys(false)) {
/* 131 */       if (this.arenas.getArenasConfig().getString(String.format("arenas.%s.world", new Object[] { s })).equalsIgnoreCase(p.getWorld().getName())) {
/* 132 */         this.arenaName = s;
/* 133 */         containsWorld = true;
/*     */         break;
/*     */       } 
/*     */     } 
/* 137 */     return containsWorld;
/*     */   }
/*     */ 
/*     */   
/*     */   private void createArena(String name, Player p) {
/* 142 */     this.arenas.getArenasConfig().set(String.format("arenas.%s.world", new Object[] { name }), p.getWorld().getName());
/* 143 */     this.arenas.getArenasConfig().set(String.format("arenas.%s.builder", new Object[] { name }), "N/A");
/* 144 */     this.arenas.getArenasConfig().set(String.format("arenas.%s.download", new Object[] { name }), "N/A");
/* 145 */     this.arenas.getArenasConfig().set(String.format("arenas.%s.time", new Object[] { name }), Long.valueOf(p.getWorld().getTime()));
/* 146 */     this.arenas.getArenasConfig().set(String.format("arenas.%s.storm", new Object[] { name }), Boolean.valueOf(false));
/* 147 */     this.arenas.getArenasConfig().createSection(String.format("arenas.%s.spawns", new Object[] { name }));
/* 148 */     this.arenas.getArenasConfig().createSection(String.format("arenas.%s.chests.tier one", new Object[] { name }));
/* 149 */     this.arenas.getArenasConfig().createSection(String.format("arenas.%s.chests.tier two", new Object[] { name }));
/* 150 */     this.arenas.saveArenasConfig();
/*     */   }
/*     */ 
/*     */   
/*     */   private boolean isNull(String name) {
/* 155 */     boolean isNull = true;
/* 156 */     for (String s : this.arenas.getArenasConfig().getConfigurationSection("arenas").getKeys(false)) {
/* 157 */       if (this.arenas.getArenasConfig().get(String.format("arenas.%s", new Object[] { name })) != null) {
/* 158 */         isNull = false;
/*     */         break;
/*     */       } 
/*     */     } 
/* 162 */     return isNull;
/*     */   }
/*     */ 
/*     */   
/*     */   private boolean playerMapInConfig(Player p) {
/* 167 */     boolean inConfig = false;
/* 168 */     for (String s : this.arenas.getArenasConfig().getConfigurationSection("arenas").getKeys(false)) {
/* 169 */       if (this.arenas.getArenasConfig().getString(String.format("arenas.%s.world", new Object[] { s })).equalsIgnoreCase(p.getWorld().getName())) {
/* 170 */         inConfig = true;
/* 171 */         this.arenaName = s;
/*     */         break;
/*     */       } 
/*     */     } 
/* 175 */     return inConfig;
/*     */   }
/*     */ 
/*     */   
/*     */   private void removeArena(String name) {
/* 180 */     this.arenas.getArenasConfig().set(String.format("arenas.%s", new Object[] { name }), null);
/* 181 */     this.arenas.saveArenasConfig();
/*     */   }
/*     */ 
/*     */   
/*     */   private String getArenas() {
/* 186 */     StringBuilder str = new StringBuilder();
/* 187 */     for (String s : this.arenas.getArenasConfig().getConfigurationSection("arenas").getKeys(false)) {
/* 188 */       str.append(s).append(", ");
/*     */     }
/* 190 */     return str.toString().trim();
/*     */   }
/*     */   
/* 193 */   private Arenas arenas = new Arenas();
/*     */ }


/* Location:              /home/tyler/Downloads/jar files/Hungergames.jar!/com/mczone/commands/ArenaCommands.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */