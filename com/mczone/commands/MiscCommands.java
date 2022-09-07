/*     */ package com.mczone.commands;
/*     */ 
/*     */ import com.mczone.configs.Arenas;
/*     */ import com.mczone.hungergames.Configuration;
/*     */ import com.mczone.hungergames.GameHandler;
/*     */ import com.mczone.hungergames.GameState;
/*     */ import com.mczone.managers.MapManager;
/*     */ import com.mczone.managers.StatsManager;
/*     */ import com.mczone.managers.VotingManager;
/*     */ import com.mczone.utils.Bounty;
/*     */ import com.mczone.utils.ChatUtils;
/*     */ import com.mczone.utils.GamePlayer;
/*     */ import com.mczone.utils.Items;
/*     */ import com.mczone.utils.Map;
/*     */ import com.mczone.utils.Messages;
/*     */ import com.mczone.utils.Perms;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Set;
/*     */ import java.util.UUID;
/*     */ import org.bukkit.Bukkit;
/*     */ import org.bukkit.World;
/*     */ import org.bukkit.command.Command;
/*     */ import org.bukkit.command.CommandExecutor;
/*     */ import org.bukkit.command.CommandSender;
/*     */ import org.bukkit.entity.Player;
/*     */ import org.bukkit.inventory.ItemStack;
/*     */ 
/*     */ public class MiscCommands implements CommandExecutor {
/*  32 */   private static List<Bounty> bounties = new ArrayList<>(); private String aName;
/*     */   private GamePlayer gPlayer;
/*  34 */   private Set<UUID> voted = new HashSet<>();
/*     */ 
/*     */   
/*     */   public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
/*  38 */     ChatUtils chatUtils = new ChatUtils();
/*  39 */     Configuration configuration = new Configuration();
/*  40 */     MapManager mapManager = new MapManager();
/*  41 */     StatsManager statsManager = new StatsManager();
/*     */ 
/*     */     
/*  44 */     if (cmd.getName().equalsIgnoreCase("load")) {
/*  45 */       if (!sender.hasPermission(Perms.load)) {
/*  46 */         sender.sendMessage(this.msgs.needPermission(Perms.load));
/*  47 */         return true;
/*     */       } 
/*  49 */       if (args.length != 1) {
/*  50 */         sender.sendMessage(this.msgs.load());
/*  51 */         return true;
/*     */       } 
/*  53 */       String mName = args[0];
/*     */       
/*  55 */       if (!mapManager.doesMapExist(mName)) {
/*  56 */         sender.sendMessage(this.msgs.mapDoesntExist(mName));
/*  57 */         return true;
/*     */       } 
/*  59 */       if (Bukkit.getWorld(mName) != null) {
/*  60 */         sender.sendMessage(this.msgs.alreadyLoaded(mName));
/*  61 */         return true;
/*     */       } 
/*  63 */       mapManager.loadMap(mName);
/*  64 */       sender.sendMessage(this.msgs.mapLoaded(mName));
/*     */     } 
/*     */ 
/*     */     
/*  68 */     if (cmd.getName().equalsIgnoreCase("unload")) {
/*  69 */       if (!sender.hasPermission(Perms.unload)) {
/*  70 */         sender.sendMessage(this.msgs.needPermission(Perms.unload));
/*  71 */         return true;
/*     */       } 
/*  73 */       if (args.length != 1) {
/*  74 */         sender.sendMessage(this.msgs.unload());
/*  75 */         return true;
/*     */       } 
/*  77 */       String mName = args[0];
/*     */       
/*  79 */       if (!mapManager.doesMapExist(mName)) {
/*  80 */         sender.sendMessage(this.msgs.mapDoesntExist(mName));
/*  81 */         return true;
/*     */       } 
/*  83 */       if (Bukkit.getWorld(mName) == null) {
/*  84 */         sender.sendMessage(this.msgs.mapAlreadyUnloaded(mName));
/*  85 */         return true;
/*     */       } 
/*  87 */       if (Bukkit.getWorld(mName).getPlayers().size() != 0) {
/*  88 */         sender.sendMessage(this.msgs.couldNotBeUnloaded(mName));
/*  89 */         return true;
/*     */       } 
/*  91 */       mapManager.unloadMap(mName);
/*  92 */       sender.sendMessage(this.msgs.mapUnloaded(mName));
/*     */     } 
/*     */ 
/*     */     
/*  96 */     if (cmd.getName().equalsIgnoreCase("map")) {
/*  97 */       if (!(sender instanceof Player)) {
/*  98 */         sender.sendMessage(this.msgs.mustBePlayer());
/*  99 */         return true;
/*     */       } 
/* 101 */       Player p = (Player)sender;
/*     */       
/* 103 */       if (!p.hasPermission(Perms.map)) {
/* 104 */         p.sendMessage(this.msgs.needPermission(Perms.map));
/* 105 */         return true;
/*     */       } 
/* 107 */       if (args.length != 1) {
/* 108 */         p.sendMessage(this.msgs.map());
/* 109 */         return true;
/*     */       } 
/* 111 */       String mName = args[0];
/*     */       
/* 113 */       if (Bukkit.getWorld(mName) == null || !mapManager.doesMapExist(mName)) {
/* 114 */         p.sendMessage(this.msgs.pleaseLoadMap(mName));
/* 115 */         return true;
/*     */       } 
/* 117 */       p.teleport(Bukkit.getWorld(mName).getSpawnLocation());
/* 118 */       p.sendMessage(this.msgs.welcome());
/*     */     } 
/*     */ 
/*     */     
/* 122 */     if (cmd.getName().equalsIgnoreCase("maps")) {
/* 123 */       if (!sender.hasPermission(Perms.maps)) {
/* 124 */         sender.sendMessage(this.msgs.needPermission(Perms.maps));
/* 125 */         return true;
/*     */       } 
/* 127 */       if (args.length != 0) {
/* 128 */         sender.sendMessage(this.msgs.maps());
/* 129 */         return true;
/*     */       } 
/*     */       
/* 132 */       StringBuilder str = new StringBuilder();
/* 133 */       for (World m : Bukkit.getWorlds()) {
/* 134 */         str.append(m.getName()).append(", ");
/*     */       }
/* 136 */       String names = str.toString().trim();
/*     */       
/* 138 */       sender.sendMessage(this.msgs.loadedMaps(names));
/*     */     } 
/*     */ 
/*     */     
/* 142 */     if (cmd.getName().equalsIgnoreCase("tier")) {
/* 143 */       if (!(sender instanceof Player)) {
/* 144 */         sender.sendMessage(this.msgs.mustBePlayer());
/* 145 */         return true;
/*     */       } 
/* 147 */       Player p = (Player)sender;
/*     */       
/* 149 */       if (!p.hasPermission(Perms.tier)) {
/* 150 */         p.sendMessage(this.msgs.needPermission(Perms.tier));
/* 151 */         return true;
/*     */       } 
/* 153 */       if (args.length != 0) {
/* 154 */         p.sendMessage(this.msgs.tier());
/* 155 */         return true;
/*     */       } 
/* 157 */       if (p.getInventory().contains(Items.tier())) {
/* 158 */         p.sendMessage(this.msgs.alreadyHaveThisItem());
/* 159 */         return true;
/*     */       } 
/* 161 */       p.getInventory().addItem(new ItemStack[] { Items.tier() });
/* 162 */       p.sendMessage(this.msgs.itemAdded());
/*     */     } 
/*     */     
/* 165 */     if (cmd.getName().equalsIgnoreCase("save")) {
/* 166 */       if (!sender.hasPermission(Perms.save)) {
/* 167 */         sender.sendMessage(this.msgs.needPermission(Perms.save));
/* 168 */         return true;
/*     */       } 
/* 170 */       if (!GameState.isState(GameState.LOBBY)) {
/* 171 */         sender.sendMessage(this.msgs.cannotAtThisTime());
/* 172 */         return true;
/*     */       } 
/* 174 */       if (args.length != 1) {
/* 175 */         sender.sendMessage(this.msgs.save());
/* 176 */         return true;
/*     */       } 
/* 178 */       String mName = args[0];
/*     */       
/* 180 */       Bukkit.getWorld(mName).save();
/* 181 */       sender.sendMessage(this.msgs.mapSaved(mName));
/*     */     } 
/*     */ 
/*     */     
/* 185 */     if (cmd.getName().equalsIgnoreCase("spawn")) {
/* 186 */       if (sender instanceof Player) {
/* 187 */         Player p = (Player)sender;
/*     */         
/* 189 */         if (!p.hasPermission(Perms.spawn)) {
/* 190 */           p.sendMessage(this.msgs.needPermission(Perms.spawn));
/* 191 */           return true;
/*     */         } 
/* 193 */         if (args.length != 0) {
/* 194 */           p.sendMessage(this.msgs.spawn());
/* 195 */           return true;
/*     */         } 
/* 197 */         if (!containsMap(p)) {
/* 198 */           p.sendMessage(this.msgs.pleaseCreateArena());
/* 199 */           return true;
/*     */         } 
/* 201 */         if (p.getInventory().contains(Items.spawn())) {
/* 202 */           p.sendMessage(this.msgs.alreadyHaveThisItem());
/* 203 */           return true;
/*     */         } 
/* 205 */         if (this.gameHandler.getCurrentArena() != null && !this.gameHandler.getCurrentArena().equalsIgnoreCase(getArenaName())) {
/* 206 */           p.sendMessage(this.msgs.pleaseLoadArenaFirst(getArenaName()));
/* 207 */           return true;
/*     */         } 
/* 209 */         p.getInventory().addItem(new ItemStack[] { Items.spawn() });
/* 210 */         p.sendMessage(this.msgs.itemAdded());
/*     */       } else {
/* 212 */         sender.sendMessage(this.msgs.mustBePlayer());
/*     */       } 
/*     */     }
/*     */     
/* 216 */     if (cmd.getName().equalsIgnoreCase("stats"))
/*     */     {
/* 218 */       if (sender instanceof Player) {
/* 219 */         Player p = (Player)sender;
/*     */         
/* 221 */         if (!p.hasPermission(Perms.stats)) {
/* 222 */           p.sendMessage(this.msgs.needPermission(Perms.stats));
/* 223 */           return true;
/*     */         } 
/* 225 */         if (args.length == 0) {
/* 226 */           statsManager.getStats(p);
/* 227 */           p.sendMessage(this.msgs.getStats(chatUtils.colorName(p), statsManager.points, statsManager.chestsOpened, statsManager.gamesPlayed, statsManager.playersKlled, statsManager.gamesWon, statsManager.deathmatchesPlayed, 
/* 228 */                 Float.valueOf(0.0F)));
/* 229 */           return true;
/*     */         } 
/* 231 */         if (args.length == 1) {
/* 232 */           String pName = args[0];
/*     */           
/* 234 */           if (Bukkit.getPlayerExact(pName) != null && Bukkit.getPlayerExact(pName).isOnline()) {
/* 235 */             statsManager.getStats(Bukkit.getPlayerExact(pName));
/* 236 */             float kd = statsManager.playersKlled.floatValue() / statsManager.deaths.floatValue();
/* 237 */             p.sendMessage(this.msgs.getStats(chatUtils.colorName(Bukkit.getPlayerExact(pName)), statsManager.points, statsManager.chestsOpened, statsManager.gamesPlayed, statsManager.playersKlled, statsManager.gamesWon, statsManager.deathmatchesPlayed, 
/* 238 */                   Float.valueOf(kd)));
/* 239 */             return true;
/*     */           } 
/* 241 */           p.sendMessage(this.msgs.notFound(pName));
/* 242 */           return true;
/*     */         } 
/* 244 */         p.sendMessage(this.msgs.stats());
/*     */       } else {
/* 246 */         sender.sendMessage(this.msgs.mustBePlayer());
/*     */       } 
/*     */     }
/*     */     
/* 250 */     if (cmd.getName().equalsIgnoreCase("list")) {
/* 251 */       if (!sender.hasPermission(Perms.list)) {
/* 252 */         sender.sendMessage(this.msgs.needPermission(Perms.list));
/* 253 */         return true;
/*     */       } 
/* 255 */       if (args.length != 0) {
/* 256 */         sender.sendMessage(this.msgs.list());
/* 257 */         return true;
/*     */       } 
/* 259 */       sender.sendMessage(ChatUtils.format(this.msgs.listPlayers(Integer.valueOf(this.gameHandler.getPlayers().size() + this.gameHandler.getSpectators().size()), configuration.MAXPLAYERS, getPlaying(), getWatching())));
/*     */     } 
/*     */     
/* 262 */     if (cmd.getName().equalsIgnoreCase("vote")) {
/* 263 */       if (sender instanceof Player) {
/* 264 */         Player p = (Player)sender;
/*     */         
/* 266 */         if (!p.hasPermission(Perms.vote)) {
/* 267 */           p.sendMessage(this.msgs.needPermission(Perms.vote));
/* 268 */           return true;
/*     */         } 
/* 270 */         if (!GameState.isState(GameState.LOBBY)) {
/* 271 */           p.sendMessage(this.msgs.cannotAtThisTime());
/* 272 */           return true;
/*     */         } 
/* 274 */         if (configuration.getLobbyTime() <= 10) {
/* 275 */           p.sendMessage(this.msgs.tooLateToVote());
/* 276 */           return true;
/*     */         } 
/* 278 */         if (args.length == 0) {
/* 279 */           choices(p);
/* 280 */           return true;
/*     */         } 
/* 282 */         if (args.length == 1) {
/* 283 */           if (this.voted.contains(p.getUniqueId())) {
/* 284 */             p.sendMessage(this.msgs.alreadyVoted());
/* 285 */             return true;
/*     */           } 
/* 287 */           Integer choiceID = Integer.valueOf(0);
/*     */           try {
/* 289 */             choiceID = Integer.valueOf(Integer.parseInt(args[0]));
/* 290 */           } catch (IllegalArgumentException ia) {
/* 291 */             p.sendMessage(this.msgs.notAnOption());
/*     */           } 
/* 293 */           if (choiceID.intValue() > this.votingManager.getChoices().size() && choiceID.intValue() == 0) {
/* 294 */             p.sendMessage(this.msgs.notAnOption());
/* 295 */             return true;
/*     */           } 
/* 297 */           this.votingManager.addVote(p, Integer.valueOf(choiceID.intValue() - 1));
/* 298 */           p.sendMessage(this.msgs.thanksForVoting(Integer.valueOf(((Map)this.votingManager.getChoices().get(choiceID.intValue() - 1)).getNumberOfVotes())));
/* 299 */           this.voted.add(p.getUniqueId());
/* 300 */           return true;
/*     */         } 
/* 302 */         p.sendMessage(this.msgs.vote());
/*     */       } else {
/* 304 */         sender.sendMessage(this.msgs.mustBePlayer());
/*     */       } 
/*     */     }
/* 307 */     if (cmd.getName().equalsIgnoreCase("bounty")) {
/* 308 */       if (!(sender instanceof Player)) {
/* 309 */         sender.sendMessage(this.msgs.mustBePlayer());
/* 310 */         return true;
/*     */       } 
/* 312 */       Player p = (Player)sender;
/*     */       
/* 314 */       if (!p.hasPermission(Perms.bounty)) {
/* 315 */         p.sendMessage(this.msgs.needPermission(Perms.bounty));
/* 316 */         return true;
/*     */       } 
/* 318 */       if (args.length != 2) {
/* 319 */         p.sendMessage(this.msgs.bounty());
/* 320 */         return true;
/*     */       } 
/* 322 */       String pName = args[0];
/* 323 */       Integer amount = Integer.valueOf(0);
/*     */       
/* 325 */       if (Bukkit.getPlayer(pName) == null) {
/* 326 */         p.sendMessage(this.msgs.notFound(pName));
/* 327 */         return true;
/*     */       } 
/*     */       try {
/* 330 */         amount = Integer.valueOf(Integer.parseInt(args[1]));
/* 331 */       } catch (IllegalArgumentException ia) {
/* 332 */         p.sendMessage(this.msgs.bounty());
/*     */       } 
/*     */       
/* 335 */       if (amount.intValue() < 100) {
/* 336 */         p.sendMessage(this.msgs.mustBountyAtleast100());
/* 337 */         return true;
/*     */       } 
/* 339 */       statsManager.getStats(p);
/* 340 */       if (amount.intValue() > statsManager.points.intValue()) {
/* 341 */         p.sendMessage(this.msgs.notEnoughPoints());
/* 342 */         return true;
/*     */       } 
/* 344 */       if (!GameState.isState(GameState.INGAME)) {
/* 345 */         p.sendMessage(this.msgs.cannotAtThisTime());
/* 346 */         return true;
/*     */       } 
/* 348 */       p.sendMessage(this.msgs.areYouSure());
/* 349 */       bounties.add(new Bounty(Bukkit.getPlayer(pName).getUniqueId(), p.getUniqueId(), amount));
/*     */     } 
/*     */     
/* 352 */     if (cmd.getName().equalsIgnoreCase("confirmbounty")) {
/* 353 */       if (!(sender instanceof Player)) {
/* 354 */         sender.sendMessage(this.msgs.mustBePlayer());
/* 355 */         return true;
/*     */       } 
/* 357 */       Player p = (Player)sender;
/*     */       
/* 359 */       if (!p.hasPermission(Perms.confirmbounty)) {
/* 360 */         p.sendMessage(this.msgs.needPermission(Perms.confirmbounty));
/* 361 */         return true;
/*     */       } 
/* 363 */       if (args.length != 0) {
/* 364 */         p.sendMessage(this.msgs.confirmbounty());
/* 365 */         return true;
/*     */       } 
/*     */       
/* 368 */       Iterator<Bounty> it = bounties.iterator();
/*     */       
/* 370 */       while (it.hasNext()) {
/* 371 */         Bounty bounty = it.next();
/* 372 */         for (GamePlayer gamePlayer : this.gameHandler.getPlayers()) {
/* 373 */           if (bounty.getSender() != p.getUniqueId()) {
/*     */             continue;
/*     */           }
/* 376 */           if (bounty.getTarget() != gamePlayer.getUUID()) {
/*     */             continue;
/*     */           }
/* 379 */           gamePlayer.setBountied(true);
/* 380 */           gamePlayer.setAmount(bounty.getAmount());
/* 381 */           ChatUtils.announce(this.msgs.bountySetOnPlayer(chatUtils.colorName(Bukkit.getPlayer(gamePlayer.getUUID())), chatUtils
/* 382 */                 .colorName(p), bounty.getAmount().intValue()), Boolean.valueOf(false), Boolean.valueOf(true));
/* 383 */           statsManager.removePoints(bounty.getAmount(), p);
/* 384 */           it.remove();
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 389 */     if (cmd.getName().equalsIgnoreCase("spectate")) {
/* 390 */       if (!(sender instanceof Player)) {
/* 391 */         sender.sendMessage(this.msgs.mustBePlayer());
/* 392 */         return true;
/*     */       } 
/* 394 */       Player p = (Player)sender;
/*     */       
/* 396 */       if (!p.hasPermission(Perms.spectate)) {
/* 397 */         p.sendMessage(this.msgs.needPermission(Perms.spectate));
/* 398 */         return true;
/*     */       } 
/* 400 */       if (args.length != 1) {
/* 401 */         p.sendMessage(this.msgs.spectate());
/* 402 */         return true;
/*     */       } 
/* 404 */       if (GameState.isState(GameState.LOBBY)) {
/* 405 */         p.sendMessage(this.msgs.cannotAtThisTime());
/* 406 */         return true;
/*     */       } 
/* 408 */       String pName = args[0];
/*     */       
/* 410 */       if (!doesExist(pName)) {
/* 411 */         p.sendMessage(this.msgs.notFound(pName));
/* 412 */         return true;
/*     */       } 
/* 414 */       p.teleport(Bukkit.getPlayer(this.gPlayer.getUUID()).getLocation());
/* 415 */       p.sendMessage(this.msgs.youreNowSpectating(chatUtils.colorName(p)));
/*     */     } 
/* 417 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean containsMap(Player p) {
/* 423 */     Arenas arenas = new Arenas();
/*     */     
/* 425 */     boolean containsMap = false;
/* 426 */     for (String s : arenas.getArenasConfig().getConfigurationSection("arenas").getKeys(false)) {
/* 427 */       if (arenas.getArenasConfig().getString(String.format("arenas.%s.world", new Object[] { s })).equalsIgnoreCase(p.getWorld().getName())) {
/* 428 */         this.aName = s;
/* 429 */         containsMap = true;
/*     */       } 
/*     */     } 
/* 432 */     return containsMap;
/*     */   }
/*     */ 
/*     */   
/*     */   private String getPlaying() {
/* 437 */     StringBuilder stringBuilder = new StringBuilder();
/* 438 */     for (GamePlayer gamePlayer : this.gameHandler.getPlayers()) {
/* 439 */       stringBuilder.append(this.chatUtils.colorName(Bukkit.getPlayer(gamePlayer.getUUID()))).append("&f, ");
/*     */     }
/* 441 */     return stringBuilder.toString().trim();
/*     */   }
/*     */ 
/*     */   
/*     */   private String getWatching() {
/* 446 */     StringBuilder stringBuilder = new StringBuilder();
/* 447 */     for (UUID uuid : this.gameHandler.getSpectators()) {
/* 448 */       stringBuilder.append(this.chatUtils.colorName(Bukkit.getPlayer(uuid))).append("&f, ");
/*     */     }
/* 450 */     return stringBuilder.toString().trim();
/*     */   }
/*     */ 
/*     */   
/*     */   private void choices(Player player) {
/* 455 */     for (int counter = 0; counter < this.votingManager.getChoices().size(); counter++) {
/* 456 */       player.sendMessage(this.msgs.choice(counter + 1, ((Map)this.votingManager.getChoices().get(counter)).getNumberOfVotes(), this.votingManager.getTotalVotes(), ((Map)this.votingManager
/* 457 */             .getChoices().get(counter)).getWorldName().replace('_', ' ').trim()));
/*     */     }
/*     */   }
/*     */   
/*     */   private boolean doesExist(String pName) {
/* 462 */     boolean exist = false;
/* 463 */     for (GamePlayer gamePlayer : this.gameHandler.getPlayers()) {
/* 464 */       if (gamePlayer.getName().equalsIgnoreCase(pName)) {
/* 465 */         exist = true;
/* 466 */         this.gPlayer = gamePlayer;
/*     */         break;
/*     */       } 
/*     */     } 
/* 470 */     return exist;
/*     */   }
/*     */   
/*     */   public String getArenaName() {
/* 474 */     return this.aName;
/*     */   }
/*     */   
/* 477 */   private ChatUtils chatUtils = new ChatUtils();
/* 478 */   private GameHandler gameHandler = new GameHandler();
/* 479 */   private Messages msgs = new Messages();
/* 480 */   private VotingManager votingManager = new VotingManager();
/*     */ }


/* Location:              /home/tyler/Downloads/jar files/Hungergames.jar!/com/mczone/commands/MiscCommands.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */