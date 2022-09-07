/*     */ package com.mczone.listeners;
/*     */ 
/*     */ import com.mczone.commands.MiscCommands;
/*     */ import com.mczone.commands.SpawnCommands;
/*     */ import com.mczone.hungergames.GameHandler;
/*     */ import com.mczone.hungergames.GameState;
/*     */ import com.mczone.managers.ChestManager;
/*     */ import com.mczone.managers.SpawnManager;
/*     */ import com.mczone.managers.StatsManager;
/*     */ import com.mczone.utils.Items;
/*     */ import com.mczone.utils.Messages;
/*     */ import com.mczone.utils.Perms;
/*     */ import org.bukkit.Material;
/*     */ import org.bukkit.block.Block;
/*     */ import org.bukkit.entity.Player;
/*     */ import org.bukkit.event.EventHandler;
/*     */ import org.bukkit.event.Listener;
/*     */ import org.bukkit.event.block.Action;
/*     */ import org.bukkit.event.player.PlayerInteractEvent;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PlayerInteract
/*     */   implements Listener
/*     */ {
/*  36 */   private static Integer spawnID = Integer.valueOf(0);
/*     */   
/*     */   @EventHandler
/*     */   public void onInteract(PlayerInteractEvent e) {
/*  40 */     ChestManager chestManager = new ChestManager();
/*  41 */     GameHandler gameHandler = new GameHandler();
/*  42 */     Messages msgs = new Messages();
/*  43 */     MiscCommands miscCommands = new MiscCommands();
/*  44 */     SpawnCommands spawnCommands = new SpawnCommands();
/*  45 */     SpawnManager spawnManager = new SpawnManager();
/*  46 */     StatsManager statsManager = new StatsManager();
/*     */     
/*  48 */     Block b = e.getClickedBlock();
/*  49 */     Player p = e.getPlayer();
/*     */ 
/*     */     
/*  52 */     if (GameState.isState(GameState.INGAME)) {
/*  53 */       if (e.getAction() != Action.RIGHT_CLICK_BLOCK) {
/*     */         return;
/*     */       }
/*  56 */       if (b.getType() != Material.CHEST) {
/*     */         return;
/*     */       }
/*  59 */       statsManager.update("UPDATE stats SET chests_opened = chests_opened + 1 WHERE uuid = ?", p);
/*     */     } 
/*     */ 
/*     */     
/*  63 */     if (p.getItemInHand().getType() == Items.tier().getType() && p.getItemInHand() != null) {
/*     */       
/*  65 */       e.setCancelled(true);
/*     */       
/*  67 */       if (p.hasPermission(Perms.tier))
/*  68 */       { if (e.getAction() != Action.LEFT_CLICK_AIR || e.getAction() != Action.RIGHT_CLICK_AIR)
/*  69 */           if (GameState.isState(GameState.LOBBY))
/*     */           
/*  71 */           { if (spawnCommands.containsMap(p))
/*     */             
/*  73 */             { if (e.getAction() == Action.LEFT_CLICK_BLOCK) {
/*  74 */                 if (!gameHandler.getCurrentArena().equalsIgnoreCase(spawnCommands.getArenaName())) {
/*  75 */                   msgs.pleaseLoadArenaFirst(spawnCommands.getArenaName());
/*     */                   return;
/*     */                 } 
/*  78 */                 if (b.getType() != Material.CHEST) {
/*  79 */                   p.sendMessage(msgs.mustBeChest());
/*     */                   return;
/*     */                 } 
/*  82 */                 if (chestManager.getChests().contains(b.getLocation())) {
/*  83 */                   p.sendMessage(msgs.chestAlreadySet(b.getType()));
/*     */                   return;
/*     */                 } 
/*  86 */                 p.sendMessage(msgs.chestSet(b.getType()));
/*  87 */                 chestManager.getChests().add(b.getLocation());
/*     */               } 
/*     */               
/*  90 */               if (e.getAction() == Action.RIGHT_CLICK_BLOCK) {
/*  91 */                 if (!gameHandler.getCurrentArena().equalsIgnoreCase(spawnCommands.getArenaName())) {
/*  92 */                   msgs.pleaseLoadArenaFirst(spawnCommands.getArenaName());
/*     */                   return;
/*     */                 } 
/*  95 */                 if (b.getType() != Material.ENDER_CHEST) {
/*  96 */                   p.sendMessage(msgs.mustBeChest());
/*     */                   return;
/*     */                 } 
/*  99 */                 if (chestManager.getEnderChests().contains(b.getLocation())) {
/* 100 */                   p.sendMessage(msgs.chestAlreadySet(b.getType()));
/*     */                   return;
/*     */                 } 
/* 103 */                 p.sendMessage(msgs.chestSet(b.getType()));
/* 104 */                 chestManager.getEnderChests().add(b.getLocation());
/*     */               }  }
/* 106 */             else { p.sendMessage(msgs.pleaseCreateArena()); }  }
/* 107 */           else { p.sendMessage("Not at this time sir.."); }
/*     */             }
/* 109 */       else { p.sendMessage(msgs.needPermission(Perms.tier)); }
/*     */     
/*     */     } 
/* 112 */     if (p.getItemInHand() != null && p.getItemInHand().getType() == Items.spawn().getType()) {
/*     */       
/* 114 */       e.setCancelled(true);
/*     */       
/* 116 */       if (!p.hasPermission(Perms.spawn)) {
/* 117 */         p.sendMessage(msgs.needPermission(Perms.spawn));
/*     */         return;
/*     */       } 
/* 120 */       if (e.getAction() == Action.RIGHT_CLICK_BLOCK) {
/*     */         
/* 122 */         if (!GameState.isState(GameState.LOBBY)) {
/* 123 */           p.sendMessage("The gamestate is not lobby lol :)");
/*     */           return;
/*     */         } 
/* 126 */         if (miscCommands.containsMap(p))
/* 127 */         { if (gameHandler.getCurrentArena() != null && gameHandler.getCurrentArena().equalsIgnoreCase(miscCommands.getArenaName()))
/*     */           
/* 129 */           { if (spawnID.intValue() <= 12) {
/* 130 */               spawnManager.getSpawns().put(spawnID, String.format("X:%.2f, Y:%.2f, Z:%.2f, Yaw:%.0f, Pitch:%.0f", new Object[] { Double.valueOf(b.getLocation().getBlockX() + 0.5D), Double.valueOf(b.getLocation().getBlockY() + 1.0D), 
/* 131 */                       Double.valueOf(b.getLocation().getBlockZ() + 0.5D), Double.valueOf(spawnID.intValue() * -15.0D), Double.valueOf(0.0D) }));
/* 132 */               p.sendMessage(msgs.spawnIDAdded(spawnID));
/* 133 */               Integer integer3 = spawnID, integer4 = spawnID = Integer.valueOf(spawnID.intValue() + 1);
/*     */               
/*     */               return;
/*     */             } 
/* 137 */             spawnManager.getSpawns().put(spawnID, String.format("X:%.2f, Y:%.2f, Z:%.2f, Yaw:%.0f, Pitch:%.0f", new Object[] { Double.valueOf(b.getLocation().getBlockX() + 0.5D), Double.valueOf(b.getLocation().getBlockY() + 1.0D), 
/* 138 */                     Double.valueOf(b.getLocation().getBlockZ() + 0.5D), Double.valueOf(180.0D - (spawnID.intValue() - 12) * 15.0D), Double.valueOf(0.0D) }));
/* 139 */             p.sendMessage(msgs.spawnIDAdded(spawnID));
/* 140 */             Integer integer1 = spawnID, integer2 = spawnID = Integer.valueOf(spawnID.intValue() + 1); }
/*     */           else
/* 142 */           { p.sendMessage(msgs.pleaseLoadArenaFirst(miscCommands.getArenaName())); }  }
/* 143 */         else { p.sendMessage(msgs.pleaseCreateArena()); }
/*     */       
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              /home/tyler/Downloads/jar files/Hungergames.jar!/com/mczone/listeners/PlayerInteract.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */