/*
---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
📌 Problem: Number of Substrings Containing All Three Characters
---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
🚩 Statement:
Given a string `s` consisting only of characters `'a'`, `'b'`, and `'c'`.  
Find the number of substrings that contain **at least one occurrence of all three characters**.  

---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
📥 Input/Output:

Example 1:
Input: s = "abcba"  
Output: 5  
Explanation: The substrings containing `'a'`, `'b'`, `'c'` are: "abc", "abcb", "abcba", "bcba", "cba".  

Example 2:
Input: s = "ccabcc"  
Output: 8  
Explanation: The substrings are: "ccab", "ccabc", "ccabcc", "cab", "cabc", "cabcc", "abc", "abcc".  

Example 3:
Input: s = "abccba"  
Output: 7  

Constraints:  
1 <= s.length <= 5 * 10^4  
s consists only of 'a', 'b', and 'c'.  

---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
💡 Intuition:
- A substring is valid if it contains at least one `'a'`, `'b'`, and `'c'`.  
- Brute force:  
  - Generate all possible substrings by fixing start index `i` and expanding `j`.  
  - Track character counts in a HashMap.  
  - As soon as the substring contains all 3 distinct chars, count it.  

---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
🔎 Approach (Brute Force):
1. Loop over all possible start indices `i`.  
2. For each `i`, expand `j` and keep track of character frequencies.  
3. If map size = 3 (meaning `'a'`, `'b'`, `'c'` are all present), increment count.  

---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
⏱️ Complexity:
- Time: O(N²) → two nested loops generate all substrings.  
- Space: O(1) → HashMap stores at most 3 characters.  

---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
💻 Code (Java):
---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
*/
  class Solution {
    public int numberOfSubstrings(String s) {
        // Brute-force approach : generate all possible substrings ✅

        int n = s.length();
        HashMap<Character, Integer> map;
        int count = 0;

        for (int i = 0; i < n; i++) {
            map = new HashMap<>();
            for (int j = i; j < n; j++) {
                map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0) + 1);
                if (map.size() == 3)
                    count += 1;
            }
        }

        return count;
    }
}

