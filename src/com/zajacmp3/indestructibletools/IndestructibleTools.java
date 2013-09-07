package com.zajacmp3.indestructibletools;

import org.bukkit.Bukkit;
import org.bukkit.Server;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;
import java.awt.event.*;
import ru.tehkode.permissions.PermissionManager;
import ru.tehkode.permissions.bukkit.PermissionsEx;

public class IndestructibleTools extends JavaPlugin implements Listener,ActionListener{
	public static Server server;
	public static PermissionManager Permissions;
	public void onDisable(){
		getServer().getLogger().fine("exit server?");
		
	}
	public void onEnable(){
		load();
		setupPermissions();
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
		if(isAllowed(player,"tools")){
			player.getItemInHand().setDurability((short) 0);
		}
	}
	@EventHandler(priority = EventPriority.NORMAL)
	public void playerDamaged(final EntityDamageByEntityEvent event){
		if(event.getEntity() instanceof Player){
			Player player = (Player)event.getEntity();
			if(isAllowed(player,"armor")){
				if(player.getInventory().getHelmet()!=null){
					player.getInventory().getHelmet().setDurability((short) 0);
				}
				if(player.getInventory().getBoots()!=null){
					player.getInventory().getBoots().setDurability((short) 0);
				}
				if(player.getInventory().getLeggings()!=null){
					player.getInventory().getLeggings().setDurability((short) 0);
				}
				if(player.getInventory().getChestplate()!=null){
					player.getInventory().getChestplate().setDurability((short) 0);
				}
			}
		}
	}
	private void setupPermissions(){
		if (IndestructibleTools.Permissions == null){
			if(getServer().getPluginManager().isPluginEnabled("PermissionsEx")){
				IndestructibleTools.Permissions = PermissionsEx.getPermissionManager();
			}
			else{
				System.out.println("Permission system not detected, defaulting to OP");
			}
		}
	}
	public static boolean isAllowed( Player player, String string ){
		if( Permissions == null ){
			return true;
		}
		if( Permissions.has(player, "indestructibletools.armor")){
			return true;
		}
		else{
			if( player.isOp() == true){
					return true;
			}
			else{
				return false;
			}
		}
	
	}
	public boolean onCommand(Command cmd,CommandSender s,String name,String[] args){
		if(name.equalsIgnoreCase("stop"){
			
		if(isAllowed(((Player)s),null)
			getServer().stop();
		}
		
		
		
	}
}
