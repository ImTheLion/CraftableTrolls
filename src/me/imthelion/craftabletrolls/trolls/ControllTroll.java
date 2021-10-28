package me.imthelion.craftabletrolls.trolls;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import me.imthelion.craftabletrolls.Main;
import me.imthelion.craftabletrolls.util.Items;

public class ControllTroll extends Troll {

	public ControllTroll() {
		super(Items.getControl());
	}
	
	@Override
	public void onSelect(Player selector, Player p) {
		PlayerControl pConTROLL  = new PlayerControl(selector, p);
		pConTROLL.start();
		
		Bukkit.getScheduler().runTaskLater(Main.getInstance(), new Runnable() {

			@Override
			public void run() {
				pConTROLL.stop();
			}
			
		}, 200L);
		
		
	}

}
