package practice1;

public class Founda {
    public static void main(String[] args) {
        String s1 = "Foundations";
        String s2;
        System.out.println(s1.charAt(1));
        s2 = s1.substring(0, 5);
        System.out.println(s2);
        System.out.println(s1.length());
        System.out.println(s2.length());
        String title = s1.toUpperCase();
        System.out.println(title);
        String description = "This is java program.";
        String front = description.substring(0, 10);
        System.out.println(front);
    }
}
