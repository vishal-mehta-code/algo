package searching;

public class SearchInRotatedArrays {

    public static void main(String[] args) {
        int[] nums = {5, 6, 7, 8, 0, 1, 2};
        System.out.println("index is : " + search(nums, 8));
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
        int l = 0;
        int r = nums.length - 1;
        int result = nums[0];

        while (l <= r) {
            if (nums[l] < nums[r]) {
                return nums[l];
            }

            int m = (l + r) / 2;
            result = Math.min(result, nums[m]);

            if (nums[l] < nums[m]) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }

        return result;
    }

    private static int findMax(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        int result = nums[r];

        while (l <= r) {
            if (nums[l] < nums[r]) {
                return nums[r];
            }

            int m = (l + r) / 2;
            result = Math.max(result, nums[m]);

            if (nums[l] < nums[m]) {
                l = m;
            } else {
                r = m-1;
            }
        }

        return result;
    }

}
