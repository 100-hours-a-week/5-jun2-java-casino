package casino.controller.game;

import static casino.domain.game.roulette.RouletteBetType.FIVE_NUMBER_BET;
import static casino.domain.type.GameType.ROULETTE;

import casino.CasinoConfig;
import casino.domain.game.Game;
import casino.domain.game.roulette.RouletteBetType;
import casino.domain.participant.Player;
import casino.domain.type.ChipType;
import casino.dto.RouletteBetInfoDto;
import casino.dto.RouletteGameResultDto;
import casino.request.Request;
import casino.response.GameResponse;
import casino.service.game.GameService;
import java.util.Map;

public class RouletteController implements GameController {
    private final Request request;
    private final GameResponse gameResponse;
    private final GameService gameService;

    public RouletteController(CasinoConfig casinoConfig) {
        this.request = casinoConfig.request();
        this.gameResponse = casinoConfig.gameResponse();
        this.gameService = casinoConfig.gameService();
    }

    @Override
    public void process(Game game, Player player) {
        gameResponse.printPlayerChips(player.getChipsBalance());
        Map<ChipType, Integer> betChips = request.getBetChips(ROULETTE);
        if (!game.isPlay()) {
            game.changeStatus();
        }

        while (game.isPlay()) {
            player.validateChipsToPlay(betChips);
            gameResponse.printRouletteBetType();
            RouletteBetType betType = request.getRouletteBetType();
            playRouletteByBetType(betType, game, player, betChips);
            game.changeStatus();
        }
    }

    private void playRouletteByBetType(RouletteBetType betType, Game game, Player player, Map<ChipType, Integer> betChips) {
        RouletteGameResultDto dto;
        if (betType == FIVE_NUMBER_BET) {
            dto = gameService.playRoulette(new RouletteBetInfoDto(betType, 0, 0, betChips), game, player);
        } else if (betType.requireOnlyNumber()) {
            int betNumber = request.getRouletteBetNumber(betType);
            dto = gameService.playRoulette(new RouletteBetInfoDto(betType, betNumber, 0, betChips), game, player);
        } else {
            gameResponse.printRouletteBetOptions(betType);
            int optionNumber = request.getRouletteBetOptionNumber(betType);
            dto = gameService.playRoulette(new RouletteBetInfoDto(betType, 0, optionNumber, betChips), game, player);
        }
        gameResponse.printRouletteGameResult(dto);
    }
}
