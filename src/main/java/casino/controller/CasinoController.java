package casino.controller;

import static casino.domain.option.MainOption.*;

import casino.CasinoConfig;
import casino.domain.option.MainOption;
import casino.domain.participant.Player;
import casino.response.CasinoResponse;
import casino.request.Request;
import casino.service.casino.CasinoMainService;
import java.util.LinkedHashMap;
import java.util.Map;

// View -> Response 변경
public class CasinoController implements Controller {
    private final Request request;
    private final CasinoResponse casinoResponse;
    private final CasinoMainService casinoMainService;
    private final Map<MainOption, Controller> controllers = new LinkedHashMap<>();

    public CasinoController(CasinoConfig casinoConfig) {
        initializeControllers(casinoConfig);
        request = casinoConfig.request();
        casinoResponse = casinoConfig.casinoResponse();
        casinoMainService = casinoConfig.casinoMainService();
    }

    @Override
    public void process() {
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

    private void initializeControllers(CasinoConfig casinoConfig) {
        controllers.put(CURRENCY_EXCHANGE, new ExchangeController(casinoConfig));
        controllers.put(CASINO_GAME, new CasinoGameController(casinoConfig));
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
