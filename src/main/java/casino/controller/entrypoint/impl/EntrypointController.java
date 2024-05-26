package casino.controller.entrypoint.impl;

import casino.Jun2CasinoObjectContainer;
import casino.controller.entrypoint.Controller;
import casino.domain.option.MainOption;
import casino.domain.participant.Player;
import casino.request.CasinoRequest;
import casino.response.CasinoResponse;
import casino.service.casino.CasinoMainService;

import java.util.LinkedHashMap;
import java.util.Map;

import static casino.domain.option.MainOption.*;

// View -> Response 변경
public class EntrypointController {
    private final CasinoRequest request;
    private final CasinoResponse casinoResponse;
    private final CasinoMainService casinoMainService;
    private final Map<MainOption, Controller> controllers = new LinkedHashMap<>();

    public EntrypointController(Jun2CasinoObjectContainer jun2CasinoObjectContainer) {
        initializeControllers(jun2CasinoObjectContainer);
        request = jun2CasinoObjectContainer.casinoRequest();
        casinoResponse = jun2CasinoObjectContainer.casinoResponse();
        casinoMainService = jun2CasinoObjectContainer.casinoMainService();
    }

    public void run() {
        MainOption mainOption;

        casinoResponse.printGreet();
        Player player = readPlayer();
        casinoMainService.saveParticipant(player);

        do {
            casinoResponse.printBlankLine();
            casinoResponse.printMainOption();
            mainOption = request.getMainOption();
            processController(mainOption);
        } while (mainOption.isContinue());
    }

    private void initializeControllers(Jun2CasinoObjectContainer jun2CasinoObjectContainer) {
        controllers.put(CURRENCY_EXCHANGE, new ExchangeController(jun2CasinoObjectContainer));
        controllers.put(CASINO_GAME, new CasinoGameController(jun2CasinoObjectContainer));
    }

    private void processController(MainOption mainOption) {
        if (mainOption == QUIT) {
            casinoResponse.printEndMessage();
            return;
        }
        Controller controller = controllers.get(mainOption);
        controller.process();
    }

    private Player readPlayer() {
        casinoResponse.printRegisterPlayerInfo();
        return request.getPlayerInfo();
    }
}
