package searching;

public class MissingNoInAP {
    private static int[] arr = {1, 3, 5, 7, 11};
    private static int diff = 0;

    public static void main(String[] args) {
        if (arr.length < 3) {
            System.out.println("missing no. cant be found");
            return;
        }
        diff = (arr[arr.length - 1] - arr[0]) / arr.length;
        System.out.println(missinNoInAP(0, arr.length - 1));
    }

    private static int missinNoInAP(int start, int end) {
        if (start < end) {

            if (start + 1 == end) {
                return arr[start] + diff;
            }

            int mid = start + (end - start) / 2;

            if (arr[mid] == arr[0] + mid * diff) {
                if (arr[mid + 1] > arr[mid] + diff) {
                    return arr[mid] + diff;
                }

                return missinNoInAP(mid + 1, end);
            } else {
                if (arr[mid - 1] < arr[mid] - diff) {
                    return arr[mid] - diff;
                }

                return missinNoInAP(start, mid - 1);
            }
        }

        return -1;
    }
}
