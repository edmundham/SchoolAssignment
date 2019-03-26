package chapter41;

public class PhoneCheck {
    
    public static void main(String[] args) {
        
        Phone myPhone = new Phone();
        
        myPhone.setInfo();
        
        myPhone.obsolete();
        
        System.out.println(myPhone);
    }
}
