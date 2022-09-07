/*    */ package com.mczone.managers;
/*    */ 
/*    */ import java.sql.Connection;
/*    */ import java.sql.DriverManager;
/*    */ import java.sql.SQLException;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class MySQLManager
/*    */ {
/*    */   private static Connection connection;
/*    */   private String host;
/*    */   private Integer port;
/*    */   private String database;
/*    */   private String user;
/*    */   private String password;
/*    */   
/*    */   public MySQLManager(String host, Integer port, String database, String user, String password) {
/* 21 */     this.host = host;
/* 22 */     this.port = port;
/* 23 */     this.database = database;
/* 24 */     this.user = user;
/* 25 */     this.password = password;
/*    */     
/*    */     try {
/* 28 */       openConnection();
/* 29 */     } catch (SQLException sql) {
/* 30 */       sql.printStackTrace();
/* 31 */     } catch (ClassNotFoundException cnf) {
/* 32 */       cnf.printStackTrace();
/*    */     } 
/*    */   }
/*    */   
/*    */   private void openConnection() throws SQLException, ClassNotFoundException {
/* 37 */     if (connection != null && !connection.isClosed()) {
/*    */       return;
/*    */     }
/*    */     
/* 41 */     synchronized (this) {
/* 42 */       Class.forName("com.mysql.jdbc.Driver");
/* 43 */       connection = DriverManager.getConnection("jdbc:mysql://" + this.host + ":" + this.port + "/" + this.database, this.user, this.password);
/*    */     } 
/*    */   }
/*    */   
/*    */   public static Connection getConnection() {
/* 48 */     return connection;
/*    */   }
/*    */ }


/* Location:              /home/tyler/Downloads/jar files/Hungergames.jar!/com/mczone/managers/MySQLManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */