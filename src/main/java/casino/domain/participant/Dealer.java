package casino.domain.participant;

import casino.domain.game.CardDeck;

public class Dealer extends Participant implements Runnable {
    private CardDeck cardDeck;

    public Dealer(String name, RoleType roleType) {
        super(name, roleType);
    }

    @Override
    public void play(CardDeck cardDeck) {
        cards.clear();

        while (getCardsValue() < 17) {
            addCard(cardDeck.drawCard());
        }
    }

    @Override
    public void run() {
        play(cardDeck);
    }

    public void setCardDeck(CardDeck cardDeck) {
        this.cardDeck = cardDeck;
    }
}
