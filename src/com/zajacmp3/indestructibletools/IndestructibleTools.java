package com.zajacmp3.indestructibletools;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

public class IndestructibleTools extends JavaPlugin implements Listener{
	public void onDisable(){
		
	}
	public void onEnable(){
		load();
		PluginDescriptionFile description = this.getDescription();
		System.out.println("IndestructibleTools "+description.getVersion()+" is launching");
		EventListener(this);
	}
	public Plugin plugin;
	public void EventListener(Plugin instance) {
	plugin = instance;
	Bukkit.getServer().getPluginManager().registerEvents(this, plugin);
	}
	private void load() {
		// TODO Auto-generated method stub
		
	}
	@EventHandler(priority = EventPriority.NORMAL)
	public void itemUsage(final PlayerInteractEvent event){
		Player player = event.getPlayer();
		player.getItemInHand().setDurability((short) 0);
	}
	@EventHandler(priority = EventPriority.NORMAL)
	public void playerDamaged(final EntityDamageByEntityEvent event){
		if(event.getEntity() instanceof Player){
			Player player = (Player)event.getEntity();
			if(player.getInventory().getHelmet()!=null){
				System.out.println("test1");
				player.getInventory().getHelmet().setDurability((short) 0);
			}
			if(player.getInventory().getBoots()!=null){
				System.out.println("test2");
				player.getInventory().getBoots().setDurability((short) 0);
			}
			if(player.getInventory().getLeggings()!=null){
				System.out.println("test3");
				player.getInventory().getLeggings().setDurability((short) 0);
			}
			if(player.getInventory().getChestplate()!=null){
				System.out.println("test4");
				player.getInventory().getChestplate().setDurability((short) 0);
			}
		}
	}
}