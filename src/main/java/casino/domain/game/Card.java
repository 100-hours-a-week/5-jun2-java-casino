package casino.domain.game;

import casino.domain.type.CardType;

public class Card {
    private final String number;
    private final CardType type;

    public Card(String number, CardType type) {
        this.number = number;
        this.type = type;
    }

    public int number() {
        return Integer.parseInt(number);
    }

    public String unicode() {
        return type.getUnicode();
    }

    public boolean isOverTen() {
        return "JQK".contains(number);
    }

    public boolean isAce() {
        return number.equals("A");
    }
}
