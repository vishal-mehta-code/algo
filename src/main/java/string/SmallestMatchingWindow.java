package string;

import java.util.HashMap;
import java.util.Map;

public class SmallestMatchingWindow {

    public static void main(String[] args) {
        String str1 = "tist";
        String str2 = "tstit";
        findMinMatchingWindow(str1.toCharArray(), str2.toCharArray());
    }

    private static void findMinMatchingWindow(char[] str1, char[] str2) {
        Map<Character, Integer> map1 = new HashMap<>();
        for (Character curr : str1) {
            map1.put(curr, map1.getOrDefault(curr, 0) + 1);
        }

        int uq = map1.size();
        int l = 0;
        int r = 0;
        int cuq = 0;
        int maxR = -1;
        int maxL = -1;

        Map<Character, Integer> map2 = new HashMap<>();

        while (r < str2.length) {
            if (map1.containsKey(str2[r])) {
                map2.put(str2[r], map2.getOrDefault(str2[r], 0) + 1);

                if (map2.get(str2[r]) == map1.get(str2[r])) {
                    cuq++;
                }
            }

            while (l < r && cuq == uq) {
                maxL = l;
                maxR = r;
                if (map1.containsKey(str2[l])) {
                    map2.put(str2[l], map2.get(str2[l]) - 1);

                    if (map2.get(str2[l]) < map1.get(str2[l])) {
                        cuq--;
                    }
                }
                l++;
            }

            r++;
        }

        System.out.println("maxL : " + maxL + " maxR : " + maxR);

        StringBuilder sb = new StringBuilder();
        for (int i = maxL; i <= maxR; i++) {
            sb.append(str2[i]);
        }
        System.out.println(sb);
    }
}
