package string;

import java.util.HashMap;
import java.util.Map;

/**
 * Two strings str1 and str2 are called isomorphic if there is a one to one mapping possible for every character of str1
 * to every character of str2. And all occurrences of every character in ‘str1′ map to same character in ‘str2′
 */
public class IsIsomorphic {

    private static Map<Character, Character> map = new HashMap<Character, Character>();
    private static boolean[] visited = new boolean[256];

    public static void main(String[] args) {
        String str1 = "axa";
        String str2 = "xbx";

        System.out.println("is isomorphic : " + isIsomorphic(str1, str2));
    }

    private static boolean isIsomorphic(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }

        for (int i = 0; i < str1.length(); i++) {
            char char1 = str1.charAt(i);
            char char2 = str2.charAt(i);

            if (!visited[char1]) {
                if (visited[char2]) {
                    return false;
                }

                visited[char1] = true;
                visited[char2] = true;
                map.put(char1, char2);
            } else if (!map.get(char1).equals(char2)) {
                return false;
            }
        }

        return true;
    }

}
