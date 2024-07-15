package me.soroku.discordvelocityplus.commands.interfaces;

import com.velocitypowered.api.command.SimpleCommand;
import me.soroku.discordvelocityplus.DiscordVelocityPlus;


public interface ICommand extends SimpleCommand {

    String getComamnd();
    String[] getAliases();

    default DiscordVelocityPlus getPlugin(){
        return null;
    };
}
