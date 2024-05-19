package casino.io.game;

public class GameOutputView {
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

    public void printBlankLine() {
        System.out.println();
    }

    public void printException(String exceptionMessage) {
        System.out.println(exceptionMessage);
        printBlankLine();
    }
}
