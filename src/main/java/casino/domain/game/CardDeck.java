package casino.domain.game;

import casino.domain.type.CardType;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class CardDeck {
    private LinkedList<Card> cards = new LinkedList<>();

    public CardDeck() {
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
        CardType[] types = CardType.values();

        for (String rank : ranks) {
            for (CardType type : types) {
                cards.add(new Card(rank, type));
            }
        }

        Collections.shuffle(cards);
    }

    public Card drawCard() {
        return cards.removeFirst();
    }
}
