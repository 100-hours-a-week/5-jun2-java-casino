package casino.domain.game;

import casino.domain.type.CardType;

public class Card {
    private final String number;
    private final CardType type;

    public Card(String number, CardType type) {
        this.number = number;
        this.type = type;
    }

    public String getCardTypeUnicode() {
        return type.getUnicode();
    }
}
