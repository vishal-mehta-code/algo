package string;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Palindrome {

    public static void main(String[] args) {

        System.out.println("is palindrome : " + isPalindrome("test" + "set" + ""));

        System.out.println("is rotation of palindrome : " + isRotationOfPalindrome("abbb"));
    }

    /**
     * another way to solve is append the str to itself for example "aab" now becomes "aabaab". now the problem becomes
     * finding palindromic string of size equal to original string.
     */
    private static boolean isRotationOfPalindrome(String str) {

        int length = str.length();

        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < length; i++) {
            Character character = str.charAt(i);

            if (map.get(character) == null) {
                map.put(character, 1);
            } else {
                map.put(character, map.get(character) + 1);
            }
        }

        Set<Map.Entry<Character, Integer>> entrySet = map.entrySet();

        int elementExistingOddTimes = 0;

        for (Map.Entry<Character, Integer> entry : entrySet) {
            if (entry.getValue() % 2 != 0) {
                elementExistingOddTimes++;

                if (elementExistingOddTimes > 1)
                    return false;
            }
        }

        return true;
    }

    private static boolean isPalindrome(String str) {
        if (str.length() <= 1) {
            return true;
        }

        return str.substring(0, 1).equals(str.substring(str.length() - 1, str.length()))
                && isPalindrome(str.substring(1, str.length() - 1));
    }
}
