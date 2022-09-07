/*     */ package com.mczone.commands;
/*     */ 
/*     */ import com.mczone.hungergames.Configuration;
/*     */ import com.mczone.hungergames.GameHandler;
/*     */ import com.mczone.hungergames.GameState;
/*     */ import com.mczone.utils.Messages;
/*     */ import com.mczone.utils.Perms;
/*     */ import org.bukkit.command.Command;
/*     */ import org.bukkit.command.CommandExecutor;
/*     */ import org.bukkit.command.CommandSender;
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
/*     */ 
/*     */ public class GameCommands
/*     */   implements CommandExecutor
/*     */ {
/*     */   public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
/*  29 */     Configuration configuration = new Configuration();
/*  30 */     GameHandler gameHandler = new GameHandler();
/*     */ 
/*     */     
/*  33 */     if (cmd.getName().equalsIgnoreCase("pause")) {
/*  34 */       if (!sender.hasPermission(Perms.pause)) {
/*  35 */         sender.sendMessage(this.msgs.needPermission(Perms.pause));
/*  36 */         return true;
/*     */       } 
/*  38 */       if (args.length != 0) {
/*  39 */         sender.sendMessage(this.msgs.pause());
/*  40 */         return true;
/*     */       } 
/*  42 */       if (!GameState.isState(GameState.LOBBY)) {
/*  43 */         sender.sendMessage(this.msgs.cannotAtThisTime());
/*  44 */         return true;
/*     */       } 
/*  46 */       if (gameHandler.isPaused()) {
/*  47 */         gameHandler.setPaused(false);
/*  48 */         sender.sendMessage(this.msgs.gamePaused(false));
/*  49 */         return true;
/*     */       } 
/*  51 */       gameHandler.setPaused(true);
/*  52 */       sender.sendMessage(this.msgs.gamePaused(true));
/*     */     } 
/*     */ 
/*     */     
/*  56 */     if (cmd.getName().equalsIgnoreCase("start")) {
/*  57 */       if (!sender.hasPermission(Perms.start)) {
/*  58 */         sender.sendMessage(this.msgs.needPermission(Perms.start));
/*  59 */         return true;
/*     */       } 
/*  61 */       if (args.length != 0) {
/*  62 */         sender.sendMessage(this.msgs.start());
/*  63 */         return true;
/*     */       } 
/*  65 */       if (!GameState.isState(GameState.LOBBY)) {
/*  66 */         sender.sendMessage(this.msgs.cannotAtThisTime());
/*  67 */         return true;
/*     */       } 
/*  69 */       if (gameHandler.isForceStart()) {
/*  70 */         gameHandler.setForceStart(false);
/*  71 */         sender.sendMessage(this.msgs.forceStart(false));
/*  72 */         return true;
/*     */       } 
/*  74 */       gameHandler.setForceStart(true);
/*  75 */       sender.sendMessage(this.msgs.forceStart(true));
/*     */     } 
/*     */ 
/*     */     
/*  79 */     if (cmd.getName().equalsIgnoreCase("skip")) {
/*  80 */       if (!sender.hasPermission(Perms.skip)) {
/*  81 */         sender.sendMessage(this.msgs.needPermission(Perms.skip));
/*  82 */         return true;
/*     */       } 
/*  84 */       if (args.length != 0) {
/*  85 */         sender.sendMessage(this.msgs.skip());
/*  86 */         return true;
/*     */       } 
/*  88 */       if (!GameState.isState(GameState.LOBBY)) {
/*  89 */         sender.sendMessage(this.msgs.cannotAtThisTime());
/*  90 */         return true;
/*     */       } 
/*  92 */       if (configuration.getLobbyTime() <= 10) {
/*  93 */         sender.sendMessage(this.msgs.cannotAtThisTime());
/*  94 */         return true;
/*     */       } 
/*  96 */       configuration.setLobbyTime(10);
/*  97 */       sender.sendMessage(this.msgs.countdownSkipped());
/*     */     } 
/*  99 */     return true;
/*     */   }
/*     */   
/* 102 */   private Messages msgs = new Messages();
/*     */ }


/* Location:              /home/tyler/Downloads/jar files/Hungergames.jar!/com/mczone/commands/GameCommands.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */