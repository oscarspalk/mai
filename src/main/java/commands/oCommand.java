package commands;

import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

import java.io.IOException;
import java.util.List;

public abstract class oCommand {
    public abstract String getCommandName();
    public abstract String getCommandDescription();
    public abstract void execute(GuildMessageReceivedEvent event, List<String> args) throws IOException;
}
