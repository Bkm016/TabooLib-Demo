package me.skymc.taboolib.demo.language2;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

import me.skymc.taboolib.demo.TabooLibDemo;
import me.skymc.taboolib.string.language2.Language2;

/**
 * @author sky
 * @since 2018年2月13日 下午7:54:24
 */
public class Language2Demo implements Listener {
	
	private Language2 language2;
	
	public Language2Demo() {
		/**
		 * 语言文件叫什么名字第一个参数就写什么
		 * 如果留空则默认载入 "zh_CN.yml"
		 * 
		 * 如果文件不存在则会抛出 "FileNotFoundException" 异常
		 */
		language2 = new Language2("Language2", TabooLibDemo.getInst());
	}
	
	@EventHandler
	public void onCommand(PlayerCommandPreprocessEvent e) {
		if (e.getMessage().equals("/l2")) {
			e.setCancelled(true);
			// 提示信息
			language2.get("MESSAGE").send(e.getPlayer());
		}
	}
}