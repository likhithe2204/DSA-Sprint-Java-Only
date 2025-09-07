/*  
---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
📌 Problem: Fruit Into Baskets  
---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
🚩 Statement:  
You are given an integer array `fruits` where `fruits[i]` represents the type of fruit the `i`-th tree produces.  

Rules:  
1. You have **two baskets**, and each basket can only contain **one type of fruit**.  
2. You must start at any tree and pick **exactly one fruit per tree** moving to the right.  
3. If you encounter a fruit that cannot fit in your baskets, you must stop.  

Return the **maximum number of fruits** you can collect.  

---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
📥 Input/Output:  

Example 1:  
Input: fruits = [1, 2, 1]  
Output: 3  
Explanation: Start at index 0, pick [1,2,1].  

Example 2:  
Input: fruits = [1, 2, 3, 2, 2]  
Output: 4  
Explanation: Start at index 1, pick [2,3,2,2].  

Example 3:  
Input: fruits = [1, 2, 3, 4, 5]  
Output: 2  
Explanation: Any two consecutive fruits form the maximum window.  

Constraints:  
- 1 ≤ fruits.length ≤ 10⁵  
- 0 ≤ fruits[i] < fruits.length  

---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
💡 Intuition:  
We need the **longest subarray containing at most 2 distinct integers**.  
This can be solved using the **sliding window + HashMap** approach.  

---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
🔎 Approach (Optimal):  
1. Use a `HashMap<Integer,Integer>` to store fruit type → frequency inside the current window.  
2. Expand the window by moving `r` (right pointer).  
3. If map size > 2, shrink the window by moving `l` (left pointer) until map size ≤ 2.  
4. At each step, update the max length of the window.  

---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
⏱️ Complexity:  
- Time: O(2N) ≈ O(N) → each fruit is added/removed at most once.  
- Space: O(2) = O(1) → HashMap stores at most 2 fruit types.  

---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
💻 Code (Java):  
---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
*/

import java.util.*;

class Solution {
    public int totalFruits(int[] fruits) {
        // O(2N) Approach - Sliding Window + Two Pointers + HashMap ✅

        int n = fruits.length;
        int l = 0, r = 0, maxLen = 0;
        HashMap<Integer, Integer> map = new HashMap<>(); // stores <fruitType, frequency>

        // Expand the window until right pointer reaches the end
        while (r < n) {
            // Add the new element into the window and update its frequency
            map.put(fruits[r], map.getOrDefault(fruits[r], 0) + 1);

            // If the window contains more than 2 distinct fruit types → invalid
            if (map.size() > 2) {
                // Shrink the window from the left until it becomes valid again
                while (map.size() > 2) {
                    map.put(fruits[l], map.get(fruits[l]) - 1); // decrease frequency
                    if (map.get(fruits[l]) == 0) {
                        map.remove(fruits[l]); // remove fruit type completely
                    }
                    l++; // move left pointer
                }
            }

            // If valid (≤ 2 fruit types), update max length
            if (map.size() <= 2) {
                maxLen = Math.max(maxLen, r - l + 1);
            }

            r++; // move right pointer
        }
        return maxLen;
    }
}

