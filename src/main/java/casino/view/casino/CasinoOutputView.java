package casino.view.casino;

public class CasinoOutputView {
    private CasinoOutputView() {
    }

    public static void printMainOption() {
        System.out.println("### 카지노 메인 화면");
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
