package com.wangypro.dathoe;

import org.bukkit.plugin.java.JavaPlugin;

public class DatHoeMain extends JavaPlugin{
	
	public void onDisable() {
		
	}
	
	public void onEnable() {
		DatHoeRecipes recipes = new DatHoeRecipes();
		this.getServer().addRecipe(recipes.SuperHoe());
		this.getServer().getPluginManager().registerEvents(new DatHoeListener(this), this);
	}

}
