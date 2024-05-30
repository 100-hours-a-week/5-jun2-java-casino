package casino.domain.participant;

import casino.domain.game.CardDeck;

public class Dealer extends Participant {
    private CardDeck cardDeck;
    private final Object lock = new Object();
    private boolean playerTurnOver = false;

    public Dealer(String name, RoleType roleType) {
        super(name, roleType);
    }

    public void clearCard() {
        cards.clear();
    }
}
