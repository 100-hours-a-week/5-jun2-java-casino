package casino.domain.participant;

public abstract class Participant {
    private static final String NAME_REGEX = "^[가-힣a-zA-Z]{3,10}$";
    protected String name;
    protected RoleType roleType;

    public Participant(String name, RoleType roleType) {
        validateName(name);
        this.name = name;
        this.roleType = roleType;
    }

    public boolean isPlayer () {
        return roleType == RoleType.PLAYER;
    }

    protected void validateName(String name) {
        if (!name.matches(NAME_REGEX)) {
            throw new IllegalArgumentException("[ERROR] 이름은 3 ~ 10자 이하의 한글 또는 영어로 설정해야 합니다.\n");
        }
    }
}
