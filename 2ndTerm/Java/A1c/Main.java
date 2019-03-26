package ca.bcit.comp2526.a1c;

/**
 * Main.java
 * Main class that contains main method.
 * 
 * @author Sunguk (Edmund) Ham, A00979841
 * @version 1.0
 */
public final class Main {
    /**
     * The size lower bound.
     */
    private static final int MIN_VALUE = 1;

    /**
     * The size upper bound.
     */
    private static final int MAX_VALUE = 30;

    /**
     * Disallows the creation of any Main objects.
     */
    private Main() {
    }

    /**
     * The entry point to the program.
     *
     * @param argv
     *            the command line args. argv[0] - the type (+, - or *) argv[1]
     *            - the start value (> 1 && < 100) argv[2] - the end value (> 1
     *            && < 100)
     */
    public static void main(final String[] argv) {
        final int expectedArgs = 3;
        final int typeArg = 0;
        final int startArg = 1;
        final int stopArg = 2;
        final ShapeType type;
        final Shape shape;
        final int width;
        final int height;

        if (argv.length != expectedArgs) {
            usage();
        }

        type = getType(argv[typeArg]);
        width = getNumber(argv[startArg]);
        height = getNumber(argv[stopArg]);

        // YOU CODE GOES HERE
        // GET THE SHAPE AND DRAW IT
        shape = getShape(type, width, height);
        shape.draw();

    }

    /**
     * Converts the supplied string into the appropriate TableType. If the
     * string is not a valid type then exits the program.
     *
     * @param string
     *            the stringto convert
     * @return the appropriate TableType
     */
    public static ShapeType getType(final String string) {
        final ShapeType type;

        if (string.equals("t")) {
            type = ShapeType.TRIANGLE;
        } else if (string.equals("d")) {
            type = ShapeType.DIAMOND;
        } else if (string.equals("r")) {
            type = ShapeType.RECTANGLE;
        } else {
            usage();
            type = null;
        }

        return (type);
    }

    /**
     * Converts the supplied string to an int. If the string is not a valid int
     * then exits the program. To be valid the string must be an integer and >
     * MIN_VALUE and < MAX_VALUE.
     *
     * @param string
     *            the string to convert
     * @return the converted number
     */
    public static int getNumber(final String string) {
        int val;

        try {
            val = Integer.parseInt(string);

            if (val < MIN_VALUE || val > MAX_VALUE) {
                usage();
            }
        } catch (final NumberFormatException ex) {
            usage();
            val = 0;
        }

        return (val);
    }

    /**
     * Create the appropriate Shape.
     *
     * @param type
     *            the type of Shape to create
     * @param width
     *            the width of the Shape
     * @param height
     *            the height of the Shape
     * @return the newly created Shape
     */
    public static Shape getShape(final ShapeType type, 
                                 final int width, 
                                 final int height) {
        final Shape shape;
        try {
            
            switch (type) {
            case TRIANGLE:
                shape = new Triangle(width, height);
                break;
            case DIAMOND:
                shape = new Diamond(width, height);
                break;
            case RECTANGLE:
                shape = new Rectangle(width, height);
                break;
            default:
                shape = null;
            }
        } catch (BadWidthException b) {
            usage();
            return null;
        }
        return (shape);
    }

    /**
     * Displays the usage message and exit the program.
     */
    public static void usage() {
        System.err.println("Usage: Main <type> <width> <height>");
        System.err.println("\tWhere <type> is one of r, t, d");
        System.err.printf("\tand <width> is between %d and %d\n", 
                MIN_VALUE, MAX_VALUE);
        System.err.printf("\tand <height> is between %d and %d\n", 
                MIN_VALUE, MAX_VALUE);
        System.err.printf("\t Width must be odd for Triangle and "
                + "Diamond shapes");
        System.exit(1);
    }
}
