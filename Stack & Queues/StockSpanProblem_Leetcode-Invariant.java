/*

---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
📌 Problem: Stock Span Problem
---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
🚩 Statement:
Given an array `arr` of size `n`, where each element `arr[i]` represents the stock price on day `i`.
Calculate the span of stock prices for each day.

The span `Si` of a day `i` is defined as the maximum number of consecutive previous days (including the current day) 
for which the stock price was less than or equal to the price on day `i`.

---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
📥 Input/ 📥 Output:

Example 1:
Input: n = 7, arr = [120, 100, 60, 80, 90, 110, 115]
Output: [1, 1, 1, 2, 3, 5, 6]

Example 2:
Input: n = 6, arr = [15, 13, 12, 14, 16, 20]
Output: [1, 1, 1, 3, 5, 6]

Example 3:
Input: n = 8, arr = [30, 20, 25, 28, 27, 29, 35, 40]
Output: [1, 1, 2, 3, 3, 6, 7, 8]

---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
💡 Intuition:
The span for a day `i` depends on the **nearest previous greater element (PGE)**.
- If there’s no greater element before day `i`, span = `i - (-1) = i + 1`.
- Otherwise, span = `i - PGE[i]`.

So the problem reduces to finding **Previous Greater Element (PGE)** for every index.

---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
🔎 Approach:
- Maintain a stack of indices (not values).
- Traverse array from left to right:
  - Pop while `arr[st.peek()] <= arr[i]`.
  - If stack is empty → PGE = -1.
  - Else PGE = st.peek().
  - Push current index.
- Finally, span[i] = i - PGE[i].

---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
⏱️ Complexity:
Time Complexity: O(N) (each element pushed/popped at most once).
Space Complexity: O(N) for stack + O(N) for result arrays.

---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
💻 Code (Java):
---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
*/

class Solution {
    public int[] stockSpan(int[] arr, int n) {
        int[] ans = new int[n]; // to store the result
        int[] PGE = findPGE(arr);

        // compute the result
        for (int i = 0; i < n; i++) {
            ans[i] = i - PGE[i]; // curr_Index - previousGreaterElement_Index.
        }
        return ans; // return the final result
    }

    // helper function -> find Previous Greater Element Array. 
    public int[] findPGE(int[] arr) {
        int n = arr.length;
        Stack<Integer> st = new Stack<>();
        int[] pge = new int[n];

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] <= arr[i]) {
                st.pop();
            }
            pge[i] = (st.isEmpty()) ? -1 : st.peek();
            st.push(i); // push the current Index ✅  -> NOT value❌
        }
        return pge;
    }
}
