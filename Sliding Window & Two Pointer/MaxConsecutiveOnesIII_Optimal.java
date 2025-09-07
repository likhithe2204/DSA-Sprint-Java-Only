/*  
---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
📌 Problem: Max Consecutive Ones III
---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
🚩 Statement:  
You are given a binary array `nums` and an integer `k`.  
You can flip at most `k` zeroes to ones.   
Return the **maximum number of consecutive 1's** after performing the flipping operation.  

---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
📥 Input/Output:  

Example 1:  
Input: nums = [1,1,1,0,0,0,1,1,1,1,0], k = 3  
Output: 10  
Explanation: Flip 0’s at indices 3,4,5 → array becomes all 1’s except last element → longest streak = 10.  

Example 2:  
Input: nums = [0,0,1,1,1,0,1,1,1,0,0,0,0,1,1,1,1], k = 3  
Output: 9  
Explanation: After optimal flips, longest sequence of consecutive 1’s is 9.  

Example 3:  
Input: nums = [1,1,0,0,1], k = 3  
Output: 5  

Constraints:  
- 1 ≤ nums.length ≤ 10⁵  
- nums[i] ∈ {0,1}  
- 0 ≤ k ≤ nums.length  

---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
💡 Intuition:  
We want the longest subarray containing at most `k` zeroes.  
→ Use **sliding window** with two pointers.  
→ Expand with right pointer, count zeros.  
→ If zeroes exceed k, shrink window from the left.  
→ Keep track of the max window length.  

---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
🔎 Approach:  
1. Initialize two pointers `l=0`, `r=0`.  
2. Expand the window with `r`.  
3. If a `0` is added, increment zero count.  
4. If zero count exceeds `k`, shrink from the left until it’s valid again.  
5. Update maximum length while iterating.  

---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
⏱️ Complexity:  
- Time: O(n) → each element is processed at most twice.  
- Space: O(1).  

---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
💻 Code (Java):
---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
*/

class Solution {
    public int longestOnes(int[] nums, int k) {
        // Sliding Window + Two Pointers ✅

        int n = nums.length;
        int l = 0, maxLen = 0, zeroes = 0;

        // Expand the window with right pointer
        for (int r = 0; r < n; r++) {
            if (nums[r] == 0) zeroes++;

            // Shrink window until zeroes <= k
            while (zeroes > k) {
                if (nums[l] == 0) zeroes--;
                l++;
            }

            // Update maximum window length
            maxLen = Math.max(maxLen, r - l + 1);
        }
        return maxLen;
    }
}
