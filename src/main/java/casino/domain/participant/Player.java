package casino.domain.participant;

public class Player extends Participant {
    private long cash;

    public Player(String name, RoleType roleType, long cash) {
        super(name, roleType);
        this.cash = cash;
    }
}
