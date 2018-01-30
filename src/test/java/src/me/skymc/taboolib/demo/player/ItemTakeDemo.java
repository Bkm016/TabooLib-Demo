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
			 * 检查玩家是否正在高亮状态
			 */
			if (e.getPlayer().isGlowing()) {
				/**
				 * 使用语言工具发送信息
				 */
				TabooLibDemo.getLanguage().send(e.getPlayer(), "ALREADY");
				return;
			}
			/**
			 * 检查玩家是否有 10 个钻石，如果有则移除
			 */
			if (!InventoryUtil.hasItem(e.getPlayer(), new ItemStack(Material.DIAMOND), 10, true)) {
				/**
				 * 使用语言工具发送信息
				 */
				TabooLibDemo.getLanguage().send(e.getPlayer(), "NOTENOUGH");
			}
			else {
				/**
				 * 设置高亮
				 */
				e.getPlayer().setGlowing(true);
				
				/**
				 * 使用语言工具发送信息
				 */
				TabooLibDemo.getLanguage().send(e.getPlayer(), "SUCCESS");
				
				/**
				 * 延迟一分钟后移除
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
