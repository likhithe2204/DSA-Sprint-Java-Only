/*
---------------------------------------------------------------------------------------------------------------------------------------

🔥 Problem: Next Greater Element II
- Platform: LeetCode, Tuf+, GFG, Naukri
- Category: Arrays / Brute-Force
- Difficulty: Medium
---------------------------------------------------------------------------------------------------------------------------------------

📝 Problem Statement:
Given a circular integer array nums, for each element find the Next Greater Element (NGE). 
The NGE is the first greater element to the right in circular order, else -1.
---------------------------------------------------------------------------------------------------------------------------------------

💡 Intuition:
For each element, check the right side first. If no greater element is found, 
wrap around and check from the start up to current index. 
Brute-force but straightforward.
---------------------------------------------------------------------------------------------------------------------------------------

🚀 Approach:
1. For each element nums[i], search for a greater element in nums[i+1...n-1].
2. If not found, search in nums[0...i-1] to simulate circularity.
3. If still not found, store -1.
4. Return result array.
---------------------------------------------------------------------------------------------------------------------------------------

⏱️ Complexity:
- Time: O(n^2) → nested loops
- Space: O(n) → output array
---------------------------------------------------------------------------------------------------------------------------------------
*/

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        // Brute-Force Approach: ✅
        int n = nums.length;
        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {
            int nextGreater = -1;
            // Step 1: search to the right
            for (int j = i + 1; j < n; j++) {
                if (nums[j] > nums[i]) {
                    nextGreater = nums[j];
                    break;
                }
            }
            // Step 2: wrap around if not found
            if (nextGreater == -1) {
                for (int j = 0; j < i; j++) {
                    if (nums[j] > nums[i]) {
                        nextGreater = nums[j];
                        break;
                    }
                }
            }
            ans[i] = nextGreater;
        }
        return ans;
    }
}
