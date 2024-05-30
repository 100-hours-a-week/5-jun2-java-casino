package casino.domain.game;

import casino.domain.participant.Player;
import casino.domain.type.GameStatus;
import casino.domain.type.GameType;

public class Game {
    private GameType gameType;
    private GameStatus status;
    protected Player player;

    public Game(GameType gameType, Player player, GameStatus status) {
        this.gameType = gameType;
        this.player = player;
        this.status = status;
    }

    public boolean isPlay() {
        return status.isPlay();
    }

    public void changeStatus() {
        if (status == GameStatus.STOP) {
            status = GameStatus.PLAY;
        } else {
            status = GameStatus.STOP;
        }
    }
}
