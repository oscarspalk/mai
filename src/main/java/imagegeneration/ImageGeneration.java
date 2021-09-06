package imagegeneration;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class ImageGeneration {
    private BufferedImage generatedImage;
    private Graphics2D g2d;
    private Font font;
    private Rectangle drawingRect;
    public ImageGeneration(int width, int height){
        this.generatedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        this.g2d =  generatedImage.createGraphics();
        Color color = new Color(255, 0,0);
        g2d.setPaint(color);
        g2d.setColor(color);

        setupRect(width,height);

    }

    public void setPixel(int x, int y, Color color){
        generatedImage.setRGB(x, y, color.getRGB());
    }

    public ImageGeneration(int width, int height, Font font){
        this.generatedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        this.g2d = generatedImage.createGraphics();
        this.font = font;
        setupRect(width,height);
    }

    private void setupRect(int width, int height){
        drawingRect = new Rectangle();
        drawingRect.setSize(width, height);
    }

    public void drawImage(BufferedImage image){
        g2d.drawImage(image, 0,0, null);
        g2d.dispose();
    }


    public void drawFilledRect(int x, int y, int X, int Y, Color color){
        g2d.setColor(color);
        g2d.fillRect(x,y,X,Y);
    }

    public void drawString(String text, int x, int y, Color color){
        g2d.setColor(color);
        g2d.drawString(text, x, y);
    }

    public void drawCenteredString(String text){

        FontRenderContext frc =
                new FontRenderContext(null, true, true);
        Rectangle2D r2D = font.getStringBounds(text, frc);
        int rWidth = (int) Math.round(r2D.getWidth());
        int rHeight = (int) Math.round(r2D.getHeight());
        int rX = (int) Math.round(r2D.getX());
        int rY = (int) Math.round(r2D.getY());

        int a = (drawingRect.width / 2) - (rWidth / 2) - rX;
        int b = (drawingRect.height / 2) - (rHeight / 2) - rY;

        g2d.drawString(text, drawingRect.x + a, drawingRect.y + b);
    }

    public byte[] buildImage(String format)  {
        if(format == "jpg" || format == "png"){
            try {
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                ImageIO.write(generatedImage, "png", baos);
                byte[] bytes = baos.toByteArray();
                return bytes;
            }
            catch (IOException ioException){
                System.out.println(ioException);
            }

        }
        return new byte[0];
    }

}
