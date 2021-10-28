package me.imthelion.craftabletrolls.util;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class Items {
	
	public static ItemStack getDrop() {
		ItemStack item =ItemUtils.getItem(Material.COAL, 1, "§0Drop inventory", null, null, false, true, 0);
		//item.addUnsafeEnchantment(Enchantment.DURABILITY, 1);
		return item;
	}
	
	public static ItemStack getInv() {
		ItemStack item =ItemUtils.getItem(Material.GOLD_INGOT, 1, "§6Inventory Acces", null, null, false, true, 0);
		//item.addUnsafeEnchantment(Enchantment.DURABILITY, 1);
		return item;
	}
	
	public static ItemStack getControl() {
		ItemStack item =ItemUtils.getItem(Material.NETHERITE_INGOT, 1, "§4§k;;§2Control Player§4;;", null, null, false, true, 0);
		//item.addUnsafeEnchantment(Enchantment.DURABILITY, 1);
		return item;
	}
	
	public static ItemStack getAch() {
		ItemStack item =ItemUtils.getItem(Material.COBBLESTONE, 1, "§7Random Achievement", null, null, false, true, 0);
		//item.addUnsafeEnchantment(Enchantment.DURABILITY, 1);
		return item;
	}
	
	public static ItemStack getPot() {
		ItemStack item =ItemUtils.getItem(Material.EXPERIENCE_BOTTLE, 1, "§1Random Effect", null, null, false, true, 0);
		//item.addUnsafeEnchantment(Enchantment.DURABILITY, 1);
		return item;
	}
	
	public static ItemStack getRandom() {
		ItemStack item =ItemUtils.getItem(Material.IRON_INGOT, 1, "§9Random Troll", null, null, false, true, 0);
		//item.addUnsafeEnchantment(Enchantment.DURABILITY, 1);
		return item;
	}
	public static ItemStack getDrown() {
		ItemStack item =ItemUtils.getItem(Material.OBSIDIAN, 1, "§bDrown Player", null, null, false, true, 0);
		//item.addUnsafeEnchantment(Enchantment.DURABILITY, 1);
		return item;
	}

}
