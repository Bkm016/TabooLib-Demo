package me.skymc.taboolib.demo.cooldown;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

import me.skymc.taboolib.cooldown.seconds.CooldownPack2;

/**
 * @author sky
 * @since 2018��2��4�� ����10:38:20
 */
public class CooldownPackDemo implements Listener {
	
	private CooldownPack2 cooldown;
	
	public CooldownPackDemo() {
		/**
		 * ����һ����ȴ����ʱ��Ϊ 10000 ���루10�룩
		 */
		cooldown = new CooldownPack2("spawn-cooldown", 10000);
	}
	
	@EventHandler
	public void onCommand(PlayerCommandPreprocessEvent e) {
		/**
		 * �ж�����
		 */
		if (e.getMessage().equalsIgnoreCase("/spawn")) {
			/**
			 * �ж���ȴ������� VIP ����� 5000 ���루5�룩
			 */
			if (cooldown.isCooldown(e.getPlayer().getName(), e.getPlayer().hasPermission("vip") ? 500 : 0)) {
				e.setCancelled(true);
				e.getPlayer().sendMessage("��4��ȴ��");
			}
		}
	}

}
