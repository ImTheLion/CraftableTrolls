package me.imthelion.craftabletrolls.trolls;

import java.util.Iterator;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.advancement.Advancement;
import org.bukkit.advancement.AdvancementProgress;
import org.bukkit.entity.Player;

import me.imthelion.craftabletrolls.util.Items;

public class Achievement extends Troll {

	public Achievement() {
		super(Items.getAch());
	}
	
	@Override
	public void onSelect(Player selector, Player p) {
		Random r = new Random();
		Iterator<Advancement> at = Bukkit.advancementIterator();
		int i = r.nextInt(20);
		int j=0;
		while(at.hasNext()) {
			Advancement a = at.next();
			if(a.getKey().toString().startsWith("minecraft:recipes")) continue;
			AdvancementProgress progress = p.getAdvancementProgress(a);
			if(progress.isDone()) continue;
			if(i >= j) {
				for(String criteria : progress.getRemainingCriteria())
				    progress.awardCriteria(criteria);
				return;
			}
			
			j++;
		}
		
	}

}
