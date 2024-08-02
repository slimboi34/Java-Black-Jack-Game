import java.util.ArrayList;  // Import statement for ArrayList

public class Hand {
    private ArrayList<Card> cards;

    public Hand() {
        this.cards = new ArrayList<>();
    }

    public void addCard(Card card) {
        cards.add(card);
    }

    // Method to get the first card safely
    public Card getFirstCard() {
        if (!cards.isEmpty()) {
            return cards.get(0);
        }
        return null;  // Consider handling this case appropriately in the calling code
    }

    public int calculateTotal() {
        int total = 0;
        int aces = 0;
        for (Card card : cards) {
            int value = card.getValue();
            if (value == 11) { // Ace
                aces++;
            }
            total += value;
        }
        while (total > 21 && aces > 0) {
            total -= 10;  // Convert an Ace from 11 to 1
            aces--;
        }
        return total;
    }

    @Override
    public String toString() {
        return cards.toString() + " (" + calculateTotal() + " points)";
    }
}

