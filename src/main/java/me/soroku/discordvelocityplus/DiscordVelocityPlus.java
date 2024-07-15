package me.soroku.discordvelocityplus;

import com.google.inject.Inject;
import com.velocitypowered.api.event.proxy.ProxyInitializeEvent;
import com.velocitypowered.api.event.Subscribe;
import com.velocitypowered.api.plugin.Plugin;
import com.velocitypowered.api.plugin.annotation.DataDirectory;
import com.velocitypowered.api.proxy.ProxyServer;
import me.soroku.discordvelocityplus.commands.LinkCommand;
import me.soroku.discordvelocityplus.commands.MainCommand;
import me.soroku.discordvelocityplus.config.FileConfiguration;
import me.soroku.discordvelocityplus.manager.CommandRegistry;
import me.soroku.discordvelocityplus.impl.DiscordManagerImp;
import me.soroku.discordvelocityplus.manager.ResourceManager;
import net.soroku.dcvp.api.DiscordAPI;
import net.soroku.dcvp.api.discord.BotInstance;
import net.soroku.dcvp.api.interfaces.IMain;
import org.slf4j.Logger;

import java.io.File;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;

@Plugin(
        id = "dcvelocityplus",
        name = "DiscordVelocityPlus",
        version = "1.0-SNAPSHOT",
        authors = {"so_roku"}
)

public class DiscordVelocityPlus implements IMain {
    private final ProxyServer server;
    private final Logger logger;
    private final File dataDirectory;
    private final File file;
    private ResourceManager resourceManager;
    private FileConfiguration config;
    private DiscordManagerImp dcManager;

    @Inject
    public DiscordVelocityPlus(ProxyServer server, Logger logger,@DataDirectory Path dataDirectory){
        this.server = server;
        this.logger = logger;
        this.dataDirectory = new File(dataDirectory.toFile().getParentFile(), this.getClass().getAnnotation(Plugin.class).name());

        try {
            this.file = new File(getClass().getProtectionDomain().getCodeSource().getLocation().toURI());
        }catch (final URISyntaxException ex){
            throw new RuntimeException(ex);


        }

        this.resourceManager = new ResourceManager(this.dataDirectory);
        this.config = resourceManager.loadConfig("config.yml");
        this.dcManager = new DiscordManagerImp(this);
        DiscordAPI.initialize(this.dcManager);
        logger.info("Successfully enabled.");
    }

    @Subscribe
    public void onProxyInitialization(ProxyInitializeEvent event) {
        CommandRegistry.register(server, new MainCommand(this));
        CommandRegistry.register(server, new LinkCommand(this, server));
    }

    public FileConfiguration getConfig() {
        return config;
    }

    @Override
    public Map<String, BotInstance> getBots() {
        return dcManager.getBots();
    }

    @Override
    public BotInstance getBot(String name) {
        return dcManager.getBotByName(name);
    }

    @Override
    public List<?> getBotList(String name){
        return getConfig().getList(name);
    }
}