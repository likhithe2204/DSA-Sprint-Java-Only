/*  
---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
📌 Problem: Fruit Into Baskets (LeetCode 904)
---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
🚩 Statement:  
You are given an integer array `fruits` where `fruits[i]` represents the type of fruit on the `i`-th tree.  
You have **2 baskets**, each can hold only one type of fruit but unlimited quantity.  
Starting from any tree, you must pick exactly one fruit from every tree moving right until you cannot continue.  

Return the **maximum number of fruits** you can collect.  

---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
📥 Input/Output:  

Example 1:  
Input: fruits = [1,2,1]  
Output: 3  
Explanation: Pick from all 3 trees.  

Example 2:  
Input: fruits = [0,1,2,2]  
Output: 3  
Explanation: Longest segment is [1,2,2].  

Example 3:  
Input: fruits = [1,2,3,2,2]  
Output: 4  
Explanation: Longest segment is [2,3,2,2].  

Constraints:  
- 1 ≤ fruits.length ≤ 10⁵  
- 0 ≤ fruits[i] < fruits.length  

---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
💡 Intuition:  
We want the longest subarray containing at most **2 distinct integers**.  
This is equivalent to "Longest Substring with At Most K Distinct Characters" where K=2.  

---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
🔎 Approach (Brute Force):  
1. For each starting index `i`, use a `HashSet` to track distinct fruit types.  
2. Extend the subarray to the right (`j`).  
3. If distinct fruits ≤ 2, update max length.  
4. If distinct fruits > 2, stop expanding further from this `i`.  

---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
⏱️ Complexity:  
- Time: O(n²) → nested loops, each subarray checked.  
- Space: O(2) = O(1) → at most 2 fruits in set.  

---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
💻 Code (Java ✅):
---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
*/

import java.util.*;

class Solution {
    public int totalFruit(int[] fruits) {
        // Brute force Approach : Generate all possible subarrays + Set ✅

        int n = fruits.length;
        int maxLen = 0;

        for (int i = 0; i < n; i++) {
            HashSet<Integer> set = new HashSet<>();
            for (int j = i; j < n; j++) {
                set.add(fruits[j]);

                if (set.size() <= 2) {
                    maxLen = Math.max(maxLen, j - i + 1);
                } else
                    break; // No use to generate further subarrays
            }
        }

        return maxLen;
    }
}

