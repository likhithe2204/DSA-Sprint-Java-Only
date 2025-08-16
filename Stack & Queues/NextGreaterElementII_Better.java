/*
---------------------------------------------------------------------------------------------------------------------------------------

🔥 Problem: Next Greater Element II
- Platform: LeetCode, Tuf+, GFG, Naukri.
- Category: Arrays / Better Approach
- Difficulty: Medium
---------------------------------------------------------------------------------------------------------------------------------------

📝 Problem Statement:
Given a circular integer array nums, for each element find the Next Greater Element (NGE). 
The NGE is the first greater element to the right in circular order, else -1.
---------------------------------------------------------------------------------------------------------------------------------------

💡 Intuition:
Since the array is circular, imagine it as doubled. 
For each element, check the next (n-1) elements using modulo to wrap around.
---------------------------------------------------------------------------------------------------------------------------------------

🚀 Approach:
1. For each nums[i], look ahead in range (i+1...i+n-1).
2. Use modulo (j % n) to wrap indices back to start.
3. If a greater element is found, store it and break.
4. If none found, store -1.
5. Return result array.
---------------------------------------------------------------------------------------------------------------------------------------

⏱️ Complexity:
- Time: O(n^2) → for each element, may scan up to n others
- Space: O(n) → output array
---------------------------------------------------------------------------------------------------------------------------------------
*/


class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] nge = new int[n];

        for (int i = 0; i < n; i++) {
            int nextGreater = -1;
            for (int j = i + 1; j < i + n; j++) {
                int ind = j % n;
                if (nums[ind] > nums[i]) {
                    nextGreater = nums[ind];
                    break;
                }
            }
            nge[i] = nextGreater;
        }
        return nge;
    }
}
