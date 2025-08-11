package searching;

public class LowerAndUpperBounds {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 5, 6, 9};
        int target = 3;
        int lower_bound = getLowerBounds(nums, target);
        System.out.println(lower_bound);

        int upper_bound = getUpperBounds(nums, target);
        System.out.println(upper_bound);
    }

    private static int getLowerBounds(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;

        while (l < r) {
            int m = (l + r) / 2;

            if (nums[m] > target) {
                r = m - 1;
            } else if (nums[m] < target) {
                l = m + 1;
            } else {
                r = m;
            }
        }

        return nums[l] == target ? l : -1;
    }

    private static int getUpperBounds(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;

        while (l < r) {
            int m = ((l + r) / 2) + 1;

            if (nums[m] < target) {
                l = m + 1;
            } else if (nums[m] == target) {
                l = m;
            } else {
                r = m - 1;
            }
        }

        return nums[r] == target ? r : -1;
    }
}
