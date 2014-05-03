package com.wangypro.dathoe;

import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.entity.Snowball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.util.BlockIterator;

public class DatHoeListener implements Listener {
	
	private final DatHoeMain plugin;
	
	public DatHoeListener(DatHoeMain plugin) {
		this.plugin = plugin;
	}
	
	@EventHandler
	public void onHoeFire(EntityShootBowEvent event) {
		if(event.getEntity() instanceof Player) {
			Player player = (Player) event.getEntity();
			
			if(!player.hasPermission("dathoe.fire")) {
				player.sendMessage(ChatColor.GOLD + "[DatHoe: Error] " + ChatColor.RED + "You don't have permission to do that!");
				event.setCancelled(true);
				return;
			}
			
			if(event.getBow().getEnchantmentLevel(Enchantment.ARROW_FIRE) == 5) {
				if(event.getBow().getEnchantmentLevel(Enchantment.ARROW_FIRE) == 5) {
					event.setCancelled(true);
					player.launchProjectile(Snowball.class).setVelocity(event.getProjectile().getVelocity().multiply(1.5));
					player.playSound(player.getLocation(), Sound.SUCCESSFUL_HIT, 1.0f, 1.0f);
				} else {
					event.setCancelled(true);
				}
			} else {
				return;
			}
		}
	}
	
	@EventHandler
	public void onSnowballHit(ProjectileHitEvent event) {
		BlockIterator iterator = new BlockIterator(event.getEntity().getWorld(),event.getEntity().getLocation().toVector(), event.getEntity().getVelocity().normalize(), 0.0D, 4);
		Block hitBlock = null;
		
		while(iterator.hasNext()) {
			hitBlock = iterator.next();
			
			if(hitBlock.getTypeId() != 0) {
				break;
			}
		}
		

		hitBlock.getWorld().playEffect(hitBlock.getLocation(), Effect.STEP_SOUND, hitBlock.getTypeId());
		Player player = (Player) event.getEntity().getShooter();
		if(player.hasPermission("dathoe.smite")) {
			hitBlock.getWorld().strikeLightning(hitBlock.getLocation());
		}
		
	}

}
