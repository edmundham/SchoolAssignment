package lab4;

    import java.awt.*;
    import java.awt.event.*;
    import javax.swing.*;
    
public class BMIPanel extends JPanel{

    private int WIDTH = 300;
    private int HEIGHT = 120;
    
    private JLabel heightLabel, weightLabel, BMILabel, resultLabel;
    private JTextField height, weight;
    private JButton calculate;
    
    public BMIPanel() {
        
        heightLabel = new JLabel("Your height in inches: ");
        weightLabel = new JLabel("Your weight in pounds: ");
        
        BMILabel = new JLabel("This is your BMI: ");
        resultLabel = new JLabel();
        
        height = new JTextField(5);
        weight = new JTextField(5);
        
        calculate = new JButton("Click to calculate");
        calculate.addActionListener(new BMIListener());
        
        add(heightLabel);
        add(weightLabel);
        add(BMILabel);
        add(resultLabel);
        add(height);
        add(weight);
        add(calculate);
        
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setBackground(Color.cyan);
        
    }
    
    private class BMIListener implements ActionListener {
        
        public void actionPerformed(ActionEvent event) {
            
            String heightText, weightText;
            int heightVal, weightVal;
            double bmi;
            
            heightText = height.getText();
            weightText = weight.getText();
            
            heightVal = Integer.parseInt(heightText);
            weightVal = Integer.parseInt(weightText);
            
            bmi = 703 * weightVal / Math.pow(heightVal, 2);
            
            resultLabel.setText(Double.toString(bmi));
            
        }
    }
}