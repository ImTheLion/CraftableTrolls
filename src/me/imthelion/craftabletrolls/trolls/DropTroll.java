package me.imthelion.craftabletrolls.trolls;

import java.util.Random;

import org.bukkit.World;
import org.bukkit.entity.Player;

import me.imthelion.craftabletrolls.util.Items;

public class DropTroll extends Troll{
	
	private static Random r = new Random();

	public DropTroll() {
		super(Items.getDrop());
	}

	@Override
	public void onSelect(Player p) {
		World world = p.getWorld();
		p.getInventory().forEach(i -> {
			if(i != null) {
				world.dropItem(p.getLocation().add(r.nextInt(3)-1, 1, r.nextInt(3)-1), i);
				p.getInventory().remove(i);
			}
		});
		
	}

}
