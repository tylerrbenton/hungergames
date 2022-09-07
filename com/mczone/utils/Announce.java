/*    */ package com.mczone.utils;
/*    */ 
/*    */ import com.mczone.hungergames.Configuration;
/*    */ import com.mczone.hungergames.GameHandler;
/*    */ import com.mczone.managers.VotingManager;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Announce
/*    */ {
/*    */   void announceSecondsTilGameStart(int seconds) {
/* 16 */     ChatUtils.announce(this.msgs.secondsTilStart(seconds), Boolean.valueOf(true), Boolean.valueOf(true));
/*    */   }
/*    */   
/*    */   void announceSecondsTilLobbyEnds(int seconds) {
/* 20 */     if (seconds == 10) {
/* 21 */       ChatUtils.announce(this.msgs.secondsTilLobbyEnds(seconds), Boolean.valueOf(true), Boolean.valueOf(true));
/* 22 */     } else if (seconds <= 5 && seconds != 0) {
/* 23 */       ChatUtils.announce(this.msgs.secondsTilLobbyEnds(seconds), Boolean.valueOf(true), Boolean.valueOf(true));
/*    */     } 
/*    */   }
/*    */   
/*    */   void announceMinutesTilDeathmatch(int minutes) {
/* 28 */     if (this.configuration.getIngameTime() == 1800) {
/* 29 */       ChatUtils.announce(this.msgs.minutesTilDeathmatch(minutes), Boolean.valueOf(true), Boolean.valueOf(true));
/* 30 */     } else if (this.configuration.getIngameTime() == 1500) {
/* 31 */       ChatUtils.announce(this.msgs.minutesTilDeathmatch(minutes), Boolean.valueOf(true), Boolean.valueOf(true));
/* 32 */     } else if (this.configuration.getIngameTime() == 1200) {
/* 33 */       ChatUtils.announce(this.msgs.minutesTilDeathmatch(minutes), Boolean.valueOf(true), Boolean.valueOf(true));
/*    */     } 
/*    */   }
/*    */   
/*    */   void announceNotEnoughPlayers(int needed) {
/* 38 */     ChatUtils.announce(this.msgs.notEnoughPlayers(needed), Boolean.valueOf(true), Boolean.valueOf(true));
/*    */   }
/*    */   
/*    */   void announceVotes() {
/* 42 */     ChatUtils.announce(String.format("%s\n%s\n%s", new Object[] { this.msgs.playersWaiting(this.gameHandler.getPlayers().size(), this.configuration.MAXPLAYERS
/* 43 */               .intValue(), this.configuration.MINPLAYERS.intValue()), this.msgs.voteUsingCommand(), this.msgs.previousMaps(new String[0]) }), Boolean.valueOf(false), Boolean.valueOf(true));
/* 44 */     for (int counter = 0; counter < this.votingManager.getChoices().size(); counter++) {
/* 45 */       ChatUtils.announce(this.msgs.choice(counter + 1, ((Map)this.votingManager.getChoices().get(counter)).getNumberOfVotes(), this.votingManager.getTotalVotes(), ((Map)this.votingManager
/* 46 */             .getChoices().get(counter)).getWorldName().replace('_', ' ').trim()), Boolean.valueOf(false), Boolean.valueOf(true));
/*    */     }
/*    */   }
/*    */   
/*    */   void announceSecondsTilDeathmatch(Integer seconds) {
/* 51 */     if (seconds.intValue() == 60) {
/* 52 */       ChatUtils.announce(this.msgs.secondsTilDeathmatch(seconds), Boolean.valueOf(true), Boolean.valueOf(true));
/* 53 */     } else if (seconds.intValue() == 10) {
/* 54 */       ChatUtils.announce(this.msgs.secondsTilDeathmatch(seconds), Boolean.valueOf(true), Boolean.valueOf(true));
/* 55 */     } else if (seconds.intValue() <= 5 && seconds.intValue() != 0) {
/* 56 */       ChatUtils.announce(this.msgs.secondsTilDeathmatch(seconds), Boolean.valueOf(true), Boolean.valueOf(true));
/*    */     } 
/*    */   }
/*    */   
/*    */   void announceLetPlayersLoadMap(Integer seconds) {
/* 61 */     ChatUtils.announce(this.msgs.pleaseAllow10Seconds(seconds), Boolean.valueOf(true), Boolean.valueOf(true));
/*    */   }
/*    */   
/*    */   void announceFightTilDeath() {
/* 65 */     ChatUtils.announce(this.msgs.fightTilDeath(), Boolean.valueOf(true), Boolean.valueOf(true));
/*    */   }
/*    */   
/*    */   void announceMinutesTilDeathmatchEnd() {
/* 69 */     Configuration configuration = new Configuration();
/* 70 */     if (configuration.getDeathmatchTime() == 180 || configuration.getDeathmatchTime() == 120 || configuration.getDeathmatchTime() == 60) {
/* 71 */       ChatUtils.announce(this.msgs.minutesTilDeathmatchEnds(Integer.valueOf(configuration.getDeathmatchTime() / 60)), Boolean.valueOf(true), Boolean.valueOf(true));
/*    */     }
/*    */   }
/*    */   
/* 75 */   private Configuration configuration = new Configuration();
/* 76 */   private GameHandler gameHandler = new GameHandler();
/* 77 */   private Messages msgs = new Messages();
/* 78 */   private VotingManager votingManager = new VotingManager();
/*    */ }


/* Location:              /home/tyler/Downloads/jar files/Hungergames.jar!/com/mczone/utils/Announce.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */