package lab4;

public class CandySales {
    
    public static void main(String[] args) {
        
    BandBooster band1 = new BandBooster("Joe");
    BandBooster band2 = new BandBooster("HaHa");
    
    System.out.println("First Week: ");
    
    band1.updateSales();
    band2.updateSales();
    
    System.out.println();
    System.out.println("Second Week: ");
    
    band1.updateSales();
    band2.updateSales();
    
    System.out.println();
    System.out.println("Thrid Week: ");
    
    band1.updateSales();
    band2.updateSales();
    
    System.out.println();
    System.out.println();
    System.out.println(band1);
    System.out.println(band2);
    
    
    }
}
