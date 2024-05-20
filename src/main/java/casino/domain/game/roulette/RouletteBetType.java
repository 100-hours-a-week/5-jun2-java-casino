package casino.domain.game.roulette;

import java.util.Arrays;

public enum RouletteBetType {
    STRAIGHT_BET(1, "한 개 숫자에 베팅", 35),
    SPLIT_BET(2, "두 개 숫자 동시에 베팅", 17),
    STREET_BET(3, "일렬로 놓여진 세 개 숫자 동시에 베팅", 11),
    SQUARE_BET(4, "네 개의 숫자 동시에 베팅", 8),
    FIVE_NUMBER_BET(5, "1, 2, 3, 0 동시에 베팅", 6),
    SIX_NUMBER_BET(6, "이어지는 여섯 숫자에 동시 베팅", 5),
    COLUMN_BET(7, "세로로 일렬하는 12개 숫자에 동시 베팅", 2),
    DOZEN_BET(8, "레이아웃의 1st 12, 2nd 12, 3rd 12에 베팅", 2),
    HIGH_LOW_NUMBER_BET(9, "1 ~ 18 까지의 숫자 또는 19 ~ 36 까지의 숫자에 베팅", 1),
    EVEN_ODD_NUMBER_BET(10, "0을 제외한 모든 번호를 짝수와 홀수로 구분하여 베팅", 1),
    COLOR_BET(11, "0을 제외한 모든 번호를 적색과 흑색으로 구분하여 베팅", 1),
    NONE(0, "없음", 0);

    private final int typeNumber;
    private final String explanation;
    private final int dividendMultiple;

    RouletteBetType(int typeNumber, String explanation, int dividendMultiple) {
        this.typeNumber = typeNumber;
        this.explanation = explanation;
        this.dividendMultiple = dividendMultiple;
    }

    public static RouletteBetType from(int number) {
        return Arrays.stream(values())
                .filter(v -> v.typeNumber == number)
                .findFirst()
                .orElse(NONE);
    }

    public int getTypeNumber() {
        return typeNumber;
    }

    public String getExplanation() {
        return explanation;
    }

    public int getDividendMultiple() {
        return dividendMultiple;
    }
}
