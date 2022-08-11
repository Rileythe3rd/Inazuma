package me.rileythe3rd.inazuma;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerToggleSneakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;


public class ElectroListener implements Listener{
	@EventHandler
	public void onPlayerSneak(PlayerToggleSneakEvent event) {
		Player p = event.getPlayer();
		ItemStack bag[] = p.getInventory().getContents();
		
		for(ItemStack is : bag) {
			if (is != null && is.hasItemMeta()) {
				ItemMeta im = is.getItemMeta();
				if (im.getLore().contains("Electro Vision")) {
					//strike nearby entities with lightning
					for(Entity in : p.getNearbyEntities(2, 2, 2)) {
						Location entityLoc = in.getLocation();
						p.getWorld().strikeLightning(entityLoc);
					}
					
				}
			}
		}
	}
}
