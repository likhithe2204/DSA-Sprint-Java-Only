/*
---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
📌 Problem: 1358. Number of Substrings Containing All Three Characters
---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
🚩 Statement:
Given a string `s` consisting only of characters `'a'`, `'b'`, and `'c'`,  
return the number of substrings containing at least one occurrence of all these characters.  

---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
📥 Input/Output:

Example 1:
Input: s = "abcabc"  
Output: 10  

Example 2:
Input: s = "aaacb"  
Output: 3  

Example 3:
Input: s = "abc"  
Output: 1  

Constraints:  
3 <= s.length <= 5 × 10⁴  
s only consists of characters `'a'`, `'b'`, `'c'`.  

---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
💡 Intuition:
- A substring is valid if it contains all 3 characters `'a'`, `'b'`, `'c'`.  
- Brute force: check all substrings.  
- Optimization: once a valid substring `[i..j]` is found, all substrings extending it (`[i..j+1]`, `[i..j+2]`, … `[i..n-1]`) are guaranteed valid.  
- So instead of continuing the loop, we can add `(n - j)` directly and break.  

---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
🔎 Approach (Optimized Brute Force):
1. Fix starting index `i`.  
2. Expand `j` and track character counts.  
3. When all 3 chars are found (`map.size() == 3`):  
   - Add `(n - j)` to the answer (all longer substrings are valid).  
   - Break to avoid extra checks.  

---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
⏱️ Complexity:
- Time: O(N²) in worst case, but optimized to reduce unnecessary checks.  
- Space: O(1), since HashMap only stores 3 characters.  

---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
💻 Code (Java):
---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
*/
  class Solution {
    public int numberOfSubstrings(String s) {
        // Optimized Brute Force : Early Break + Counting ✅

        int n = s.length();
        HashMap<Character, Integer> map;
        int count = 0;

        for (int i = 0; i < n; i++) {
            map = new HashMap<>();
            for (int j = i; j < n; j++) {
                map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0) + 1);
                if (map.size() == 3) {
                    count += (n - j); // trick: all longer substrings are valid ✅
                    break;
                }
            }
        }

        return count;
    }
}

