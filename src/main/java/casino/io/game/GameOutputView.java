package casino.io.game;

import casino.domain.type.GameType;

public class GameOutputView {
    private static final String SLOT_MACHINE_GREET = "\n"
            + " _____  _         _    ___  ___              _      _              \n"
            + "/  ___|| |       | |   |  \\/  |             | |    (_)             \n"
            + "\\ `--. | |  ___  | |_  | .  . |  __ _   ___ | |__   _  _ __    ___ \n"
            + " `--. \\| | / _ \\ | __| | |\\/| | / _` | / __|| '_ \\ | || '_ \\  / _ \\\n"
            + "/\\__/ /| || (_) || |_  | |  | || (_| || (__ | | | || || | | ||  __/\n"
            + "\\____/ |_| \\___/  \\__| \\_|  |_/ \\__,_| \\___||_| |_||_||_| |_| \\___|\n";

    private static final String ROULETTE_GREET = "______                _        _    _         \n"
            + "| ___ \\              | |      | |  | |        \n"
            + "| |_/ /  ___   _   _ | |  ___ | |_ | |_   ___ \n"
            + "|    /  / _ \\ | | | || | / _ \\| __|| __| / _ \\\n"
            + "| |\\ \\ | (_) || |_| || ||  __/| |_ | |_ |  __/\n"
            + "\\_| \\_| \\___/  \\__,_||_| \\___| \\__| \\__| \\___|\n";

    private static final String BLACKJACK_GREET = "______  _               _       _               _    \n"
            + "| ___ \\| |             | |     (_)             | |   \n"
            + "| |_/ /| |  __ _   ___ | | __   _   __ _   ___ | | __\n"
            + "| ___ \\| | / _` | / __|| |/ /  | | / _` | / __|| |/ /\n"
            + "| |_/ /| || (_| || (__ |   <   | || (_| || (__ |   < \n"
            + "\\____/ |_| \\__,_| \\___||_|\\_\\  | | \\__,_| \\___||_|\\_\\\n"
            + "                              _/ |                   \n"
            + "                             |__/       ";

    private static final String BACCARAT_GREET = "______                                         _   \n"
            + "| ___ \\                                       | |  \n"
            + "| |_/ /  __ _   ___   ___   __ _  _ __   __ _ | |_ \n"
            + "| ___ \\ / _` | / __| / __| / _` || '__| / _` || __|\n"
            + "| |_/ /| (_| || (__ | (__ | (_| || |   | (_| || |_ \n"
            + "\\____/  \\__,_| \\___| \\___| \\__,_||_|    \\__,_| \\__|";

    public void printGameOption() {
        System.out.println("!! 카지노 게임장에 입장하셨습니다 !!");
        System.out.println("==================================");
        System.out.println("|          게임장 메인 화면          |");
        System.out.println("==================================");
        System.out.println("1. 슬롯 머신 (Slot Machine)");
        System.out.println("2. 룰렛 (Roulette)");
        System.out.println("3. 블랙잭 (Blackjack)");
        System.out.println("4. 바카라 (Baccarat)");
        System.out.println("Q. 나가기");
    }

    public void printGameGreet(GameType type) {
        if (type == GameType.SLOT_MACHINE) {
            System.out.println(SLOT_MACHINE_GREET);
        } else if (type == GameType.ROULETTE) {
            System.out.println(ROULETTE_GREET);
        } else if (type == GameType.BLACKJACK) {
            System.out.println(BLACKJACK_GREET);
        } else if (type == GameType.BACCARAT) {
            System.out.println(BACCARAT_GREET);
        }
    }

    public void printBlankLine() {
        System.out.println();
    }

    public void printException(String exceptionMessage) {
        System.out.println(exceptionMessage);
        printBlankLine();
    }
}
