/*
------------------------------------------------------------------------------------------------------------------------------------------------------
Problem: 930. Binary Subarrays With Sum
------------------------------------------------------------------------------------------------------------------------------------------------------
Statement:
Given a binary array nums and an integer goal, return the number of non-empty subarrays with sum equal to goal.  
A subarray is a contiguous part of the array.  

------------------------------------------------------------------------------------------------------------------------------------------------------
Input / Output:
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

------------------------------------------------------------------------------------------------------------------------------------------------------
Intuition:
The problem asks us to count subarrays whose sum equals `goal`.  
Instead of checking all subarrays (brute force), we can use the **sliding window technique** for subarrays with at most a given sum.  
The trick:  
Count(subarrays with sum ≤ goal) – Count(subarrays with sum ≤ goal-1) = Count(subarrays with sum = goal).  

------------------------------------------------------------------------------------------------------------------------------------------------------
Approach:
1. Use two pointers (`l` and `r`) to maintain a sliding window sum.  
2. Count the number of subarrays with sum ≤ `goal`.  
3. Repeat for `goal-1`.  
4. Subtract results to get the exact count.  

------------------------------------------------------------------------------------------------------------------------------------------------------
Complexity:
Time: O(N) — each element is processed at most twice.  
Space: O(1) — constant extra variables.  

------------------------------------------------------------------------------------------------------------------------------------------------------
Code:
*/
class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        return numSubarraysWithSumLessThanEqualtoK(nums, goal) - numSubarraysWithSumLessThanEqualtoK(nums, goal - 1);
    }

    public int numSubarraysWithSumLessThanEqualtoK(int[] nums, int goal) {
        // Most Optimal Approach : Sliding Window + 2 Pointers ✅

        if (goal < 0)
            return 0; // edge case

        int n = nums.length;
        int l = 0, sum = 0, cnt = 0;

        for (int r = 0; r < n; r++) {
            sum += nums[r];
            if (sum > goal) {
                while (sum > goal) {
                    sum -= nums[l];
                    l++;
                }
            }
            cnt += (r - l + 1);
        }

        return cnt;
    }
}

