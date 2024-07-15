# DiscordVelocityPlus Plugin

DiscordVelocityPlus is a Minecraft plugin designed to integrate multiple Discord bots with your server. The project is currently under development with plans to inspect and add more features.

## Features

- Create and manage multiple Discord bots.
- Extendable through addons to enhance bot functionality.

## Installation

1. Download the DiscordVelocityPlus plugin jar file.
2. Place the jar file in the `plugins` directory of your Minecraft server.
3. Start your server to generate the default configuration files for DiscordVelocityPlus.
4. Configure the plugin using the generated configuration files.

## Configuration

Below is an example configuration for DiscordVelocityPlus:

```yaml
enabled: true # Set to true to enable the feature

bots:
  - name: "logBot"
    token: "your_discord_bot_token_1"
    guild_id: "your_discord_guild_id_1"
  
  - name: "ricky"
    token: "your_discord_bot_token_2"
    guild_id: "your_discord_guild_id_2"
```

Edit this configuration file to match your setup with your Discord bot tokens and guild IDs.

## Addons

DiscordVelocityPlus supports addons that can interact with the Discord bots. These addons can extend the functionality of the bots and provide various features.

### [LuckPermsLogger]((https://github.com/OfficialRikiDev/LuckPermsLogger)  )

One of the addons for DiscordVelocityPlus is `luckpermslogger`. This addon logs LuckPerms events and sends these logs to a specified Discord channel using a bot managed by DiscordVelocityPlus.

#### Features of LuckPermsLogger

- Sends LuckPerms logs to a Discord channel.
- Configurable via in-game commands.
- Toggle logging on or off as needed.

#### Commands

- `/lpl reload`  
  Reloads the plugin configuration.

- `/lpl set channel <channelId>`  
  Sets the Discord channel ID where logs will be sent.

- `/lpl set bot <botName>`  
  Sets the name of the Discord bot used for logging.

- `/lpl set toggle`  
  Toggles whether the bot will send logs to Discord or not.

## Development Status

The plugin is currently under development. We are actively inspecting more features to add and enhance functionality. As of now, there are no commands available for DiscordVelocityPlus itself, but more features will be added soon.

## Contributing

Contributions are welcome! Please fork the repository and submit pull requests.

```

If you need any more details or modifications, feel free to ask!
