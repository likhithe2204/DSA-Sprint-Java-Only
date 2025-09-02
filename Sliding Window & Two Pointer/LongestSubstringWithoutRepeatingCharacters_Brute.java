/*  
---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
📌 Problem: Longest Substring Without Repeating Characters

---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
🚩 Statement:  
Given a string `s`, find the length of the longest substring without duplicate characters.  

---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
📥 Input/Output:  
Input:  s = "abcabcbb"  
Output: 3  
Explanation: The answer is "abc", with the length of 3.  

Input:  s = "bbbbb"  
Output: 1  
Explanation: The answer is "b", with the length of 1.  

Input:  s = "pwwkew"  
Output: 3  
Explanation: The answer is "wke", with the length of 3.  
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.  

Constraints:  
- 0 <= s.length <= 5 * 10^4  
- s consists of English letters, digits, symbols and spaces.  

---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
💡 Intuition:  
We want the longest continuous part of the string where no character repeats. 
The brute force approach is to try every substring and check for duplicates using hashing. 

---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
🔎 Approach:  
1. Iterate through every starting index `i`.
2. For each `i`, extend the substring to the right (`j`) 
   until a duplicate character is found.
3. Use a hash array of size 256 to track visited characters.
4. Update maximum length whenever we get a longer valid substring.
5. Return the maximum length found.

---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
⏱️ Complexity:  
- Time Complexity: O(n^2)   // checking all substrings
- Space Complexity: O(256) ≈ O(1)   // hash array

---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
💻 Code:
---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
*/

class Solution {
    public int lengthOfLongestSubstring(String s) {
        // Brute force approach using hashing.

        int n = s.length();
        int max_len = 0;

        // Try every possible starting point i
        for (int i = 0; i < n; i++) {
            int len = 0;
            int[] hash = new int[256]; // Tracks whether a character has appeared in the current substring

            // Extend substring from i to j
            for (int j = i; j < n; j++) {
                if (hash[s.charAt(j)] == 1) {
                    // Character already seen → stop extending
                    break;
                }
                // Update substring length and maximum
                len = j - i + 1;
                max_len = Math.max(max_len, len);

                // Mark character as seen
                hash[s.charAt(j)] = 1;
            }
        }
        return max_len;
    }
}
