package casino.service.game;

import casino.domain.game.Game;
import casino.domain.game.slotmachine.SlotMachineGame;
import casino.domain.game.slotmachine.SlotMachineResult;
import casino.domain.participant.Player;
import casino.domain.type.GameType;
import casino.dto.SlotMachineGameResultDto;

public interface GameService {
    public Game generateGame(GameType type, Player player);
    public SlotMachineGameResultDto playSlotMachine(Game game, Player player);
    public void playRoulette(Game game,Player player);
    public void playBlackjack(Game game,Player player);
    public void playBaccarat(Game game,Player player);
}
