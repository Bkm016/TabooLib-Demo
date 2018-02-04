package me.skymc.taboolib.demo.thread;

import org.bukkit.event.EventHandler;

import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

import me.skymc.taboolib.thread.ThreadUtils;

/**
 * @author sky
 * @since 2018��2��4�� ����10:47:21
 */
public class ThreadUtilsDemo implements Listener {
	
	private ThreadUtils theadTask;
	
	public ThreadUtilsDemo() {
		/**
		 * �����̳߳أ���СΪ 5
		 */
		theadTask = new ThreadUtils(5);
	}
	
	@EventHandler
	public void onCommand(PlayerCommandPreprocessEvent e) {
		if (e.getMessage().equals("/lag")) {
			e.setCancelled(true);
			
			for (int i = 0 ; i < 10 ; i++) {
				/**
				 * ִ������
				 */
				theadTask.execute(new Runnable() {
					
					@Override
					public void run() {
						try {
							/**
							 * ģ������
							 */
							Thread.sleep(5000L);
						}
						catch (Exception e) {
							// 
						}
						
						e.getPlayer().sendMessage("�ӳ� 5 �������ִ�����!");
					}
				});
			}
		}
	}

}
