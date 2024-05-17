package casino.domain.casino;

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
