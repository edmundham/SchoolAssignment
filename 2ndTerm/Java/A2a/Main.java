package ca.bcit.comp2526.a2a;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import javax.swing.JFrame;

/**
 * Main.java
 * Main class that has main method runs the program.
 * 
 * @author Sunguk (Edmund) Ham, A00979841
 * @version 1.0
 */
public final class Main {
    
    private static final Toolkit TOOLKIT;
    private static final int WORLD_SIZE = 25;
    private static final float PERCENTAGE_SIZE_SCREEN = 0.80f;
    private static final float MAX_PERCENTAGE_SIZE = 100.0f;

    static {
        TOOLKIT = Toolkit.getDefaultToolkit();
    }

    /**
     * Empty given constructor by instructor.
     */
    private Main() {
    }

    /**
     * runs the program.
     * 
     * @param argv unused.
     */
    public static void main(final String[] argv) {
        final GameFrame frame;
        final World world;

        RandomGenerator.reset();
        world = new World(WORLD_SIZE, WORLD_SIZE);
        world.init();
        frame = new GameFrame(world);
        position(frame);
        frame.init();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    private static void position(final GameFrame frame) {
        final Dimension size;

        size = calculateScreenArea(PERCENTAGE_SIZE_SCREEN,
                PERCENTAGE_SIZE_SCREEN);
        frame.setSize(size);
        frame.setLocation(centreOnScreen(size));
    }

    /**
     * returns x and y coordinates of centre of the screen.
     * 
     * @param size of the screen
     * @return Point object of centre of the screen
     */
    public static Point centreOnScreen(final Dimension size) {
        final Dimension screenSize;

        if (size == null) {
            throw new IllegalArgumentException("Size cannot be null");
        }

        screenSize = TOOLKIT.getScreenSize();

        Point centrePoint = new Point((screenSize.width - size.width) / 2,
                (screenSize.height - size.height) / 2);
        return centrePoint;
    }

    /**
     * calculates screen area based on the width and height percentages.
     * 
     * @param widthPercent percentages of width for calculation
     * @param heightPercent percentages of height for calculation
     * @return Dimension of width and height size
     */
    public static Dimension calculateScreenArea(final float widthPercent, 
            final float heightPercent) {
        final Dimension screenSize;
        final Dimension area;
        final int width;
        final int height;
        final int size;

        if ((widthPercent <= 0.0f) || (widthPercent > MAX_PERCENTAGE_SIZE)) {
            throw new IllegalArgumentException("widthPercent cannot be "
                    + "<= 0 or > 100 - got: " + widthPercent);
        }

        if ((heightPercent <= 0.0f) || (heightPercent > MAX_PERCENTAGE_SIZE)) {
            throw new IllegalArgumentException("heightPercent cannot be "
                    + "<= 0 or > 100 - got: " + heightPercent);
        }

        screenSize = TOOLKIT.getScreenSize();
        width = (int) (screenSize.width * widthPercent);
        height = (int) (screenSize.height * heightPercent);
        size = Math.min(width, height);
        area = new Dimension(size, size);

        return (area);
    }
}
