package casino.domain.participant;

public abstract class Participant {
    protected String name;
    protected RoleType roleType;

    public Participant(String name, RoleType roleType) {
        this.name = name;
        this.roleType = roleType;
    }

    public boolean isPlayer () {
        return roleType == RoleType.PLAYER;
    }
}
