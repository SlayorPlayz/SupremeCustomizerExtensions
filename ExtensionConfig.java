package com.slayorplayz.supremecustomizer.inventory.codeblocks.extensions;

import org.bukkit.configuration.file.FileConfiguration;

import java.util.List;

public class ExtensionConfig {

    private FileConfiguration conf;

    public ExtensionConfig(FileConfiguration configuration){
        this.conf = configuration;
    }

    public FileConfiguration getConf() {
        return conf;
    }

    public List<String> dependencies = conf.getStringList("dependencies");
    public String mainclass = conf.getString("main");
    public String version = conf.getString("version");
    public String api_version = conf.getString("api-version");
    public String name = conf.getString("name");

}
