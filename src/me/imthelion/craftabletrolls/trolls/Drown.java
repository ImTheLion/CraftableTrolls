package me.imthelion.craftabletrolls.trolls;

import org.bukkit.Material;
import org.bukkit.entity.Player;

import me.imthelion.craftabletrolls.util.Items;

public class Drown extends Troll {

	public Drown() {
		super(Items.getDrown());
	}
	
	@Override
	public void onSelect(Player p) {
		p.getLocation().add(0,0,0).getBlock().setType(Material.OBSIDIAN);
		p.getLocation().add(0,0,1).getBlock().setType(Material.OBSIDIAN);
		p.getLocation().add(0,0,-1).getBlock().setType(Material.OBSIDIAN);
		p.getLocation().add(1,0,1).getBlock().setType(Material.OBSIDIAN);
		p.getLocation().add(1,0,-1).getBlock().setType(Material.OBSIDIAN);
		p.getLocation().add(-1,0,1).getBlock().setType(Material.OBSIDIAN);
		p.getLocation().add(-1,0,-1).getBlock().setType(Material.OBSIDIAN);
		p.getLocation().add(1,0,0).getBlock().setType(Material.OBSIDIAN);
		p.getLocation().add(-1,0,0).getBlock().setType(Material.OBSIDIAN);
		
		p.getLocation().add(0,2,0).getBlock().setType(Material.OBSIDIAN);
		p.getLocation().add(0,2,1).getBlock().setType(Material.OBSIDIAN);
		p.getLocation().add(0,2,-1).getBlock().setType(Material.OBSIDIAN);
		p.getLocation().add(1,2,1).getBlock().setType(Material.OBSIDIAN);
		p.getLocation().add(1,2,-1).getBlock().setType(Material.OBSIDIAN);
		p.getLocation().add(-1,2,1).getBlock().setType(Material.OBSIDIAN);
		p.getLocation().add(-1,2,-1).getBlock().setType(Material.OBSIDIAN);
		p.getLocation().add(1,2,0).getBlock().setType(Material.OBSIDIAN);
		p.getLocation().add(-1,2,0).getBlock().setType(Material.OBSIDIAN);
		
		p.getLocation().add(0,1,0).getBlock().setType(Material.WATER);
		p.getLocation().add(0,1,1).getBlock().setType(Material.GLASS_PANE);
		p.getLocation().add(0,1,-1).getBlock().setType(Material.GLASS_PANE);
		p.getLocation().add(1,1,1).getBlock().setType(Material.OBSIDIAN);
		p.getLocation().add(1,1,-1).getBlock().setType(Material.OBSIDIAN);
		p.getLocation().add(-1,1,1).getBlock().setType(Material.OBSIDIAN);
		p.getLocation().add(-1,1,-1).getBlock().setType(Material.OBSIDIAN);
		p.getLocation().add(1,1,0).getBlock().setType(Material.GLASS_PANE);
		p.getLocation().add(-1,1,0).getBlock().setType(Material.GLASS_PANE);		
		
		
	}

}
