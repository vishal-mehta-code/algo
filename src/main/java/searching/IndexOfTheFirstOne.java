package searching;

public class IndexOfTheFirstOne {

    public static void main(String[] args) {
        int[] nums = {0, 0, 0, 1, 1, 1, 1, 1};
        System.out.println("index is : " + search(nums));
    }

    private static int search(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            int m = (l + r) / 2;
            if (nums[m] == 1) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        return l;
    }
}
