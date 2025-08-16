/*
──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────
📝 Platform: GeeksforGeeks, Naukri, Tuf+
💡 Problem: Next Greater Element
🎯 Difficulty: Medium
🏷️ Topic Tags: Stack, Monotonic Stack
🏢 Company Tags: Flipkart, Amazon, Microsoft, MakeMyTrip, Adobe
──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────

📖 Problem Statement:
Given an array arr[] of integers, find the next greater element for each element in order of their appearance.
Next greater element of an element in the array is the nearest element on the right which is greater than the current element.
If it does not exist, the next greater element is -1.

──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────
⚡ Examples:
Input: arr[] = [1, 3, 2, 4]
Output: [3, 4, 4, -1]

Input: arr[] = [6, 8, 0, 1, 3]
Output: [8, -1, 1, 3, -1]

Input: arr[] = [10, 20, 30, 50]
Output: [20, 30, 50, -1]

Input: arr[] = [50, 40, 30, 10]
Output: [-1, -1, -1, -1]
──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────

📌 Constraints:
1 ≤ arr.size() ≤ 10^6
0 ≤ arr[i] ≤ 10^9
──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────

💡 Intuition:
Find nearest greater element to the right for each element.
Brute-force O(n^2), optimized using a stack.

──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────
🛠️ Approach:
1️⃣ Initialize stack and result array of same size filled with -1.  
2️⃣ Traverse array from right to left:  
   - Pop from stack while top ≤ current element.  
   - If stack not empty, set result[i] = stack.peek().  
   - Push current element to stack.

⏱️ Time Complexity: O(n)  
💾 Space Complexity: O(n)
──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────

💻 Code:
*/

import java.util.*;

public class Solution {

    public static int[] nextGreaterElement(int[] arr, int n) {
        // Optimal Approach: Using Monotonic Stack

        Stack<Integer> st = new Stack<>();
        int[] nge = new int[n];

        // Back traversal
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && st.peek() <= arr[i]) {
                st.pop();
            }
            if (st.isEmpty()) 
                nge[i] = -1;
            else 
                nge[i] = st.peek();

            st.push(arr[i]);
        }

        return nge;
    }
}
