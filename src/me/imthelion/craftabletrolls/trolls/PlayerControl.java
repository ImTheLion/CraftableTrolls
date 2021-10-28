package me.imthelion.craftabletrolls.trolls;

import java.util.Collection;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.potion.PotionEffect;
import org.bukkit.scheduler.BukkitRunnable;

import me.imthelion.craftabletrolls.Main;

public class PlayerControl implements Listener {
	
	private final Player p;
	private final Player target;
	private Inventory inv;
	private GameMode gamemode;
	private double health;
	private boolean isControlled;
	private Location loc;
	private int SelectedSlot;
	private float walkspeed;
	private int fireTicks;
	private int food;
	private Collection<PotionEffect> effects;
	
	
	public PlayerControl(Player player, Player target) {
		p = player;
		this.target = target;
		Bukkit.getPluginManager().registerEvents(this, Main.getInstance());
	}
	
	public void start() {
		inv = Bukkit.createInventory(null, 45);
		for(int i = 0; i < 40; i++) {
			inv.setItem(i, p.getInventory().getItem(i));
		}
		gamemode = p.getGameMode();
		health = p.getHealth();
		loc = p.getLocation();
		fireTicks = p.getFireTicks();
		SelectedSlot = p.getInventory().getHeldItemSlot();
		walkspeed = target.getWalkSpeed();
		food = p.getFoodLevel();
		effects = p.getActivePotionEffects();
		p.setFoodLevel(target.getFoodLevel());
		target.setWalkSpeed(0F);
		p.getInventory().setHeldItemSlot(target.getInventory().getHeldItemSlot());
		for(int i = 0; i < 40; i++) {
			p.getInventory().setItem(i, target.getInventory().getItem(i));
		}
		p.teleport(target);
		p.setFireTicks(target.getFireTicks());
		p.hidePlayer(Main.getInstance(), target);
		p.setGameMode(target.getGameMode());
		p.setHealth(target.getHealth());
		p.addPotionEffects(target.getActivePotionEffects());
		for(Player player : Bukkit.getOnlinePlayers()) {
			if(player.equals(p)) continue;
			player.hidePlayer(Main.getInstance(), p);
		}
		isControlled = true;
		
		BukkitRunnable run = new BukkitRunnable() {
			@Override
			public void run() {
				if(isControlled) {
					target.teleport(p);
					target.getInventory().setHeldItemSlot(p.getInventory().getHeldItemSlot());
					target.setFoodLevel(food);
					target.setFireTicks(p.getFireTicks());
					for(int i = 0; i < 40; i++) {
						target.getInventory().setItem(i, p.getInventory().getItem(i));
					}
				} else {
					cancel();
				}
			}
			
		};
		
		run.runTaskTimer(Main.getInstance(), 0, 1L);
		
	}
	
	@EventHandler
	public void onEvent(PlayerDropItemEvent e) {
		if(!isControlled) return;
		if(e.getPlayer().equals(p)) {
			target.getInventory().remove(e.getItemDrop().getItemStack());
		}
		if(e.getPlayer().equals(target)) {
			e.setCancelled(true);
		}
	}
	
	@EventHandler
	public void onEvent(InventoryClickEvent e) {
		if(!isControlled) return;
		if(e.getWhoClicked().equals(p)) {
			for(int i = 0; i < 40; i++) {
				p.getInventory().setItem(i, target.getInventory().getItem(i));
			}
		}
		if(e.getWhoClicked().equals(target)) {
			e.setCancelled(true);
		}
	}
	
	@EventHandler
	public void onEvent(PlayerInteractEvent e) {
		if(!isControlled) return;
		if(e.getPlayer().equals(p)) {
			
		}
		if(e.getPlayer().equals(target)) {
			e.setCancelled(true);
		}
	}
	
	@EventHandler
	public void onEvent(EntityDamageEvent e) {
		if(!isControlled) return;
		if(e.getEntity().equals(p)) {
			target.damage(0.1);
			target.setHealth(p.getHealth());
			if(e.getDamage() >= p.getHealth()) {
				e.setCancelled(true);
				stop();
				
			}
		}
		if(e.getEntity().equals(target)) {
			e.setCancelled(true);
		}
	}
	
	public void stop() {
		isControlled = false;
		p.setFoodLevel(food);
		target.setWalkSpeed(walkspeed);
		for(int i = 0; i < 40; i++) {
			p.getInventory().setItem(i, inv.getItem(i));
		}
		p.teleport(loc);
		if(!(p.getActivePotionEffects() == null))p.getActivePotionEffects().forEach(e -> {
			p.removePotionEffect(e.getType());
		});
		p.addPotionEffects(effects);
		p.getInventory().setHeldItemSlot(SelectedSlot);
		p.showPlayer(Main.getInstance(), target);
		p.setGameMode(gamemode);
		p.setFireTicks(fireTicks);
		p.setHealth(health);
		p.setFireTicks(0);
		for(Player player : Bukkit.getOnlinePlayers()) {
			if(player.equals(p)) continue;
			player.showPlayer(Main.getInstance(), p);
		}
	}

}
