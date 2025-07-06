package string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class AllAnagramsInAFile {

    public static void main(String[] args) {
        String[] array = {"thore", "ganamar", "notanagram", "anagram", "other"};

        Map<String, List<String>> map = new HashMap<>();
        for (String str : array) {
            int[] count = new int[26];
            for (char curr : str.toCharArray()) {
                count[curr - 'a']++;
            }
            StringBuilder hash = new StringBuilder();
            for (int i = 0; i < 26; i++) {
                hash.append(count[i]).append("#");
            }
            map.computeIfAbsent(hash.toString(), (k -> new ArrayList<>())).add(str);
        }
        System.out.println(map.values());
    }
}
