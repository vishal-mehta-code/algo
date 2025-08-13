package searching;

public class SearchInRotatedArrays {

    public static void main(String[] args) {
        int[] nums = {5, 6, 7, 8, 9, 1, 2};
        System.out.println("index is : " + search(nums, 9));
        System.out.println("max is : " + findMax(nums));
        System.out.println("min is : " + findMin(nums));
    }

    private static int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            int m = (l + r) / 2;

            if (nums[m] == target) {
                return m;
            } else if (nums[m] >= nums[l]) {
                if (nums[l] <= target && nums[m] > target) {
                    r = m - 1;
                } else {
                    l = m + 1;
                }
            } else if (nums[m] <= nums[r]) {
                if (nums[r] >= target && nums[m] < target) {
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            }
        }

        return -1;
    }

    private static int findMin(int[] nums) {
        return -1;
    }

    private static int findMax(int[] nums) {
        int l = 0;
        int r = nums.length - 1;

        while (l < r) {
            int m = (l + r) / 2;

            if (m == 0) {
                if (nums[m] <= nums[m + 1]) {
                    return m + 1;
                }
            }
            else if (nums[m - 1] <= nums[m] && nums[m] >= nums[m + 1]) {
                return m;
            } else if (nums[m - 1] <= nums[m]) {
                l = m + 1;
            } else if (nums[m - 1] >= nums[m]) {
                r = m - 1;
            }
        }

        return -1;
    }

}
