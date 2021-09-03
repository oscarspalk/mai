package commands;

import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

import java.util.List;

public class helloCommand extends oCommand {


    @Override
    public String getCommandName() {
        return "hej";
    }

    @Override
    public String getCommandDescription() {
        return "says hello";
    }

    @Override
    public void execute(GuildMessageReceivedEvent event, List<String> args) {
        event.getChannel().sendMessage("hi " + event.getAuthor().getName()).queue();
    }
}
