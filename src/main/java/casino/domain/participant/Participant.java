package casino.domain.participant;

import casino.domain.game.Card;
import java.util.ArrayList;
import java.util.List;

public abstract class Participant {
    private static final String NAME_REGEX = "^[가-힣a-zA-Z]{3,10}$";
    protected String name;
    protected RoleType roleType;
    protected List<Card> cards = new ArrayList<>();

    protected Participant(String name, RoleType roleType) {
        validateName(name);
        this.name = name;
        this.roleType = roleType;
    }

    public boolean isPlayer () {
        return roleType == RoleType.PLAYER;
    }

    public synchronized void addCard(Card card) {
        cards.add(card);
    }

    public int getCardsValue() {
        int value = 0;
        int aceCount = 0;

        for (Card card : cards) {
            int cardValue = card.getValue();
            if (cardValue == 11) { // Ace
                aceCount++;
            }
            value += cardValue;
        }

        while (value > 21 && aceCount > 0) {
            value -= 10;
            aceCount--;
        }

        return value;
    }

    public List<Card> getCards() {
        return List.copyOf(cards);
    }

    public boolean isBusted() {
        return getCardsValue() > 21;
    }

    public String getName() {
        return name;
    }

    protected void validateName(String name) {
        if (!name.matches(NAME_REGEX)) {
            throw new IllegalArgumentException("[ERROR] 이름은 3 ~ 10자 이하의 한글 또는 영어로 설정해야 합니다.\n");
        }
    }
}
