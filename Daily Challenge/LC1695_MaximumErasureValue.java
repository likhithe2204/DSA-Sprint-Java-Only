// ✅ Leetcode 1695. Maximum Erasure Value
// ✅ Brute-Force Approach | TLE for large inputs

class Solution {
    public int maximumUniqueSubarray(int[] nums) {

        // Task : Find the maximum sum of a subarray containing only unique elements
        
        int n = nums.length;
        int max = 0;

        // Explore all possible subarrays
        for (int i = 0; i < n; i++) {
            int sum = 0; // Reset sum for each new subarray starting at i
            HashSet<Integer> set = new HashSet<>(); // Track unique elements

            for (int j = i; j < n; j++) {
                if (set.contains(nums[j])) break; // Duplicate found, stop

                // Add unique element to set and sum
                set.add(nums[j]);
                sum += nums[j];

                // Update maximum sum
                max = Math.max(max, sum);
            }
        }

        return max;
    }
}
