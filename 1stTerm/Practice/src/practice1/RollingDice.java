package practice1;

public class RollingDice {
    public static void main(String[] args) {
        Die die1, die2;
        int sum;
        
        die1 = new Die(); 
        die2 = new Die();
        // �ؿ� �ΰ��� �ڸ�Ʈǥ���ϸ� die1�� die2�� faceValue�� ���ڸ� print��
        die1.roll(); // 1-6
        die2.roll(); // 1-6
        System.out.println("Die One: " + die1 + ", Die Two: " + die2);
        
        die1.roll(); // 1-6
        die2.setFaceValue(4); //faceValue�� 4�� ��
        
        System.out.println("Die One: " + die1 + ", Die Two: " + die2);
        
        sum = die1.getFaceValue() + die2.getFaceValue();//�ٷ��� faceValue����
        System.out.println("Sum: " + sum);
        
        sum = die1.roll() + die2.roll();
        System.out.println("Die One: " + die1 + ", Die Two: " + die2);
        System.out.println("New sum: " + sum);
    }
}
