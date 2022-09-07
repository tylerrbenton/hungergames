/*    */ package com.mczone.utils;
/*    */ 
/*    */ import com.mczone.managers.SpawnManager;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import java.util.concurrent.ThreadLocalRandom;
/*    */ import org.bukkit.Color;
/*    */ import org.bukkit.FireworkEffect;
/*    */ import org.bukkit.Location;
/*    */ import org.bukkit.entity.EntityType;
/*    */ import org.bukkit.entity.Firework;
/*    */ import org.bukkit.inventory.meta.FireworkMeta;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Fireworks
/*    */ {
/*    */   private void spawnFirework(Location location) {
/* 22 */     Firework f = (Firework)location.getWorld().spawnEntity(location, EntityType.FIREWORK);
/* 23 */     FireworkMeta fm = f.getFireworkMeta();
/*    */     
/* 25 */     List<FireworkEffect> effects = new ArrayList<>();
/* 26 */     effects.add(FireworkEffect.builder().withColor(new Color[] { Color.ORANGE, Color.WHITE }).withFlicker().withFade(Color.YELLOW).withTrail().with(FireworkEffect.Type.BALL_LARGE).build());
/*    */     
/* 28 */     fm.addEffects(new FireworkEffect[] { effects.get(ThreadLocalRandom.current().nextInt(effects.size())) });
/* 29 */     fm.setPower(1);
/* 30 */     f.setFireworkMeta(fm);
/*    */   }
/*    */ 
/*    */   
/*    */   public void playFireworks() {
/* 35 */     for (Location l : this.spawnManager.getLocations()) {
/* 36 */       spawnFirework(l.add(0.0D, 0.0D, 0.0D));
/*    */     }
/*    */   }
/*    */   
/* 40 */   private SpawnManager spawnManager = new SpawnManager();
/*    */ }


/* Location:              /home/tyler/Downloads/jar files/Hungergames.jar!/com/mczone/utils/Fireworks.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */