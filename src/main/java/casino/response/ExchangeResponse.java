package casino.response;

import casino.domain.type.ChipType;
import casino.dto.AccountBalanceInfoDto;
import java.util.List;
import java.util.Map;

public class ExchangeResponse {
    public void printExchangeOption() {
        System.out.println("!! 환전소에 입장하셨습니다 !!");
        System.out.println("==================================");
        System.out.println("|          환전소 메인 화면          |");
        System.out.println("==================================");
        System.out.println("1. 보유 잔액 확인");
        System.out.println("2. 보유 현금 칩 교환 (현금 -> 칩)");
        System.out.println("3. 보유 칩 현금 교환 (칩 -> 현금)");
        System.out.println("Q. 나가기");
    }

    public void printAccountBalanceInfo(AccountBalanceInfoDto dto) {
        printBlankLine();
        System.out.println("======================================================");
        System.out.println("|                     보유 잔액 확인                     |");
        System.out.println("======================================================");
        System.out.printf("현금 : " + String.format("%,d", dto.cash())+ "\n");

        Map<ChipType, Integer> chips = dto.chips();
        for (Map.Entry<ChipType, Integer> entry : chips.entrySet()) {
            String result = entry.getKey().getName()
                    + " (" + String.format("%,d", entry.getKey().getKrw()) + "원) : "
                    + entry.getValue() + " 개";
            System.out.println(result);
        }
    }

    public void printExchangeCashToChips() {
        printBlankLine();
        System.out.println("======================================================");
        System.out.println("|              보유 현금 칩 교환 (현금 -> 칩)              |");
        System.out.println("======================================================");
        printChipsInfo();
    }

    public void printExchangeChipsToCash(Map<ChipType, Integer> chips) {
        printBlankLine();
        System.out.println("======================================================");
        System.out.println("|                보유 칩 교환 (칩 -> 현금)                |");
        System.out.println("======================================================");
        printChipsInfo();
        printPlayerChips(chips);
    }

    public void printPlayerChips(Map<ChipType, Integer> chips) {
        System.out.println("============================== 플레이어 보유 칩 ==============================");
        for (Map.Entry<ChipType, Integer> entry : chips.entrySet()) {
            ChipType type = entry.getKey();
            int count = entry.getValue();
            System.out.print("[" + type.name() + "]:" + count + " ");
        }
        printBlankLine();
    }

    public void printBlankLine() {
        System.out.println();
    }

    public void printException(String exceptionMessage) {
        System.out.println(exceptionMessage);
    }

    private void printChipsInfo() {
        List<ChipType> types = List.of(ChipType.values());
        for (ChipType type : types) {
            System.out.println(type.getName() + " - " + type.getKrw() + " 원");
        }
    }
}
