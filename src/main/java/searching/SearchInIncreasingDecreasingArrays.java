package searching;

public class SearchInIncreasingDecreasingArrays {

    public static void main(String[] args) {
        int[] nums1 = {6, 4, 3, 1};
        int[] nums2 = {10, 9, 8, 11, 12, 13};

        System.out.println("pivot in the increasing and decreasing array : " + findPivotInIncreasingDecreasingArray(nums1));

        System.out.println("pivot in the decreasing and increasing array : " + findPivotInDecreasingIncreasingArray(nums2));
    }

    private static int findPivotInDecreasingIncreasingArray(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int m = (l + r) / 2;
            if (m == 0) {
                if (nums[m + 1] < nums[m]) {
                    return nums[m + 1];
                } else {
                    return nums[m];
                }
            }
            if (m == nums.length - 1) {
                if (nums[m - 1] < nums[m]) {
                    return nums[m - 1];
                } else {
                    return nums[m];
                }
            }

            if (nums[m - 1] > nums[m] && nums[m] < nums[m + 1]) {
                return nums[m];
            } else if (nums[m - 1] > nums[m] && nums[m] > nums[m + 1]) {
                l = m + 1;
            } else {
                r = m - 1;
            }


        }
        return -1;
    }

    private static int findPivotInIncreasingDecreasingArray(int[] nums) {
        int l = 0;
        int r = nums.length - 1;

        while (l <= r) {
            int m = (l + r) / 2;

            if (m == 0) {
                if (nums[m + 1] > nums[m]) {
                    return nums[m + 1];
                } else {
                    return nums[m];
                }

            } else if (m == nums.length - 1) {
                if (nums[m - 1] > nums[m]) {
                    return nums[m - 1];
                } else {
                    return nums[m];
                }
            }

            if (nums[m - 1] < nums[m] && nums[m] > nums[m + 1]) {
                return nums[m];
            } else if (nums[m - 1] < nums[m] && nums[m] < nums[m + 1]) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }


        return -1;
    }

}
