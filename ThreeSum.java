import java.util.Arrays;

public class ThreeSum {

    static int[][] threeSum(int[] nums) {

        Arrays.sort(nums);

        int n = nums.length;

        // Maximum possible number of triplets
        int[][] temp = new int[n * n][3];

        int count = 0;

        for (int i = 0; i < n - 2; i++) {

            // Skip duplicate first elements
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = n - 1;

            while (left < right) {

                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {

                    temp[count][0] = nums[i];
                    temp[count][1] = nums[left];
                    temp[count][2] = nums[right];

                    count++;

                    left++;
                    right--;

                    // Skip duplicates
                    while (left < right &&
                           nums[left] == nums[left - 1]) {
                        left++;
                    }

                    while (left < right &&
                           nums[right] == nums[right + 1]) {
                        right--;
                    }

                } else if (sum < 0) {

                    left++;

                } else {

                    right--;
                }
            }
        }

        // Create result array with exact size
        int[][] result = new int[count][3];

        for (int i = 0; i < count; i++) {
            result[i][0] = temp[i][0];
            result[i][1] = temp[i][1];
            result[i][2] = temp[i][2];
        }

        return result;
    }

    public static void main(String[] args) {

        int[] nums = {-1, 0, 1, 2, -1, -4};

        int[][] result = threeSum(nums);

        System.out.println("Triplets:");

        for (int i = 0; i < result.length; i++) {

            System.out.println(
                "[" + result[i][0] + ", " +
                result[i][1] + ", " +
                result[i][2] + "]"
            );
        }
    }
}