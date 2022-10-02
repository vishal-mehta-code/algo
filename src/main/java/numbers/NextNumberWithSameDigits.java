package numbers;

import java.util.Arrays;

public class NextNumberWithSameDigits {

    public static void main(String[] args) {
        int[] array = {5, 3, 4, 9, 7, 6};

        int lastelement = array[array.length - 1];

        int smallindex = lastelement;
        for (int i = array.length - 2; i >= 0; i--) {
            if (array[i] < lastelement) {
                smallindex = i;
                break;
            }
        }

        if (smallindex == lastelement) {
            System.out.println("no sol exist");
        }

        swap(array, array.length - 1, smallindex);

        sort(array, smallindex + 1, array.length - 1);

        System.out.println(Arrays.toString(array));
    }

    private static void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    private static void sort(int[] array, int start, int end) {
        if (start < end) {
            int p = partion(array, start, end);
            sort(array, start, p - 1);
            sort(array, p + 1, end);
        }
    }

    private static int partion(int[] array, int start, int end) {
        int x = array[end];
        int i = start - 1;
        for (int j = start; j < end; j++) {
            if (array[j] <= x) {
                i++;
                swap(array, i, j);
            }
        }
        swap(array, i + 1, end);
        return i + 1;
    }
}
