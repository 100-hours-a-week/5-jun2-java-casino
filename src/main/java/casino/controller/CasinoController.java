package casino.controller;

import casino.CasinoConfig;
import casino.domain.options.MainOption;
import casino.domain.participant.Player;
import casino.domain.participant.RoleType;
import casino.io.casino.CasinoInputView;
import casino.io.casino.CasinoOutputView;
import casino.service.casino.CasinoMainService;
import java.util.LinkedHashMap;
import java.util.Map;

public class CasinoController implements Controller {
    private final CasinoInputView casinoInputView;
    private final CasinoOutputView casinoOutputView;
    private final CasinoMainService casinoMainService;
    private final Map<MainOption, Controller> controllers = new LinkedHashMap<>();

    public CasinoController(CasinoConfig casinoConfig) {
        initializeControllers();
        casinoInputView = casinoConfig.casinoInputView();
        casinoOutputView = casinoConfig.casinoOutputView();
        casinoMainService = casinoConfig.casinoMainService();
    }

    @Override
    public void process() {
        MainOption mainOption;

        casinoOutputView.printGreet();
        Player player = registerPlayer();
        casinoMainService.saveParticipant(player);
        System.out.println(casinoMainService.findParticipantByRoleType(RoleType.PLAYER).toString());

        do {
            casinoOutputView.printBlankLine();
            casinoOutputView.printMainOption();
            mainOption = casinoInputView.readMainOption();
            processController(mainOption);
        } while (mainOption.isContinue());
    }

    private void initializeControllers() {
        controllers.put(MainOption.CURRENCY_EXCHANGE, new CurrencyExchangeController());
        controllers.put(MainOption.CASINO_GAME, new CasinoGameController());
    }

    private void processController(MainOption mainOption) {
        if (mainOption == MainOption.QUIT) {
            casinoOutputView.printEndMessage();
            return;
        }
        Controller controller = controllers.get(mainOption);
        controller.process();
    }

    private Player registerPlayer() {
        casinoOutputView.printRegisterPlayerInfo();
        return casinoInputView.readPlayerInfo();
    }
}
