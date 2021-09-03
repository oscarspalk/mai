package listeners;

import commands.flagImageCommand;
import commands.helloCommand;
import commands.oCommand;
import commands.stringImageCommand;
import net.dv8tion.jda.api.events.ReadyEvent;
import net.dv8tion.jda.api.events.interaction.SlashCommandEvent;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.build.CommandData;
import net.dv8tion.jda.api.requests.restaction.CommandListUpdateAction;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.impl.SimpleLoggerFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;


public class CommandListener extends ListenerAdapter {



    private List<oCommand> commands = new ArrayList<>();
    @Override
    public void onReady(@NotNull ReadyEvent event) {
        System.out.println("Ready");
        addCommand(new helloCommand());
        addCommand(new stringImageCommand());
        addCommand(new flagImageCommand());
        /*

         Slash Commands

         */

    }

    public void addCommand(oCommand cmd){
        commands.add(cmd);
    }

    public oCommand getCommand(String name){
        for (int i = 0; i < commands.size(); i++){
            if(commands.get(i).getCommandName().equals(name)){

                return commands.get(i);
            }
        }
        return null;
    }

    @Override
    public void onGuildMessageReceived(@NotNull GuildMessageReceivedEvent event) {
        if(event.getAuthor().isBot()){
            return;
        }

        String[] args = event.getMessage().getContentRaw().split("\\s+");
        System.out.println(args[0]);
        oCommand cmd = getCommand(args[0].toLowerCase());
            if(cmd != null){
                List<String> argsList = new ArrayList<>(Arrays.asList(args));
                argsList.remove(0);
                try {
                    cmd.execute(event, argsList);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

    }

    @Override
    public void onSlashCommand(@NotNull SlashCommandEvent event) {
        Long millis = System.currentTimeMillis();
        String command = event.getName().toLowerCase();
        System.out.println(command);
        switch (command){
            case "greet":
                event.reply("hei").setEphemeral(true).queue();
                break;
            case "ping":
                event.reply(millis - System.currentTimeMillis() + " ms").queue();
                break;
            default:
                return;
        }

    }
}
