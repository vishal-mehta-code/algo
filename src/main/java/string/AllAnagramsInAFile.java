package string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class AllAnagramsInAFile {

    public static void main(String[] args) {
        String[] array = {"thore", "ganamar", "notanagram", "anagram", "other"};

        mapCharactersToPrimeNo();

        printAllAnagrams(array);
    }

    private static Map<Character, Integer> map = new HashMap<>();
    private static Map<Long, List<String>> wordsMap = new HashMap<>();

    // Time O (mn) where let say m being the avarage size of the word and n is the no of words
    // Space O(n) as we need to create a map and list of n words
    private static void printAllAnagrams(String[] array) {
        for (int i = 0; i < array.length; i++) {
            String word = array[i];

            long hash = 1L;
            for (int j = 0; j < word.length(); j++) {
                hash = hash * map.get(word.charAt(j));
            }

            if (null != wordsMap.get(hash)) {
                List<String> anagrams = wordsMap.get(hash);
                anagrams.add(word);
                wordsMap.put(hash, anagrams);
            } else {
                List<String> anagrams = new ArrayList<>();
                anagrams.add(word);
                wordsMap.put(hash, anagrams);
            }
        }

        for (Entry<Long, List<String>> entry : wordsMap.entrySet()) {
            if (entry.getValue().size() > 1) {
                System.out.println(entry.getValue());
            }
        }
    }

    // O(1) space.
    private static void mapCharactersToPrimeNo() {
        // Map of the alphabets and prime factors
        map.put('a', 2);
        map.put('b', 3);
        map.put('c', 5);
        map.put('d', 7);
        map.put('e', 11);
        map.put('f', 13);
        map.put('g', 17);
        map.put('h', 19);
        map.put('i', 23);
        map.put('j', 29);
        map.put('k', 31);
        map.put('l', 37);
        map.put('m', 41);
        map.put('n', 43);
        map.put('o', 47);
        map.put('p', 53);
        map.put('q', 59);
        map.put('r', 61);
        map.put('s', 67);
        map.put('t', 71);
        map.put('u', 73);
        map.put('v', 79);
        map.put('w', 83);
        map.put('x', 89);
        map.put('y', 97);
        map.put('z', 101);
    }

}
