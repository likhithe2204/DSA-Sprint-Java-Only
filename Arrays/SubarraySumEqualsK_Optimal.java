/*
---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
📌 Problem: 560. Subarray Sum Equals K
---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
🚩 Statement:
Given an array of integers `nums` and an integer `k`, return the total number of subarrays whose sum equals `k`.  
A subarray is a contiguous non-empty sequence of elements within an array.

---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
📥 Input/Output:

Example 1:  
Input: nums = [1,1,1], k = 2  
Output: 2  

Example 2:  
Input: nums = [1,2,3], k = 3  
Output: 2  

Constraints:  
1 <= nums.length <= 2 * 10^4  
-1000 <= nums[i] <= 1000  
-10^7 <= k <= 10^7  

---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
💡 Intuition:
- Maintain a **running prefix sum** as we traverse the array.  
- If the current prefix sum is `S`, and we want subarray sum = `k`, then we look for how many times `(S - k)` has already appeared.  
- Store prefix sums and their frequencies in a hashmap for constant-time lookup.  

---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
🔎 Approach (Optimal - Prefix Sum + HashMap):
1. Initialize a hashmap `map<prefixSum, count>`.  
2. Put `(0, 1)` in the map to handle subarrays starting from index 0.  
3. Traverse the array, adding each number to `currentPrefixSum`.  
4. Compute `sum = currentPrefixSum - k`.  
   - If `sum` exists in the map, add its frequency to the answer.  
5. Update the frequency of `currentPrefixSum` in the map.  
6. Return the count of valid subarrays.  

---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
⏱️ Complexity:
- Time: O(N) → one pass over the array.  
- Space: O(N) → hashmap stores prefix sums.  

---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
💻 Code (Java):
---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
*/

class Solution {
    public int subarraySum(int[] nums, int k) {
        // Optimal Approach : Prefix Sum + Hashing ✅

        int n = nums.length;
        int currentPrefixSum = 0;
        int subarrayCount = 0;
        HashMap<Integer, Integer> map = new HashMap<>(); // map<prefixSum, cnt>
        map.put(0, 1); // Set 0th element in the element with count 1

        for (int i = 0; i < n; i++) {
            currentPrefixSum += nums[i];

            // Look for how many prefix sums equal to currentPrefixSum - k
            int sum = currentPrefixSum - k;
            subarrayCount += map.getOrDefault(sum, 0);

            // Update the count of currentPrefixSum in the map
            map.put(currentPrefixSum, map.getOrDefault(currentPrefixSum, 0) + 1);
        }

        return subarrayCount;
    }
}

