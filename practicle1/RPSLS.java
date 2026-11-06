import java.util.Random;
import java.util.Scanner;
 
public class RPSLS {
 
    enum Move {
        ROCK, PAPER, SCISSORS, LIZARD, SPOCK
    }
 
    static Move winner(Move player, Move computer) {
 
        if (player == computer) {
            return null;
        }
 
        return switch (player) {
            case ROCK -> (computer == Move.SCISSORS ||
                          computer == Move.LIZARD)
                          ? player : computer;
 
            case PAPER -> (computer == Move.ROCK ||
                           computer == Move.SPOCK)
                           ? player : computer;
 
            case SCISSORS -> (computer == Move.PAPER ||
                              computer == Move.LIZARD)
                              ? player : computer;
 
            case LIZARD -> (computer == Move.PAPER ||
                            computer == Move.SPOCK)
                            ? player : computer;
 
            case SPOCK -> (computer == Move.ROCK ||
                           computer == Move.SCISSORS)
                           ? player : computer;
        };
    }
 
    public static void main(String[] args) {
 
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
 
        int playerScore = 0;
        int computerScore = 0;
 
        Move[] moves = Move.values();
 
        for (int round = 1; round <= 5; round++) {
 
            System.out.println("\nRound " + round);
            System.out.println("Choose: ROCK, PAPER, SCISSORS, LIZARD, SPOCK");
 
            Move player = Move.valueOf(sc.next().toUpperCase());
            Move computer = moves[random.nextInt(moves.length)];
 
            System.out.println("You chose: " + player);
            System.out.println("Computer chose: " + computer);
 
            Move result = winner(player, computer);
 
            if (result == null) {
                System.out.println("It's a tie!");
            } else if (result == player) {
                System.out.println("You win this round!");
                playerScore++;
            } else {
                System.out.println("Computer wins this round!");
                computerScore++;
            }
 
            System.out.println("Score: " + playerScore +
                               " - " + computerScore);
        }
 
        System.out.println("\n--- Final Result ---");
 
        if (playerScore > computerScore) {
            System.out.println("You win " + playerScore +
                               " - " + computerScore);
        } else if (computerScore > playerScore) {
            System.out.println("Computer wins " + computerScore +
                               " - " + playerScore);
        } else {
            System.out.println("The game is a tie!");
        }
 
        sc.close();
    }
}
