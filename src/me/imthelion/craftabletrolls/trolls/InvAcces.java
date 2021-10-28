package me.imthelion.craftabletrolls.trolls;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import me.imthelion.craftabletrolls.Main;
import me.imthelion.craftabletrolls.util.Items;

public class InvAcces extends Troll {

	public InvAcces() {
		super(Items.getInv());
	}

	@Override
	public void onSelect(Player selector, Player p) {
		selector.openInventory(p.getInventory());
		Bukkit.getScheduler().runTaskLaterAsynchronously(Main.getInstance(), new Runnable() {

			@Override
			public void run() {
				selector.closeInventory();
				
			}
			
			
		}, 100L);
		
	}

}
