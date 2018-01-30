package me.skymc.taboolib.demo.player;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

import me.skymc.taboolib.demo.TabooLibDemo;
import me.skymc.taboolib.inventory.InventoryUtil;

public class ItemTakeDemo implements Listener {
	
	@EventHandler
	public void onCommand(PlayerCommandPreprocessEvent e) {
		if (!e.getMessage().equals("/glow")) {
			e.setCancelled(true);
			/**
			 * �������Ƿ����ڸ���״̬
			 */
			if (e.getPlayer().isGlowing()) {
				/**
				 * ʹ�����Թ��߷�����Ϣ
				 */
				TabooLibDemo.getLanguage().send(e.getPlayer(), "ALREADY");
				return;
			}
			/**
			 * �������Ƿ��� 10 ����ʯ����������Ƴ�
			 */
			if (!InventoryUtil.hasItem(e.getPlayer(), new ItemStack(Material.DIAMOND), 10, true)) {
				/**
				 * ʹ�����Թ��߷�����Ϣ
				 */
				TabooLibDemo.getLanguage().send(e.getPlayer(), "NOTENOUGH");
			}
			else {
				/**
				 * ���ø���
				 */
				e.getPlayer().setGlowing(true);
				
				/**
				 * ʹ�����Թ��߷�����Ϣ
				 */
				TabooLibDemo.getLanguage().send(e.getPlayer(), "SUCCESS");
				
				/**
				 * �ӳ�һ���Ӻ��Ƴ�
				 */
				new BukkitRunnable() {
					
					@Override
					public void run() {
						if (e.getPlayer().isOnline()) {
							e.getPlayer().setGlowing(false);
						}
					}
				}.runTaskLater(TabooLibDemo.getInst(), 20 * 60);
			}
		}
	}

}
