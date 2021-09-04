package general;



import java.util.EnumSet;

import listeners.CommandListener;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.interactions.commands.build.CommandData;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.requests.restaction.CommandListUpdateAction;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.security.auth.login.LoginException;

public class mai{

    private static final Logger LOGGER = LoggerFactory.getLogger(mai.class);

    public static void main(String args[]) throws LoginException, InterruptedException {
        JDA mai = JDABuilder.createLight("ODc0MzYzNTE4NjM0MzAzNjA4.YRF4ew.UFO5ieOC5RvKt9OYTBe4Fs2zOdw")
                .addEventListeners(new CommandListener())

                .setActivity(Activity.competing("with Dyno"))
                .build();
        mai.awaitReady();
        mai.upsertCommand("ping", "get mai's current response time").queue();
        mai.upsertCommand("greet", "greets mai").queue();
    }


}
