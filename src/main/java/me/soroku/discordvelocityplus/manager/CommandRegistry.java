package me.soroku.discordvelocityplus.manager;

import com.velocitypowered.api.command.CommandManager;
import com.velocitypowered.api.command.CommandMeta;
import com.velocitypowered.api.proxy.ProxyServer;
import me.soroku.discordvelocityplus.commands.interfaces.ICommand;

public class CommandRegistry {
    public static void register(ProxyServer server, ICommand object){
        CommandManager commandManager = server.getCommandManager();
        CommandMeta commandMeta = commandManager.metaBuilder(object.getComamnd())
                .aliases(object.getAliases())
                .plugin(server)
                .build();

        // Finally, you can register the command
        commandManager.register(commandMeta, object);
    }
}
