package net.adminkse.plugins.commandDenyPlugin.listeners

import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerCommandPreprocessEvent
import org.bukkit.plugin.java.JavaPlugin

class PlayerCommandPreprocessListener(var plugin: JavaPlugin): Listener {
    @EventHandler
    public fun onPlayerCommandPreprocess(event:PlayerCommandPreprocessEvent) {
        if(event.message.split(" ")[0] in plugin.config.getStringList("deniedCommands")) {
            println(event.player.hasPermission("deniedcommands"))
            if(!event.player.hasPermission("deniedcommands")) {
                event.isCancelled = true
                event.player.sendMessage("Unknown command. Type \"/help\" for help.")
            }
        }
    }
}
