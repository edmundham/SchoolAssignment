package lab6;

    import java.util.Scanner;
    import java.text.NumberFormat;

    /**
     * <p>This file contains a program that tallies the results of
     * an election. It reads in the number of votes for each of
     * two candidates in each of several precincts. It determines
     * the total number of votes received by each candidate, the
     * percent of votes received by each candidate, the number of
     * precincts each candidate carries, and the
     * maximum winning margin in a precinct.</p>
     * 
     * @author ham29
     *
     */
public class Election {

    public static void main(String[] args) {
        int votesForPolly;      //number of votes for polly in each precinct
        int votesForErnest;     //number of votes for Ernest in each precinct
        int totalPolly = 0;         //running total of votes for Polly
        int totalErnest = 0;        //running total of votes for Ernest
        double percentPolly;
        double percentErnest;
        int count = 0;
        int winPolly = 0;
        int winErnest = 0;
        int tiePrecint = 0;
        String response;        //answer (y or n) to the "more precincts" question
        
        Scanner scan = new Scanner(System.in);
        NumberFormat fmt = NumberFormat.getPercentInstance();
        
        System.out.println();
        System.out.println("Election Day Vote Counting Program");
        System.out.println();
        
        //Initialization
        votesForPolly = 0;
        votesForErnest = 0;
        response = "y";
        
        //Loop to "process" the votes in each precinct
        do {
            if (response.substring(0, 1).equalsIgnoreCase("y")) {
                count++;
                System.out.println("Precint number: " + count);
                
                System.out.print("Enter the vote for Polly: ");
                votesForPolly = scan.nextInt();
                System.out.print("Enter the vote for Ernest: ");
                votesForErnest = scan.nextInt();
            }
            
            if (votesForPolly > votesForErnest) {
                winPolly++;
            }   else if (votesForPolly < votesForErnest) {
                winErnest++;
            }   else {
                tiePrecint++;
            }
            
            totalPolly += votesForPolly;
            totalErnest += votesForErnest;
            percentPolly = (double) (totalPolly / (double) (totalPolly + totalErnest));
            percentErnest = (double) (totalErnest / (double) (totalPolly + totalErnest));
            
            System.out.println("Is there more precint?");
            response = scan.next();
            
        }   while (response.substring(0, 1).equalsIgnoreCase("y"));
        //Print out the results
        
        System.out.println("This is the result: ");
        System.out.println("Vote Polly earned: " + totalPolly);
        System.out.println("Vote Ernest earned: " + totalErnest);
        System.out.println("Polly: " + fmt.format(percentPolly));
        System.out.println("Ernest: " + fmt.format(percentErnest));
        System.out.println("Tied Precints: " + tiePrecint);
        System.out.println("Polly winning Precints: " + winPolly);
        System.out.println("Ernest winning Precints: " + winErnest);
        
    }
}
