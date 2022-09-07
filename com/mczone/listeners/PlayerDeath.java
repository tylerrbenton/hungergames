/*     */ package com.mczone.listeners;
/*     */ 
/*     */ import com.mczone.hungergames.GameHandler;
/*     */ import com.mczone.hungergames.GameState;
/*     */ import com.mczone.managers.StatsManager;
/*     */ import com.mczone.utils.ChatUtils;
/*     */ import com.mczone.utils.GamePlayer;
/*     */ import com.mczone.utils.Messages;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ import java.util.UUID;
/*     */ import org.bukkit.Bukkit;
/*     */ import org.bukkit.GameMode;
/*     */ import org.bukkit.Location;
/*     */ import org.bukkit.entity.Player;
/*     */ import org.bukkit.event.EventHandler;
/*     */ import org.bukkit.event.Listener;
/*     */ import org.bukkit.event.entity.PlayerDeathEvent;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PlayerDeath
/*     */   implements Listener
/*     */ {
/*  32 */   private static Map<UUID, Location> deaths = new HashMap<>();
/*     */   
/*     */   @EventHandler
/*     */   public void onDeath(PlayerDeathEvent e) {
/*  36 */     GameHandler gameHandler = new GameHandler();
/*  37 */     Messages msgs = new Messages();
/*  38 */     StatsManager statsManager = new StatsManager();
/*     */     
/*  40 */     Player p = e.getEntity();
/*     */     
/*  42 */     e.setDeathMessage(null);
/*     */     
/*  44 */     statsManager.update("UPDATE stats SET deaths = deaths + 1 WHERE uuid = ?", p);
/*  45 */     Integer points = Integer.valueOf(statsManager.getPoints(p).intValue() / 10);
/*  46 */     statsManager.removePoints(points, p);
/*     */     
/*  48 */     if (GameState.isState(GameState.LOBBY)) {
/*     */       return;
/*     */     }
/*     */     
/*  52 */     p.getWorld().strikeLightningEffect(p.getLocation());
/*     */     
/*  54 */     Boolean isBountied = Boolean.valueOf(false);
/*  55 */     Integer bAmount = Integer.valueOf(0);
/*     */     
/*  57 */     Iterator<GamePlayer> it = gameHandler.getPlayers().iterator();
/*  58 */     while (it.hasNext()) {
/*  59 */       GamePlayer gPlayer = it.next();
/*  60 */       if (gPlayer.getUUID() != p.getUniqueId()) {
/*     */         continue;
/*     */       }
/*  63 */       isBountied = Boolean.valueOf(gPlayer.isBountied());
/*  64 */       bAmount = gPlayer.getAmount();
/*     */       
/*  66 */       it.remove();
/*     */     } 
/*  68 */     gameHandler.getSpectators().add(p.getUniqueId());
/*     */     
/*  70 */     p.sendMessage(msgs.eliminated());
/*     */     
/*  72 */     if (!GameState.isState(GameState.DEATHMATCH)) {
/*  73 */       ChatUtils.announce(msgs.tributesRemaining(gameHandler.getPlayers().size()), Boolean.valueOf(false), Boolean.valueOf(true));
/*  74 */       ChatUtils.announce(msgs.specsWatching(gameHandler.getSpectators().size()), Boolean.valueOf(false), Boolean.valueOf(true));
/*     */     } 
/*     */ 
/*     */     
/*  78 */     if (isBountied.booleanValue()) {
/*  79 */       statsManager.getBounty(bAmount, p.getKiller());
/*  80 */       ChatUtils.announce(msgs.bountyClaimedUponDeath(bAmount, this.chatUtils.colorName(p.getKiller())), Boolean.valueOf(false), Boolean.valueOf(true));
/*     */     } 
/*     */ 
/*     */     
/*  84 */     for (GamePlayer gamePlayer : gameHandler.getPlayers()) {
/*  85 */       if (gamePlayer.getUUID() == p.getKiller().getUniqueId()) {
/*  86 */         p.getKiller().sendMessage(msgs.pointsGainedForKill(points.intValue(), this.chatUtils.colorName(p)));
/*  87 */         statsManager.update("UPDATE stats SET players_killed = players_killed + 1 WHERE uuid = ?", p.getKiller());
/*  88 */         statsManager.addPoints(points, p.getKiller());
/*     */       } 
/*     */     } 
/*  91 */     p.sendMessage(msgs.pointsLost(points));
/*  92 */     ChatUtils.announce(msgs.cannonHeard(this.chatUtils.colorName(p)), Boolean.valueOf(false), Boolean.valueOf(true));
/*     */ 
/*     */     
/*  95 */     for (GamePlayer gamePlayer : gameHandler.getPlayers()) {
/*  96 */       Bukkit.getPlayer(gamePlayer.getUUID()).hidePlayer(p);
/*     */     }
/*  98 */     deaths.put(p.getUniqueId(), p.getLocation());
/*  99 */     p.spigot().respawn();
/* 100 */     p.setGameMode(GameMode.SPECTATOR);
/*     */   }
/*     */   
/*     */   static Map<UUID, Location> getDeaths() {
/* 104 */     return deaths;
/*     */   }
/*     */   
/* 107 */   private ChatUtils chatUtils = new ChatUtils();
/*     */ }


/* Location:              /home/tyler/Downloads/jar files/Hungergames.jar!/com/mczone/listeners/PlayerDeath.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */