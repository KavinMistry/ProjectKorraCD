package com.projectkorra.projectkorra;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class CustomDamageConfig
{
    private final static CustomDamageConfig instance = new CustomDamageConfig();

    private File file;
    private FileConfiguration config;

    private CustomDamageConfig()
    {
    }

    public void load(){
        file = new File(ProjectKorra.getInstance().getDataFolder(), "custom-damage.yml");

        if(!file.exists())
        {
            ProjectKorra.getInstance().saveResource("custom-damage.yml", false);
        }

        config = new YamlConfiguration();
        config.options().parseComments(true);

        try {
            config.load(file);
        } catch (Exception ignored){
        }
    }

    public FileConfiguration getConfig() {
        return config;
    }

    public void saveConfig()
    {
        try {
            config.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void reloadConfig()
    {
        if (file == null) {
            load();
        }
        config = YamlConfiguration.loadConfiguration(file);
    }

    public static CustomDamageConfig getInstance()
    {
        return instance;
    }
}