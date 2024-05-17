package casino;

import casino.io.casino.CasinoInputView;
import casino.io.casino.CasinoOutputView;
import casino.repository.CasinoMainRepository;
import casino.repository.CasinoRepository;
import casino.service.casino.CasinoMainService;
import casino.service.casino.CasinoMainServiceImpl;
import java.util.Scanner;

public class CasinoConfig {
    public CasinoOutputView casinoOutputView() {
        return new CasinoOutputView();
    }

    public CasinoInputView casinoInputView() {
        return new CasinoInputView(scanner());
    }

    public CasinoMainService casinoMainService() {
        return new CasinoMainServiceImpl(casinoRepository());
    }

    public CasinoRepository casinoRepository() {
        return CasinoMainRepository.getInstance();
    }

    private Scanner scanner() {
        return new Scanner(System.in);
    }
}
