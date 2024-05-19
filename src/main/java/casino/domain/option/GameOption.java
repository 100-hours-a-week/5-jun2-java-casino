package casino.domain.option;

import casino.domain.type.GameType;
import java.util.Arrays;

public enum GameOption {
    SLOT_MACHINE("1", GameType.SLOT_MACHINE),
    ROULETTE("2", GameType.ROULETTE),
    BLACKJACK("3", GameType.BLACKJACK),
    BACCARAT("4", GameType.BACCARAT),
    QUIT("Q", GameType.NONE);

    private final String optionNumber;
    private GameType type;

    GameOption(String optionNumber, GameType type) {
        this.optionNumber = optionNumber;
        this.type = type;
    }
    public static GameOption from(String optionNumber) {
        return Arrays.stream(values())
                .filter(option -> option.optionNumber.equals(optionNumber))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("[ERROR] 선택할 수 없는 기능입니다.\n"));
    }

    public boolean isContinue() {
        return this != QUIT;
    }
}
