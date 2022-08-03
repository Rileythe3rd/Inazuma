package me.rileythe3rd.inazuma;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerToggleSneakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.util.Vector;

public class AnemoListener implements Listener{
	
	@EventHandler
	public void onPlayerSneak(PlayerToggleSneakEvent event) {
		Player p = event.getPlayer();
		ItemStack bag[] = p.getInventory().getContents();
		
		for(ItemStack is : bag) {
			if (is != null && is.hasItemMeta()) {
				ItemMeta im = is.getItemMeta();
				if (im.getLore().contains("Anemo Vision")) {
					p.setVelocity(new Vector(15, 0, 0));
					
					//Yeet in the air: slight velocity up?
					//When click in mid air, plunge
					//if no click in midair, just float down
					//invulnerable for a certain duration (what if they disconnect)
				}
			}
		}
	}

}
