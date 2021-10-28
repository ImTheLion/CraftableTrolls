package me.imthelion.craftabletrolls.trolls;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bukkit.entity.Player;

import me.imthelion.craftabletrolls.util.PlayerGUI;

public class TrollManager {
	
	private List<Troll> trollInstances = new ArrayList<Troll>();
	private static PlayerGUI GUIInstance = new PlayerGUI();
	private Map<Player, Troll> current = new HashMap<>();
	
	public void load() {
		//add instances
		trollInstances.add(new DropTroll());
		trollInstances.add(new Achievement());
		trollInstances.add(new ControllTroll());
		trollInstances.add(new Drown());
		trollInstances.add(new InvAcces());
		trollInstances.add(new IronTroll());
		trollInstances.add(new PotEffect());

		
		
	}
	
	public Troll getInstanceByType(Class<? extends Troll> c) {
		for(Troll instance : trollInstances) {
			if(instance.getClass().equals(c))
				return instance;
		}
		return null;
	}
	
	public static PlayerGUI getGUI() {
		return GUIInstance;
	}
	
	public Troll getCurrent(Player p) {
		return current.get(p);
	}
	
	public void setCurrent(Player p, Troll troll) {
		current.put(p, troll);
	}

}
