package lab8;

public class Compare3 implements Comparable{
    
    private static Comparable val;

    public static Comparable largest(Comparable val1, Comparable val2,
            Comparable val3) {

        if (val1.compareTo(val2) > 0 && val1.compareTo(val3) > 0) {
            return val1;
        }   else if (val2.compareTo(val1) > 0 && val2.compareTo(val3) > 0) {
            return val2;
        }   else if (val3.compareTo(val2) > 0 && val3.compareTo(val1) > 0) {
            return val3;
        }   else {
            return val;
        }
        
    }


    @Override
    public int compareTo(Object arg0) {
        // TODO Auto-generated method stub
        return 0;
    }


}
