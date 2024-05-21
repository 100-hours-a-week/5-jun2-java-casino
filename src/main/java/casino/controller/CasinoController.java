package casino.controller;

import static casino.domain.option.MainOption.*;

import casino.CasinoConfig;
import casino.domain.option.MainOption;
import casino.domain.participant.Player;
import casino.io.casino.CasinoOutputView;
import casino.request.Request;
import casino.service.casino.CasinoMainService;
import java.util.LinkedHashMap;
import java.util.Map;

// View -> Response 변경
public class CasinoController implements Controller {
    private final Request request;
    private final CasinoOutputView casinoOutputView;
    private final CasinoMainService casinoMainService;
    private final Map<MainOption, Controller> controllers = new LinkedHashMap<>();

    public CasinoController(CasinoConfig casinoConfig) {
        initializeControllers(casinoConfig);
        request = casinoConfig.request();
        casinoOutputView = casinoConfig.casinoOutputView();
        casinoMainService = casinoConfig.casinoMainService();
    }

    @Override
    public void process() {
        MainOption mainOption;

        casinoOutputView.printGreet();
        Player player = readPlayer();
        casinoMainService.saveParticipant(player);

        do {
            casinoOutputView.printBlankLine();
            casinoOutputView.printMainOption();
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
            casinoOutputView.printEndMessage();
            return;
        }
        Controller controller = controllers.get(mainOption);
        controller.process();
    }

    private Player readPlayer() {
        casinoOutputView.printRegisterPlayerInfo();
        return request.getPlayerInfo();
    }
}
