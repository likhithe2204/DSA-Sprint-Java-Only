/*
---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
📌 Problem: Longest Substring With At Most K Distinct Characters
---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
🚩 Statement:
Given a string `s` and an integer `k`, find the length of the longest substring that contains **at most k distinct characters**.  

---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
📥 Input/Output:

Example 1:
Input: s = "aababbcaacc", k = 2  
Output: 6  
Explanation: "aababb" is the longest substring with at most 2 distinct characters.  

Example 2:
Input: s = "abcddefg", k = 3  
Output: 4  
Explanation: "bcdd" is the longest substring with at most 3 distinct characters.  

Example 3:
Input: s = "abccab", k = 4  
Output: 6  

Constraints:  
1 <= s.length <= 10⁵  
1 <= k <= 26  

---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
💡 Intuition:
- A valid substring is one that has at most `k` distinct characters.  
- Brute force: generate all substrings and check distinct counts.  
- Optimization possible: use sliding window with a frequency map.  

---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
🔎 Approach (Brute Force with Early Break):
1. Start at each index `i`.  
2. Expand window with `j` until distinct characters exceed `k`.  
3. Track maximum valid length seen so far.  
4. Use HashMap to maintain frequency of characters.  

---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
⏱️ Complexity:
- Time: O(N²) in worst case (nested loops).  
- Space: O(K), since map can hold at most `k` characters.  

---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
💻 Code (Java):
---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
*/
  class Solution {
    public int kDistinctChar(String s, int k) {
        // Brute force approach : Generate all possible substrings ✅

        int n = s.length();
        int maxLen = 0;

        for (int i = 0; i < n; i++) {
            HashMap<Character, Integer> map = new HashMap<>();
            
            for (int j = i; j < n; j++) {
                map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0) + 1);
                if (map.size() <= k) {
                    maxLen = Math.max(maxLen, j - i + 1);
                } else {
                    break; // optimization: stop expanding once distinct > k ✅
                }
            }
        }

        return maxLen;
    }
}

