package casino.domain.type;

public enum CardType {
    SPADE("스페이드", "\u2660"),
    HEART("하트", "\u2665"),
    DIAMOND("다이아몬드", "\u2666"),
    CLOVER("클로버", "\u2663");

    private final String name;
    private final String unicode;

    CardType(String name, String unicode) {
        this.name = name;
        this.unicode = unicode;
    }

    public String getName() {
        return name;
    }

    public String getUnicode() {
        return unicode;
    }
}
