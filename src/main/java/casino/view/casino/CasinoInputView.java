package casino.view.casino;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
        return reader.next();
    }
}
