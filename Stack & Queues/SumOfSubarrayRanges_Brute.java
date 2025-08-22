/*
------------------------------------------------------------------------------------------------------------------------------------------------------------
🪐 Problem: 2104. Sum of Subarray Ranges
Platform: LeetCode
Difficulty: Medium
Tags: Array, Brute Force
------------------------------------------------------------------------------------------------------------------------------------------------------------

📘 Problem Statement:
You are given an integer array `nums`.
The range of a subarray = (maximum element - minimum element).
Return the sum of all subarray ranges of nums.

------------------------------------------------------------------------------------------------------------------------------------------------------------
💡 Example 1:
Input: nums = [1,2,3]
Output: 4
Explanation: Subarrays = 
[1] → max-min=0  
[2] → 0  
[3] → 0  
[1,2] → 2-1=1  
[2,3] → 3-2=1  
[1,2,3] → 3-1=2  
Total = 4

💡 Example 2:
Input: nums = [1,3,3]
Output: 4

------------------------------------------------------------------------------------------------------------------------------------------------------------
🧠 Intuition:
- For every possible subarray, calculate its max and min.
- Add (max - min) to the result.
- Brute-force because we check all possible subarrays.

------------------------------------------------------------------------------------------------------------------------------------------------------------
📝 Approach (Brute-Force):
1. Loop over all subarrays using two pointers (i, j).
2. For each subarray, maintain `minVal` and `maxVal`.
3. Update result += (maxVal - minVal).
4. Return the result.

------------------------------------------------------------------------------------------------------------------------------------------------------------
⏱ Complexity:
- Time: O(n^2) → Checking all subarrays.
- Space: O(1) → Only variables for min, max, sum.

------------------------------------------------------------------------------------------------------------------------------------------------------------
✅ Code (Brute Force):
*/

class Solution {
    public long subArrayRanges(int[] nums) {
        // Brute-Force Approach: 
        //                      - check all subarrays ✅

        int n = nums.length;
        long sum = 0;

        for (int i = 0; i < n; i++) {
            int minVal = nums[i];
            int maxVal = nums[i];

            for (int j = i; j < n; j++) {
                minVal = Math.min(minVal, nums[j]);
                maxVal = Math.max(maxVal, nums[j]);
                sum += (maxVal - minVal);
            }
        }

        return sum;
    }
}
