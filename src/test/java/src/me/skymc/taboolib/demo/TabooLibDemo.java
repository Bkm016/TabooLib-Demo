package me.skymc.taboolib.demo;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import me.skymc.taboolib.demo.display.DisplayDemo;
import me.skymc.taboolib.demo.message.ChatCatcherDemo;
import me.skymc.taboolib.display.ActionUtils;
import me.skymc.taboolib.display.TitleUtils;
import me.skymc.taboolib.string.Language;
import lombok.Getter;

public class TabooLibDemo extends JavaPlugin {
	
	@Getter
	private static Plugin inst;
	
	@Getter
	private static Language language;
	
	@Override
	public void onLoad() {
		inst = this;
		saveDefaultConfig();
	}
	
	@Override
	public void onEnable() {
		language = new Language(getConfig().getString("Language"), this);
		
		Bukkit.getPluginManager().registerEvents(new DisplayDemo(), this);
		Bukkit.getPluginManager().registerEvents(new ChatCatcherDemo(), this);
	}
}
