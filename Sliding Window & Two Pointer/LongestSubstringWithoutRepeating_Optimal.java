/*  
---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
📌 Problem: Longest Substring Without Repeating Characters
---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
🚩 Statement:  
Given a string `S`, find the **length of the longest substring** without repeating characters.  

---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
📥 Input/Output:  

Example 1:  
Input: S = "abcddabac"  
Output: 4  
Explanation: The answer is "abcd", with length 4.  

Example 2:  
Input: S = "aaabbbccc"  
Output: 2  
Explanation: The longest substrings are "ab", "bc" → length 2.  

Example 3:  
Input: S = "aaaa"  
Output: 1  
Explanation: The longest substring is "a".  

Constraints:  
- 1 ≤ S.length ≤ 5 * 10⁴  
- S contains only lowercase English letters.  

---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
💡 Intuition:  
We want the longest substring where no character repeats.  
→ Use **Sliding Window + Hashing** to track the last seen index of each character.  
→ Adjust left pointer when duplicates are found.  

---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
🔎 Approach:  
1. Use an array `hash[256]` to store the **last index** of each character (initialized to `-1`).  
2. Maintain two pointers:  
   - `l` → left boundary of the current substring.  
   - `r` → right pointer, iterating over the string.  
3. For each character:  
   - If it was seen before **and lies in current window [l, r]**, move `l` to `hash[char] + 1`.  
   - Update max length.  
   - Mark the current index of the character in `hash`.  

---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
⏱️ Complexity:  
- Time: O(n) → each character is processed once.  
- Space: O(256) → constant, for ASCII map.  

---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
💻 Code (Java):
---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
*/

class Solution {
    public int longestNonRepeatingSubstring(String s) {
        // Optimal Approach: Sliding Window + Hashing ✅

        int[] hash = new int[256];
        for (int i = 0; i < 256; i++) {
            hash[i] = -1; // initially unseen
        }

        int n = s.length();
        int l = 0, r = 0, maxLen = 0;

        while (r < n) {
            // If character was seen before and lies inside current window
            if (hash[s.charAt(r)] != -1 && hash[s.charAt(r)] >= l) {
                l = hash[s.charAt(r)] + 1; // move left boundary
            }

            // update max length
            int len = r - l + 1;
            maxLen = Math.max(maxLen, len);

            // store the current character index
            hash[s.charAt(r)] = r;
            r++;
        }

        return maxLen;
    }
}

