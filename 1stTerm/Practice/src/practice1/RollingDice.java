package practice1;

public class RollingDice {
    public static void main(String[] args) {
        Die die1, die2;
        int sum;
        
        die1 = new Die(); 
        die2 = new Die();
        // 밑에 두개를 코멘트표시하면 die1과 die2는 faceValue인 숫자를 print함
        die1.roll(); // 1-6
        die2.roll(); // 1-6
        System.out.println("Die One: " + die1 + ", Die Two: " + die2);
        
        die1.roll(); // 1-6
        die2.setFaceValue(4); //faceValue가 4가 됨
        
        System.out.println("Die One: " + die1 + ", Die Two: " + die2);
        
        sum = die1.getFaceValue() + die2.getFaceValue();//바로전 faceValue가짐
        System.out.println("Sum: " + sum);
        
        sum = die1.roll() + die2.roll();
        System.out.println("Die One: " + die1 + ", Die Two: " + die2);
        System.out.println("New sum: " + sum);
    }
}
