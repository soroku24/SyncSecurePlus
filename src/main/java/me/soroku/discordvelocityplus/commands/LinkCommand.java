package me.soroku.discordvelocityplus.commands;


import com.velocitypowered.api.command.CommandSource;
import com.velocitypowered.api.proxy.Player;
import com.velocitypowered.api.proxy.ProxyServer;
import me.soroku.discordvelocityplus.DiscordVelocityPlus;
import me.soroku.discordvelocityplus.commands.interfaces.ICommand;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public final class LinkCommand implements ICommand {
    private final String command = "link";
    private final String[] aliases = {""};
    private DiscordVelocityPlus plugin;
    private ProxyServer server;

    public LinkCommand(DiscordVelocityPlus plugin, ProxyServer server) {
        this.server = server;
        this.plugin = plugin;
    }

    @Override
    public void execute(final Invocation invocation) {
        CommandSource source = invocation.source();

        String[] args = invocation.arguments();

        source.sendMessage(Component.text("Link", NamedTextColor.AQUA));
    }

    @Override
    public boolean hasPermission(final Invocation invocation) {
        return invocation.source().hasPermission("command.test");
    }



    @Override
    public CompletableFuture<List<String>> suggestAsync(final Invocation invocation) {
        String[] args = invocation.arguments();

        if(args.length == 0){
            List<String> players = new ArrayList<>();

            server.getAllPlayers().forEach(player ->{
                players.add(player.getUsername());
            });

            return CompletableFuture.completedFuture(players);
        }
        return CompletableFuture.completedFuture(List.of());
    }

    @Override
    public String getComamnd() {
        return this.command;
    }

    @Override
    public String[] getAliases() {
        return this.aliases;
    }

    @Override
    public DiscordVelocityPlus getPlugin() {
        return plugin;
    }
}