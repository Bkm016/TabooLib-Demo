package me.skymc.taboolib.demo.cooldown;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

import me.skymc.taboolib.cooldown.seconds.CooldownPack2;

/**
 * @author sky
 * @since 2018年2月4日 下午10:38:20
 */
public class CooldownPackDemo implements Listener {
	
	private CooldownPack2 cooldown;
	
	public CooldownPackDemo() {
		/**
		 * 创建一个冷却包，时间为 10000 毫秒（10秒）
		 */
		cooldown = new CooldownPack2("spawn-cooldown", 10000);
	}
	
	@EventHandler
	public void onCommand(PlayerCommandPreprocessEvent e) {
		/**
		 * 判断命令
		 */
		if (e.getMessage().equalsIgnoreCase("/spawn")) {
			/**
			 * 判断冷却，如果是 VIP 则减少 5000 毫秒（5秒）
			 */
			if (cooldown.isCooldown(e.getPlayer().getName(), e.getPlayer().hasPermission("vip") ? 500 : 0)) {
				e.setCancelled(true);
				e.getPlayer().sendMessage("§4冷却中");
			}
		}
	}

}
