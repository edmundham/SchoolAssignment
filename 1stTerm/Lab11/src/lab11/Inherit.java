package lab11;

public class Inherit {
    
    class Figure {
        void display() {
            System.out.println("Figure");
        }
    }
    
    class Rectangle extends Figure {
        void display() {
            System.out.println("Rectangle");
        }
        void display(String s) {
            System.out.println(s);
        }
    }
    
    class Box extends Figure {
        void display() {
            System.out.println("Box");
        }
        void display(String s) {
            System.out.println("This is printed: " + s);
        }
    }
    
    Inherit() {
        Figure f = new Figure();
        Rectangle r = new Rectangle();
        Box b = new Box();
        f.display();
        f = r;
        f.display();
        f = b;
        f.display();
    }
    
    public static void main(String[] args) {
        new Inherit();
    }

}
