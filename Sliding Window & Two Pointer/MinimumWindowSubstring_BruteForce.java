/*
---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
📌 Problem: Minimum Window Substring
---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
🚩 Statement:
Given two strings `s` and `t`. Find the smallest window substring of `s` that includes all characters in `t` (including duplicates) in the window.  
Return the empty string `""` if no such substring exists.
---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
🎯 Input/Output:
Input : s = "ADOBECODEBANC", t = "ABC"  
Output : "BANC"  

Input : s = "a", t = "a"  
Output : "a"  

Input : s = "aAbBDdcC", t = "Bc"  
Output : "BDdc" (or any valid minimum window that includes all characters)
---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
💡 Intuition:
We need to check every substring of `s` and verify whether it contains all the characters of `t`.  
To do this, we generate substrings starting at each index, count required characters using a hash array, and check validity.  
This brute force approach is not efficient for large inputs but works conceptually.
---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
⚙️ Approach:
1. Iterate through each index `i` of `s` as a starting point.  
2. Initialize a frequency hash for all characters in `t`.  
3. Expand a window from `i` onward, decreasing counts in the hash when characters match.  
4. Keep track of the count of matched characters.  
5. Once all `t` characters are matched, update `minLen` and `startIndex` if this window is smaller than the previous one.  
6. Return the substring based on `startIndex` and `minLen`.
---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
⏱️ Complexity:
- Time: O(n²) in the worst case (since we check substrings starting from each index).  
- Space: O(1) (fixed hash array of size 256).
---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
💻 Code (Java):
  */
class Solution {
    public String minWindow(String s, String t) {
        // Brute force approach : Generate all the substrings & Pick up the minLen for all the Valid Ones ✅

        int m = s.length();
        int n = t.length();

        int minLen = Integer.MAX_VALUE;
        int startIndex = -1;

        // Outer loop to check each and every character of "s".
        for (int i = 0; i < m; i++) {

            int[] hash = new int[256];
            int cnt = 0;

            // Pre-Insert all the Characters of "t" in hash[].
            for (int j = 0; j < n; j++) {
                hash[t.charAt(j)]++;
            }

            // Inner loop to generate all possible substrings.
            for (int j = i; j < m; j++) {
                if (hash[s.charAt(j)] > 0) {
                    cnt += 1;
                    hash[s.charAt(j)]--;

                    if (cnt == n) {
                        if (j - i + 1 < minLen) {
                            minLen = j - i + 1;
                            startIndex = i;
                        }
                        break;
                    }
                }
            }
        }

        if (startIndex == -1)
            return "";
        else
            return s.substring(startIndex, startIndex + minLen);
    }
}
