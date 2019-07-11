package code.war;

import java.util.Arrays;

public class FindOdd {
    public static int findIt(int[] a) {
        return Arrays.stream(a).reduce((init, next)-> init ^ next).orElse(0);
    }
}
