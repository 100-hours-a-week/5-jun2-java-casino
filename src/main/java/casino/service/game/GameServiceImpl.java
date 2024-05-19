package casino.service.game;

import static casino.domain.type.GameStatus.*;
import static casino.domain.type.GameType.*;

import casino.domain.game.BaccaratGame;
import casino.domain.game.BlackjackGame;
import casino.domain.game.Game;
import casino.domain.game.RouletteGame;
import casino.domain.game.SlotMachineGame;
import casino.domain.participant.Player;
import casino.domain.type.GameType;

public class GameServiceImpl implements GameService {
    @Override
    public Game generateGame(GameType type, Player player) {
        if (type == SLOT_MACHINE) {
            return new SlotMachineGame(type, player, PLAY);
        }
        if (type == ROULETTE) {
            return new RouletteGame(type, player, PLAY);
        }
        if (type == BLACKJACK) {
            return new BlackjackGame(type, player, PLAY);
        }
        if (type == BACCARAT) {
            return new BaccaratGame(type, player, PLAY);
        }
        throw new IllegalArgumentException("[ERROR] 존재하지 않는 게임입니다.\n");
    }

    @Override
    public void playSlotMachine(Game game, Player player) {

    }

    @Override
    public void playRoulette(Game game, Player player) {

    }

    @Override
    public void playBlackjack(Game game, Player player) {

    }

    @Override
    public void playBaccarat(Game game, Player player) {

    }
}
