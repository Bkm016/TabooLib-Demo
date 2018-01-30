package me.skymc.taboolib.demo.player.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import me.skymc.taboolib.demo.TabooLibDemo;
import me.skymc.taboolib.events.PlayerJumpEvent;

public class ListenerPlayerJump implements Listener {
	
	@EventHandler
	public void onJump(PlayerJumpEvent e) {
		TabooLibDemo.getLanguage().send(e.getPlayer(), "JUMP");
	}

}
