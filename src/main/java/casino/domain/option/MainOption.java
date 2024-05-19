package casino.domain.option;

import java.util.Arrays;

public enum MainOption {
    CURRENCY_EXCHANGE("1", "환전소"),
    CASINO_GAME("2", "카지노 게임"),
    QUIT("Q", "종료");

    private final String optionNumber;
    private final String command;

    MainOption(String optionNumber, String command) {
        this.optionNumber = optionNumber;
        this.command = command;
    }

    public static MainOption from(String optionNumber) {
        return Arrays.stream(values())
                .filter(option -> option.optionNumber.equals(optionNumber))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("[ERROR] 선택할 수 없는 기능입니다.\n"));
    }

    public boolean isContinue() {
        return this != QUIT;
    }
}
