package com.lenis0012.bukkit.marriage.lang;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;



import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;

import com.lenis0012.bukkit.marriage.Marriage;


public class LangConfig extends YamlConfiguration {
	private static LangConfig instance;
	
	public static LangConfig get() {
		if(instance != null)
			return instance;
		else
			return instance = new LangConfig();
	}
	
	private Marriage plugin;
	private File file;
	
	public LangConfig() {
		this.plugin = Marriage.instance;
		this.file = new File(plugin.getDataFolder(), "lang.yml");
		plugin.getDataFolder().mkdir();
		
		try {
			if(!file.exists())
				file.createNewFile();
		} catch(IOException e) {
			plugin.getLogger().log(Level.SEVERE, "Failed to create lang.yml", e);
		}
		
		this.reload();
	}
	
	public void reload() {
		try {
			this.load(file);
		} catch (FileNotFoundException e) {
			plugin.getLogger().log(Level.SEVERE, "Ошибка загрузки lang.yml (не найдено)", e);
		} catch (IOException e) {
			plugin.getLogger().log(Level.SEVERE, "Ошибка загрузки lang.yml", e);
		} catch (InvalidConfigurationException e) {
			plugin.getLogger().log(Level.SEVERE, "Ошибка загрузки lang.yml (недействительно)", e);
		}
	}
	
	public void save() {
		try {
			this.save(file);
		} catch (IOException e) {
			plugin.getLogger().log(Level.SEVERE, "Ошибка сохранения lang.yml", e);
		}
	}
	
	public String getMessageWithDefault(String path, String def) {
		if(this.contains("messages." + path))
			return this.getString("messages." + path);
		else {
			this.set("messages." + path, def);
			this.save();
			return def;
		}
	}
	
	public String getWordWithDefault(String path, String def) {
		if(this.contains("words." + path))
			return this.getString("words." + path);
		else {
			this.set("words." + path, def);
			this.save();
			return def;
		}
	}
}