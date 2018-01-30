package me.skymc.taboolib.demo.display;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import me.skymc.taboolib.display.ActionUtils;
import me.skymc.taboolib.display.TitleUtils;

public class DisplayDemo implements Listener {
	
	@EventHandler
	public void onCommand(PlayerJoinEvent e) {
		/**
		 * 向玩家发送大标题
		 */
		TitleUtils.sendTitle(e.getPlayer(), "欢迎!", 10, 100, 10, "欢迎来到这个服务器!", 10, 100, 10);
		
		/**
		 * 向其他玩家发送小标题
		 */
		for (Player player : Bukkit.getOnlinePlayers()) {
			if (!player.equals(e.getPlayer())) {
				ActionUtils.send(player, "玩家 " + e.getPlayer().getName() + " 加入服务器");
			}
		}
	}
}