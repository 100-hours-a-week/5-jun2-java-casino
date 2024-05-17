package casino.view.casino;

import java.util.Scanner;

public class CasinoInputView {
    private static final Scanner reader = new Scanner(System.in);

    private CasinoInputView() {
    }


    public static String readMainOption()  {
        CasinoOutputView.printMainOption();
        return read();
    }

    private static String read() {
        System.out.println("원하는 기능을 선택하세요.");
        System.out.print(">> ");
        return reader.next();
    }
}
