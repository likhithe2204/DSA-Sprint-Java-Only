/*
📝 Problem: Sum of Subarray Minimums
Difficulty: Medium
Platform: Coding Ninjas / LeetCode Style
Category: Monotonic Stack / Subarrays
---------------------------------------------------------------------------------------------------------------------------------------

📌 Problem Statement:
You are given an array 'arr' of length ‘N’.
Let ‘X’ be the minimum element of any contiguous subarray of ‘arr’.
You need to return the sum of 'X' over all the contiguous subarrays of 'arr'.
Since the answer may be large, return it modulo 10^9+7.

---------------------------------------------------------------------------------------------------------------------------------------

🎯 Example 1:
Input: arr = [1, 2, 3, 4], N = 4
Output: 20 ✅

🎯 Example 2:
Input: arr = [1, 5, 3], N = 3
Output: 14 ✅

🎯 Example 3:
Input: arr = [5, 10, 5, 10], N = 4
Output: 60 ✅

---------------------------------------------------------------------------------------------------------------------------------------

⚡ Intuition:
- Each element `arr[i]` is the minimum of several subarrays.
- To count contribution:
   🔹 Find **Previous Smaller Element (PSE)** → distance to the left until a smaller element.  
   🔹 Find **Next Smaller Element (NSE)** → distance to the right until a smaller or equal element.  
- Contribution of arr[i] = arr[i] × left × right
- Add all contributions modulo 1e9+7.

---------------------------------------------------------------------------------------------------------------------------------------

🛠 Approach (Optimal):
1. Use monotonic stack to compute PSE (strictly smaller).  
2. Use monotonic stack to compute NSE (smaller or equal).  
3. For each index i → contribution = arr[i] * left[i] * right[i].  
4. Take sum modulo 1e9+7.

⏱ Time Complexity: O(N)
📦 Space Complexity: O(N)

---------------------------------------------------------------------------------------------------------------------------------------

🚀 Optimal Code:
*/
import java.util.*;

class Solution {
    public static int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        long mod = (long)1e9 + 7;

        int[] left = new int[n];
        int[] right = new int[n];

        // Step 1: Previous Smaller Element (strictly smaller)
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] > arr[i]) {
                st.pop();
            }
            left[i] = st.isEmpty() ? i + 1 : i - st.peek();
            st.push(i);
        }

        // Step 2: Next Smaller Element (smaller or equal)
        st.clear();
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }
            right[i] = st.isEmpty() ? n - i : st.peek() - i;
            st.push(i);
        }

        // Step 3: Contribution of each element
        long ans = 0;
        for (int i = 0; i < n; i++) {
            long contrib = (long) arr[i] * left[i] * right[i];
            ans = (ans + contrib) % mod;
        }

        return (int) ans;
    }
}
