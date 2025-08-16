/*
---------------------------------------------------------------------------------------------------------------------------------------

🔥 Problem: Next Smaller Element  
Difficulty: Medium  
Platform: LeetCode / GFG , Tuf+
---------------------------------------------------------------------------------------------------------------------------------------

📝 Problem Statement:  
Given an array of integers `arr`, find the Next Smaller Element (NSE) for every element.  
The NSE for an element x is the first element to the right of x that is smaller than x.  
If there is no smaller element to the right, return -1 for that index.  
---------------------------------------------------------------------------------------------------------------------------------------

🔍 Example:  
Input: arr = [4, 8, 5, 2, 25]  
Output: [2, 5, 2, -1, -1]  
---------------------------------------------------------------------------------------------------------------------------------------

💡 Intuition:  
Instead of checking all elements to the right for every index (brute force),  
we can maintain a **Monotonic Increasing Stack** (stores potential candidates).  
By processing the array **from right to left**, we can efficiently find the next smaller element.  
---------------------------------------------------------------------------------------------------------------------------------------

🚀 Approach (Optimal – Monotonic Stack):  
- Traverse the array from **right to left**.  
- Maintain a stack that stores only potential smaller elements.  
- For each element `arr[i]`:  
  - Pop all elements from the stack that are **greater or equal** to `arr[i]`.  
  - If the stack becomes empty → NSE = -1.  
  - Else → NSE = stack.peek().  
  - Push the current element into the stack.  
---------------------------------------------------------------------------------------------------------------------------------------

⏱️ Complexity Analysis:  
- **Time:** O(n) → Each element is pushed and popped at most once.  
- **Space:** O(n) → Stack + output array.  
---------------------------------------------------------------------------------------------------------------------------------------
*/

class Solution {
    public int[] nextSmallerElements(int[] arr) {
        // Optimal Approach : Use Monotonic Stack ✅

        int n = arr.length;
        int[] nse = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && st.peek() >= arr[i]) {
                st.pop();
            }
            nse[i] = st.isEmpty() ? -1 : st.peek();
            st.push(arr[i]);
        }
        return nse;
    }
}
