/*
------------------------------------------------------------------------------------------------------------------------------------------------------
Problem: Count Number of Nice Subarrays
------------------------------------------------------------------------------------------------------------------------------------------------------
Statement:
Given an array nums and an integer k.  
An array is called nice if and only if it contains k odd numbers.  
Find the number of nice subarrays in the given array nums.  

A subarray is a continuous part of the array.  

------------------------------------------------------------------------------------------------------------------------------------------------------
Input / Output:
Example 1:
Input: nums = [1, 1, 2, 1, 1], k = 3  
Output: 2  
Explanation: The subarrays with three odd numbers are [1,1,2,1] and [1,2,1,1].  

Example 2:
Input: nums = [4, 8, 2], k = 1  
Output: 0  

Example 3:
Input: nums = [41, 3, 5], k = 2  
Output: 1  

Constraints:
1 <= nums.length <= 5 * 10^4  
1 <= nums[i] <= 10^5  
1 <= k <= nums.length  

------------------------------------------------------------------------------------------------------------------------------------------------------
Intuition:
We need to count subarrays containing exactly `k` odd numbers.  
A simple brute force approach is to generate all possible subarrays, count how many odds each has, and increment the result if it equals `k`.  

------------------------------------------------------------------------------------------------------------------------------------------------------
Approach:
1. Iterate over all possible starting indices `i`.  
2. For each start, expand subarray to the right (`j`).  
3. Keep a counter for odd numbers in the current subarray.  
4. If the counter equals `k`, increment the answer.  

------------------------------------------------------------------------------------------------------------------------------------------------------
Complexity:
Time: O(N^2) — since we check all possible subarrays.  
Space: O(1) — only counters used.  

------------------------------------------------------------------------------------------------------------------------------------------------------
Code:
*/
class Solution {
    public int numberOfOddSubarrays(int[] nums, int k) {
        // Brute force Approach : Generate all possible subarrays ✅

        long n = nums.length;
        long cnt = 0;
        for (int i = 0; i < n; i++) {
            long tracker = 0;
            for (int j = i; j < n; j++) {

                if (nums[j] % 2 == 1)
                    tracker++;

                if (tracker == k)
                    cnt++;
            }
        }
        return (int)cnt;
    }
}

