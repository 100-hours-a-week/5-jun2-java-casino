package casino.domain.participant;

import casino.domain.game.Card;
import casino.domain.game.CardDeck;
import java.util.ArrayList;
import java.util.List;

public abstract class Participant {
    private static final String NAME_REGEX = "^[가-힣a-zA-Z]{3,10}$";
    protected String name;
    protected RoleType roleType;
    protected List<Card> cards = new ArrayList<>();

    public Participant(String name, RoleType roleType) {
        validateName(name);
        this.name = name;
        this.roleType = roleType;
    }

    public boolean isPlayer () {
        return roleType == RoleType.PLAYER;
    }

    public void addCard(Card card) {
        cards.add(card);
    }

    public int getCardsValue() {
        int value = 0;
        int ace = 0;

        for (Card card : cards) {
            if (card.isOverTen()) {
                value += 10;
            } else if (card.isAce()) {
                ace += 1;
                value += 1;
            } else {
                value += card.number();
            }
        }

        while (value > 21 && ace > 0) {
            value -= 10;
            ace--;
        }

        return value;
    }

    public abstract void play(CardDeck cardDeck);

    public boolean isBusted() {
        return getCardsValue() > 21;
    }

    protected void validateName(String name) {
        if (!name.matches(NAME_REGEX)) {
            throw new IllegalArgumentException("[ERROR] 이름은 3 ~ 10자 이하의 한글 또는 영어로 설정해야 합니다.\n");
        }
    }
}
