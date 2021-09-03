package commands;

import imagegeneration.ImageGeneration;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

public class stringImageCommand extends oCommand{
    @Override
    public String getCommandName() {
        return "string";
    }

    @Override
    public String getCommandDescription() {
        return "draws a string on an image";
    }

    @Override
    public void execute(GuildMessageReceivedEvent event, List<String> args)  {
        if(args.size() > 2){
            try{
                int dimensX = Integer.parseInt(args.get(1));
                int dimensY = Integer.parseInt(args.get(2));
                ImageGeneration img = new ImageGeneration(dimensX, dimensY);
                Color color = new Color(255,255,255);
                img.drawString(args.get(0), 20, 30,color);
                byte[] image = img.buildImage("jpg");
                event.getChannel().sendFile(image, "image.jpg").queue();
                return;
            }
            catch (Exception e){
                event.getChannel().sendMessage("Send venligst de ordentlige parametre").queue();
                return;
            }
        }
        event.getChannel().sendMessage("Send venligst en streng, x og y som parameter").queue();
        return;
    }
}
