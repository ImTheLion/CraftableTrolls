package me.imthelion.craftabletrolls;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import me.imthelion.craftabletrolls.recipes.RecipeManager;
import me.imthelion.craftabletrolls.trolls.TrollManager;

public class Main extends JavaPlugin implements Listener {
	
	private static TrollManager manager;
	private static Main instance;
	private static List<ItemStack> skulls = new ArrayList<>();
	
	
	@Override
	public void onEnable() {
		instance = this;
		manager = new TrollManager();
		manager.load();
		
		
		PluginManager pm = Bukkit.getPluginManager();
		pm.registerEvents(this, this);
		
		LoadPlayers();
		new RecipeManager();
		Bukkit.getLogger().log(Level.INFO, "Enabled!");
	}
	
	@Override
	public void onDisable() {
		RecipeManager.remove();
		
		Bukkit.getLogger().log(Level.FINE, "Disabled!");
	}
	
	public static TrollManager getTrollManager() {
		return manager;
	}
	
	public static Main getInstance() {
		return instance;
	}
	
	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		
		ItemStack item = new ItemStack(Material.PLAYER_HEAD);
		SkullMeta meta = (SkullMeta) item.getItemMeta();
		meta.setOwningPlayer(p);
		meta.setDisplayName(p.getName());
		item.setItemMeta(meta);
		skulls.add(item);
		TrollManager.getGUI().updateGUI();
	}
	
	@EventHandler
	public void onQuit(PlayerQuitEvent e) {
		Player p = e.getPlayer();
		try {
		for(ItemStack item : skulls) {
			SkullMeta meta = (SkullMeta) item.getItemMeta();
			if(meta.hasOwner()) {
				if(meta.getOwningPlayer().equals(p)) {
					skulls.remove(item);
				}
			}
		}
		} catch(Exception ignored) {}
		TrollManager.getGUI().updateGUI();
	}
	
	public static List<ItemStack> getSkulls() {
		return skulls;
	}
	
	public void LoadPlayers() {
		if(Bukkit.getOnlinePlayers().size()<1) return;
		for(Player p : Bukkit.getOnlinePlayers()) {
			ItemStack item = new ItemStack(Material.PLAYER_HEAD);
			SkullMeta meta = (SkullMeta) item.getItemMeta();
			meta.setOwningPlayer(p);
			meta.setDisplayName(p.getName());
			item.setItemMeta(meta);
			skulls.add(item);
		}
		TrollManager.getGUI().updateGUI();
	}


}
