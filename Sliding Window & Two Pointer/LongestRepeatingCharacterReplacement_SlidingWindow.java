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
- We want the longest substring that can become all the same character after at most `k` replacements.  
- Using a sliding window:
  - Expand window with right pointer.  
  - Track the frequency of the most common character in the current window.  
  - If window size - maxFreq > k → too many changes, shrink window from left.  
- Keep updating the maximum valid window length.  

---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
🔎 Approach (Optimal):
1. Maintain a frequency array of characters.  
2. Use two pointers (`l`, `r`) for window.  
3. Expand right pointer and update frequency.  
4. Track `maxFreq` of any character in current window.  
5. If window length - maxFreq > k → shrink from left.  
6. Otherwise, update maximum window length.  

---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
⏱️ Complexity:
- Time: O(N) → each index visited at most twice (by `l` and `r`).  
- Space: O(26) → constant space for character frequency.  

---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
💻 Code (Java):
---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
*/

class Solution {
    public int characterReplacement(String s, int k) {
        // O(2N) -> Sliding Window + 2 Pointers

        int n = s.length();
        int l = 0, maxFreq = 0, maxLen = 0;
        int[] hash = new int[26];

        for (int r = 0; r < n; r++) {
            hash[s.charAt(r) - 'A']++;
            maxFreq = Math.max(maxFreq, hash[s.charAt(r) - 'A']);
            int changes = (r - l + 1) - maxFreq;

            if (changes > k) {
                // INVALID Window
                while (changes > k) {
                    hash[s.charAt(l) - 'A']--;
                    l++;
                    changes = (r - l + 1) - maxFreq; // recheck after shrinking
                }
                maxLen = Math.max(maxLen, r - l + 1);
            }

            if (changes <= k) {
                // VALID Window
                maxLen = Math.max(maxLen, r - l + 1);
            }
        }

        return maxLen;
    }
}

