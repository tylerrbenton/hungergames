/*     */ package com.mczone.utils;
/*     */ 
/*     */ import com.mczone.hungergames.GameState;
/*     */ import com.mczone.managers.VotingManager;
/*     */ import org.bukkit.Material;
/*     */ import org.bukkit.World;
/*     */ import org.bukkit.entity.Player;
/*     */ import org.bukkit.permissions.Permission;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Messages
/*     */ {
/*     */   public String youreNowSpectating(String pName) {
/*  20 */     return String.format(ChatUtils.format(this.chatUtils.consolePrefix() + "&aYou are now spectating %s&a."), new Object[] { pName });
/*     */   }
/*     */   
/*     */   public String youreAbleToSpec() {
/*  24 */     return ChatUtils.format(this.chatUtils.consolePrefix() + "&fYou are now able to spectate others. You may click the item in your inventory to quit spectating an individual if you are.");
/*     */   }
/*     */   
/*     */   public String eliminated() {
/*  28 */     return ChatUtils.format(this.chatUtils.consolePrefix() + "&aYou have been eliminated from the game.");
/*     */   }
/*     */   
/*     */   public String pointsLost(Integer amount) {
/*  32 */     return String.format(ChatUtils.format(this.chatUtils.consolePrefix() + "&3You've lost &8&l[&e%d&8&l] &3points for dying&8!"), new Object[] { amount });
/*     */   }
/*     */   
/*     */   public String youWereSponsored(Player p) {
/*  36 */     return String.format(ChatUtils.format(this.chatUtils.consolePrefix() + "&fSurprise - You were sponsored by %s!\n" + this.chatUtils
/*  37 */           .consolePrefix() + "&fRemember to thank them!"), new Object[] { p.getName() });
/*     */   }
/*     */   
/*     */   public String areYouSure() {
/*  41 */     return ChatUtils.format(this.chatUtils.consolePrefix() + "&7Are you sure&8? &cThis cannot be undone! &7Use &8&l[&6/confirmbounty&8&l] &7 to confirm&8.");
/*     */   }
/*     */   
/*     */   public String listPlayers(Integer players, Integer maxPlayers, String ingame, String watching) {
/*  45 */     if (GameState.isState(GameState.LOBBY)) {
/*  46 */       return String.format(ChatUtils.format(this.chatUtils.consolePrefix() + "&fThere are &8&l[&6%d&8&l/&6%d&8&l] &fplayers online&8.\n&8- &fWatching&8: %s"), new Object[] { players, maxPlayers, ingame });
/*     */     }
/*     */     
/*  49 */     return String.format(ChatUtils.format(this.chatUtils.consolePrefix() + "&fThere are &8&l[&6%d&8&l/&6%d&8&l] &fplayers online&8.\n&8- &fIngame&8: %s\n&8- &fWatching&8: %s"), new Object[] { players, maxPlayers, ingame, watching });
/*     */   }
/*     */ 
/*     */   
/*     */   public String getStats(String pName, Integer points, Float chestsOpened, Float gamesPlayed, Float playerKills, Float gamesWon, Float dematchesPlayed, Float killDeathRatio) {
/*  54 */     return String.format(ChatUtils.format("&8&m    &r %s's &fstats &8&m    \n&fPoints: &e%d\n&fChests Opened: &e%.1f\n&fGames Played: &e%.1f\n&fPlayer Kills: &e%.1f\n&fGames Won: &e %.1f\n&fDeathmatches: &e%.1f\n&fKill / Death Ratio: &e%.2f"), new Object[] { pName, points, chestsOpened, gamesPlayed, playerKills, gamesWon, dematchesPlayed, killDeathRatio });
/*     */   }
/*     */ 
/*     */   
/*     */   public String allSpawnsSaved(Integer spawns) {
/*  59 */     if (spawns.intValue() == 1) {
/*  60 */       return String.format(ChatUtils.format(this.chatUtils.consolePrefix() + "&f%d &aspawn was successfully saved.."), new Object[] { spawns });
/*     */     }
/*  62 */     return String.format(ChatUtils.format(this.chatUtils.consolePrefix() + "&f%d &aspawns was successfully saved.."), new Object[] { spawns });
/*     */   }
/*     */   
/*     */   public String arenaCreated(String name) {
/*  66 */     return String.format(ChatUtils.format(this.chatUtils.consolePrefix() + "&aArena &f%s &awas successfully created.."), new Object[] { name });
/*     */   }
/*     */   
/*     */   public String arenaLoaded(String name) {
/*  70 */     return String.format(ChatUtils.format(this.chatUtils.consolePrefix() + "&aArena &f%s &awas successfully loaded.."), new Object[] { name });
/*     */   }
/*     */   
/*     */   public String arenaRemoved(String name) {
/*  74 */     return String.format(ChatUtils.format(this.chatUtils.consolePrefix() + "&aArena &f%s &a was successfully removed.."), new Object[] { name });
/*     */   }
/*     */   
/*     */   public String arenaContainsThisWorld(String name) {
/*  78 */     return String.format(ChatUtils.format(this.chatUtils.consolePrefix() + "&aArena &f%s &acontains this world.."), new Object[] { name });
/*     */   }
/*     */   
/*     */   public String chestSet(Material material) {
/*  82 */     return String.format(ChatUtils.format(this.chatUtils.consolePrefix() + "&aThe &f%s &awas set successfully.."), new Object[] { material });
/*     */   }
/*     */   
/*     */   public String chestsSaved(Integer chests, Integer enderChests) {
/*  86 */     Integer chestsSaved = Integer.valueOf(chests.intValue() + enderChests.intValue());
/*     */     
/*  88 */     if (chestsSaved.intValue() != 1) {
/*  89 */       return String.format(ChatUtils.format(this.chatUtils.consolePrefix() + "&f%d &achests was successfully saved.."), new Object[] { chestsSaved });
/*     */     }
/*  91 */     return String.format(ChatUtils.format(this.chatUtils.consolePrefix() + "&f%d &achest was successfully saved.."), new Object[] { chestsSaved });
/*     */   }
/*     */   
/*     */   public String currentArenas(String names) {
/*  95 */     return String.format(ChatUtils.format(this.chatUtils.consolePrefix() + "&a%s"), new Object[] { names });
/*     */   }
/*     */ 
/*     */   
/*     */   public String loadedMaps(String names) {
/* 100 */     return String.format(ChatUtils.format(this.chatUtils.consolePrefix() + "&a%s"), new Object[] { names });
/*     */   }
/*     */ 
/*     */   
/*     */   public String spawnSaved() {
/* 105 */     return ChatUtils.format(this.chatUtils.consolePrefix() + "&aSpawn was successfully saved..");
/*     */   }
/*     */ 
/*     */   
/*     */   public String forceStart(boolean isForceStart) {
/* 110 */     if (isForceStart)
/* 111 */       return ChatUtils.format(this.chatUtils.consolePrefix() + "&aForce start enabled.."); 
/* 112 */     return ChatUtils.format(this.chatUtils.consolePrefix() + "&cForce start disabled..");
/*     */   }
/*     */ 
/*     */   
/*     */   public String gamePaused(boolean isPaused) {
/* 117 */     if (isPaused)
/* 118 */       return ChatUtils.format(this.chatUtils.consolePrefix() + "&aPaused.."); 
/* 119 */     return ChatUtils.format(this.chatUtils.consolePrefix() + "&cUnpaused..");
/*     */   }
/*     */   
/*     */   public String noArenas() {
/* 123 */     return ChatUtils.format(this.chatUtils.consolePrefix() + "&cNo arenas to see here..");
/*     */   }
/*     */   
/*     */   public String countdownSkipped() {
/* 127 */     return ChatUtils.format(this.chatUtils.consolePrefix() + "&aCountdown was skipped..");
/*     */   }
/*     */   
/*     */   public String thanksForVoting(Integer votes) {
/* 131 */     if (votes.intValue() == 1) {
/* 132 */       return String.format(ChatUtils.format(this.chatUtils.consolePrefix() + "&fYour map now has &8&l[&e%d&8&l] &fvote&8."), new Object[] { votes });
/*     */     }
/* 134 */     return String.format(ChatUtils.format(this.chatUtils.consolePrefix() + "&fYour map now has &8&l[&e%d&8&l] &fvotes&8."), new Object[] { votes });
/*     */   }
/*     */   
/*     */   public String itemAdded() {
/* 138 */     return ChatUtils.format(this.chatUtils.consolePrefix() + "&aItem was successfully added..");
/*     */   }
/*     */   
/*     */   public String serverReload() {
/* 142 */     return ChatUtils.format(this.chatUtils.consolePrefix() + "&cKicked due to Hunger games being reloaded..");
/*     */   }
/*     */ 
/*     */   
/*     */   public String spawnIDAdded(Integer spawnID) {
/* 147 */     return String.format(ChatUtils.format(this.chatUtils.consolePrefix() + "&aSpawnID &f%d &awas successfully added."), new Object[] { spawnID });
/*     */   }
/*     */   
/*     */   public String mapSaved(String mName) {
/* 151 */     return String.format(ChatUtils.format(this.chatUtils.consolePrefix() + "&aMap &f%s &awas successfully saved.."), new Object[] { mName });
/*     */   }
/*     */   
/*     */   public String mapUnloaded(String mName) {
/* 155 */     return String.format(ChatUtils.format(this.chatUtils.consolePrefix() + "&aMap &f%s &awas successfully unloaded.."), new Object[] { mName });
/*     */   }
/*     */   
/*     */   public String mapLoaded(String mName) {
/* 159 */     return String.format(ChatUtils.format(this.chatUtils.consolePrefix() + "&aMap &f%s &awas loaded successfully.."), new Object[] { mName });
/*     */   }
/*     */   
/*     */   public String welcome() {
/* 163 */     return ChatUtils.format(this.chatUtils.consolePrefix() + "&aWelcome..");
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String confirmbounty() {
/* 169 */     return ChatUtils.format(this.chatUtils.errorPrefix() + "confirmbounty");
/*     */   }
/*     */   
/*     */   public String bounty() {
/* 173 */     return ChatUtils.format(this.chatUtils.errorPrefix() + "&cbounty <player name> <amount>");
/*     */   }
/*     */   
/*     */   public String sponsor() {
/* 177 */     return ChatUtils.format(this.chatUtils.errorPrefix() + "&csponsor <player name>");
/*     */   }
/*     */   
/*     */   public String spectate() {
/* 181 */     return ChatUtils.format(this.chatUtils.errorPrefix() + "&cspectate <player name>");
/*     */   }
/*     */   
/*     */   public String arena() {
/* 185 */     return ChatUtils.format(this.chatUtils.errorPrefix() + "&carena");
/*     */   }
/*     */   
/*     */   public String arenas() {
/* 189 */     return ChatUtils.format(this.chatUtils.errorPrefix() + "&carenas");
/*     */   }
/*     */   
/*     */   public String confirmspawn() {
/* 193 */     return ChatUtils.format(this.chatUtils.errorPrefix() + "&cconfirmspawn");
/*     */   }
/*     */   
/*     */   public String createarena() {
/* 197 */     return ChatUtils.format(this.chatUtils.errorPrefix() + "&ccreatearena <arena name>");
/*     */   }
/*     */   
/*     */   public String load() {
/* 201 */     return ChatUtils.format(this.chatUtils.errorPrefix() + "&cload <map name>");
/*     */   }
/*     */   
/*     */   public String list() {
/* 205 */     return ChatUtils.format(this.chatUtils.errorPrefix() + "&clist");
/*     */   }
/*     */   
/*     */   public String loadarena() {
/* 209 */     return ChatUtils.format(this.chatUtils.errorPrefix() + "&cloadarena <arena name>");
/*     */   }
/*     */   
/*     */   public String pause() {
/* 213 */     return ChatUtils.format(this.chatUtils.errorPrefix() + "&cpause");
/*     */   }
/*     */   
/*     */   public String removearena() {
/* 217 */     return ChatUtils.format(this.chatUtils.errorPrefix() + "&cremovearena <arena name>");
/*     */   }
/*     */   
/*     */   public String save() {
/* 221 */     return ChatUtils.format(this.chatUtils.errorPrefix() + "&csave <map name>");
/*     */   }
/*     */   
/*     */   public String savechests() {
/* 225 */     return ChatUtils.format(this.chatUtils.errorPrefix() + "&csavechests");
/*     */   }
/*     */   
/*     */   public String savespawns() {
/* 229 */     return ChatUtils.format(this.chatUtils.errorPrefix() + "&csavespawns");
/*     */   }
/*     */   
/*     */   public String setspawn() {
/* 233 */     return ChatUtils.format(this.chatUtils.errorPrefix() + "setspawn\n" + this.chatUtils.errorPrefix() + "&csetspawn <0-23>");
/*     */   }
/*     */   
/*     */   public String skip() {
/* 237 */     return ChatUtils.format(this.chatUtils.errorPrefix() + "&cskip");
/*     */   }
/*     */   
/*     */   public String spawn() {
/* 241 */     return ChatUtils.format(this.chatUtils.errorPrefix() + "&cspawn");
/*     */   }
/*     */   
/*     */   public String stats() {
/* 245 */     return ChatUtils.format(this.chatUtils.errorPrefix() + "&cstats\n" + this.chatUtils.errorPrefix() + "&cstats <player name>");
/*     */   }
/*     */   
/*     */   public String start() {
/* 249 */     return ChatUtils.format(this.chatUtils.errorPrefix() + "&cstart");
/*     */   }
/*     */   
/*     */   public String tier() {
/* 253 */     return ChatUtils.format(this.chatUtils.errorPrefix() + "&ctier");
/*     */   }
/*     */   
/*     */   public String unload() {
/* 257 */     return ChatUtils.format(this.chatUtils.errorPrefix() + "&cunload <map name>");
/*     */   }
/*     */   
/*     */   public String map() {
/* 261 */     return ChatUtils.format(this.chatUtils.errorPrefix() + "&cmap <map name>");
/*     */   }
/*     */   
/*     */   public String maps() {
/* 265 */     return ChatUtils.format(this.chatUtils.errorPrefix() + "&cmaps");
/*     */   }
/*     */   
/*     */   public String vote() {
/* 269 */     return ChatUtils.format(this.chatUtils.errorPrefix() + "&cvote <map number>");
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String mustBountyAtleast100() {
/* 275 */     return ChatUtils.format(this.chatUtils.errorPrefix() + "&cYou must bounty a minimum 100 points.");
/*     */   }
/*     */   
/*     */   public String noBountyToConfirm() {
/* 279 */     return ChatUtils.format(this.chatUtils.errorPrefix() + "&rYou have no bounty to confirm.");
/*     */   }
/*     */   
/*     */   public String chestAlreadySet(Material material) {
/* 283 */     return String.format(ChatUtils.format(this.chatUtils.errorPrefix() + "&cThis &f%s &cis already set.."), new Object[] { material });
/*     */   }
/*     */   
/*     */   public String couldNotBeUnloaded(String mName) {
/* 287 */     return String.format(ChatUtils.format(this.chatUtils.errorPrefix() + "&cMap &f%s &ccannot be unloaded if world contain players.."), new Object[] { mName });
/*     */   }
/*     */   
/*     */   public String mustBeChest() {
/* 291 */     return ChatUtils.format(this.chatUtils.errorPrefix() + "&cThis must be a &fMATERIAL.CHEST&c..");
/*     */   }
/*     */   
/*     */   public String mustBeEnderChest() {
/* 295 */     return ChatUtils.format(this.chatUtils.errorPrefix() + "&cThis must be an &fMATERIAL.ENDER_CHEST&c..");
/*     */   }
/*     */   
/*     */   public String notFound(String name) {
/* 299 */     return String.format(ChatUtils.format(this.chatUtils.errorPrefix() + "&cPlayer %s could not be found."), new Object[] { name });
/*     */   }
/*     */   
/*     */   public String pleaseLoadArenaFirst(String arenaName) {
/* 303 */     return String.format(ChatUtils.format(this.chatUtils.errorPrefix() + "&cPleaes load arena &f%s &cbefore you continue.."), new Object[] { arenaName });
/*     */   }
/*     */   
/*     */   public String spawnIDAlreadyExist(Integer spawnID) {
/* 307 */     return String.format(ChatUtils.format(this.chatUtils.errorPrefix() + "&cSpawnID &f%d &calready exists, please use \"/confirmspawn\" to confirm.."), new Object[] { spawnID });
/*     */   }
/*     */   
/*     */   public String notEnoughPoints() {
/* 311 */     return ChatUtils.format(this.chatUtils.errorPrefix() + "&cNot enough points.");
/*     */   }
/*     */   
/*     */   public String pleaseLoadMap(String mName) {
/* 315 */     return String.format(ChatUtils.format(this.chatUtils.errorPrefix() + "&cPlease load map &f%s &c.."), new Object[] { mName });
/*     */   }
/*     */   
/*     */   public String alreadyLoaded(String mName) {
/* 319 */     return String.format(ChatUtils.format(this.chatUtils.errorPrefix() + "&cMap &f%s &cis already loaded.."), new Object[] { mName });
/*     */   }
/*     */   
/*     */   public String alreadyHaveThisItem() {
/* 323 */     return ChatUtils.format(this.chatUtils.errorPrefix() + "&cYou already have that item..");
/*     */   }
/*     */   
/*     */   public String alreadyVoted() {
/* 327 */     return ChatUtils.format(this.chatUtils.errorPrefix() + "&cYou've already voted..");
/*     */   }
/*     */   
/*     */   public String arenaAlreadyContainsMap(String name) {
/* 331 */     return String.format(ChatUtils.format(this.chatUtils.errorPrefix() + "&cArena &f%s &calready contains this world.."), new Object[] { name });
/*     */   }
/*     */   
/*     */   public String arenaDoesNotExist(String name) {
/* 335 */     return String.format(ChatUtils.format(this.chatUtils.errorPrefix() + "&cArena &f%s &cdoes not exist.."), new Object[] { name });
/*     */   }
/*     */   
/*     */   public String arenaAlreadyLoaded(String arenaName) {
/* 339 */     return String.format(ChatUtils.format(this.chatUtils.errorPrefix() + "&cArena &f%s &cis already loaded.."), new Object[] { arenaName });
/*     */   }
/*     */   
/*     */   public String cannotAtThisTime() {
/* 343 */     return ChatUtils.format(this.chatUtils.errorPrefix() + "&cYou cannot execute that command at this time..");
/*     */   }
/*     */   
/*     */   public String cannotJoin() {
/* 347 */     return String.format(ChatUtils.format("&cCannot join while game is %s.."), new Object[] { GameState.getState() });
/*     */   }
/*     */   
/*     */   public String pleaseCreateArena() {
/* 351 */     return ChatUtils.format(this.chatUtils.errorPrefix() + "&cPlease create an arena.");
/*     */   }
/*     */   
/*     */   public String noChestsToSave() {
/* 355 */     return ChatUtils.format(this.chatUtils.errorPrefix() + "&cYou have no chests to save.");
/*     */   }
/*     */   
/*     */   public String noSpawnsToSave() {
/* 359 */     return ChatUtils.format(this.chatUtils.errorPrefix() + "&cYou have no spawns to save.");
/*     */   }
/*     */   
/*     */   public String mustBePlayer() {
/* 363 */     return ChatUtils.format(this.chatUtils.errorPrefix() + "&cYou must be a player to execute this command.");
/*     */   }
/*     */   
/*     */   public String needPermission(Permission permission) {
/* 367 */     return String.format(ChatUtils.format(this.chatUtils.errorPrefix() + "&cYou must have permission %s to use this command."), new Object[] { permission.getName() });
/*     */   }
/*     */   
/*     */   public String noArenaForMap(World map) {
/* 371 */     return String.format(ChatUtils.format(this.chatUtils.errorPrefix() + "&cMap &f%s &cis not a part of an arena."), new Object[] { map.getName() });
/*     */   }
/*     */   
/*     */   public String notAnOption() {
/* 375 */     return ChatUtils.format(this.chatUtils.errorPrefix() + "&cThat is not an option.");
/*     */   }
/*     */   
/*     */   public String tooLateToVote() {
/* 379 */     return ChatUtils.format(this.chatUtils.errorPrefix() + "&cYou may not vote at this time.");
/*     */   }
/*     */   
/*     */   public String mapAlreadyUnloaded(String mName) {
/* 383 */     return String.format(ChatUtils.format(this.chatUtils.errorPrefix() + "&cMap &f%s &cis already unloaded."), new Object[] { mName });
/*     */   }
/*     */   
/*     */   public String mapDoesntExist(String mName) {
/* 387 */     return String.format(ChatUtils.format(this.chatUtils.errorPrefix() + "&cMap &f%s &cdoes not exist."), new Object[] { mName });
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String chestsRestocked(String names) {
/* 393 */     return String.format(ChatUtils.format(this.chatUtils.consolePrefix() + "&3Sponsors have refilled the chests!\n" + this.chatUtils.consolePrefix() + "These tributes have passed: %s"), new Object[] { names });
/*     */   }
/*     */   
/*     */   public String bountyClaimedUponDeath(Integer points, String name) {
/* 397 */     return String.format(ChatUtils.format("&6A bounty of &8&l[&a%d&8&l] &6points has been claimed upon %s's &6death&8."), new Object[] { points, name });
/*     */   }
/*     */   
/*     */   public String tributesRemaining(int tributes) {
/* 401 */     if (tributes == 1) {
/* 402 */       return String.format(ChatUtils.format(this.chatUtils.consolePrefix() + "&aOnly &8&l[&6%d&8&l] &atribute remain!"), new Object[] { Integer.valueOf(tributes) });
/*     */     }
/* 404 */     return String.format(ChatUtils.format(this.chatUtils.consolePrefix() + "&aOnly &8&l[&6%d&8&l] &atributes remain!"), new Object[] { Integer.valueOf(tributes) });
/*     */   }
/*     */   
/*     */   public String specsWatching(int specs) {
/* 408 */     if (specs == 1) {
/* 409 */       return String.format(ChatUtils.format(this.chatUtils.consolePrefix() + "&aThere is &8&l[&6%d&8&l] &aspectator watching the game."), new Object[] { Integer.valueOf(specs) });
/*     */     }
/* 411 */     return String.format(ChatUtils.format(this.chatUtils.consolePrefix() + "&aThere are &8&l[&6%d&8&l] &aspectators watching the game."), new Object[] { Integer.valueOf(specs) });
/*     */   }
/*     */   
/*     */   public String pointsGainedForKill(int points, String killed) {
/* 415 */     if (points == 1) {
/* 416 */       return String.format(ChatUtils.format(this.chatUtils.consolePrefix() + "&3You've gained &8&l[&e%d&8&l] &3point for killing %s&8!"), new Object[] { Integer.valueOf(points), killed });
/*     */     }
/* 418 */     return String.format(ChatUtils.format(this.chatUtils.consolePrefix() + "&3You've gained &8&l[&e%d&8&l] &3points for killing %s&8!"), new Object[] { Integer.valueOf(points), killed });
/*     */   }
/*     */   
/*     */   public String cannonHeard(String killed) {
/* 422 */     return String.format(ChatUtils.format("&6A cannon can be heard in the distance in memorial for %s&8."), new Object[] { killed });
/*     */   }
/*     */   
/*     */   public String bountySetOnPlayer(String target, String sender, int points) {
/* 426 */     return String.format(ChatUtils.format(this.chatUtils.consolePrefix() + "&3Bounty has been set on %s &3by %s &3for &8&l[&e%d&8&l] &3points&8."), new Object[] { target, sender, Integer.valueOf(points) });
/*     */   }
/*     */   
/*     */   public String secondsTilStart(int seconds) {
/* 430 */     if (seconds == 30)
/* 431 */       return String.format(ChatUtils.format(this.chatUtils.consolePrefix() + "&cPlease wait &8&l[&e%d&8&l] &cseconds before the games begin."), new Object[] { Integer.valueOf(seconds) }); 
/* 432 */     if (seconds == 0)
/* 433 */       return ChatUtils.format(this.chatUtils.consolePrefix() + "&3The games have begun!"); 
/* 434 */     if (seconds == 1) {
/* 435 */       return String.format(ChatUtils.format(this.chatUtils.consolePrefix() + "&8&l[&e%d&8&l] &csecond until the games begin."), new Object[] { Integer.valueOf(seconds) });
/*     */     }
/* 437 */     return String.format(ChatUtils.format(this.chatUtils.consolePrefix() + "&8&l[&e%d&8&l] &cseconds until the games begin."), new Object[] { Integer.valueOf(seconds) });
/*     */   }
/*     */   
/*     */   public String secondsTilLobbyEnds(int seconds) {
/*     */     String msg;
/* 442 */     if (seconds == 1) {
/* 443 */       msg = String.format(ChatUtils.format(this.chatUtils.consolePrefix() + "&8&l[&e%d&8&l] &csecond until lobby ends."), new Object[] { Integer.valueOf(seconds) });
/*     */     } else {
/* 445 */       msg = String.format(ChatUtils.format(this.chatUtils.consolePrefix() + "&8&l[&e%d&8&l] &cseconds until lobby ends."), new Object[] { Integer.valueOf(seconds) });
/* 446 */     }  return msg;
/*     */   }
/*     */   
/*     */   public String notEnoughPlayers(int needed) {
/* 450 */     return String.format(ChatUtils.format(this.chatUtils.consolePrefix() + "&cNot enough players to begin.. need %d more to start.."), new Object[] { Integer.valueOf(needed) });
/*     */   }
/*     */   
/*     */   public String minutesTilDeathmatch(int minutes) {
/* 454 */     if (minutes == 1) {
/* 455 */       return String.format(ChatUtils.format(this.chatUtils.consolePrefix() + "&8&l[&e%d&8&l] &cminute until deathmatch."), new Object[] { Integer.valueOf(minutes) });
/*     */     }
/* 457 */     return String.format(ChatUtils.format(this.chatUtils.consolePrefix() + "&8&l[&e%d&8&l] &cminutes until deathmatch."), new Object[] { Integer.valueOf(minutes) });
/*     */   }
/*     */   
/*     */   public String mapCredits(String map, String builder, String download) {
/* 461 */     return String.format(ChatUtils.format(this.chatUtils.consolePrefix() + "&eMap Name &2%s\n" + this.chatUtils.consolePrefix() + "&eMap Builder &2%s\n" + this.chatUtils
/* 462 */           .consolePrefix() + "&eMap Download &2%s"), new Object[] { map, builder, download });
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String playersWaiting(int currentPlayerWaiting, int maxPlayers, int minPlayers) {
/* 468 */     return String.format(ChatUtils.format(this.chatUtils.consolePrefix() + "&2Players waiting: &8&l[&e%d&8&l/&e%d&8&l] &2Games require &8&l[&e%d&8&l] &2to play."), new Object[] {
/* 469 */           Integer.valueOf(currentPlayerWaiting), Integer.valueOf(maxPlayers), Integer.valueOf(minPlayers) });
/*     */   }
/*     */   
/*     */   public String voteUsingCommand() {
/* 473 */     return ChatUtils.format(this.chatUtils.consolePrefix() + "&2Vote using &8&l[&a/vote #&8&l]");
/*     */   }
/*     */ 
/*     */   
/*     */   public String previousMaps(String... maps) {
/* 478 */     if (maps.length == 0) {
/* 479 */       return ChatUtils.format(this.chatUtils.consolePrefix() + "&2Previous maps played: &7None");
/*     */     }
/*     */     
/* 482 */     if (maps.length == 1) {
/* 483 */       return String.format(ChatUtils.format(this.chatUtils.consolePrefix() + "&2Previous map played: &7%s"), new Object[] { maps[0] });
/*     */     }
/*     */     
/* 486 */     if (maps.length == 2) {
/* 487 */       return String.format(ChatUtils.format(this.chatUtils.consolePrefix() + "&2Previous maps played: &7%s, %s"), new Object[] { maps[0], maps[1] });
/*     */     }
/*     */     
/* 490 */     if (maps.length == 3) {
/* 491 */       return String.format(ChatUtils.format(this.chatUtils.consolePrefix() + "&2Previous maps played: &7%s, %s, %s"), new Object[] { maps[0], maps[1], maps[2] });
/*     */     }
/* 493 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public String choice(int mapNumber, int numberOfVotesForMap, int totalVotesForMaps, String mapName) {
/*     */     float percentage;
/* 499 */     if (totalVotesForMaps != 0)
/* 500 */     { percentage = numberOfVotesForMap / totalVotesForMaps * 100.0F; }
/* 501 */     else { percentage = 0.0F; }
/*     */     
/* 503 */     if (numberOfVotesForMap == 1)
/* 504 */       return String.format(ChatUtils.format(this.chatUtils.consolePrefix() + "&a%d &8» | &e%d &7Vote &8| &e%.2f%% &7Chance &8| &2%s"), new Object[] {
/* 505 */             Integer.valueOf(mapNumber), Integer.valueOf(numberOfVotesForMap), Float.valueOf(percentage), mapName
/*     */           }); 
/* 507 */     return String.format(ChatUtils.format(this.chatUtils.consolePrefix() + "&a%d &8» | &e%d &7Votes &8| &e%.2f%% &7Chance &8| &2%s"), new Object[] {
/* 508 */           Integer.valueOf(mapNumber), Integer.valueOf(numberOfVotesForMap), Float.valueOf(percentage), mapName });
/*     */   }
/*     */   
/*     */   public String secondsTilDeathmatch(Integer seconds) {
/* 512 */     if (seconds.intValue() == 1) {
/* 513 */       return String.format(ChatUtils.format(this.chatUtils.consolePrefix() + "&8&l[&e%d&8&l] &csecond until deathmatch!"), new Object[] { seconds });
/*     */     }
/* 515 */     return String.format(ChatUtils.format(this.chatUtils.consolePrefix() + "&8&l[&e%d&8&l] &cseconds until deathmatch!"), new Object[] { seconds });
/*     */   }
/*     */   
/*     */   public String pleaseAllow10Seconds(Integer seconds) {
/* 519 */     if (seconds.intValue() == 1) {
/* 520 */       return String.format(ChatUtils.format(this.chatUtils.consolePrefix() + "&4Please allow &8&l[&e%d&8&l] &4second for all players to load the map."), new Object[] { seconds });
/*     */     }
/* 522 */     return String.format(ChatUtils.format(this.chatUtils.consolePrefix() + "&4Please allow &8&l[&e%d&8&l] &4seconds for all players to load the map."), new Object[] { seconds });
/*     */   }
/*     */   
/*     */   public String fightTilDeath() {
/* 526 */     return ChatUtils.format(this.chatUtils.consolePrefix() + "&cFight til the death!");
/*     */   }
/*     */   
/*     */   public String minutesTilDeathmatchEnds(Integer minutes) {
/* 530 */     if (minutes.intValue() == 1) {
/* 531 */       return String.format(ChatUtils.format(this.chatUtils.consolePrefix() + "&8&l[&e%d&8&l] &cminute until deathmatch ends!"), new Object[] { minutes });
/*     */     }
/* 533 */     return String.format(ChatUtils.format(this.chatUtils.consolePrefix() + "&8&l[&e%d&8&l] &cminutes until deathmatch ends!"), new Object[] { minutes });
/*     */   }
/*     */   
/*     */   public String winner(String name) {
/* 537 */     return String.format(ChatUtils.format(this.chatUtils.consolePrefix() + "&aThe games have ended!\n" + this.chatUtils.consolePrefix() + "&a%s &ahas won the Hunger games!"), new Object[] { name });
/*     */   }
/*     */ 
/*     */   
/*     */   public String serverStopped(String proxy, String server) {
/* 542 */     return String.format(ChatUtils.format("&aServer %s %s was successfully stopped."), new Object[] { proxy, server });
/*     */   }
/*     */ 
/*     */   
/*     */   public String expectLag() {
/* 547 */     return ChatUtils.format(this.chatUtils.consolePrefix() + "&3Map is loading right now.. expect some lag..");
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String cannotLoadMap(String mName) {
/* 553 */     return String.format(ChatUtils.format("&cCannot load lobby map %s.. Please make sure the map exist.."), new Object[] { mName });
/*     */   }
/*     */   
/*     */   public String cannotLoadMap() {
/* 557 */     return ChatUtils.format("&cCannot load lobby map.. Please check your config..");
/*     */   }
/*     */   
/*     */   public String mustHaveAnArena() {
/* 561 */     return ChatUtils.format("&cYou must have at least one arena.. Please use /createarena <arena name> to create a new arena..");
/*     */   }
/*     */ 
/*     */   
/*     */   public String mustHaveSpawns(String arena) {
/* 566 */     return String.format(ChatUtils.format("&cYou must have 24 spawns.. Please use /loadarena %s and /setspawn <0-23> to set spawns.."), new Object[] { arena });
/*     */   }
/*     */   
/*     */   public String mustHave24Spawns() {
/* 570 */     return ChatUtils.format("&cDeathmach requires 24 set spawns.");
/*     */   }
/*     */   
/* 573 */   private ChatUtils chatUtils = new ChatUtils();
/* 574 */   private VotingManager votingManager = new VotingManager();
/*     */ }


/* Location:              /home/tyler/Downloads/jar files/Hungergames.jar!/com/mczone/utils/Messages.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */