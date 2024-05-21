package casino.controller;

import static casino.domain.game.roulette.RouletteBetType.*;

import casino.CasinoConfig;
import casino.domain.game.Game;
import casino.domain.game.GameGenerator;
import casino.domain.game.roulette.RouletteBetType;
import casino.domain.option.GameOption;
import casino.domain.participant.Player;
import casino.domain.participant.RoleType;
import casino.domain.type.ChipType;
import casino.domain.type.GameType;
import casino.dto.RouletteBetInfoDto;
import casino.dto.RouletteGameResultDto;
import casino.dto.SlotMachineGameResultDto;
import casino.response.GameResponse;
import casino.request.Request;
import casino.service.casino.CasinoMainService;
import casino.service.game.GameService;
import java.util.Map;

/**
 *  리팩토링시 게임 종류별로 컨트롤러 및 서비스, I/O 로직 분리 -> 해당 클래스가 너무 많은 책임을 가짐
 *  단순히 종류에 따른 게임 실행 기능을 하는 것이 역할 (라우팅 개념)
 *  1. 컨트롤러에서 input 로직 의존성 분리 -> Request 레이어로 분리하는 방법?
 *  2. 게임 종류별 컨트롤러를 호출하고, 비즈니스 로직은 서비스 레이어에 위임하도록 구현
 */
public class CasinoGameController implements Controller {
    private final Request request;
    private final GameResponse gameResponse;
    private final CasinoMainService casinoMainService;
    private final GameService gameService;

    public CasinoGameController(CasinoConfig casinoConfig) {
        this.request = casinoConfig.request();
        this.gameResponse = casinoConfig.gameResponse();
        this.casinoMainService = casinoConfig.casinoMainService();
        this.gameService = casinoConfig.gameService();
    }

    @Override
    public void process() {
        GameOption gameOption;

        do {
            gameResponse.printBlankLine();
            gameResponse.printGameOption();
            gameOption = request.getGameOption();
            playGame(gameOption);
        } while (gameOption.isContinue());
    }

    private void playGame(GameOption gameOption) {
        Player player = (Player) casinoMainService.findParticipantByRoleType(RoleType.PLAYER);
        Game game = GameGenerator.generateGame(gameOption.getType(), player);
        gameResponse.printGameGreet(gameOption.getType());

        try {
            if (gameOption == GameOption.SLOT_MACHINE) {
                playSlotMachine(game, player);
            } else if (gameOption == GameOption.ROULETTE) {
                playRoulette(game, player);
            } else if (gameOption == GameOption.BLACKJACK) {
                playBlackjack(game, player);
            } else if (gameOption == GameOption.BACCARAT) {
                playBaccarat(game, player);
            }
        } catch (Exception e) {
            gameResponse.printException(e.getMessage());
        }
    }

    private void playSlotMachine(Game game, Player player) {
        boolean playGame = request.getSlotMachinePayment();

        if (playGame && !game.isPlay()) {
            game.changeStatus();
        }
        if (!playGame) {
            return;
        }
        while (game.isPlay()) {
            SlotMachineGameResultDto result = gameService.playSlotMachine(game, player);
            gameResponse.printSlotMachineResult(result);

            boolean retry = request.getRetryGame();
            if (retry) {
                playSlotMachine(game, player);
            } else {
                game.changeStatus();
                return;
            }
        }
    }

    private void playRoulette(Game game, Player player) {
        gameResponse.printPlayerChips(player.getChipsBalance());
        Map<ChipType, Integer> betChips = request.getBetChips(GameType.ROULETTE);
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

    private void playBlackjack(Game game, Player player) {
    }

    private void playBaccarat(Game game, Player player) {

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
