package commands;

import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

import java.io.IOException;
import java.util.List;

public class curveCommand extends oCommand{
    @Override
    public String getCommandName() {
        return "curve";
    }

    @Override
    public String getCommandDescription() {
        return "returns an image with ";
    }

    @Override
    public void execute(GuildMessageReceivedEvent event, List<String> args) throws IOException {

    }
}
