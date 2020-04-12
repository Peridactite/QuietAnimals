package me.peridactite.quietanimals;

import org.bukkit.plugin.java.JavaPlugin;

public final class QuietAnimals extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        System.out.println("[QuietAnimals]: Enabled.");

        // Register our command "kit" (set an instance of your command class as executor)
        this.getCommand("hushAnimals").setExecutor(new CommandHushAnimals());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
