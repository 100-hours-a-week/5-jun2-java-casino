package casino.domain.game;

import casino.domain.type.CardType;

public class Card {
    private final String number;
    private final CardType type;

    public Card(String number, CardType type) {
        this.number = number;
        this.type = type;
    }

    public int getValue() {
        switch (number) {
            case "A":
                return 11; // Ace
            case "K":
            case "Q":
            case "J":
                return 10;
            default:
                return Integer.parseInt(number);
        }
    }

    @Override
    public String toString() {
        return type.getUnicode() + number;
    }
}
