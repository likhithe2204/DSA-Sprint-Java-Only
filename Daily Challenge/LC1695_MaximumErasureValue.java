## 1695. Maximum Erasure Value (LeetCode - Medium)
/*
✅ Problem: Maximum Erasure Value (LeetCode - 1695 - Medium)

📝 Problem Statement:
You are given an array of positive integers `nums` and want to erase a subarray containing only unique elements. 
The score of that subarray is the sum of its elements.
Return the **maximum score** possible by erasing exactly one subarray.

An array `b` is a subarray of `a` if it forms a contiguous subsequence of `a`.

🔸 Example 1:
Input: nums = [4,2,4,5,6]
Output: 17

🔸 Example 2:
Input: nums = [5,2,1,2,5,2,1,2,5]
Output: 8

🔹 Constraints:
- 1 <= nums.length <= 10^5
- 1 <= nums[i] <= 10^4

🔍 Approach:
- Brute force each subarray from i to j.
- Check for duplicates using HashSet.
- Track max sum of subarray with unique elements.

🧠 Time Complexity: O(n^2)
🧠 Space Complexity: O(n)
*/

class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        // Brute-Force Approach : TLE
        // Explore all possible subarrays with unique elements 
        // and keep a track of sum and max for each subarray✅

        int n = nums.length;
        int max = 0;

        for (int i = 0; i < nums.length; i++) {
            int sum = 0; // Resest for every new i
            // Ensure that you take a HashSet too ! {* to remove duplicates if any *}
            HashSet<Integer> set = new HashSet<>();
            
            // For every i go through each and every possibile subarray
            for (int j = i; j < nums.length; j++) {
                // Ensure there are no duplicates 
                if (set.contains(nums[j]))
                    break;

                // Otherwise 

                // ✅ Add that new Element into the subarray
                set.add(nums[j]);
                // ✅ Keep a track of sum
                sum += nums[j];
                // ✅ Also keep a track of max
                max = Math.max(max, sum);
            }
        }
        return max;
    }
}
