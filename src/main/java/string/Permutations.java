package string;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

public class Permutations {

    public static void main(String[] args) {
        permutations("", "abc");
        lexographicPermutations("12321");
    }

    private static void lexographicPermutations(String str) {
        char[] charArray = str.toCharArray();
        Arrays.sort(charArray);
        String sortedString = new String(charArray);
        System.out.println(sortedString);
        permutations("", sortedString);
        System.out.println(set);
    }

    private static final Set<String> set = new LinkedHashSet<>();

    private static void permutations(String prefix, String str) {
        if (str.isEmpty()) {
            set.add(prefix);
            return;
        }

        for (int i = 0; i < str.length(); i++) {
            permutations(prefix + str.charAt(i), str.substring(0, i) + str.substring(i + 1));
        }
    }

}
