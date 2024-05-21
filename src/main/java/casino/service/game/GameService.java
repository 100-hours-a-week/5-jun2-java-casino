package casino.service.game;

import casino.domain.game.Game;
import casino.domain.game.roulette.RouletteBetType;
import casino.domain.game.slotmachine.SlotMachineGame;
import casino.domain.game.slotmachine.SlotMachineResult;
import casino.domain.participant.Player;
import casino.domain.type.GameType;
import casino.dto.RouletteBetInfoDto;
import casino.dto.RouletteGameResultDto;
import casino.dto.SlotMachineGameResultDto;

public interface GameService {
    public SlotMachineGameResultDto playSlotMachine(Game game, Player player);
    public RouletteGameResultDto playRoulette(RouletteBetInfoDto info, Game game, Player player);
    public void playBlackjack(Game game,Player player);
}
