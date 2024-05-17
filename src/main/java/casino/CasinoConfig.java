package casino;

import casino.io.casino.CasinoInputView;
import casino.io.casino.CasinoOutputView;
import java.util.Scanner;

public class CasinoConfig {
    public CasinoOutputView casinoOutputView() {
        return new CasinoOutputView();
    }

    public CasinoInputView casinoInputView() {
        return new CasinoInputView(scanner());
    }

    private Scanner scanner() {
        return new Scanner(System.in);
    }
}
