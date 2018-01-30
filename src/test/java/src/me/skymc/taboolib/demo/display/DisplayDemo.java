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
		 * ����ҷ��ʹ����
		 */
		TitleUtils.sendTitle(e.getPlayer(), "��ӭ!", 10, 100, 10, "��ӭ�������������!", 10, 100, 10);
		
		/**
		 * ��������ҷ���С����
		 */
		for (Player player : Bukkit.getOnlinePlayers()) {
			if (!player.equals(e.getPlayer())) {
				ActionUtils.send(player, "��� " + e.getPlayer().getName() + " ���������");
			}
		}
	}
}