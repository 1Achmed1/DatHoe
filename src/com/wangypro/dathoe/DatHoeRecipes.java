package com.wangypro.dathoe;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.ShapelessRecipe;
import org.bukkit.inventory.meta.ItemMeta;

public class DatHoeRecipes {

	public ShapelessRecipe SuperHoe() {
		
		ItemStack hoe = new ItemStack(Material.BOW);
		ItemMeta hoeMeta = hoe.getItemMeta();
		
		List<String> lore = new ArrayList<String>();
		lore.add(ChatColor.GRAY + "Snowballs 69");
		lore.add(ChatColor.GRAY + "Smite 69");
		lore.add(ChatColor.GOLD + "THE HOE OF SUPERNESS!");
		lore.add(ChatColor.DARK_PURPLE + "Shoot yo foes, hoe!");
		
		hoeMeta.setDisplayName(ChatColor.AQUA + "Superbow");
		hoeMeta.setLore(lore);
		hoeMeta.addEnchant(Enchantment.ARROW_FIRE, 5, true);
		hoe.setItemMeta(hoeMeta);
		
		ShapelessRecipe recipe = new ShapelessRecipe(hoe);
		recipe.addIngredient(Material.BOW);
		recipe.addIngredient(Material.SNOW_BALL);
		
		return recipe;
	}
	
}
