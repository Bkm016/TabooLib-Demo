package me.skymc.taboolib.demo;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import me.skymc.taboolib.demo.display.DisplayDemo;
import me.skymc.taboolib.demo.message.ChatCatcherDemo;
import me.skymc.taboolib.demo.player.ItemTakeDemo;
import me.skymc.taboolib.demo.player.listener.ListenerPlayerJump;
import me.skymc.taboolib.demo.sound.SoundPackDemo;
import me.skymc.taboolib.string.Language;

public class TabooLibDemo extends JavaPlugin {
	
	private static Plugin inst;
	private static Language language;
	
	public static Plugin getInst() {
		return inst;
	}
	
	public static Language getLanguage() {
		return language;
	}
	
	@Override
	public void onLoad() {
		inst = this;
		saveDefaultConfig();
	}
	
	@Override
	public void onEnable() {
		/**
		 * ×¢²áÓïÑÔÎÄ¼ş
		 */
		language = new Language(getConfig().getString("Language"), this);
		
		/**
		 * ×¢²á¼àÌıÆ÷
		 */
		Bukkit.getPluginManager().registerEvents(new DisplayDemo(), this);
		Bukkit.getPluginManager().registerEvents(new ChatCatcherDemo(), this);
		Bukkit.getPluginManager().registerEvents(new ItemTakeDemo(), this);
		Bukkit.getPluginManager().registerEvents(new ListenerPlayerJump(), this);
		
		/**
		 * ×¢²áÖ¸Áî
		 */
		Bukkit.getPluginCommand("soundtest").setExecutor(new SoundPackDemo());
		Bukkit.getPluginCommand("soundtest").setTabCompleter(new SoundPackDemo());
		
		/**
		 * ÔØÈëÌáÊ¾
		 */
		language.send(Bukkit.getConsoleSender(), "ENABLE");
	}
}
