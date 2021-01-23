package me.Adrenalize.TrialTwo;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
	@Override
	public void onEnable() {
		ItemManager.iman();
		Commands cmd = new Commands();
		getCommand("thor").setExecutor(cmd);
		getCommand("wither").setExecutor(cmd);
		getServer().getPluginManager().registerEvents(new Events(), this);
	}
	
	@Override
	public void onDisable() {
		
	}
}
