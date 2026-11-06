import java.util.ArrayList;
 
public class Driver1 {
 
    public static void main(String[] args) {
 
        ArrayList<Card> cards = new ArrayList<>();
 
        Card[] deck = {
            new Card("Ace", "Spades"),
            new Card("King", "Hearts"),
            new Card("Queen", "Diamonds"),
            new Card("Ace", "Spades"),
            new Card("Jack", "Clubs")
        };
 
        for (Card card : deck) {
 
            if (cards.contains(card)) {
                System.out.println("Duplicate found: " + card);
            } else {
                cards.add(card);
            }
        }
    }
}
