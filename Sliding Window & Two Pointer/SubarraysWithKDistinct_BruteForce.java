/*
---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
📌 Problem: Subarrays with K Different Integers
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
- Brute force: generate all subarrays from each starting index and track distinct elements.
- Use a HashMap to count frequencies and break inner loop if distinct count > k.
- Count only subarrays where distinct count == k.

---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
🔎 Approach (Brute Force):
1. Iterate over all starting indices i of the array.
2. For each i, use a HashMap to count frequency of elements in the current subarray.
3. Iterate j from i to n-1:
   - Add nums[j] to the map.
   - If map.size() == k, increment count.
   - If map.size() > k, break the inner loop since any longer subarray will have more than k distinct integers.
4. Return the total count.

---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
⏱️ Complexity:
- Time: O(N^2) in worst case (all subarrays considered).
- Space: O(K) for the HashMap per subarray.

---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
💻 Code (Java):
---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
*/
  class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        int n = nums.length;
        int count = 0;

        for (int i = 0; i < n; i++) {
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int j = i; j < n; j++) {
                map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);
                if (map.size() == k) {
                    count++;
                } else if (map.size() > k) {
                    break;
                }
            }
        }

        return count;
    }
}
