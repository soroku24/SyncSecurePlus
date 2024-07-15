package me.soroku.discordvelocityplus.commands;


import com.velocitypowered.api.command.CommandSource;

import java.util.concurrent.CompletableFuture;
import java.util.List;

import me.soroku.discordvelocityplus.DiscordVelocityPlus;
import me.soroku.discordvelocityplus.commands.interfaces.ICommand;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;

public final class MainCommand implements ICommand {
    private final String command = "dcv";
    private final String[] aliases = {""};
    private DiscordVelocityPlus plugin;

    public MainCommand(DiscordVelocityPlus plugin) {
        this.plugin = plugin;
    }

    @Override
    public void execute(final Invocation invocation) {
        CommandSource source = invocation.source();

        String[] args = invocation.arguments();

        source.sendMessage(Component.text("Hello World!", NamedTextColor.AQUA));
    }

    @Override
    public boolean hasPermission(final Invocation invocation) {
        return invocation.source().hasPermission("command.test");
    }

    @Override
    public CompletableFuture<List<String>> suggestAsync(final Invocation invocation) {
        String[] args = invocation.arguments();
        if(args.length > 1)
            return CompletableFuture.completedFuture(List.of("test", "test2"));
        return CompletableFuture.completedFuture(List.of("set", "disable"));
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