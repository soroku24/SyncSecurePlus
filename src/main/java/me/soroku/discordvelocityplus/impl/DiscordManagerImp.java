package me.soroku.discordvelocityplus.impl;

import me.soroku.discordvelocityplus.DiscordVelocityPlus;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.soroku.dcvp.api.discord.BotInstance;
import net.soroku.dcvp.api.interfaces.DiscordManager;

import java.util.*;

public class DiscordManagerImp implements DiscordManager {

    private Map<String, BotInstance> botsInitiated;
    private DiscordVelocityPlus plugin;

    public DiscordManagerImp(DiscordVelocityPlus plugin){
        this.plugin = plugin;
        this.botsInitiated = new HashMap<>();
        initializeBots();
    }

    @Override
    public BotInstance getBotByName(String botName){
        return botsInitiated.get(botName);
    }

    @Override
    public Map<String, BotInstance> getBots(){
        return botsInitiated;
    }

    private void initializeBots(){
        List<?> bots = new ArrayList<>(plugin.getBotList("bots"));
        if(bots != null){
            for(Object item : bots){
                LinkedHashMap<?, ?> botDetails = (LinkedHashMap<?, ?>) item;
                String name = (String) botDetails.get("name");
                String token = (String) botDetails.get("token");
                String guildId = (String) botDetails.get("guild_id");

                try {
                    JDA jda = JDABuilder.createLight(token, Collections.emptyList())
                            .build().awaitReady();
                    botsInitiated.put(name, new BotInstance(jda, guildId));
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
