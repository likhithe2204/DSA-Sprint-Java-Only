/*

------------------------------------------------------------------------------------------------------------------------------------------------------------

🪐 Problem: 402. Remove K Digits
Platform: LeetCode
Difficulty: Medium
Tags: Stack, Greedy, Monotonic Stack
------------------------------------------------------------------------------------------------------------------------------------------------------------

📘 Problem Statement:
Given string `num` representing a non-negative integer `num`, and an integer `k`,  
remove `k` digits from the number so that the new number is the smallest possible.  

Return the resulting number as a string.  
------------------------------------------------------------------------------------------------------------------------------------------------------------

💡 Intuition:
To make the number smallest, we should:
- Remove digits that are **greater than the next one** (greedy).
- Keep digits in **monotonic increasing order**.
- Finally, trim leading zeros.
------------------------------------------------------------------------------------------------------------------------------------------------------------

🛠️ Approach:
1. Use a **StringBuilder as a stack**.
2. Iterate each digit:
   - While top of stack > current digit and k > 0 → pop.
   - Push current digit.
3. If still `k > 0` after traversal → remove from end.
4. Remove leading zeros.
5. Edge case: if empty, return `"0"`.
------------------------------------------------------------------------------------------------------------------------------------------------------------

⏱️ Complexity Analysis:
- Time: O(n) ✅ (each digit pushed/popped once)
- Space: O(n) ✅ (stack usage via StringBuilder)
------------------------------------------------------------------------------------------------------------------------------------------------------------

🔥 Code (Java):
*/
class Solution {
    public String removeKdigits(String num, int k) {
        // Optimal Approach: ✅ (Improved Time & Space)

        int n = num.length();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            char c = num.charAt(i);

            // Monotonic increasing stack logic
            while (sb.length() > 0 && k > 0 && sb.charAt(sb.length() - 1) > c) {
                sb.deleteCharAt(sb.length() - 1);
                k--;
            }

            sb.append(c);
        }

        // If still k left, remove from the end
        while (k > 0 && sb.length() > 0) {
            sb.deleteCharAt(sb.length() - 1);
            k--;
        }

        // Remove leading zeros
        int idx = 0;
        while (idx < sb.length() && sb.charAt(idx) == '0') {
            idx++;
        }

        /*
        What's actually happening here : ✅
            ✅ Skip all leading '0' digits using idx.
            ✅ If entire string is zeros (idx == sb.length()), return "0".
            ✅ Else, return substring from first non-zero digit (sb.substring(idx)).
            ✅ Ensures result has no invalid leading zeros.
        */

        String result = (idx == sb.length()) ? "0" : sb.substring(idx);
        return result;
    }
}
