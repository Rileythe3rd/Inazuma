package me.rileythe3rd.inazuma;

import org.bukkit.plugin.java.JavaPlugin;

public class InazumaPlugin extends JavaPlugin {
	

private static InazumaPlugin plugin;
	
	@Override
	public void onEnable() {
		plugin = this;
		getServer().getPluginManager().registerEvents(new WaterListener(), this);
	} 
	
	public void onDisable() {

}

	public static InazumaPlugin getPlugin() {
		return plugin;
}
}
