package general;


import listeners.CommandListener;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;

import javax.security.auth.login.LoginException;

public class mai{


    public static void main(String args[]) throws LoginException, InterruptedException {
        JDA mai = JDABuilder.createLight(System.getenv("TOKEN"))
                .addEventListeners(new CommandListener())

                .setActivity(Activity.competing("with Dyno"))
                .build();
        mai.awaitReady();
        mai.upsertCommand("ping", "get mai's current response time").queue();
        mai.upsertCommand("greet", "greets mai").queue();
    }


}
