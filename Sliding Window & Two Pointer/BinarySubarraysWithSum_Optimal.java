/*
---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
📌 Problem: 930. Binary Subarrays With Sum
---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
🚩 Statement:
Given a binary array `nums` and an integer `goal`, return the number of non-empty subarrays with a sum equal to `goal`.  
A subarray is a contiguous non-empty sequence of elements within an array.

---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
📥 Input/Output:

Example 1:  
Input: nums = [1,0,1,0,1], goal = 2  
Output: 4  

Example 2:  
Input: nums = [0,0,0,0,0], goal = 0  
Output: 15  

Constraints:  
1 <= nums.length <= 3 * 10^4  
nums[i] is either 0 or 1.  
0 <= goal <= nums.length  

---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
💡 Intuition:
- We want to count subarrays where the sum equals `goal`.  
- Brute force = check all subarrays → O(N²). Too slow for `3 * 10^4`.  
- Optimal trick: Use **prefix sums** + **hash map**.  
  - Maintain a running prefix sum.  
  - If `currentPrefixSum - goal` has appeared before, it means a subarray ending at current index sums to `goal`.  

---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
🔎 Approach (Optimal – Prefix Sum + Hashing):
1. Initialize `currentPrefixSum = 0` and `subarrayCount = 0`.  
2. Store base case in map: `{0 → 1}` (empty prefix).  
3. Traverse array:  
   - Update prefix sum with current element.  
   - Compute `sumToRemove = currentPrefixSum - goal`.  
   - If `sumToRemove` exists in map, add its frequency to `subarrayCount`.  
   - Update frequency of `currentPrefixSum` in map.  
4. Return `subarrayCount`.  

---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
⏱️ Complexity:
- Time: O(N) → single pass with HashMap lookups.  
- Space: O(N) → hash map stores prefix sums.  

---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
💻 Code (Java):
---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
*/

class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        // Optimal Approach : Prefix Sum + Hashing ✅

        int n = nums.length;
        int currentPrefixSum = 0;
        int subarrayCount = 0;
        HashMap<Integer, Integer> map = new HashMap<>(); // map<prefixSum, cnt>

        map.put(0, 1); // setting 0 in the map

        for (int i = 0; i < n; i++) {
            currentPrefixSum += nums[i];
            int sumToRemove = currentPrefixSum - goal;
            subarrayCount += map.getOrDefault(sumToRemove, 0);
            map.put(currentPrefixSum, map.getOrDefault(currentPrefixSum, 0) + 1);
        }

        return subarrayCount;
    }
}

