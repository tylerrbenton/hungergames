/*     */ package com.mczone.managers;
/*     */ 
/*     */ import java.sql.PreparedStatement;
/*     */ import java.sql.ResultSet;
/*     */ import java.sql.SQLException;
/*     */ import java.util.UUID;
/*     */ import org.bukkit.entity.Player;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class StatsManager
/*     */ {
/*     */   public UUID uuid;
/*     */   public String name;
/*     */   public Float chestsOpened;
/*     */   public Float gamesPlayed;
/*     */   public Float playersKlled;
/*     */   public Float gamesWon;
/*     */   public Float deathmatchesPlayed;
/*     */   public Float deaths;
/*     */   public Integer points;
/*     */   
/*     */   public boolean hasData(Player p) {
/*  24 */     boolean hasData = false;
/*     */     try {
/*  26 */       PreparedStatement preparedStatement = MySQLManager.getConnection().prepareStatement("SELECT uuid, games_played FROM stats WHERE uuid = ?");
/*  27 */       preparedStatement.setString(1, p.getUniqueId().toString());
/*     */       
/*  29 */       ResultSet resultSet = preparedStatement.executeQuery();
/*     */       
/*  31 */       if (resultSet.next()) {
/*  32 */         hasData = true;
/*     */       }
/*  34 */       resultSet.close();
/*  35 */     } catch (SQLException sql) {
/*  36 */       sql.printStackTrace();
/*     */     } 
/*  38 */     return hasData;
/*     */   }
/*     */   
/*     */   public void getStats(Player p) {
/*     */     try {
/*  43 */       PreparedStatement preparedStatement = MySQLManager.getConnection().prepareStatement("SELECT * FROM stats WHERE uuid = ?");
/*  44 */       preparedStatement.setString(1, p.getUniqueId().toString());
/*     */       
/*  46 */       ResultSet resultSet = preparedStatement.executeQuery();
/*     */       
/*  48 */       if (resultSet.next()) {
/*  49 */         this.uuid = UUID.fromString(resultSet.getString(1));
/*  50 */         this.name = resultSet.getString(2);
/*  51 */         this.points = Integer.valueOf(resultSet.getInt(3));
/*  52 */         this.chestsOpened = Float.valueOf(resultSet.getFloat(4));
/*  53 */         this.gamesPlayed = Float.valueOf(resultSet.getFloat(5));
/*  54 */         this.playersKlled = Float.valueOf(resultSet.getFloat(6));
/*  55 */         this.gamesWon = Float.valueOf(resultSet.getFloat(7));
/*  56 */         this.deathmatchesPlayed = Float.valueOf(resultSet.getFloat(8));
/*  57 */         this.deaths = Float.valueOf(resultSet.getFloat(9));
/*  58 */         resultSet.close();
/*     */       } 
/*  60 */     } catch (SQLException sql) {
/*  61 */       sql.printStackTrace();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void addData(Player p) {
/*     */     try {
/*  68 */       String statement = "INSERT INTO stats (uuid, name, points, chests_opened, games_played, players_killed, games_won,deathmatches_played, deaths) VALUES (?, ?, 100, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0)";
/*     */       
/*  70 */       PreparedStatement preparedStatement = MySQLManager.getConnection().prepareStatement(statement);
/*     */       
/*  72 */       preparedStatement.setString(1, p.getUniqueId().toString());
/*  73 */       preparedStatement.setString(2, p.getName());
/*     */       
/*  75 */       preparedStatement.execute();
/*  76 */       preparedStatement.close();
/*     */     }
/*  78 */     catch (SQLException sql) {
/*  79 */       sql.printStackTrace();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void update(String s, Player p) {
/*     */     try {
/*  86 */       PreparedStatement preparedStatement = MySQLManager.getConnection().prepareStatement(s);
/*     */       
/*  88 */       preparedStatement.setString(1, p.getUniqueId().toString());
/*     */       
/*  90 */       preparedStatement.execute();
/*  91 */       preparedStatement.close();
/*     */     }
/*  93 */     catch (SQLException sql) {
/*  94 */       sql.printStackTrace();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void getBounty(Integer amount, Player p) {
/*     */     try {
/* 101 */       PreparedStatement preparedStatement = MySQLManager.getConnection().prepareStatement("UPDATE stats SET points = points + ? WHERE uuid = ?");
/*     */       
/* 103 */       preparedStatement.setInt(1, amount.intValue());
/* 104 */       preparedStatement.setString(2, p.getUniqueId().toString());
/*     */       
/* 106 */       preparedStatement.executeUpdate();
/* 107 */     } catch (SQLException sql) {
/* 108 */       sql.printStackTrace();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Integer getPoints(Player p) {
/* 115 */     Integer points = null;
/*     */     try {
/* 117 */       PreparedStatement preparedStatement = MySQLManager.getConnection().prepareStatement("SELECT points FROM stats WHERE uuid = ?");
/* 118 */       preparedStatement.setString(1, p.getUniqueId().toString());
/*     */       
/* 120 */       ResultSet resultSet = preparedStatement.executeQuery();
/*     */       
/* 122 */       if (!resultSet.next());
/*     */ 
/*     */       
/* 125 */       points = Integer.valueOf(resultSet.getInt(1));
/* 126 */       resultSet.close();
/* 127 */     } catch (SQLException sql) {
/* 128 */       sql.printStackTrace();
/*     */     } 
/* 130 */     return points;
/*     */   }
/*     */   
/*     */   public void addPoints(Integer points, Player p) {
/*     */     try {
/* 135 */       PreparedStatement preparedStatement = MySQLManager.getConnection().prepareStatement("UPDATE stats SET points = points + ? WHERE uuid = ?");
/* 136 */       preparedStatement.setString(1, String.valueOf(points));
/* 137 */       preparedStatement.setString(2, p.getUniqueId().toString());
/*     */       
/* 139 */       preparedStatement.executeUpdate();
/* 140 */       preparedStatement.close();
/* 141 */     } catch (SQLException sql) {
/* 142 */       sql.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   public void removePoints(Integer points, Player p) {
/*     */     try {
/* 148 */       PreparedStatement preparedStatement = MySQLManager.getConnection().prepareStatement("UPDATE stats SET points = points - ? WHERE uuid = ?");
/* 149 */       preparedStatement.setString(1, String.valueOf(points));
/* 150 */       preparedStatement.setString(2, p.getUniqueId().toString());
/*     */       
/* 152 */       preparedStatement.executeUpdate();
/* 153 */       preparedStatement.close();
/* 154 */     } catch (SQLException sql) {
/* 155 */       sql.printStackTrace();
/*     */     } 
/*     */   }
/*     */ }


/* Location:              /home/tyler/Downloads/jar files/Hungergames.jar!/com/mczone/managers/StatsManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */