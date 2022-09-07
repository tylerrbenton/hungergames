/*    */ package com.mczone.commands;
/*    */ 
/*    */ import com.mczone.configs.Arenas;
/*    */ import com.mczone.hungergames.GameHandler;
/*    */ import com.mczone.managers.ChestManager;
/*    */ import com.mczone.utils.Messages;
/*    */ import com.mczone.utils.Perms;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import org.bukkit.Location;
/*    */ import org.bukkit.command.Command;
/*    */ import org.bukkit.command.CommandExecutor;
/*    */ import org.bukkit.command.CommandSender;
/*    */ import org.bukkit.entity.Player;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ChestCommands
/*    */   implements CommandExecutor
/*    */ {
/*    */   public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
/* 26 */     Messages msgs = new Messages();
/*    */     
/* 28 */     if (cmd.getName().equalsIgnoreCase("savechests"))
/* 29 */       if (sender instanceof Player)
/* 30 */       { Player p = (Player)sender;
/*    */         
/* 32 */         if (p.hasPermission(Perms.savechests))
/*    */         
/* 34 */         { if (args.length == 0)
/*    */           
/* 36 */           { if (this.chestManager.getChests().size() != 0 || this.chestManager.getEnderChests().size() != 0)
/*    */             
/* 38 */             { saveChests();
/* 39 */               p.sendMessage(msgs.chestsSaved(Integer.valueOf(this.chestManager.getChests().size()), Integer.valueOf(this.chestManager.getEnderChests().size()))); }
/*    */             else
/* 41 */             { p.sendMessage(msgs.noChestsToSave()); }  }
/* 42 */           else { p.sendMessage(msgs.savechests()); }
/*    */            }
/* 44 */         else { p.sendMessage(msgs.needPermission(Perms.savechests)); }  }
/* 45 */       else { sender.sendMessage(msgs.mustBePlayer()); }
/*    */        
/* 47 */     return true;
/*    */   }
/*    */   
/*    */   private void saveChests() {
/* 51 */     Arenas arenas = new Arenas();
/* 52 */     GameHandler gameHandler = new GameHandler();
/*    */     
/* 54 */     List<String> chests = new ArrayList<>();
/* 55 */     List<String> enderChests = new ArrayList<>();
/*    */     
/* 57 */     for (Location location : this.chestManager.getChests()) {
/* 58 */       chests.add(location(location));
/*    */     }
/* 60 */     for (Location location : this.chestManager.getEnderChests()) {
/* 61 */       enderChests.add(location(location));
/*    */     }
/*    */     
/* 64 */     arenas.getArenasConfig().set(String.format("arenas.%s.chests.tier one", new Object[] { gameHandler.getCurrentArena() }), chests);
/* 65 */     arenas.getArenasConfig().set(String.format("arenas.%s.chests.tier two", new Object[] { gameHandler.getCurrentArena() }), enderChests);
/* 66 */     arenas.saveArenasConfig();
/*    */   }
/*    */   
/*    */   private String location(Location location) {
/* 70 */     return String.format("X:%.2f, Y:%.2f, Z:%.2f", new Object[] { Double.valueOf(location.getX()), Double.valueOf(location.getY()), Double.valueOf(location.getZ()) });
/*    */   }
/*    */   
/* 73 */   private ChestManager chestManager = new ChestManager();
/*    */ }


/* Location:              /home/tyler/Downloads/jar files/Hungergames.jar!/com/mczone/commands/ChestCommands.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */