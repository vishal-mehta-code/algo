package string;

public class AnagramPatternSearch {

    public static void main(String[] args) {
        String word = "AAABABAA";
        String ptrn = "AABA";

        search(ptrn.toCharArray(), word.toCharArray());
    }

    private static int[] p = new int[256];
    private static int[] w = new int[256];

    private static void search(char[] ptrn, char[] word) {
        // populate pattern ASCII array
        for (int i = 0; i < ptrn.length; i++) {
            p[ptrn[i]]++;
        }

        for (int i = 0; i < word.length; i++) {
            if (i < ptrn.length - 1) {
                w[word[i]]++;
            } else if (i == ptrn.length - 1) {
                w[word[i]]++;
                boolean anagram = compare();
                if (anagram) {
                    System.out.println("found index : " + (i - ptrn.length + 1));
                }
            } else {
                w[word[i - ptrn.length]]--;
                w[word[i]]++;
                boolean anagram = compare();
                if (anagram) {
                    System.out.println("found index : " + (i - ptrn.length + 1));
                }
            }
        }
    }

    private static boolean compare() {
        for (int i = 0; i < 256; i++) {
            if (p[i] != w[i]) {
                return false;
            }
        }
        return true;
    }
}
