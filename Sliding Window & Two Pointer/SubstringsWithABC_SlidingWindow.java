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
- Instead of checking all substrings, track the **latest index** of each character `'a'`, `'b'`, `'c'`.  
- At position `i`, if all three chars have been seen, the smallest index among them decides the earliest start of a valid substring.  
- Every substring ending at `i` and starting before/equal to that min index is guaranteed valid.  

---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
🔎 Approach (Optimal Sliding Window):
1. Maintain an array `lastSeen[3]` storing the last index of `'a'`, `'b'`, and `'c'`.  
2. Traverse the string: update the current char’s index.  
3. If all characters have been seen:  
   - Add `1 + min(lastSeen[0], lastSeen[1], lastSeen[2])` to the answer.  
   - Because every prefix up to that minimum contributes a valid substring ending at `i`.  

---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
⏱️ Complexity:
- Time: O(N), single pass.  
- Space: O(1), constant array of size 3.  

---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
💻 Code (Java):
---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
*/
  class Solution {
    public int numberOfSubstrings(String s) {
        // Optimal Approach : Track last seen indices ✅

        int n = s.length();
        int[] lastSeen = { -1, -1, -1 }; 
        int count = 0;

        for (int i = 0; i < n; i++) {
            lastSeen[s.charAt(i) - 'a'] = i; // update index
            if (lastSeen[0] != -1 && lastSeen[1] != -1 && lastSeen[2] != -1) {
                count += 1 + Math.min(Math.min(lastSeen[0], lastSeen[1]), lastSeen[2]);
            }
        }

        return count;
    }
}

