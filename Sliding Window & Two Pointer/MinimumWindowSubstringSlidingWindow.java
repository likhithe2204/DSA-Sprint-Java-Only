/*
---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
📌 Problem: 76. Minimum Window Substring
---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
🚩 Statement:
Given two strings s and t of lengths m and n respectively, return the minimum window substring of s such that every character in t (including duplicates) is included in the window.  
If there is no such substring, return the empty string "".  
The testcases are guaranteed such that the answer is unique.  

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
- Brute force (checking all substrings) is too costly → O(m * n).  
- We can optimize using **sliding window** with two pointers.  
- Maintain a frequency array `hash[]` for required chars in `t`.  
- Expand the right pointer to include chars, and shrink from the left when the window is valid.  
- Keep track of the minimum valid window length.  

---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
⚙️ Approach:
1. Count frequency of all characters in `t`.  
2. Use two pointers `l` and `r` to maintain a window over `s`.  
3. Expand `r` until window contains all characters of `t`.  
4. Shrink from `l` while the window remains valid, updating the minimum length.  
5. Return the substring if found, else `""`.  

---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
⏱️ Complexity:
- Time: O(m + n) (each char visited at most twice).  
- Space: O(1) (hash array of fixed size 256).  

---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
💻 Code (Java):
  */
class Solution {
    public String minWindow(String s, String t) {
        // Optimal Approach : Sliding Window + 2 Pointers ✅

        int n = s.length(), m = t.length();
        int minLen = Integer.MAX_VALUE, cnt = 0, startInd = -1, l = 0;

        int[] hash = new int[256];

        // ✅ pre-insert all the characters of t into hash[]
        for (int i = 0; i < m; i++) {
            hash[t.charAt(i)]++;
        }

        // ✅ expand the window from right 
        for (int r = 0; r < n; r++) {
            if (hash[s.charAt(r)] > 0) {
                cnt++;
            }
            hash[s.charAt(r)]--;

            // ✅ shrink the window from left until VALID.
            while (cnt == m) {

                // ✅ valid window
                if (r - l + 1 < minLen) {
                    minLen = r - l + 1;
                    startInd = l;
                }

                hash[s.charAt(l)]++;
                if (hash[s.charAt(l)] > 0)
                    cnt--;
                l++;
            }

        }
        return (startInd == -1) ? "" : s.substring(startInd, startInd + minLen);
    }
}

