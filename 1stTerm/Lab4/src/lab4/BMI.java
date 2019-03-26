package lab4;

    import javax.swing.JFrame;

public class BMI {
    
    public static void main(String[] args) {
        
        JFrame frame = new JFrame("BMI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        BMIPanel panel = new BMIPanel();
        
        frame.getContentPane().add(panel);
        frame.pack();
        frame.setVisible(true);
    }
}
