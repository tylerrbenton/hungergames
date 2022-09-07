/*    */ package com.mczone.utils;
/*    */ 
/*    */ import org.bukkit.permissions.Permission;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Perms
/*    */ {
/*    */   public static Permission createarena;
/*    */   public static Permission removearena;
/*    */   public static Permission loadarena;
/*    */   public static Permission arena;
/*    */   
/*    */   public void setupPermissions() {
/* 16 */     createarena = new Permission("hungergames.commands.arena.createarena", "Creates a new arena.");
/* 17 */     removearena = new Permission("hungergames.commands.arena.removearena", "Removes specified arena.");
/* 18 */     loadarena = new Permission("hungergames.commands.arena.loadarena", "Loads specified arena.");
/* 19 */     arena = new Permission("hungergames.commands.arena.arena", "Checks if world belongs to arena.");
/* 20 */     arenas = new Permission("hungergames.commands.arena.arenas", "List all arenas.");
/*    */ 
/*    */     
/* 23 */     pause = new Permission("hungergames.commands.game.pause", "Pause the game.");
/* 24 */     start = new Permission("hungergames.commands.game.start", "Force start game.");
/* 25 */     skip = new Permission("hungergames.commands.game.skip", "Skip countdown timer.");
/* 26 */     vote = new Permission("hungergames.commands.game.vote", "Vote for maps.");
/*    */ 
/*    */     
/* 29 */     owner = new Permission("hungergames.owner");
/* 30 */     developer = new Permission("hungergames.developer");
/* 31 */     admin = new Permission("hungergames.administrator");
/* 32 */     srmod = new Permission("hungergames.seniormoderator");
/* 33 */     mod = new Permission("hungergames.moderator");
/* 34 */     vip = new Permission("hungergames.vip");
/* 35 */     builder = new Permission("hungergames.mapmaker");
/* 36 */     quantum = new Permission("hungergames.quantum");
/* 37 */     platinum = new Permission("hungergames.platinum");
/* 38 */     diamond = new Permission("hungergames.diamond");
/* 39 */     gold = new Permission("hungergames.gold");
/*    */ 
/*    */ 
/*    */     
/* 43 */     load = new Permission("hungergames.commands.misc.load", "Loads map.");
/* 44 */     unload = new Permission("hungergames.commands.misc.unload", "Unloads map.");
/* 45 */     remove = new Permission("hungergames.commands.misc.remove", "Removes map.");
/* 46 */     map = new Permission("hungergames.commands.misc.map", "Teleports to map.");
/* 47 */     tier = new Permission("hungergames.commands.chest.tier", "Tier chests.");
/* 48 */     maps = new Permission("hungergames.commands.misc.maps", "List all loaded map.");
/* 49 */     spawn = new Permission("hungergames.commands.misc.spawn", "Tool used to set spawns.");
/* 50 */     stats = new Permission("hungergames.commands.misc.stats", "Returns the current stats for player.");
/* 51 */     list = new Permission("hungergames.commands.misc.list", "List all players and specs in the game.");
/* 52 */     bounty = new Permission("hungergames.commands.misc.bounty", "Set a bounty for a player.");
/* 53 */     confirmbounty = new Permission("hungergames.commands.misc.confirmbounty", "Confirm bounty.");
/* 54 */     sponsor = new Permission("hungergames.commands.misc.sponsor", "Sponsor a player an item.");
/* 55 */     spectate = new Permission("hungergames.commands.misc.spectate", "Spectate other players.");
/*    */ 
/*    */     
/* 58 */     setspawn = new Permission("hungergames.commands.spawn.setspawn", "Sets current spawn.");
/* 59 */     delspawn = new Permission("hungergames.commands.spawn.delspawn", "Removes specified spawn.");
/* 60 */     savespawns = new Permission("hungergames.commands.spawn.undospawn", "Saves all spawns.");
/* 61 */     confirmspawn = new Permission("hungergames.commands.spawn.confirmspawn", "Confirmation to overwrite current spawn.");
/* 62 */     save = new Permission("hungergames.commands.misc.save", "Saves changes to specified .");
/*    */ 
/*    */     
/* 65 */     savechests = new Permission("hungergames.commands.chest.savechests", "Save set chests.");
/*    */   }
/*    */   
/*    */   public static Permission arenas;
/*    */   public static Permission pause;
/*    */   public static Permission start;
/*    */   public static Permission skip;
/*    */   public static Permission vote;
/*    */   public static Permission owner;
/*    */   public static Permission developer;
/*    */   public static Permission admin;
/*    */   public static Permission srmod;
/*    */   public static Permission mod;
/*    */   public static Permission vip;
/*    */   public static Permission builder;
/*    */   public static Permission quantum;
/*    */   public static Permission platinum;
/*    */   public static Permission diamond;
/*    */   public static Permission gold;
/*    */   public static Permission load;
/*    */   public static Permission unload;
/*    */   public static Permission remove;
/*    */   public static Permission map;
/*    */   public static Permission setspawn;
/*    */   public static Permission delspawn;
/*    */   public static Permission savespawns;
/*    */   public static Permission confirmspawn;
/*    */   public static Permission tier;
/*    */   public static Permission maps;
/*    */   public static Permission savechests;
/*    */   public static Permission save;
/*    */   public static Permission spawn;
/*    */   public static Permission stats;
/*    */   public static Permission list;
/*    */   public static Permission bounty;
/*    */   public static Permission confirmbounty;
/*    */   public static Permission sponsor;
/*    */   public static Permission spectate;
/*    */ }


/* Location:              /home/tyler/Downloads/jar files/Hungergames.jar!/com/mczone/utils/Perms.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */