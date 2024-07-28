# SyncSecure+ Plugin

SyncSecurePlus is a Minecraft plugin designed to integrate multiple Discord bots with your server. The project is currently under development with plans to inspect and add more features.

## Features

- Create and manage multiple Discord bots.
- Extendable through addons to enhance bot functionality.
- Player join/leave logger that sends notifications to Discord.
- Verification commands to link Minecraft accounts with Discord accounts.
- Information commands to display player details.
- Unlink command to remove account links.

## Installation

1. Download the SyncSecurePlus plugin jar file.
2. Place the jar file in the `plugins` directory of your Minecraft server.
3. Start your server to generate the default configuration files for SyncSecurePlus.
4. Configure the plugin using the generated configuration files.

## Configuration

Below is an example configuration for SyncSecurePlus:

```yaml
enabled: true # Set to true to enable the feature

database: "mysql"

discord:
  token: "123"
  server_id: "123"
  log_channel_id: "123"
  verified_role_id: "123"
  nonverified_role_id: "123"

mysql:
  DATABASE: "syncsecureplus"
  HOST: "localhost"
  PORT: 3306
  USERNAME: "root"
  PASSWORD: ""

bots:
  - name: "logBot"
    token: "your_discord_bot_token_1"
    guild_id: "your_discord_guild_id_1"
  
  - name: "ricky"
    token: "your_discord_bot_token_2"
    guild_id: "your_discord_guild_id_2"
```

Edit this configuration file to match your setup with your Discord bot tokens and guild IDs.

## Commands

### In-Game Commands (Permission : syncsecureplus.link)
- `/link <username>`: Links a Minecraft account with a Discord account.
- `/link cancel`: Cancels the verification process.

### Discord Commands
- `/info <player>`: Displays detailed information about a player.
- `/unlink`: Unlinks a Minecraft account from a Discord account.

## Addons

SyncSecurePlus supports addons that can interact with the Discord bots. These addons can extend the functionality of the bots and provide various features.

### [LuckPermsLogger](https://github.com/OfficialRikiDev/LuckPermsLogger) 

One of the addons for SyncSecurePlus is `luckpermslogger`. This addon logs LuckPerms events and sends these logs to a specified Discord channel using a bot managed by SyncSecurePlus.

#### Features of LuckPermsLogger

- Sends LuckPerms logs to a Discord channel.
- Configurable via in-game commands.
- Toggle logging on or off as needed.

## Development Status

The plugin is currently under development. We are actively inspecting more features to add and enhance functionality. As of now, there are no commands available for SyncSecurePlus itself, but more features will be added soon.

## Contributing

Contributions are welcome! Please fork the repository and submit pull requests.

## Powered by Yohhan Development

This plugin is powered by Yohhan Development. For inquiries and support, feel free to join our Discord. We also offer illustration and graphic design services. Just open a ticket! [https://discord.gg/A9jgs4SvkD](https://discord.gg/A9jgs4SvkD)

## License

Unauthorized copying, modification, distribution, in whole or in part, is strictly prohibited.

Any alteration, adaptation, or derivation of the plugin’s code is forbidden. Users must not reverse engineer or attempt to decompile the plugin in any form.

We reserve the right to modify these terms and conditions at any time. By continuing to use this plugin, you agree to comply with the most current version of these terms.

---

If you need any more details or modifications, feel free to ask!
