public class FindMinimumRotatedArray {

    static int findMin(int[] nums) {

        int left = 0;
        int right = nums.length - 1;

        while (left < right) {

            int mid = left + (right - left) / 2;

            // If middle element is greater than the
            // rightmost element, minimum is on the right
            if (nums[mid] > nums[right]) {

                left = mid + 1;

            } else {

                // Minimum is at mid or on the left
                right = mid;
            }
        }

        return nums[left];
    }

    public static void main(String[] args) {

        int[] nums = {3, 4, 5, 1, 2};

        int result = findMin(nums);

        System.out.println(
            "Minimum element = " + result
        );
    }
}