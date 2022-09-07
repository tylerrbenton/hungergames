/*     */ package com.mczone.hungergames;
/*     */ import com.mczone.commands.ArenaCommands;
/*     */ import com.mczone.configs.Arenas;
/*     */ import com.mczone.configs.Config;
/*     */ import com.mczone.listeners.BlockIgnite;
/*     */ import com.mczone.listeners.EntityDamage;
/*     */ import com.mczone.listeners.EntityDamageByEntity;
/*     */ import com.mczone.listeners.InventoryClick;
/*     */ import com.mczone.listeners.PlayerInteract;
/*     */ import com.mczone.listeners.PlayerPreLogin;
/*     */ import com.mczone.listeners.PlayerQuit;
/*     */ import com.mczone.managers.ChestManager;
/*     */ import com.mczone.managers.MapManager;
/*     */ import com.mczone.managers.VotingManager;
/*     */ import com.mczone.utils.BungeeCord;
/*     */ import com.mczone.utils.Messages;
/*     */ import com.mczone.utils.Perms;
/*     */ import com.mczone.utils.Runnable;
/*     */ import java.util.logging.Logger;
/*     */ import org.bukkit.command.CommandExecutor;
/*     */ import org.bukkit.entity.Player;
/*     */ import org.bukkit.event.Listener;
/*     */ import org.bukkit.plugin.Plugin;
/*     */ import org.bukkit.plugin.PluginDescriptionFile;
/*     */ 
/*     */ public class Hungergames extends JavaPlugin {
/*  27 */   private Logger l = getLogger(); private static Hungergames hungergames;
/*  28 */   private PluginDescriptionFile pdf = getDescription();
/*     */ 
/*     */   
/*     */   public void onEnable() {
/*  32 */     this.l.info(String.format("%s v.%s was successfully loaded.", new Object[] { this.pdf.getName(), this.pdf.getVersion() }));
/*     */     
/*  34 */     for (Player everyone : getServer().getOnlinePlayers()) {
/*  35 */       everyone.kickPlayer(this.msgs.serverReload());
/*     */     }
/*     */     
/*  38 */     GameState.setCurrentState(GameState.LOBBY);
/*     */     
/*  40 */     registerArenaCommands(new String[] { "createarena", "removearena", "loadarena", "arena", "arenas" });
/*  41 */     registerChestCommands(new String[] { "savechests" });
/*  42 */     registerGameCommands(new String[] { "pause", "start", "skip" });
/*  43 */     registerMiscCommands(new String[] { "load", "unload", "remove", "map", "maps", "tier", "save", "spawn", "stats", "list", "vote", "bounty", "confirmbounty", "sponsor" });
/*  44 */     registerSpawnCommands(new String[] { "setspawn", "delspawn", "savespawns", "confirmspawn" });
/*  45 */     registerListeners(new Listener[] { (Listener)new PlayerJoin(), (Listener)new PlayerQuit(), (Listener)new PlayerMove(), (Listener)new PlayerInteract(), (Listener)new InventoryOpen(), (Listener)new BlockBreak(), (Listener)new PlayerDeath(), (Listener)new PlayerPreLogin(), (Listener)new BlockIgnite(), (Listener)new PlayerRespawn(), (Listener)new EntityDamageByEntity(), (Listener)new EntityDamage(), (Listener)new PlayerChat(), (Listener)new InventoryClick(), (Listener)new EntitySpawn() });
/*     */ 
/*     */     
/*  48 */     getServer().getMessenger().registerOutgoingPluginChannel((Plugin)this, "BungeeCord");
/*  49 */     getServer().getMessenger().registerIncomingPluginChannel((Plugin)this, "BungeeCord", (PluginMessageListener)new BungeeCord());
/*     */     
/*  51 */     hungergames = this;
/*  52 */     this.arenas.setup();
/*  53 */     this.config.setup();
/*  54 */     this.perms.setupPermissions();
/*  55 */     this.mapManager.loadSpawn();
/*  56 */     this.votingManager.addChoices();
/*     */     
/*  58 */     new Runnable();
/*  59 */     new MySQLManager("74.194.245.37", Integer.valueOf(3306), "MCZone", "root", "");
/*     */   }
/*     */   
/*     */   public void onDisable() {
/*  63 */     if (GameState.isState(GameState.LOBBY)) {
/*     */       return;
/*     */     }
/*  66 */     this.mapManager.unloadMap(this.votingManager.getMapName());
/*     */   }
/*     */   
/*     */   private void registerArenaCommands(String... commands) {
/*  70 */     for (String command : commands) {
/*  71 */       getCommand(command).setExecutor((CommandExecutor)new ArenaCommands());
/*     */     }
/*     */   }
/*     */   
/*     */   private void registerChestCommands(String... commands) {
/*  76 */     for (String command : commands) {
/*  77 */       getCommand(command).setExecutor((CommandExecutor)new ChestCommands());
/*     */     }
/*     */   }
/*     */   
/*     */   private void registerGameCommands(String... commands) {
/*  82 */     for (String command : commands) {
/*  83 */       getCommand(command).setExecutor((CommandExecutor)new GameCommands());
/*     */     }
/*     */   }
/*     */   
/*     */   private void registerMiscCommands(String... commands) {
/*  88 */     for (String command : commands) {
/*  89 */       getCommand(command).setExecutor((CommandExecutor)new MiscCommands());
/*     */     }
/*     */   }
/*     */   
/*     */   private void registerSpawnCommands(String... commands) {
/*  94 */     for (String command : commands) {
/*  95 */       getCommand(command).setExecutor((CommandExecutor)new SpawnCommands());
/*     */     }
/*     */   }
/*     */   
/*     */   private void registerListeners(Listener... listeners) {
/* 100 */     for (Listener listener : listeners) {
/* 101 */       getServer().getPluginManager().registerEvents(listener, (Plugin)this);
/*     */     }
/*     */   }
/*     */   
/*     */   public static Hungergames getHungergames() {
/* 106 */     return hungergames;
/*     */   }
/*     */   
/* 109 */   private Arenas arenas = new Arenas();
/* 110 */   private ChestManager chestManager = new ChestManager();
/* 111 */   private Config config = new Config();
/* 112 */   private Messages msgs = new Messages();
/* 113 */   private Perms perms = new Perms();
/* 114 */   private MapManager mapManager = new MapManager();
/* 115 */   private VotingManager votingManager = new VotingManager();
/*     */ }


/* Location:              /home/tyler/Downloads/jar files/Hungergames.jar!/com/mczone/hungergames/Hungergames.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */