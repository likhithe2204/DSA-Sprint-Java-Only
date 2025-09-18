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
- Brute force works but is too slow (O(N²)).  
- Instead, we can use a **sliding window with two pointers**.  
- The idea:  
  - Expand the right pointer until more than `k` distinct characters appear.  
  - Then shrink the left pointer until we are back to `k` or fewer distinct characters.  
  - Track the maximum valid window size throughout.  

---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
🔎 Approach (Sliding Window + HashMap):
1. Use two pointers `l` and `r` to maintain a sliding window.  
2. Expand the window by moving `r` and adding chars to a frequency map.  
3. If the map has more than `k` distinct chars, shrink from the left (`l`).  
4. Track `maxLen` whenever the window is valid.  

---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
⏱️ Complexity:
- Time: O(N), since each character is processed at most twice (once by `r`, once by `l`).  
- Space: O(K), since the map holds at most `k` distinct characters.  

---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
💻 Code (Java):
---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
*/
  class Solution {
    public int kDistinctChar(String s, int k) {
        // Optimal Approach : Sliding Window & 2 Pointers + Hashing ✅

        int n = s.length();
        int l = 0, maxLen = 0;
        HashMap<Character, Integer> map = new HashMap<>();

        for (int r = 0; r < n; r++) {
            // expand the window from right
            map.put(s.charAt(r), map.getOrDefault(s.charAt(r), 0) + 1);
            
            if (map.size() > k) {
                // shrink from left until valid
                while (map.size() > k) {
                    map.put(s.charAt(l), map.get(s.charAt(l)) - 1);
                    if (map.get(s.charAt(l)) == 0)
                        map.remove(s.charAt(l));
                    l++;
                }
            }

            maxLen = Math.max(maxLen, r - l + 1);
        }

        return maxLen;
    }
}

