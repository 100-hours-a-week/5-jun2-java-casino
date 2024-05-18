package casino.utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Util {
    private static final String COMMA = ",";

    public static List<Integer> splitByComma(String target) {
        return Arrays.stream(target.split(COMMA))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
