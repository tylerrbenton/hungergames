/*     */ package com.mczone.managers;
/*     */ 
/*     */ import com.mczone.configs.Arenas;
/*     */ import com.mczone.hungergames.GameHandler;
/*     */ import com.mczone.hungergames.Hungergames;
/*     */ import com.mczone.utils.Item;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.List;
/*     */ import java.util.concurrent.ThreadLocalRandom;
/*     */ import org.bukkit.Bukkit;
/*     */ import org.bukkit.Location;
/*     */ import org.bukkit.Material;
/*     */ import org.bukkit.World;
/*     */ import org.bukkit.block.Chest;
/*     */ import org.bukkit.inventory.Inventory;
/*     */ import org.bukkit.plugin.Plugin;
/*     */ import org.bukkit.scheduler.BukkitRunnable;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ChestManager
/*     */ {
/*  27 */   private static List<Location> chests = new ArrayList<>();
/*  28 */   private static List<Location> enderChests = new ArrayList<>();
/*     */   
/*  30 */   private static List<Item> one = new ArrayList<>();
/*  31 */   private static List<Item> two = new ArrayList<>();
/*     */   
/*     */   public void loadChests() {
/*  34 */     addChests(String.format("arenas.%s.chests.tier one", new Object[] { this.gameHandler.getCurrentArena() }), chests);
/*  35 */     addChests(String.format("arenas.%s.chests.tier two", new Object[] { this.gameHandler.getCurrentArena() }), enderChests);
/*     */   }
/*     */   
/*     */   public void addChests() {
/*  39 */     chests.clear();
/*  40 */     addChests(String.format("arenas.%s.chests.tier one", new Object[] { this.votingManager.getArenaName() }), chests);
/*  41 */     enderChests.clear();
/*  42 */     addChests(String.format("arenas.%s.chests.tier two", new Object[] { this.votingManager.getArenaName() }), enderChests);
/*     */   }
/*     */   
/*     */   private void addChests(String chestsPath, List<Location> l) {
/*  46 */     for (String s : this.arenas.getArenasConfig().getStringList(chestsPath)) {
/*  47 */       World w; if (this.arenas.getArenasConfig().getStringList(chestsPath) == null) {
/*     */         continue;
/*     */       }
/*     */       
/*     */       try {
/*  52 */         w = Bukkit.getWorld(this.arenas.getArenasConfig().getString(String.format("arenas.%s.world", new Object[] { this.gameHandler.getCurrentArena() })));
/*  53 */       } catch (IllegalArgumentException iae) {
/*  54 */         w = Bukkit.getWorld(this.votingManager.getMapName());
/*     */       } 
/*  56 */       String[] str = s.split(", ");
/*     */ 
/*     */       
/*  59 */       Location location = new Location(w, Double.parseDouble(str[0].replaceAll("[^0-9-.]", "")), Double.parseDouble(str[1].replaceAll("[^0-9-.]", "")), Double.parseDouble(str[2].replaceAll("[^0-9-.]", "")), 0.0F, 0.0F);
/*  60 */       l.add(location);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setEnderChests() {
/*  66 */     for (Location l : enderChests) {
/*  67 */       if (l.getBlock().getType() != Material.ENDER_CHEST) {
/*     */         continue;
/*     */       }
/*  70 */       Byte by = Byte.valueOf(l.getBlock().getData());
/*  71 */       l.getBlock().setType(Material.CHEST);
/*  72 */       l.getBlock().setData(by.byteValue());
/*     */     } 
/*     */     
/*  75 */     (new BukkitRunnable()
/*     */       {
/*     */         public void run() {
/*  78 */           ChestManager.this.addTierOneItems();
/*  79 */           ChestManager.this.addTierTwoItems();
/*     */         }
/*  81 */       }).runTaskLater((Plugin)Hungergames.getHungergames(), 20L);
/*     */   }
/*     */   
/*     */   private void addTierOne(Item... items) {
/*  85 */     one.addAll(Arrays.asList(items));
/*     */   }
/*     */   
/*     */   private void addTierTwo(Item... items) {
/*  89 */     two.addAll(Arrays.asList(items));
/*     */   }
/*     */   
/*  92 */   private ThreadLocalRandom random = ThreadLocalRandom.current();
/*     */ 
/*     */ 
/*     */   
/*     */   private void addItems() {
/*  97 */     addTierOne(new Item[] { new Item(Material.FISHING_ROD, Integer.valueOf(1), Integer.valueOf(87)), new Item(Material.BOWL, Integer.valueOf(1), Integer.valueOf(27)), new Item(Material.RAW_CHICKEN, Integer.valueOf(1), Integer.valueOf(23)), new Item(Material.RAW_BEEF, 
/*  98 */             Integer.valueOf(1), Integer.valueOf(54)), new Item(Material.LEATHER_HELMET, Integer.valueOf(1), Integer.valueOf(66)), new Item(Material.LEATHER_CHESTPLATE, Integer.valueOf(1), Integer.valueOf(42)), new Item(Material.LEATHER_LEGGINGS, 
/*  99 */             Integer.valueOf(1), Integer.valueOf(35)), new Item(Material.LEATHER_BOOTS, Integer.valueOf(1), Integer.valueOf(23)), new Item(Material.WOOD_SWORD, Integer.valueOf(1), Integer.valueOf(86)), new Item(Material.WOOD_AXE, 
/* 100 */             Integer.valueOf(1), Integer.valueOf(49)), new Item(Material.BOW, Integer.valueOf(1), Integer.valueOf(63)), new Item(Material.GOLD_INGOT, Integer.valueOf(1), Integer.valueOf(57)), new Item(Material.CARROT, Integer.valueOf(1), Integer.valueOf(68)), new Item(Material.PORK, 
/* 101 */             Integer.valueOf(1), Integer.valueOf(47)), new Item(Material.COOKIE, Integer.valueOf(1), Integer.valueOf(29)), new Item(Material.MELON, Integer.valueOf(1), Integer.valueOf(21)), new Item(Material.STICK, Integer.valueOf(1), Integer.valueOf(73)), new Item(Material.FLINT, 
/* 102 */             Integer.valueOf(1), Integer.valueOf(68)), new Item(Material.FEATHER, Integer.valueOf(5), Integer.valueOf(37)), new Item(Material.BOAT, Integer.valueOf(1), Integer.valueOf(43)) });
/*     */     
/* 104 */     addTierTwo(new Item[] { new Item(Material.GOLD_HELMET, Integer.valueOf(1), Integer.valueOf(this.random.nextInt(74, 82))), new Item(Material.GOLD_CHESTPLATE, Integer.valueOf(1), Integer.valueOf(this.random.nextInt(76, 83))), new Item(Material.GOLD_LEGGINGS, 
/* 105 */             Integer.valueOf(1), Integer.valueOf(this.random.nextInt(42, 57))), new Item(Material.GOLD_BOOTS, Integer.valueOf(1), Integer.valueOf(this.random.nextInt(34, 41))), new Item(Material.CHAINMAIL_HELMET, Integer.valueOf(1), Integer.valueOf(this.random.nextInt(51, 57))), new Item(Material.CHAINMAIL_CHESTPLATE, 
/* 106 */             Integer.valueOf(1), Integer.valueOf(this.random.nextInt(49, 57))), new Item(Material.CHAINMAIL_LEGGINGS, Integer.valueOf(1), Integer.valueOf(this.random.nextInt(55, 61))), new Item(Material.CHAINMAIL_BOOTS, Integer.valueOf(1), Integer.valueOf(this.random.nextInt(43, 51))), new Item(Material.IRON_HELMET, 
/* 107 */             Integer.valueOf(1), Integer.valueOf(this.random.nextInt(45, 51))), new Item(Material.IRON_CHESTPLATE, Integer.valueOf(1), Integer.valueOf(this.random.nextInt(66, 73))), new Item(Material.IRON_LEGGINGS, Integer.valueOf(1), Integer.valueOf(this.random.nextInt(67, 81))), new Item(Material.IRON_BOOTS, 
/* 108 */             Integer.valueOf(1), Integer.valueOf(this.random.nextInt(31, 56))), new Item(Material.STONE_SWORD, Integer.valueOf(1), Integer.valueOf(this.random.nextInt(76, 83))), new Item(Material.ARROW, Integer.valueOf(5), Integer.valueOf(this.random.nextInt(67, 78))), new Item(Material.GOLDEN_CARROT, Integer.valueOf(1), Integer.valueOf(52)), new Item(Material.IRON_INGOT, 
/* 109 */             Integer.valueOf(1), Integer.valueOf(this.random.nextInt(31, 43))), new Item(Material.DIAMOND, Integer.valueOf(1), Integer.valueOf(this.random.nextInt(24, 36))), new Item(Material.GOLDEN_APPLE, Integer.valueOf(1), Integer.valueOf(this.random.nextInt(34, 43))), new Item(Material.GRILLED_PORK, 
/* 110 */             Integer.valueOf(1), Integer.valueOf(this.random.nextInt(63, 71))), new Item(Material.COOKED_BEEF, Integer.valueOf(1), Integer.valueOf(this.random.nextInt(56, 76))), new Item(Material.BREAD, Integer.valueOf(1), Integer.valueOf(this.random.nextInt(56, 75))), new Item(Material.COOKED_CHICKEN, 
/* 111 */             Integer.valueOf(1), Integer.valueOf(86)), new Item(Material.FLINT_AND_STEEL, Integer.valueOf(1), Integer.valueOf(this.random.nextInt(74, 83))), new Item(Material.COOKED_FISH, Integer.valueOf(1), Integer.valueOf(this.random.nextInt(43, 76))), new Item(Material.PUMPKIN_PIE, 
/* 112 */             Integer.valueOf(1), Integer.valueOf(this.random.nextInt(78, 89))), new Item(Material.BAKED_POTATO, Integer.valueOf(1), Integer.valueOf(this.random.nextInt(68, 79))) });
/*     */   }
/*     */ 
/*     */   
/*     */   private void addTierOneItems() {
/* 117 */     List<Item> items = new ArrayList<>();
/* 118 */     for (Location l : chests) {
/* 119 */       if (!(l.getBlock().getState() instanceof Chest)) {
/*     */         continue;
/*     */       }
/* 122 */       Chest chest = (Chest)l.getBlock().getState();
/*     */       
/* 124 */       if (chest.getInventory().getSize() == 27) {
/* 125 */         addItems(chest.getInventory(), items, one, Integer.valueOf(4), Integer.valueOf(8), Integer.valueOf(27)); continue;
/* 126 */       }  addItems(chest.getInventory(), items, one, Integer.valueOf(13), Integer.valueOf(17), Integer.valueOf(54));
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private void addTierTwoItems() {
/* 132 */     List<Item> items = new ArrayList<>();
/*     */     
/* 134 */     for (Location l : enderChests) {
/* 135 */       if (!(l.getBlock().getState() instanceof Chest)) {
/*     */         continue;
/*     */       }
/* 138 */       Chest chest = (Chest)l.getBlock().getState();
/*     */       
/* 140 */       if (chest.getInventory().getSize() == 27) {
/* 141 */         addItems(chest.getInventory(), items, two, Integer.valueOf(5), Integer.valueOf(8), Integer.valueOf(27)); continue;
/* 142 */       }  addItems(chest.getInventory(), items, two, Integer.valueOf(13), Integer.valueOf(16), Integer.valueOf(54));
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private void addItems(Inventory inventory, List<Item> l, List<Item> il, Integer amountOrigin, Integer amountBound, Integer bound) {
/* 148 */     inventory.clear();
/*     */     
/* 150 */     int amount = this.random.nextInt(amountOrigin.intValue(), amountBound.intValue());
/* 151 */     while (amount != 0) {
/* 152 */       addItems();
/* 153 */       for (Item item : il) {
/* 154 */         if (item.getChance().intValue() > this.random.nextInt(0, 100)) {
/* 155 */           l.add(item);
/*     */         }
/*     */       } 
/*     */       
/* 159 */       if (l.size() == 0) {
/*     */         continue;
/*     */       }
/*     */       
/* 163 */       int chance = this.random.nextInt(0, 100);
/* 164 */       int randomIndex = this.random.nextInt(0, l.size());
/* 165 */       int randomSlot = this.random.nextInt(0, bound.intValue());
/*     */       
/* 167 */       if (((Item)l.get(randomIndex)).getChance().intValue() > chance) {
/* 168 */         if (!inventory.contains(((Item)l.get(randomIndex)).getItem())) {
/* 169 */           inventory.setItem(randomSlot, ((Item)l.get(randomIndex)).getItem());
/*     */         }
/*     */         
/* 172 */         amount--;
/* 173 */         l.clear(); il.clear(); one.clear(); two.clear();
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public void refillChests() {
/* 179 */     addTierOneItems();
/* 180 */     addTierTwoItems();
/*     */   }
/*     */   
/*     */   public List<Location> getChests() {
/* 184 */     return chests;
/*     */   }
/*     */   
/*     */   public List<Location> getEnderChests() {
/* 188 */     return enderChests;
/*     */   }
/*     */   
/* 191 */   private Arenas arenas = new Arenas();
/* 192 */   private GameHandler gameHandler = new GameHandler();
/* 193 */   private VotingManager votingManager = new VotingManager();
/*     */ }


/* Location:              /home/tyler/Downloads/jar files/Hungergames.jar!/com/mczone/managers/ChestManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */