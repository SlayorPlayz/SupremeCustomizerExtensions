package com.slayorplayz.supremecustomizer.inventory.codeblocks.extensions;

import com.google.common.base.Charsets;
import com.slayorplayz.supremecustomizer.SC;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.*;
import java.net.JarURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.jar.JarFile;

public class ExtensionBlockReader {

    private File file;

    public ExtensionBlockReader(File file){
        this.file = file;
    }

    public File getFile() {
        return file;
    }

    public ExtensionConfig hasBlockYml(){
        try {
            URLClassLoader loader = new URLClassLoader(new URL[]{file.toURI().toURL()});
            InputStream in = loader.getResourceAsStream("/block.yml");
            Reader targetReader = new InputStreamReader(in);
            FileConfiguration fc = YamlConfiguration.loadConfiguration(targetReader);
            return new ExtensionConfig(fc);
        }catch (IOException e){
            return null;
        }
    }
}
