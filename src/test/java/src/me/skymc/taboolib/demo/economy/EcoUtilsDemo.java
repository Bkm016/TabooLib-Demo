package me.skymc.taboolib.demo.economy;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

import me.skymc.taboolib.economy.EcoUtils;

/**
 * @author sky
 * @since 2018��2��4�� ����10:52:27
 */
public class EcoUtilsDemo implements Listener {
	
	@EventHandler
	public void onDeath(PlayerDeathEvent e) {
		if (e.getEntity().getKiller() != null) {
			
			/**
			 * ��ӽ��
			 */
			EcoUtils.add(e.getEntity().getKiller(), 100);
			
			/**
			 * ��ʾ��Ϣ
			 */
			e.getEntity().getKiller().sendMessage("��7��ɱ��� " + e.getEntity().getName() + " ��� 100 ���");
		}
	}

}
