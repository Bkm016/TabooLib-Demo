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
		 * 如果玩家输入指令 /tp
		 */
		if (e.getMessage().equals("/tp")) {
			e.setCancelled(true);
			
			/**
			 * 创建聊天捕捉器
			 */
			ChatCatcher.call(e.getPlayer(), new ChatCatcher.Catcher() {
				
				/**
				 * 玩家输入 "quit()" 可以退出引导
				 */
				@Override
				public void cancel() {
					e.getPlayer().sendMessage("§7取消引导");
				}
				
				/**
				 * 捕捉器发送之前
				 */
				@Override
				public Catcher before() {
					e.getPlayer().sendMessage("§7请在聊天框中输入玩家名称, \"quit()\" 退出引导");
					return this;
				}
				
				@Override
				/**
				 * 捕捉器捕捉聊天信息后
				 * 如果返回为真，则重复当前捕捉器
				 * 如果返回为否，则结束
				 */
				public boolean after(String message) {
					Player player = Bukkit.getPlayerExact(message);
					if (player != null) {
						e.getPlayer().sendMessage("§7已传送至玩家 " + message);
						e.getPlayer().teleport(player);
						return false;
					}
					else {
						e.getPlayer().sendMessage("§4玩家 " + message + " 不在线");
						return true;
					}
				}
			});
		}
	}
}