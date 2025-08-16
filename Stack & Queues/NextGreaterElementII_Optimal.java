/*
---------------------------------------------------------------------------------------------------------------------------------------

🔥 Problem: Next Greater Element II
- Platform: LeetCode, GFG, Tuf+, Naukri 
- Category: Arrays / Monotonic Stack
- Difficulty: Medium
---------------------------------------------------------------------------------------------------------------------------------------

📝 Problem Statement:
Given a circular integer array nums, for each element find the Next Greater Element (NGE). 
The NGE is the first greater element to the right in circular order, else -1.
---------------------------------------------------------------------------------------------------------------------------------------

💡 Intuition:
Think of the array as doubled (to handle circularity).  
Traverse from right → left while maintaining a stack of "potential next greater" elements.  
For each index, the top of the stack (if exists) is the next greater element.  
This avoids repeated scanning and gives an optimal solution.
---------------------------------------------------------------------------------------------------------------------------------------

🚀 Approach:
1. Traverse indices from (2n-1) down to 0 (simulate doubled array).  
2. Pop smaller elements from stack → they can’t be NGE.  
3. If in original array (i < n), record the top of stack as NGE (or -1 if empty).  
4. Push current element into stack.  
5. Return the result array.
---------------------------------------------------------------------------------------------------------------------------------------

⏱️ Complexity:
- Time: O(n) → each element pushed/popped at most once  
- Space: O(n) → stack + output array
---------------------------------------------------------------------------------------------------------------------------------------
*/

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        // Optimal Approach : ✅

        int n = nums.length;
        int[] nge = new int[n];
        Stack<Integer> st = new Stack<>();

        // Hypothetically think of doubled array & traversing from backwards. ✅✅
        for (int i = 2 * n - 1; i >= 0; i--) {
            // Remove all smaller elements and store only next greater elements in stack
            while (!st.isEmpty() && st.peek() <= nums[i % n]) {
                st.pop(); // keep on removing all smaller poles.
            }
            // ✅✅ Only compute nge[] for original array, not hypothetical extension
            if (i < n) {
                nge[i] = st.isEmpty() ? -1 : st.peek();
            }
            st.push(nums[i % n]);
        }
        return nge;
    }
}
