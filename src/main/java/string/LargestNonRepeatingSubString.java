package string;

import java.util.HashMap;
import java.util.Map;

public class LargestNonRepeatingSubString {

    private static final char[] str = "GEEKSFORGEEKS".toCharArray();

    public static void main(String[] args) {
        int start = 0;
        int max = 0;
        int maxStart = 0;

        Map<Character, Integer> map = new HashMap<Character, Integer>();

        for (int i = 0; i < str.length; i++) {
            if (null != map.get(str[i])) {
                int lastIndex = map.get(str[i]);

                if (lastIndex >= start) {
                    start = lastIndex + 1;
                }
            }

            if (max < i - start) {
                max = i - start;
                maxStart = start;
            }

            map.put(str[i], i);
        }

        printLargestNonRepeatingSubStringFoundSoFar(maxStart, max);
    }

    private static void printLargestNonRepeatingSubStringFoundSoFar(int start, int max) {
        StringBuilder builder = new StringBuilder();
        for (int i = start; i <= start + max; i++) {
            builder.append(str[i]);
        }
        System.out.println(builder);
    }
}
