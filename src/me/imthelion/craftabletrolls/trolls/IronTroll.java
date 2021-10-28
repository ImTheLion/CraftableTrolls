package me.imthelion.craftabletrolls.trolls;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.WeatherType;
import org.bukkit.entity.Bat;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

import me.imthelion.craftabletrolls.Main;
import me.imthelion.craftabletrolls.util.Items;

public class IronTroll extends Troll {

	public IronTroll() {
		super(Items.getRandom());
	}
	
	@Override
	public void onSelect(Player p) {
		Random r = new Random();
		switch(r.nextInt(10)) {
		case 0:
			p.getWorld().createExplosion(p.getLocation(), 5F, true, true);
			break;
		case 1:
			p.getLocation().getBlock().setType(Material.COBWEB);
			p.getLocation().add(0,0,1).getBlock().setType(Material.COBWEB);
			p.getLocation().add(0,0,-1).getBlock().setType(Material.COBWEB);
			p.getLocation().add(1,0,1).getBlock().setType(Material.COBWEB);
			p.getLocation().add(1,0,-1).getBlock().setType(Material.COBWEB);
			p.getLocation().add(-1,0,1).getBlock().setType(Material.COBWEB);
			p.getLocation().add(-1,0,-1).getBlock().setType(Material.COBWEB);
			p.getLocation().add(1,0,0).getBlock().setType(Material.COBWEB);
			p.getLocation().add(-1,0,0).getBlock().setType(Material.COBWEB);
			p.getLocation().add(0,5,0).getBlock().setType(Material.LAVA);
			break;
		case 2:
			Location loc = new Location(p.getWorld(), p.getLocation().getBlockX()+0.5, 
					p.getLocation().getBlockY(), p.getLocation().getBlockZ()+0.5);
			p.teleport(loc);
			for(Location l = loc; l.getBlockY() >= 0; l.subtract(0,1,0)) {
				l.getBlock().setType(Material.AIR);
			}
			break;
		case 3:
			p.setBedSpawnLocation(null, true);
			p.sendMessage("§cBye Bye Bed >:D");
			break;
		case 4:
			Location lo = p.getLocation();
			Bukkit.getScheduler().runTaskLater(Main.getInstance(), new Runnable() {

				@Override
				public void run() {
					p.teleport(lo);
					p.sendMessage("§aLaggback :P");
					
				}
				
			}, 200L);
			break;
		case 5:
			Vector v = new Vector(r.nextInt(16)-8, 20, r.nextInt(16)-8);
			p.setVelocity(v);
			break;
		case 6:
			Location loc2 = p.getLocation().clone();
			loc2.setPitch(p.getLocation().getPitch()*-1);
			loc2.setYaw(p.getLocation().getYaw()*-1);
			p.teleport(loc2);
			break;
		case 7:
			p.setFireTicks(15*20);
			break;
		case 8:
			p.setPlayerWeather(WeatherType.DOWNFALL);
			p.setPlayerTime(18000L, true);
			Bukkit.getScheduler().runTaskLater(Main.getInstance(), new Runnable() {

				@Override
				public void run() {
					p.resetPlayerWeather();
					p.resetPlayerTime();
					
				}
				
			}, 60*20);
			break;
		case 9:
			Bat bat = (Bat)p.getWorld().spawnEntity(p.getLocation().add(0,10,0), EntityType.BAT);
			bat.addPassenger(p);
			break;
			
		}
		
		
	}

}
