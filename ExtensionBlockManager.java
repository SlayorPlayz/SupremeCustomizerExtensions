package com.slayorplayz.supremecustomizer.inventory.codeblocks.extensions;

import com.slayorplayz.supremecustomizer.SC;
import com.slayorplayz.supremecustomizer.utils.LoggerUtils;
import org.bukkit.Bukkit;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class ExtensionBlockManager {

    private Map<String, ExtensionBlock> getBlocks;

    public ExtensionBlockManager() {
        getBlocks = new HashMap<>();
        if (!dir.exists()) {
            dir.mkdir();
            LoggerUtils.log("&cNo extensions to load!");
        } else {
            load();
        }
    }

    public Map<String, ExtensionBlock> getBlocks() {
        return getBlocks;
    }

    public File dir = new File(SC.inst().getDataFolder() + "/extensions");

    private void load() {
        if (dir.listFiles().length == 0) {
            LoggerUtils.log("&cNo extensions to load!");
        }
        for (File file : dir.listFiles()) {
            ExtensionBlockReader ebr = new ExtensionBlockReader(file);
            if (ebr.hasBlockYml() != null) {
                try {
                    if (ebr.hasBlockYml() != null) {
                        if (!ebr.hasBlockYml().dependencies.isEmpty()) {
                            for (String s : ebr.hasBlockYml().dependencies) {
                                if (Bukkit.getPluginManager().getPlugin(s) == null){
                                    LoggerUtils.log("&c" + file.getName() + " has a dependency not satisfied! (" + s + ")");
                                    return;
                                }
                                if (!Bukkit.getPluginManager().getPlugin(s).isEnabled()){
                                    LoggerUtils.log("&c" + file.getName() + " has a dependency not satisfied! (" + s + ")");
                                    return;
                                }
                            }
                        }
                    }
                    if (!ebr.hasBlockYml().api_version.equalsIgnoreCase("0.1-1")){
                        LoggerUtils.log("&c" + file.getName() + " has a version mismatch! (Extension Version: " + ebr.hasBlockYml().api_version + ", Our Version: 0.1-1)");
                        continue;
                    }
                    Class<?> main = Class.forName(ebr.hasBlockYml().mainclass);
                    if (!main.isAssignableFrom(ExtensionBlock.class)) {
                        LoggerUtils.log("&c" + file.getName() + " is an invalid extension! (Main class doesn't extend ExtensionBlock class!)");
                        continue;
                    }
                    ExtensionBlock eb = (ExtensionBlock) main.cast(ExtensionBlock.class);
                    eb.load();
                    getBlocks.put(ebr.hasBlockYml().name, eb);
                    LoggerUtils.log("&aLoaded extension: " + ebr.hasBlockYml().name + " v" + ebr.hasBlockYml().version);
                } catch (ClassNotFoundException e) {
                    LoggerUtils.log("&c" + file.getName() + " is an invalid extension! (Main class not found!)");
                } catch (Exception e) {
                    LoggerUtils.log("&c" + file.getName() + " has a code error in it! (The Extension)");
                }
            } else {
                LoggerUtils.log("&c" + file.getName() + " is an invalid extension! (No block.yml)");
            }
        }
    }
}
