package me.rileythe3rd.inazuma;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Creeper;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerToggleSneakEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.potion.PotionType;

public class WaterListener implements Listener {
	@EventHandler
	public void onPlayerSneak(PlayerToggleSneakEvent event) {
		Player p = event.getPlayer();
		ItemStack bag[] = p.getInventory().getContents();
		
	
			
			for(ItemStack is : bag) {
				if (is != null && is.hasItemMeta()) {
					ItemMeta im = is.getItemMeta();
					if (im.getLore().contains("Hydro Vision")) {
					
						//levitate player
					p.addPotionEffect(new PotionEffect(PotionEffectType.LEVITATION, 60, 1));
					
					//summon creeper
					Location loc = p.getLocation();
					Creeper entity = (Creeper)p.getWorld().spawnEntity(loc, EntityType.CREEPER);
					
					Bukkit.getScheduler().runTaskLater(InazumaPlugin.getPlugin(), () -> {
					    entity.explode();
					}, 30);
		;
					
				}

				//make player levitate a little
				// drop a live tnt
				//probably make player immune to explosion damage
				//make this happen when hotbbar is in slot 2 
			
		
			}
		
		
		//new idea. If we make "Constellation Stencils" we can create techniques for each character, and use a button to assign them to a player. 
		//Then we check for the appropriate vision element. Fir now we can create "Pyro Stencil." "Hydro stencil" etc.
		

		
		
		
		
//		if (p.getInventory().contains(itemstack)) {
//			
//		}
	}
}
}