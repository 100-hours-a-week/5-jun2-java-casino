package casino.domain.game.roulette;

import java.util.List;

public enum RouletteColorType {
    RED("빨간색", List.of(2, 4, 6, 8, 10, 11, 13, 15, 17, 20, 22, 24, 26, 28, 29, 31, 33, 35)),
    BLACK("검정색", List.of(1, 3, 5, 7, 9, 12, 14, 16, 18, 19, 21, 23, 25, 27, 30, 32, 34, 36)),
    NONE("색 없음", List.of(0));

    private final String color;
    private final List<Integer> numbers;

    RouletteColorType(String color, List<Integer> numbers) {
        this.color = color;
        this.numbers = numbers;
    }

    public static RouletteColorType findColorByNumber(int number) {
        if (RED.numbers.contains(number)) {
            return RED;
        } else if (BLACK.numbers.contains(number)) {
            return BLACK;
        }
        return NONE;
    }
}
