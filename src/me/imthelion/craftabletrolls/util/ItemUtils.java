package me.imthelion.craftabletrolls.util;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;

public class ItemUtils {
	
	public static ItemStack getItem(Material mat, int amount, String name, Map<Enchantment, Integer> ench, String[] lore, boolean unbreakable, boolean hideFlags, Integer data) {
		ItemStack item;
		if(data != null) item = new ItemStack(mat, amount, data.shortValue()); else item = new ItemStack(mat, amount);
		item = addEnchants(item, ench);
		ItemMeta meta = item.getItemMeta();
		if(name != null)meta.setDisplayName(name);
		if(lore != null) meta.setLore(Arrays.asList(lore));
		if(hideFlags) {
			for(ItemFlag flag : ItemFlag.values()) {
				meta.addItemFlags(flag);
			}
		}
		meta.setUnbreakable(unbreakable);
		item.setItemMeta(meta);
		return item;
	}

	public static ItemStack getLeatherItem(final Material mat, final int amount, final String name, final Map<Enchantment, Integer> ench,
			final String[] lore, final boolean unbreakable, final boolean hideFlags, final Color color) {
		ItemStack item;
		item = new ItemStack(mat, amount);
		LeatherArmorMeta meta = (LeatherArmorMeta) item.getItemMeta();
		if(name != null)meta.setDisplayName(name);
		if(lore != null) meta.setLore(Arrays.asList(lore));
		if(hideFlags) {
			for(ItemFlag flag : ItemFlag.values()) {
				meta.addItemFlags(flag);
			}
		}
		meta.setUnbreakable(unbreakable);
		meta.setColor(color);
		item.setItemMeta(meta);
		item = addEnchants(item, ench);
		return item;
	}
	
	public static ItemStack addEnchants(ItemStack item, Map<Enchantment, Integer> ench) {
		if(ench == null)return item;
		for (Map.Entry<Enchantment, Integer> entry : ench.entrySet()) {
			item.addUnsafeEnchantment(entry.getKey(), entry.getValue());
		}
		return item;
	}
	
	public static ItemStack modifyItem(ItemStack item, String name, Map<Enchantment, Integer> ench, String[] lore, boolean unbreakable, boolean hideFlags) {
		item = addEnchants(item, ench);
		ItemMeta meta = item.getItemMeta();
		if(name != null)meta.setDisplayName(name);
		if(lore != null) meta.setLore(Arrays.asList(lore));
		if(hideFlags) {
			for(ItemFlag flag : ItemFlag.values()) {
				meta.addItemFlags(flag);
			}
		}
		meta.setUnbreakable(unbreakable);
		item.setItemMeta(meta);
		return item;
	}
	
	public static Map<ItemStack, Integer> sortMap() {
		Map<ItemStack, Integer> map = new HashMap<>();
		
		
		
		return map;
	}
	
	public static void consumeItemInHand(Player player, int count) {
        if (player.getInventory().getItemInMainHand().getAmount() >= count) {
            player.getInventory().getItemInMainHand().setAmount(player.getInventory().getItemInMainHand().getAmount() - count);
        } else {
            player.setItemInHand(new ItemStack(Material.AIR));
        }
    }
	
	public static void consumeItem(Player player, int count, ItemStack item) {
		if (!player.getInventory().getItemInMainHand().isSimilar(item)) return;
        if (player.getInventory().getItemInMainHand().getAmount() >= count) {
            player.getInventory().getItemInMainHand().setAmount(player.getInventory().getItemInMainHand().getAmount() - count);
        } else {
            player.setItemInHand(new ItemStack(Material.AIR));
        }
    }
}

