package me.imthelion.craftabletrolls.recipes;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ShapedRecipe;

import me.imthelion.craftabletrolls.Main;
import me.imthelion.craftabletrolls.util.Items;

public class RecipeManager {
	
	public RecipeManager() {
		drop();
		acces();
		control();
		achievement();
		iron();
		pot();
		drown();
	}
	
	public void drop() {
		ShapedRecipe recipe = new ShapedRecipe(new NamespacedKey(Main.getInstance(), "drop"), Items.getDrop());
		recipe.shape("BBB","BCB","BBB");
		recipe.setIngredient('B', Material.COAL);
		recipe.setIngredient('C', Material.HOPPER);
		Bukkit.addRecipe(recipe);
	}
	
	public void acces() {
		ShapedRecipe recipe = new ShapedRecipe(new NamespacedKey(Main.getInstance(), "acces"), Items.getInv());
		recipe.shape("BBB","BCB","BBB");
		recipe.setIngredient('B', Material.GOLD_INGOT);
		recipe.setIngredient('C', Material.CHEST);
		Bukkit.addRecipe(recipe);
	}
	
	public void control() {
		ShapedRecipe recipe = new ShapedRecipe(new NamespacedKey(Main.getInstance(), "control"), Items.getControl());
		recipe.shape("BBB","BCB","BBB");
		recipe.setIngredient('B', Material.RED_STAINED_GLASS);
		recipe.setIngredient('C', Material.DIAMOND);
		Bukkit.addRecipe(recipe);
	}
	public void achievement() {
		ShapedRecipe recipe = new ShapedRecipe(new NamespacedKey(Main.getInstance(), "achievement"), Items.getAch());
		recipe.shape("BBB","BCB","BBB");
		recipe.setIngredient('B', Material.COBBLESTONE);
		recipe.setIngredient('C', Material.DIRT);
		Bukkit.addRecipe(recipe);
	}
	public void iron() {
		ShapedRecipe recipe = new ShapedRecipe(new NamespacedKey(Main.getInstance(), "iron_troll"), Items.getRandom());
		recipe.shape("BBB","BCB","BBB");
		recipe.setIngredient('B', Material.IRON_INGOT);
		recipe.setIngredient('C', Material.CLAY_BALL);
		Bukkit.addRecipe(recipe);
	}
	public void pot() {
		ShapedRecipe recipe = new ShapedRecipe(new NamespacedKey(Main.getInstance(), "potion_troll"), Items.getPot());
		recipe.shape("BBB","BCB","BBB");
		recipe.setIngredient('B', Material.SAND);
		recipe.setIngredient('C', Material.POTION);
		Bukkit.addRecipe(recipe);
	}
	public void drown() {
		ShapedRecipe recipe = new ShapedRecipe(new NamespacedKey(Main.getInstance(), "drown"), Items.getDrown());
		recipe.shape("BBB","BCB","BBB");
		recipe.setIngredient('B', Material.OBSIDIAN);
		recipe.setIngredient('C', Material.WATER_BUCKET);
		Bukkit.addRecipe(recipe);
	}
	
	public static void remove() {
		Bukkit.removeRecipe(new NamespacedKey(Main.getInstance(), "drop"));
		Bukkit.removeRecipe(new NamespacedKey(Main.getInstance(), "acces"));
		Bukkit.removeRecipe(new NamespacedKey(Main.getInstance(), "control"));
		Bukkit.removeRecipe(new NamespacedKey(Main.getInstance(), "achievement"));
		Bukkit.removeRecipe(new NamespacedKey(Main.getInstance(), "iron_troll"));
		Bukkit.removeRecipe(new NamespacedKey(Main.getInstance(), "potion_troll"));
		Bukkit.removeRecipe(new NamespacedKey(Main.getInstance(), "drown"));
	}

}
