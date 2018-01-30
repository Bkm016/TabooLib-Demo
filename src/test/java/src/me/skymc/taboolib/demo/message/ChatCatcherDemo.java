package me.skymc.taboolib.demo.message;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

import me.skymc.taboolib.message.ChatCatcher;
import me.skymc.taboolib.message.ChatCatcher.Catcher;

public class ChatCatcherDemo implements Listener {
	
	@EventHandler
	public void onCommand(PlayerCommandPreprocessEvent e) {
		/**
		 * ����������ָ�� /tp
		 */
		if (e.getMessage().equals("/tp")) {
			e.setCancelled(true);
			
			/**
			 * �������첶׽��
			 */
			ChatCatcher.call(e.getPlayer(), new ChatCatcher.Catcher() {
				
				/**
				 * ������� "quit()" �����˳�����
				 */
				@Override
				public void cancel() {
					e.getPlayer().sendMessage("��7ȡ������");
				}
				
				/**
				 * ��׽������֮ǰ
				 */
				@Override
				public Catcher before() {
					e.getPlayer().sendMessage("��7����������������������, \"quit()\" �˳�����");
					return this;
				}
				
				@Override
				/**
				 * ��׽����׽������Ϣ��
				 * �������Ϊ�棬���ظ���ǰ��׽��
				 * �������Ϊ�������
				 */
				public boolean after(String message) {
					Player player = Bukkit.getPlayerExact(message);
					if (player != null) {
						e.getPlayer().sendMessage("��7�Ѵ�������� " + message);
						e.getPlayer().teleport(player);
						return false;
					}
					else {
						e.getPlayer().sendMessage("��4��� " + message + " ������");
						return true;
					}
				}
			});
		}
	}
}