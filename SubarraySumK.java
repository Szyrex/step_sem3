import java.util.HashMap;

public class SubarraySumK {

    static int subarraySum(int[] nums, int k) {

        HashMap<Integer, Integer> prefixSumFrequency =
                new HashMap<>();

        // Empty prefix
        prefixSumFrequency.put(0, 1);

        int currentSum = 0;
        int count = 0;

        for (int i = 0; i < nums.length; i++) {

            currentSum += nums[i];

            // Check whether currentSum - k appeared before
            int requiredSum = currentSum - k;

            if (prefixSumFrequency.containsKey(requiredSum)) {

                count += prefixSumFrequency.get(requiredSum);
            }

            // Store/update current prefix sum
            prefixSumFrequency.put(
                currentSum,
                prefixSumFrequency.getOrDefault(currentSum, 0) + 1
            );
        }

        return count;
    }

    public static void main(String[] args) {

        int[] nums = {1, 1, 1};
        int k = 2;

        int result = subarraySum(nums, k);

        System.out.println(
            "Number of subarrays = " + result
        );
    }
}