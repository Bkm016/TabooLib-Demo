package me.skymc.taboolib.demo.economy;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

import me.skymc.taboolib.economy.EcoUtils;

/**
 * @author sky
 * @since 2018年2月4日 下午10:52:27
 */
public class EcoUtilsDemo implements Listener {
	
	@EventHandler
	public void onDeath(PlayerDeathEvent e) {
		if (e.getEntity().getKiller() != null) {
			
			/**
			 * 添加金币
			 */
			EcoUtils.add(e.getEntity().getKiller(), 100);
			
			/**
			 * 提示信息
			 */
			e.getEntity().getKiller().sendMessage("§7击杀玩家 " + e.getEntity().getName() + " 获得 100 金币");
		}
	}

}
