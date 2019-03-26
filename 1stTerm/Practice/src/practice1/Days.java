package practice1;

    public class Days {
        
        enum DaysWeek {Mon, Tue, Wed, Thu, Fri, Sat, Sun };
        
        public static void main(String[] args) {
            
            DaysWeek D1, D2, D3, D4, D5, D6, D7;
            
            D1 = DaysWeek.Mon;
            D2 = DaysWeek.Tue;
            D3 = DaysWeek.Wed;
            D4 = DaysWeek.Thu;
            D5 = DaysWeek.Fri;
            D6 = DaysWeek.Sat;
            D7 = DaysWeek.Sun;
            
            System.out.println(D1);
            System.out.println(D2.name());
            System.out.println(D3.ordinal());
            System.out.println(D4);
            System.out.println(D5.name());
            System.out.println(D6.ordinal());
            System.out.println(D7);
        }
}
