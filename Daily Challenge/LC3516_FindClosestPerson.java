/*  
---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
📌 Problem: 3516. Find Closest Person
---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
🚩 Statement:  
You are given three integers `x`, `y`, and `z`, representing the positions of three people on a number line:  

- `x`: position of Person 1.  
- `y`: position of Person 2.  
- `z`: position of Person 3 (fixed, does not move).  

Both Person 1 and Person 2 move toward Person 3 at the same speed.  

Return:  
- `1` → if Person 1 arrives first.  
- `2` → if Person 2 arrives first.  
- `0` → if both arrive at the same time.  

---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
📥 Input/Output:  

Example 1:  
Input: x = 2, y = 7, z = 4  
Output: 1  
Explanation: Person 1 takes 2 steps, Person 2 takes 3 steps → Person 1 arrives first.  

Example 2:  
Input: x = 2, y = 5, z = 6  
Output: 2  
Explanation: Person 1 takes 4 steps, Person 2 takes 1 step → Person 2 arrives first.  

Example 3:  
Input: x = 1, y = 5, z = 3  
Output: 0  
Explanation: Both Person 1 and Person 2 take 2 steps → reach at the same time.  

Constraints:  
- 1 ≤ x, y, z ≤ 100  

---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
💡 Intuition:  
The one who is **closer in distance** to Person 3 will reach first since speed is the same.  
If distances are equal → both reach together.  

---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
🔎 Approach:  
1. Compute absolute distance of Person 1 to Person 3 → `d1 = |x - z|`.  
2. Compute absolute distance of Person 2 to Person 3 → `d2 = |y - z|`.  
3. Compare:  
   - If `d1 < d2` → return 1.  
   - If `d2 < d1` → return 2.  
   - Otherwise → return 0.  

---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
⏱️ Complexity:  
- Time: O(1), just absolute differences.  
- Space: O(1).  

---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
💻 Code (Java):
---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
*/

class Solution {
    public int findClosest(int x, int y, int z) {
        int d1 = Math.abs(x - z); // distance of Person 1 from Person 3
        int d2 = Math.abs(y - z); // distance of Person 2 from Person 3

        if (d1 < d2) 
            return 1; // Person 1 arrives first
        else if (d2 < d1) 
            return 2; // Person 2 arrives first
        else 
            return 0; // Both arrive at the same time
    }
}
