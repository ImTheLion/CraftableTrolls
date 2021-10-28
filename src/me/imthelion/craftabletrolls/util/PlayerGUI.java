package me.imthelion.craftabletrolls.util;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;

import me.imthelion.craftabletrolls.Main;

public class PlayerGUI implements Listener {
	
	private final Inventory inv;
	
	public PlayerGUI() {
		Bukkit.getPluginManager().registerEvents(this, Main.getInstance());
		
		inv = load();
	}
	
	private Inventory load() {
		Inventory inv = Bukkit.createInventory(null, 9, "§8Select Player");
		
		for(int i = 0; (i < 8)&&(i < Main.getSkulls().size()); i++) {
			inv.setItem(i, Main.getSkulls().get(i));
		}
		
		return inv;
	}
	
	
	public void open(Player p) {
		p.openInventory(inv);
	}
	
	public Inventory getInv() {
		return inv;
	}
	
	public void updateGUI() {
		inv.clear();
		for(int i = 0; (i < 8)&&(i < Main.getSkulls().size()); i++) {
			inv.setItem(i, Main.getSkulls().get(i));
			
		}
	}
	
	@EventHandler
	public void onClick(InventoryClickEvent e) {
		if(!e.getInventory().equals(inv))
			return;
		
		Player p = (Player) e.getWhoClicked();
		e.setCancelled(true);
		if(e.getView().getType() == InventoryType.PLAYER)
			return;
		if(e.getSlot() >= Main.getSkulls().size()) return;
		String name = e.getInventory().getItem(e.getSlot()).getItemMeta().getDisplayName();
		Player selected = null;
		if(Bukkit.getOnlinePlayers().size() <1)return;
		for (Player player : Bukkit.getOnlinePlayers()) {
			if(player.getName().equalsIgnoreCase(name)) {
				selected = player;
				break;
			}
		}
		if(selected == null) return;
		p.closeInventory();
		PlayerChoosePlayerEvent event = new PlayerChoosePlayerEvent(selected, p, Main.getTrollManager().getCurrent(p));
		Bukkit.getScheduler().runTask(Main.getInstance(), new Runnable() {
			@Override
			public void run() {
				Bukkit.getPluginManager().callEvent(event);
			}
		});
		
	}

}
