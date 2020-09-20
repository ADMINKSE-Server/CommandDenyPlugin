package net.adminkse.plugins.commandDenyPlugin

import net.adminkse.plugins.commandDenyPlugin.listeners.PlayerCommandPreprocessListener
import org.bukkit.Bukkit
import org.bukkit.plugin.java.JavaPlugin

class CommandDenyPlugin: JavaPlugin() {
    override fun onEnable() {
        super.onEnable()

        Bukkit.getPluginManager().registerEvents(PlayerCommandPreprocessListener(this), this)

        if(this.config.saveToString()=="") this.saveDefaultConfig()
    }
}