package me.imthelion.craftabletrolls.trolls;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import me.imthelion.craftabletrolls.util.Items;

public class PotEffect extends Troll {
	
	private List<PotionEffectType> allowed = new ArrayList<>();

	public PotEffect() {
		super(Items.getPot());
		load();
	}
	
	@Override
	public void onSelect(Player p) {
		PotionEffectType type;
		Random r = new Random();
		type = allowed.get(r.nextInt(allowed.size()));
		
		
		PotionEffect effect = new PotionEffect(type, 30*20, 2, true, false, false);
		if(effect.getType() == PotionEffectType.HARM)effect = new PotionEffect(type, 1, 1, true, false, false);
		if(effect.getType() == PotionEffectType.WITHER)effect = new PotionEffect(type, 20*20, 0, true, false, false);
		p.addPotionEffect(effect);
	}
	
	public void load() {
		allowed.add(PotionEffectType.BAD_OMEN);
		allowed.add(PotionEffectType.BLINDNESS);
		allowed.add(PotionEffectType.CONFUSION);
		allowed.add(PotionEffectType.GLOWING);
		allowed.add(PotionEffectType.HARM);
		allowed.add(PotionEffectType.HUNGER);
		allowed.add(PotionEffectType.LEVITATION);
		allowed.add(PotionEffectType.POISON);
		allowed.add(PotionEffectType.SLOW);
		allowed.add(PotionEffectType.SLOW_DIGGING);
		allowed.add(PotionEffectType.UNLUCK);
		allowed.add(PotionEffectType.WEAKNESS);
		allowed.add(PotionEffectType.WITHER);

	}
	
	

}
