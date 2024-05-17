package casino.controller;

import casino.domain.options.MainOption;
import casino.utils.InputHandler;
import com.sun.tools.javac.Main;
import java.util.LinkedHashMap;
import java.util.Map;

public class CasinoController implements Controller {
    private final Map<MainOption, Controller> controllers = new LinkedHashMap<>();

    public CasinoController() {
        initializeControllers();
    }

    @Override
    public void process() {
        MainOption mainOption;
        greeting();

        do {
            mainOption = InputHandler.receiveValidMainOption();
            processController(mainOption);
        } while (mainOption.isContinue());
    }

    private void greeting() {
        // 환영 메시지 출력 로직
    }

    private void initializeControllers() {
        controllers.put(MainOption.CURRENCY_EXCHANGE, new CurrencyExchangeController());
        controllers.put(MainOption.CASINO_GAME, new CasinoGameController());
    }

    private void processController(MainOption mainOption) {
        if (mainOption == MainOption.QUIT) {
            return;
        }
        Controller controller = controllers.get(mainOption);
        controller.process();
    }
}
