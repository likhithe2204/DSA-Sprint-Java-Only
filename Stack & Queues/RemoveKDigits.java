/*
------------------------------------------------------------------------------------------------------------------------------------------------------------
🪐 Problem: 402. Remove K Digits
Platform: LeetCode
Difficulty: Medium
Tags: Stack, Greedy, String
------------------------------------------------------------------------------------------------------------------------------------------------------------

📘 Problem Statement:
Given string num representing a non-negative integer num, and an integer k, return the smallest possible integer after removing k digits from num.

Examples:
Input: num = "1432219", k = 3
Output: "1219"

Input: num = "10200", k = 1
Output: "200"

Input: num = "10", k = 2
Output: "0"

Constraints:
- 1 <= k <= num.length <= 10^5
- num consists of only digits
- num does not have any leading zeros except for the zero itself
------------------------------------------------------------------------------------------------------------------------------------------------------------

💡 Intuition:
To get the smallest number:
- We should remove digits that are "greater" when a smaller digit comes later.
- Use a stack to maintain an increasing sequence of digits.
- Pop from the stack whenever the top digit is larger than the current digit and `k > 0`.
- Finally, handle extra `k` removals, and trim leading zeroes.

------------------------------------------------------------------------------------------------------------------------------------------------------------

✅ Approach:
1. Traverse through digits of `num`.
2. Maintain a stack:
   - While top of stack > current digit and we can still remove (`k > 0`), pop from stack.
   - Push current digit.
3. If `k` > 0 after traversal, remove remaining digits from stack top.
4. Build result from stack (reverse order).
5. Remove leading zeroes.
6. If result is empty → return "0", else return result.

------------------------------------------------------------------------------------------------------------------------------------------------------------

⏱️ Complexity Analysis:
- Time: O(n) → Each digit is pushed & popped at most once.
- Space: O(n) → Stack & result string.

------------------------------------------------------------------------------------------------------------------------------------------------------------

🔥 Code (Java):
*/

class Solution {
    public String removeKdigits(String num, int k) {
        int n = num.length();
        Stack<Character> st = new Stack<>();
        StringBuilder res = new StringBuilder();

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && k > 0 && st.peek() > num.charAt(i)) {
                st.pop();
                k--;
            }
            st.push(num.charAt(i));
        }

        // Remove extra digits if needed
        while (k > 0) {
            st.pop();
            k--;
        }

        if (st.isEmpty()) return "0";

        while (!st.isEmpty()) {
            res.append(st.pop());
        }

        // Remove leading zeroes
        while (res.length() > 0 && res.charAt(res.length() - 1) == '0') {
            res.deleteCharAt(res.length() - 1);
        }

        res.reverse();

        return res.length() == 0 ? "0" : res.toString();
    }
}
