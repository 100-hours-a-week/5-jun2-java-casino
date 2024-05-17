package casino.view.casino;

public class CasinoOutputView {
    private CasinoOutputView() {
    }

    public static void printGreet() {
        System.out.print("\n"
                + " _    _        _                                 _              ___                _____   _____              _                _ \n"
                + "| |  | |      | |                               | |            |_  |              / __  \\ /  __ \\            (_)              | |\n"
                + "| |  | |  ___ | |  ___   ___   _ __ ___    ___  | |_   ___       | | _   _  _ __  `' / /' | /  \\/  __ _  ___  _  _ __    ___  | |\n"
                + "| |/\\| | / _ \\| | / __| / _ \\ | '_ ` _ \\  / _ \\ | __| / _ \\      | || | | || '_ \\   / /   | |     / _` |/ __|| || '_ \\  / _ \\ | |\n"
                + "\\  /\\  /|  __/| || (__ | (_) || | | | | ||  __/ | |_ | (_) | /\\__/ /| |_| || | | |./ /___ | \\__/\\| (_| |\\__ \\| || | | || (_) ||_|\n"
                + " \\/  \\/  \\___||_| \\___| \\___/ |_| |_| |_| \\___|  \\__| \\___/  \\____/  \\__,_||_| |_|\\_____/  \\____/ \\__,_||___/|_||_| |_| \\___/ (_)\n"
                + "                                                                                                                                 \n"
                + "                                                                                                                                 \n");
    }

    public static void printMainOption() {
        System.out.println("### 카지노 메인 화면 ###");
        System.out.println("1. 환전소");
        System.out.println("2. 카지노 게임");
        System.out.println("Q. 종료");
    }

    public static void printBlankLine() {
        System.out.println();
    }

    public static void printException(String exceptionMessage) {
        System.out.println(exceptionMessage);
        printBlankLine();
    }
}
