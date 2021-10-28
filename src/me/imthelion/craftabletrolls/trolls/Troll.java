package me.imthelion.craftabletrolls.trolls;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;

import me.imthelion.craftabletrolls.Main;
import me.imthelion.craftabletrolls.util.ItemUtils;
import me.imthelion.craftabletrolls.util.PlayerChoosePlayerEvent;

public abstract class Troll implements Listener {
	
	private final ItemStack key;
	protected final TrollManager tm;
	private ItemStack item;

	public Troll(ItemStack key) {
		this.key = key;
		tm = Main.getTrollManager();
		Bukkit.getPluginManager().registerEvents(this, Main.getInstance());
		
	}
	
	protected void onUse(Player p) {
		tm.setCurrent(p, this);
		TrollManager.getGUI().open(p);
		
	}
	
	@EventHandler
	public void onInteract(PlayerInteractEvent e) {
		if(e.getHand() != EquipmentSlot.HAND)return;
		if(e.getPlayer().getInventory().getItemInMainHand() == null)return;
		if(!e.getPlayer().getInventory().getItemInMainHand().isSimilar(key)) return;
		e.setCancelled(true);
		item = e.getItem();
		Player p = e.getPlayer();
		
		onUse(p);	
	}
	
	@EventHandler
	public void onSelect(PlayerChoosePlayerEvent e) {
		if(!e.getTroll().equals(this))return;
		ItemUtils.consumeItem(e.getSelector(), 1, item);
		e.getSelector().sendMessage("§aNow trolling " + e.getPlayer().getName());
		onSelect(e.getSelector(), e.getPlayer());
		onSelect(e.getPlayer());
		
	}
	
	public void onSelect(Player selector, Player p) {
		
	}
	
	public void onSelect(Player p) {
		
	}

}
