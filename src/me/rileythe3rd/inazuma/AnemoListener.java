package me.rileythe3rd.inazuma;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerToggleSneakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitTask;
import org.bukkit.util.Vector;

public class AnemoListener implements Listener{
	@EventHandler
	public void onPlayerLeftClick(PlayerInteractEvent event) {
		Player p = event.getPlayer();
		Action a = event.getAction();
		//If player is in map, drag them down and do damage, player will be removed in  2 seconds
		if ((a == Action.LEFT_CLICK_AIR || a == Action.LEFT_CLICK_BLOCK) && map.containsKey(p)) {
			p.setVelocity(new Vector(0, -40, 0));
			
			//give player resistance during plunge
			p.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 2 * 20, 5));
			map.remove(p).cancel();
		}
	}
	
	public HashMap<Player, BukkitTask> map = new HashMap<>();
	
	@EventHandler
	public void onPlayerSneak(PlayerToggleSneakEvent event) {
		Player p = event.getPlayer();
		ItemStack bag[] = p.getInventory().getContents();
		
		for(ItemStack is : bag) {
			if (is != null && is.hasItemMeta()) {
				ItemMeta im = is.getItemMeta();
				if (im.getLore().contains("Anemo Vision")) {
					//Yeet in the air: slight velocity up?
					p.setVelocity(new Vector(0, 40, 0));
					map.put(p, 
					
					//remove added player after 2 seconds
					Bukkit.getScheduler().runTaskLater(InazumaPlugin.getPlugin(), () -> {
					    map.remove(p);
					}, 2 * 20)
				
					);
					//When click in mid air, plunge
					//if no click in midair, just float down
					//invulnerable for a certain duration (what if they disconnect)
				
			}
		}
	}
	}
}
