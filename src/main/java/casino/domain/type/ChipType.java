package casino.domain.type;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public enum ChipType {
    WHITE("흰색 칩", 1000, 1),
    PINK("분홍색 칩", 2500, 3),
    RED("빨간색 칩", 5000, 5),
    BLUE("파란색 칩", 10000, 10),
    GREEN("초록색 칩", 25000, 25),
    BLACK("검정색 칩", 100000, 100);

    private final String name;
    private final int krw;
    private final int dollar;

    ChipType(String name, int krw, int dollar) {
        this.name = name;
        this.krw = krw;
        this.dollar = dollar;
    }

    public static Map<ChipType, Integer> generateInfoByCounts(List<Integer> counts) {
        Map<ChipType, Integer> result = new EnumMap<>(ChipType.class);
        ChipType[] types = values();

        if (counts.size() != types.length) {
            throw new IllegalStateException("[ERROR] 올바르지 않은 개수입니다.\n");
        }

        for (int i = 0; i < types.length; i++) {
            result.put(types[i], counts.get(i));
        }

        return result;
    }

    public String getName() {
        return name;
    }

    public int getKrw() {
        return krw;
    }

    public int getDollar() {
        return dollar;
    }
}
