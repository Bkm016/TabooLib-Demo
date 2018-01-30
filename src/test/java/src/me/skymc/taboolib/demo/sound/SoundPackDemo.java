package me.skymc.taboolib.demo.sound;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import me.skymc.taboolib.demo.TabooLibDemo;
import me.skymc.taboolib.demo.sound.enums.SoundEnums;
import me.skymc.taboolib.sound.SoundPack;

public class SoundPackDemo implements CommandExecutor, TabCompleter {
	
	@Override
	public boolean onCommand(CommandSender sender, Command arg1, String arg2, String[] args) {
		if (!(sender instanceof Player)) {
			TabooLibDemo.getLanguage().send(sender, "CONSOLE");
			return false;
		}
		
		if (args.length == 0) {
			TabooLibDemo.getLanguage().send(sender, "SOUNDEMPTY");
			return false;
		}
		
		new SoundPack(args[0]).play((Player) sender);;
		return true;
	}

	@Override
	public List<String> onTabComplete(CommandSender arg0, Command arg1, String arg2, String[] args) {
		List<String> sounds = new ArrayList<>();
		for (SoundEnums sound : SoundEnums.values()) {
			sounds.add(sound.name());
		}
		return sounds;
	}
}
