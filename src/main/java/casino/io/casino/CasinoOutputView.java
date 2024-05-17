package casino.io.casino;

public class CasinoOutputView {
    public void printGreet() {
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

    public void printMainOption() {
        System.out.println("!! 카지노에 입장하셨습니다 !!");
        System.out.println("==================================");
        System.out.println("|          카지노 메인 화면          |");
        System.out.println("==================================");
        System.out.println("1. 환전소");
        System.out.println("2. 카지노 게임");
        System.out.println("Q. 종료");
    }

    public void printRegisterPlayerInfo() {
        System.out.println("==================================");
        System.out.println("|          플레이어 등록 화면         |");
        System.out.println("==================================");
    }

    public void printEndMessage() {
        printBlankLine();
        System.out.println("==================================");
        System.out.println("|     감사합니다. 안녕히 가십시오.   |  ");
        System.out.println("==================================");
    }

    public void printBlankLine() {
        System.out.println();
    }

    public void printException(String exceptionMessage) {
        System.out.println(exceptionMessage);
        printBlankLine();
    }
}
