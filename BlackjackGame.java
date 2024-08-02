import java.util.Scanner;

public class BlackjackGame {
    private Deck deck;
    private Hand dealerHand;
    private Hand playerHand;

    public BlackjackGame() {
        deck = new Deck();
        deck.shuffle();
        dealerHand = new Hand();
        playerHand = new Hand();
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);

        // Initial deal
        playerHand.addCard(deck.drawCard());
        dealerHand.addCard(deck.drawCard());
        playerHand.addCard(deck.drawCard());
        dealerHand.addCard(deck.drawCard());

        System.out.println("Dealer's Hand: " + dealerHand.getFirstCard() + " and [hidden]");
        System.out.println("Your Hand: " + playerHand);

        // Player's turn
        boolean playerBusted = false;
        while (true) {
            System.out.print("Hit or Stand? (enter H or S): ");
            String action = scanner.nextLine().trim().toUpperCase();
            if (action.equals("H")) {
                playerHand.addCard(deck.drawCard());
                System.out.println("Your Hand: " + playerHand);
                if (playerHand.calculateTotal() > 21) {
                    System.out.println("You busted!");
                    playerBusted = true;
                    break;
                }
            } else {
                break;
            }
        }

        // Dealer's turn
        if (!playerBusted) {
            while (dealerHand.calculateTotal() < 17) {
                dealerHand.addCard(deck.drawCard());
                System.out.println("Dealer's Hand: " + dealerHand);
            }

            if (dealerHand.calculateTotal() > 21) {
                System.out.println("Dealer busted!");
            } else if (dealerHand.calculateTotal() >= playerHand.calculateTotal()) {
                System.out.println("Dealer wins!");
            } else {
                System.out.println("Player wins!");
            }
        } else {
            System.out.println("Dealer wins!");
        }

        scanner.close();
    }

    public static void main(String[] args) {
        BlackjackGame game = new BlackjackGame();
        game.start();
    }
}

