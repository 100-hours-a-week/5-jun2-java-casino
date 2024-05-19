package casino.domain.type;

public enum GameStatus {
    PLAY("플레이"),
    STOP("멈춤");

    private final String status;

    GameStatus(String status) {
        this.status = status;
    }

    public boolean isPlay() {
        return this == PLAY;
    }
}
