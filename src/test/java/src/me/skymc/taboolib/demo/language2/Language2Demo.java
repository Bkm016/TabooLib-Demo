package me.skymc.taboolib.demo.language2;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

import me.skymc.taboolib.demo.TabooLibDemo;
import me.skymc.taboolib.string.language2.Language2;

/**
 * @author sky
 * @since 2018��2��13�� ����7:54:24
 */
public class Language2Demo implements Listener {
	
	private Language2 language2;
	
	public Language2Demo() {
		/**
		 * �����ļ���ʲô���ֵ�һ��������дʲô
		 * ���������Ĭ������ "zh_CN.yml"
		 * 
		 * ����ļ�����������׳� "FileNotFoundException" �쳣
		 */
		language2 = new Language2("Language2", TabooLibDemo.getInst());
	}
	
	@EventHandler
	public void onCommand(PlayerCommandPreprocessEvent e) {
		if (e.getMessage().equals("/l2")) {
			e.setCancelled(true);
			// ��ʾ��Ϣ
			language2.get("MESSAGE").send(e.getPlayer());
		}
	}
}