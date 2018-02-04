package me.skymc.taboolib.demo.thread;

import org.bukkit.event.EventHandler;

import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

import me.skymc.taboolib.thread.ThreadUtils;

/**
 * @author sky
 * @since 2018年2月4日 下午10:47:21
 */
public class ThreadUtilsDemo implements Listener {
	
	private ThreadUtils theadTask;
	
	public ThreadUtilsDemo() {
		/**
		 * 创建线程池，大小为 5
		 */
		theadTask = new ThreadUtils(5);
	}
	
	@EventHandler
	public void onCommand(PlayerCommandPreprocessEvent e) {
		if (e.getMessage().equals("/lag")) {
			e.setCancelled(true);
			
			for (int i = 0 ; i < 10 ; i++) {
				/**
				 * 执行任务
				 */
				theadTask.execute(new Runnable() {
					
					@Override
					public void run() {
						try {
							/**
							 * 模拟任务
							 */
							Thread.sleep(5000L);
						}
						catch (Exception e) {
							// 
						}
						
						e.getPlayer().sendMessage("延迟 5 秒的任务执行完毕!");
					}
				});
			}
		}
	}

}
