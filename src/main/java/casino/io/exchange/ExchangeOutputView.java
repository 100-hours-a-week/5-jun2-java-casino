package casino.io.exchange;

public class ExchangeOutputView {
    public void printExchangeOption() {
        System.out.println("!! 환전소에 입장하셨습니다 !!");
        System.out.println("==================================");
        System.out.println("|          환전소 메인 화면          |");
        System.out.println("==================================");
        System.out.println("1. 보유 잔액 확인");
        System.out.println("2. 보유 현금 코인화 (현금 -> 코인)");
        System.out.println("3. 보유 코인 현금화 (코인 -> 현금)");
        System.out.println("Q. 나가기");
    }

    public void printBlankLine() {
        System.out.println();
    }
}
