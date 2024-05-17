package casino.domain.options;

import java.util.Arrays;

public enum ExchangeOption {
    CHECK_ACCOUNT("1", "보유 잔액 확인"),
    CASH_TO_CHIP("2", "현금 -> 칩 교환"),
    CHIP_TO_CASH("3", "칩 -> 현금 교환"),
    QUIT("Q", "나가기");

    private final String optionNumber;
    private final String command;

    ExchangeOption(String optionNumber, String command) {
        this.optionNumber = optionNumber;
        this.command = command;
    }

    public static ExchangeOption from(String optionNumber) {
        return Arrays.stream(values())
                .filter(option -> option.optionNumber.equals(optionNumber))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("[ERROR] 선택할 수 없는 기능입니다.\n"));
    }

    public boolean isContinue() {
        return this != QUIT;
    }
}
