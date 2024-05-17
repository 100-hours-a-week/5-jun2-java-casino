package casino.domain.participant;

public enum RoleType {
    PLAYER("플레이어"),
    DEALER("딜러");

    private final String type;

    RoleType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
