package casino.controller;

import static casino.domain.type.GameType.*;

import casino.CasinoConfig;
import casino.controller.game.BlackjackController;
import casino.controller.game.GameController;
import casino.controller.game.RouletteController;
import casino.controller.game.SlotMachineController;
import casino.domain.game.Game;
import casino.domain.game.GameGenerator;
import casino.domain.option.GameOption;
import casino.domain.participant.Player;
import casino.domain.participant.RoleType;
import casino.domain.type.GameType;
import casino.response.GameResponse;
import casino.request.Request;
import casino.service.casino.CasinoMainService;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 *  리팩토링시 게임 종류별로 컨트롤러 및 서비스, I/O 로직 분리 -> 해당 클래스가 너무 많은 책임을 가짐
 *  단순히 종류에 따른 게임 실행 기능을 하는 것이 역할 (라우팅 개념)
 *  1. 컨트롤러에서 input 로직 의존성 분리 -> Request 레이어로 분리하는 방법 [O]
 *  2. 게임 종류별 컨트롤러를 호출하고, 비즈니스 로직은 서비스 레이어에 위임하도록 구현 [O]
 *  3. 컨트롤러에서 play -> 서비스에서 play -> 도메인에서 play [O]
 */
public class CasinoGameController implements Controller {
    private final Request request;
    private final GameResponse gameResponse;
    private final CasinoMainService casinoMainService;
    Map<GameType, GameController> controllers = new LinkedHashMap<>();

    public CasinoGameController(CasinoConfig casinoConfig) {
        initializeControllers(casinoConfig);
        this.request = casinoConfig.request();
        this.gameResponse = casinoConfig.gameResponse();
        this.casinoMainService = casinoConfig.casinoMainService();
    }

    @Override
    public void process() {
        GameOption gameOption;

        do {
            gameResponse.printBlankLine();
            gameResponse.printGameOption();
            gameOption = request.getGameOption();
            processController(gameOption);
        } while (gameOption.isContinue());
    }

    private void initializeControllers(CasinoConfig casinoConfig) {
        controllers.put(SLOT_MACHINE, new SlotMachineController(casinoConfig));
        controllers.put(ROULETTE, new RouletteController(casinoConfig));
        controllers.put(BLACKJACK, new BlackjackController(casinoConfig));
    }

    private void processController(GameOption gameOption) {
        if (gameOption == GameOption.QUIT) {
            return;
        }

        GameController controller = controllers.get(gameOption.getType());
        Player player = (Player) casinoMainService.findParticipantByRoleType(RoleType.PLAYER);
        Game game = GameGenerator.generateGame(gameOption.getType(), player);
        gameResponse.printGameGreet(gameOption.getType());

        try {
            controller.process(game, player);
        } catch (Exception e) {
            gameResponse.printException(e.getMessage());
        }
    }
}
