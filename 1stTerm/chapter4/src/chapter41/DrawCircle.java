package chapter41;

    import java.awt.*;
    import javax.swing.*;
    import java.util.Random;

public class DrawCircle {
    
    Random generator = new Random();
    //16777215
    private int x;
    private int y;
    private int width;
    private int height;
    private int colorinteger;
    private String colorbinary;
    private int colorcode;
    
    public DrawCircle() {
        x = generator.nextInt(501);
        y = generator.nextInt(501);
        width = generator.nextInt(100) + 100;
        height = generator.nextInt(100) + 100;
        colorinteger = generator.nextInt(16777216);
        
    }
        
    public void draw(Graphics g) {
        Color rgbColor = new Color(colorinteger); //0 - 2^24
        g.setColor(rgbColor);
        g.fillRect(x, y, width, height);
    }
}
