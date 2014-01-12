package com.lenis0012.bukkit.marriage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;

import org.bukkit.Bukkit;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;

public class PlayerConfig extends YamlConfiguration {
	private File file;
	
	public PlayerConfig(File file) {
		this.file = file;
		this.reload();
	}
	
	public void save() {
		try {
			this.save(this.file);
		} catch (IOException ex) {
			Bukkit.getLogger().log(Level.SEVERE, "Не могу сохранить " + file, ex);
		}
	}
	
	public void reload() {
		try {
			this.load(file);
		} catch (FileNotFoundException ex) {
		} catch (IOException ex) {
			Bukkit.getLogger().log(Level.SEVERE, "Не могу закгрузить " + file, ex);
		} catch (InvalidConfigurationException ex) {
			Bukkit.getLogger().log(Level.SEVERE, "Не могу загрузить " + file, ex);
		}
	}
}