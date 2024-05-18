package casino.domain.participant;

public class Player extends Participant {
    private long cash;
    // TO-DO
    // EnumMap 으로 칩 관리

    public Player(String name, RoleType roleType, long cash) {
        super(name, roleType);
        this.cash = cash;
    }
}
