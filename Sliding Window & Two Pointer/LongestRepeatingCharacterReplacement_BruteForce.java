/*
---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
📌 Problem: 424. Longest Repeating Character Replacement

---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
🚩 Statement:
You are given a string `s` and an integer `k`. You can choose any character of the string and change it to any other uppercase English character.  
You can perform this operation at most `k` times.  
Return the length of the longest substring containing the same letter you can get after performing the above operations.

---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
📥 Input/Output:

Example 1:
Input: s = "ABAB", k = 2
Output: 4

Example 2:
Input: s = "AABABBA", k = 1
Output: 4

Constraints:
1 <= s.length <= 10^5
s consists of only uppercase English letters.
0 <= k <= s.length

---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
💡 Intuition:
Brute force way →  
- Generate all substrings.  
- For each substring, calculate the frequency of each character.  
- The number of changes needed = (length of substring - max frequency character).  
- If changes ≤ k, it is valid. Track maximum length.

---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
🔎 Approach (Brute Force):
1. Iterate over all possible starting points `i`.  
2. For each `i`, expand substring with `j`.  
3. Maintain frequency of characters using a hash array.  
4. Keep track of maximum frequency in substring.  
5. Calculate required changes = (substring length - maxFreq).  
6. If changes ≤ k → update answer.  
7. Else break early.  

---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
⏱️ Complexity:
- Time: O(N^2 * 26) in worst case.  
- Space: O(26) = O(1).  

---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
💻 Code (Java):
---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
*/

class Solution {
    public int characterReplacement(String s, int k) {
        // Brute force approach : Generate all substrings + changes to make {len - maxFreq} ✅

        int n = s.length();
        int maxFreq = 0;
        int maxLen = 0;

        for (int i = 0; i < n; i++) {
            int[] hash = new int[26];
            for (int j = i; j < n; j++) {
                // update in hash array 
                hash[s.charAt(j) - 'A']++;
                // keep a track of maximum frequency for each substring 
                maxFreq = Math.max(maxFreq, hash[s.charAt(j) - 'A']);
                // Calculate the changes 
                int changes = (j - i + 1) - maxFreq;
                // check are changes valid 
                if (changes <= k) {
                    maxLen = Math.max(maxLen, j - i + 1);
                } else {
                    break; // no use to generate that substring
                }
            }
        }

        return maxLen;
    }
}

