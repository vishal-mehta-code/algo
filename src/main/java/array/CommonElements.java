package array;

public class CommonElements {

    private static int[] ar1 = {1, 5, 10, 20, 30, 120};
    private static int[] ar2 = {6, 7, 20, 20, 30, 120};
    private static int[] ar3 = {3, 4, 15, 20, 30, 70, 80, 120};

    public static void main(String[] args) {
        findCommonElements();
    }

    private static void findCommonElements() {
        int i = 0, j = 0, k = 0;
        while (i < ar1.length && j < ar2.length && k < ar3.length) {
            if ((ar1[i] == ar2[j]) && (ar1[i] == ar3[k])) {
                System.out.println("common element is : " + ar1[i]);
                i++;
                j++;
                k++;
            } else if (ar1[i] < ar2[j])
                i++;
            else if (ar2[j] < ar3[k])
                j++;
            else
                k++;
        }
    }
}
