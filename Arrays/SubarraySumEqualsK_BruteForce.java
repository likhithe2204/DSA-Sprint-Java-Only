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
- We want to find the number of subarrays that add up to exactly `k`.  
- Brute force way:  
  - Try every possible subarray by fixing start index `i`.  
  - Expand end index `j` and maintain running sum.  
  - If sum == k, increase count.  

---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
🔎 Approach (Brute Force):
1. Iterate over all start positions `i`.  
2. For each start, expand end `j` and maintain a running sum.  
3. Whenever running sum equals `k`, increment the count.  

---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
⏱️ Complexity:
- Time: O(N²) → double loop for all subarrays.  
- Space: O(1) → only sum + counter.  

---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
💻 Code (Java):
---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
*/

class Solution {
    public int subarraySum(int[] nums, int k) {
        // Brute force Approach : ✅

        int n = nums.length;
        int cnt = 0;

        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += nums[j];
                if (sum == k)
                    cnt++;
            }
        }

        return cnt;
    }
}

