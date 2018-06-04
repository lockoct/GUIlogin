package net.mmyz.ld.login;

import java.io.File;
import java.util.Objects;
import java.util.TreeMap;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

public class LoginInfoUtil {
	public static TreeMap<String, String> getPlayerLoginInfo(String playerName) {
		TreeMap<String, String> playerLoginInfo = new TreeMap<>();

		File pwFile = new File("plugins/GUIlogin/login.yml");

		FileConfiguration fc = YamlConfiguration.loadConfiguration(pwFile);

		if (Objects.equals(fc.getString(playerName + ".pwEncrypt"), null)) {
			fc.set(playerName+".pwEncrypt", "");
		}
		playerLoginInfo.put("pwEncrypt", fc.getString(playerName + ".pwEncrypt"));
		
		return playerLoginInfo;
	}
}
