package casino.domain.type;

public enum GameType {
    SLOT_MACHINE("슬롯 머신"),
    ROULETTE("룰렛"),
    BLACKJACK("블랙잭"),
    BACCARAT("바카라"),
    NONE("없음");

    private final String name;

    GameType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
