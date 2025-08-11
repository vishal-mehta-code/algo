package searching;

public class BinarySearch {
    public static void main(String[] args) {
        int[] nums = {1, 3};
        int target = 5;
        int index = binSearch(nums, target);
        System.out.println("index : " + index);
    }

    private static int binSearch(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;

        while (l < r) {
            int m = (l + r) / 2;
            if (nums[m] == target) {
                return m;
            } else if (nums[m] > target) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return -1;
    }
}
