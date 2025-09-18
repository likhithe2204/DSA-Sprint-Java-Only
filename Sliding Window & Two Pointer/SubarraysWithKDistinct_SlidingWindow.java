/*
---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
📌 Problem: Subarrays with K Different Integers (Optimal)
---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
🚩 Statement:
Given an integer array `nums` and an integer `k`, return the number of **good subarrays** of `nums`.  
A good array is a contiguous subarray where the number of **different integers** is exactly `k`.

---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
📥 Input/Output:

Example 1:
Input: nums = [1,2,1,2,3], k = 2
Output: 7
Explanation: Subarrays formed with exactly 2 different integers: [1,2], [2,1], [1,2], [2,3], [1,2,1], [2,1,2], [1,2,1,2]

Example 2:
Input: nums = [1,2,1,3,4], k = 3
Output: 3
Explanation: Subarrays formed with exactly 3 different integers: [1,2,1,3], [2,1,3], [1,3,4]

Constraints:
1 <= nums.length <= 2 * 10^4
1 <= nums[i], k <= nums.length

---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
💡 Intuition:
- Number of subarrays with exactly `k` distinct =  
  Number of subarrays with ≤ `k` distinct − Number of subarrays with ≤ `k-1` distinct  
- Use sliding window + hashmap to efficiently count subarrays with ≤ K distinct elements.

---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
🔎 Approach (Sliding Window Optimal):
1. Define a helper function to count subarrays with **at most K distinct integers**:
   - Initialize two pointers `l` and `r` for the window and a HashMap for element counts.
   - Expand the right pointer `r`, adding elements to the map.
   - If map.size() > K, shrink the left pointer `l` until map.size() ≤ K.
   - Count subarrays ending at `r` as `(r - l + 1)` and accumulate.
2. Return `subarraysWithAtMostK(nums, k) - subarraysWithAtMostK(nums, k - 1)`.

---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
⏱️ Complexity:
- Time: O(N) — each element is added and removed at most once.
- Space: O(K) — for the HashMap storing element counts.

---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
💻 Code (Java):
---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
*/
  class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return subarraysWithAtMostK(nums, k) - subarraysWithAtMostK(nums, k - 1);
    }

    private int subarraysWithAtMostK(int[] nums, int k) {
        if (k <= 0) return 0;

        int n = nums.length;
        int l = 0, count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int r = 0; r < n; r++) {
            map.put(nums[r], map.getOrDefault(nums[r], 0) + 1);

            while (map.size() > k) {
                map.put(nums[l], map.get(nums[l]) - 1);
                if (map.get(nums[l]) == 0) map.remove(nums[l]);
                l++;
            }

            count += (r - l + 1);
        }

        return count;
    }
}

