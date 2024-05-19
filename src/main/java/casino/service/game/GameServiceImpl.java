package casino.service.game;

import static casino.domain.type.GameStatus.*;
import static casino.domain.type.GameType.*;

import casino.domain.game.baccarat.BaccaratGame;
import casino.domain.game.blackjack.BlackjackGame;
import casino.domain.game.Game;
import casino.domain.game.roulette.RouletteGame;
import casino.domain.game.slotmachine.SlotMachineGame;
import casino.domain.game.slotmachine.SlotMachineResult;
import casino.domain.participant.Player;
import casino.domain.type.GameType;
import casino.dto.SlotMachineGameResultDto;
import java.util.LinkedHashMap;
import java.util.Map;

public class GameServiceImpl implements GameService {
    @Override
    public Game generateGame(GameType type, Player player) {
        if (type == SLOT_MACHINE) {
            return new SlotMachineGame(type, player, STOP);
        }
        if (type == ROULETTE) {
            return new RouletteGame(type, player, STOP);
        }
        if (type == BLACKJACK) {
            return new BlackjackGame(type, player, STOP);
        }
        if (type == BACCARAT) {
            return new BaccaratGame(type, player, STOP);
        }
        throw new IllegalArgumentException("[ERROR] 존재하지 않는 게임입니다.\n");
    }

    @Override
    public SlotMachineGameResultDto playSlotMachine(Game game, Player player) {
        SlotMachineGame slotMachineGame = (SlotMachineGame) game;
        int[] numbersResult = slotMachineGame.generateRandomNumbers();
        SlotMachineResult result = slotMachineGame.calculateWinningResult(numbersResult);
        return new SlotMachineGameResultDto(result, numbersResult);
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
