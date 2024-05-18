package casino;

import casino.io.casino.CasinoInputView;
import casino.io.casino.CasinoOutputView;
import casino.io.exchange.ExchangeInputView;
import casino.io.exchange.ExchangeOutputView;
import casino.repository.CasinoMainRepository;
import casino.repository.CasinoRepository;
import casino.service.casino.CasinoMainService;
import casino.service.casino.CasinoMainServiceImpl;
import casino.service.exchange.ExchangeService;
import casino.service.exchange.ExchangeServiceImpl;
import java.util.Scanner;

public class CasinoConfig {
    /**
     * I/O Views
     */
    public CasinoOutputView casinoOutputView() {
        return new CasinoOutputView();
    }

    public CasinoInputView casinoInputView() {
        return new CasinoInputView(scanner());
    }

    public ExchangeOutputView exchangeOutputView() {
        return new ExchangeOutputView();
    }

    public ExchangeInputView exchangeInputView() {
        return new ExchangeInputView(scanner());
    }

    /**
     *  Services & Repositories
     */
    public CasinoMainService casinoMainService() {
        return new CasinoMainServiceImpl(casinoRepository());
    }

    public CasinoRepository casinoRepository() {
        return CasinoMainRepository.getInstance();
    }

    public ExchangeService exchangeService() {
        return new ExchangeServiceImpl();
    }

    private Scanner scanner() {
        return new Scanner(System.in);
    }
}
