/*
---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
📌 Problem: 76. Minimum Window Substring
---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
🚩 Statement:
Given two strings s and t of lengths m and n respectively, return the minimum window substring of s such that every character in t (including duplicates) is included in the window.  
If there is no such substring, return the empty string "".  

---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
🎯 Input/Output:
Example 1:  
Input: s = "ADOBECODEBANC", t = "ABC"  
Output: "BANC"  

Example 2:  
Input: s = "a", t = "a"  
Output: "a"  

Example 3:  
Input: s = "a", t = "aa"  
Output: ""  

---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
💡 Intuition:
- For each starting index `i` in `s`, try building substrings.  
- Maintain a frequency array `hash[]` for characters of `t`.  
- As we expand substring, reduce counts in `hash[]`.  
- Once all `t` chars are matched → update answer if substring is smaller.  
- This brute force solution works but is **O(m * n)**, not optimal.  

---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
⚙️ Approach:
1. Loop over each starting index `i`.  
2. Initialize hash[] with counts of `t`.  
3. Expand substring from `i` onwards.  
4. Keep track of how many characters of `t` are matched.  
5. If all matched, check window length and update minimum.  
6. Return the substring if found, else `""`.  

---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
⏱️ Complexity:
- Time: O(m * n) (brute force, generating substrings).  
- Space: O(1) (constant hash array of size 256).  

---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
💻 Code (Java):
 */
class Solution {
    public String minWindow(String s, String t) {
        // Bruteforce approach : generate all substrings + hashing ✅

        int n = s.length(), m = t.length();
        int minLen = Integer.MAX_VALUE;
        int startIndex = -1;

        for (int i = 0; i < n; i++) {

            int[] hash = new int[256];
            int cnt = 0;

            // ✅ Pre-insert all the characters of t into hash[]
            for (int j = 0; j < m; j++) {
                hash[t.charAt(j)]++;
            }

            // ✅ generate all possible substrings
            for (int j = i; j < n; j++) {

                if (hash[s.charAt(j)] > 0) {
                    cnt++; // track the window
                    hash[s.charAt(j)]--;

                    // ✅ valid window
                    if (cnt == m) {
                        if (j - i + 1 < minLen) {
                            minLen = j - i + 1;
                            startIndex = i;
                        }
                        break;
                    }
                }
            }
        }
        return (startIndex == -1) ? "" : s.substring(startIndex, startIndex + minLen);
    }
}
