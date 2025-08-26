/*
------------------------------------------------------------------------------------------------------------------------------------------------------------
🪐 Problem: 84. Largest Rectangle in Histogram
Platform: LeetCode
Difficulty: Hard
Tags: Stack, Monotonic Stack, Array
------------------------------------------------------------------------------------------------------------------------------------------------------------

📘 Problem Statement:
Given an array of integers heights representing the histogram's bar height where 
the width of each bar is 1, return the area of the largest rectangle in the histogram.

------------------------------------------------------------------------------------------------------------------------------------------------------------
🔎 Example:
Input: heights = [2,1,5,6,2,3]
Output: 10
Explanation: The largest rectangle is formed using heights 5 and 6.

Input: heights = [2,4]
Output: 4

------------------------------------------------------------------------------------------------------------------------------------------------------------
🧠 Intuition:
To find the largest rectangle for each bar, we need to know:
- The **nearest smaller element on the left (PSE)**.
- The **nearest smaller element on the right (NSE)**.
This gives us the maximum width that the current bar can extend.  
Then, area = height[i] × (NSE[i] - PSE[i] - 1).

------------------------------------------------------------------------------------------------------------------------------------------------------------
💡 Approach:
1. Use a monotonic stack to compute PSE (previous smaller element).
2. Use another monotonic stack to compute NSE (next smaller element).
3. Iterate over all bars and calculate:
   - width = NSE[i] - PSE[i] - 1
   - area = heights[i] × width
4. Keep track of the maximum area found.

------------------------------------------------------------------------------------------------------------------------------------------------------------
⏱️ Complexity Analysis:
- Time: O(n) → Each bar is pushed and popped once from stack.
- Space: O(n) → For storing PSE and NSE arrays.

------------------------------------------------------------------------------------------------------------------------------------------------------------
✅ Code Implementation:
*/
class Solution {
    public int largestRectangleArea(int[] heights) {
        // BruteForce Approach✅
        int[] pse = findPSE(heights);
        int[] nse = findNSE(heights);
        int maxi = 0;

        for (int i = 0; i < heights.length; i++) {
            maxi = Math.max(maxi, heights[i] * (nse[i] - pse[i] - 1));
        }
        return maxi;
    }

    private int[] findPSE(int[] arr) {
        int n = arr.length;
        int[] pse = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }
            pse[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        return pse;
    }

    private int[] findNSE(int[] arr) {
        int n = arr.length;
        int[] nse = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }
            nse[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }
        return nse;
    }
}
