/*    */ package com.mczone.utils;
/*    */ 
/*    */ import com.google.common.io.ByteArrayDataInput;
/*    */ import com.google.common.io.ByteArrayDataOutput;
/*    */ import com.google.common.io.ByteStreams;
/*    */ import com.mczone.hungergames.Hungergames;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.plugin.Plugin;
/*    */ import org.bukkit.plugin.messaging.PluginMessageListener;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class BungeeCord
/*    */   implements PluginMessageListener
/*    */ {
/* 18 */   private ByteArrayDataOutput out = ByteStreams.newDataOutput();
/*    */   
/*    */   private static String serverName;
/*    */ 
/*    */   
/*    */   public void onPluginMessageReceived(String channel, Player player, byte[] message) {
/* 24 */     if (!channel.equalsIgnoreCase("BungeeCord"));
/*    */ 
/*    */ 
/*    */     
/* 28 */     ByteArrayDataInput in = ByteStreams.newDataInput(message);
/* 29 */     String subChannel = in.readUTF();
/*    */     
/* 31 */     if (subChannel.equalsIgnoreCase("GetServer")) {
/* 32 */       serverName = in.readUTF();
/*    */     }
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void connectToHub(Player p) {
/* 39 */     this.out.writeUTF("Connect");
/* 40 */     this.out.writeUTF("Hub_340");
/* 41 */     p.sendPluginMessage((Plugin)Hungergames.getHungergames(), "BungeeCord", this.out.toByteArray());
/*    */   }
/*    */ }


/* Location:              /home/tyler/Downloads/jar files/Hungergames.jar!/com/mczone/utils/BungeeCord.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */