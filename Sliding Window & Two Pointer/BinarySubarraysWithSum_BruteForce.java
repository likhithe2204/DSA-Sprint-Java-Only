/*
---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
📌 Problem: 930. Binary Subarrays With Sum
---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
🚩 Statement:
Given a binary array `nums` and an integer `goal`, return the number of non-empty subarrays with a sum equal to `goal`.  
A subarray is a contiguous part of the array.

---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
📥 Input/Output:

Example 1:
Input: nums = [1,0,1,0,1], goal = 2  
Output: 4  
Explanation: The subarrays with sum 2 are:  
[1,0,1], [0,1,0,1], [1,0,1,0], [1,0,1]  

Example 2:
Input: nums = [0,0,0,0,0], goal = 0  
Output: 15  

Constraints:
1 <= nums.length <= 3 * 10^4  
nums[i] is either 0 or 1.  
0 <= goal <= nums.length  

---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
💡 Intuition:
- We need to count how many subarrays sum up exactly to `goal`.  
- Brute force way:  
  - Fix the starting point `i`.  
  - Expand the ending point `j`.  
  - Track sum of `nums[i..j]`.  
  - If sum == goal → increment count.  

---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
🔎 Approach (Brute Force):
1. Iterate over all possible subarray start indices `i`.  
2. For each `i`, expand the end index `j`.  
3. Keep track of running sum while expanding.  
4. If running sum equals `goal`, increment count.  

---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
⏱️ Complexity:
- Time: O(N²) → two nested loops.  
- Space: O(1) → only counters and running sum.  

---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
💻 Code (Java):
---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
*/

class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        // Brute-force Approach : Generate all possible subarrays ✅

        int n = nums.length;
        int cnt = 0;

        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += nums[j];
                if (sum == goal)
                    cnt++;
            }
        }

        return cnt;
    }
}

