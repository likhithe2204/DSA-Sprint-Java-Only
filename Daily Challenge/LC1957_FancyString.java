## 1957. Delete Characters to Make Fancy String (LeetCode Easy)
/*
✅ Problem: Delete Characters to Make Fancy String (LeetCode - 1957 - Easy)

📝 Problem Statement:
A fancy string is a string where no three consecutive characters are equal.

Given a string `s`, delete the minimum number of characters from `s` to make it fancy.
Return the resulting fancy string. It is guaranteed that the answer will always be unique.

🔸 Example 1:
Input: s = "leeetcode"
Output: "leetcode"
Explanation: Remove one 'e' to avoid three consecutive 'e's.

🔸 Example 2:
Input: s = "aaabaaaa"
Output: "aabaa"
Explanation: Remove one 'a' from the start and two 'a's from the end.

🔸 Example 3:
Input: s = "aab"
Output: "aab"
Explanation: Already a fancy string.

🔹 Constraints:
- 1 <= s.length <= 10^5
- s consists only of lowercase English letters
*/

class Solution {
    public String makeFancyString(String s) {
        // Initialize a StringBuilder to build the final result
        StringBuilder sb = new StringBuilder();

        // Count of consecutive characters
        int cnt = 1;
        // Append the first character by default
        sb.append(s.charAt(0));

        for (int i = 1; i < s.length(); i++) {
            // If current character matches previous, increase count
            if (s.charAt(i) == s.charAt(i - 1)) {
                cnt++;
            } else {
                // Reset count if characters differ
                cnt = 1;
            }
            
            // Append character only if it's not the 3rd or more in a row
            if (cnt < 3) {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}
