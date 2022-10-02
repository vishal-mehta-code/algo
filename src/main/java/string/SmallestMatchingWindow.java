package string;

public class SmallestMatchingWindow {

    private static final int MAX_CHARS = 256;

    public static void main(String[] args) {
        String str1 = "tist";
        String str2 = "this is a test string";
        findMinMatchingWindow(str1.toCharArray(), str2.toCharArray());
    }

    private static void findMinMatchingWindow(char[] str1, char[] str2) {
        int[] count1 = new int[MAX_CHARS];

        for (char current : str1) {
            ++count1[current];
        }

        int start = 0;
        int min = Integer.MAX_VALUE;
        int[] count2 = new int[MAX_CHARS];
        for (int i = 0; i < str2.length; i++) {
            ++count2[str2[i]];

            if (i >= str1.length - 1) {

                boolean isFound = isFound(count1, count2);

                if (isFound) {
                    while (start <= i - str1.length) {
                        --count2[str2[start]];

                        if (isFound(count1, count2)) {
                            start = start + 1;
                        } else {
                            ++count2[str2[start]];
                            break;
                        }
                    }

                    if (i - start < min) {
                        min = i - start;
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = start; i <= start + min; i++) {
            sb.append(str2[i]);
        }

        System.out.println("min window is : " + sb.toString());
    }

    private static boolean isFound(int[] count1, int[] count2) {
        for (int i = 0; i < MAX_CHARS; i++) {
            if (count1[i] > 0 && count2[i] < count1[i]) {
                return false;
            }
        }
        return true;
    }

}
