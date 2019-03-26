package lab3;

    enum Rank1 { jack, ace, two, three, four, five, six, seven, eight, nine, 
                ten, queen, king }

    public class Rank {
        public static void main(String[] args) {
            
            Rank1 highCard, faceCard, card1, card2;
            
            highCard = Rank1.ace;
            faceCard = Rank1.jack;
            card1 = Rank1.five;
            card2 = Rank1.nine;
            
            System.out.println("A blackjack hand: " + highCard + " and " +
                               faceCard);
            int card1Val, card2Val;
            
            card1Val = card1.ordinal();
            card2Val = card2.ordinal();
            
            System.out.println("A two card hand: " + card1 + " " + card2);
            System.out.println("Hand value: " + (card1Val + card2Val));
            
        }
}
