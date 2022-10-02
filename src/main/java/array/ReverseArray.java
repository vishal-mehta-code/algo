package array;

import java.util.Arrays;

public class ReverseArray {
    private static int[] a = {1, 2, 3, 4, 5, 6};

    public static void main(String[] args) {
        reverseArray(0, a.length - 1);
        System.out.println("reverse array is : " + Arrays.toString(a));

    }

    private static void reverseArray(int start, int end) {

        if (start >= end)
            return;

        swap(start, end);
        reverseArray(start + 1, end - 1);
    }

    private static void swap(int start, int end) {
        int tmp = a[start];
        a[start] = a[end];
        a[end] = tmp;
    }

}
