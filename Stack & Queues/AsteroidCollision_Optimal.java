/*
------------------------------------------------------------------------------------------------------------------------------------------------------------
🪐 Problem: 735. Asteroid Collision
Platform: LeetCode
Difficulty: Medium
Tags: Stack, Simulation
------------------------------------------------------------------------------------------------------------------------------------------------------------

📘 Problem Statement:
We are given an array of integers representing asteroids in a row.
- Absolute value = size of asteroid
- Sign = direction (positive → right, negative → left)
- All asteroids move at the same speed.

Rules:
- If two asteroids collide → smaller one explodes
- If equal size → both explode
- Same direction → never collide

Return the state of asteroids after all collisions.

------------------------------------------------------------------------------------------------------------------------------------------------------------
💡 Example 1:
Input: [5,10,-5]
Output: [5,10]
Explanation: 10 destroys -5.

💡 Example 2:
Input: [8,-8]
Output: []
Explanation: Both destroy each other.

💡 Example 3:
Input: [10,2,-5]
Output: [10]
------------------------------------------------------------------------------------------------------------------------------------------------------------

🧠 Intuition:
- Collisions only happen if a right-moving asteroid (+) meets a left-moving one (-).
- Use a stack to simulate the asteroid path:
  - Push asteroids that move right.
  - When a left-moving asteroid comes:
    - Keep checking the top of stack for collisions.
    - Resolve based on size until stable.

------------------------------------------------------------------------------------------------------------------------------------------------------------
📝 Approach:
1. Iterate through each asteroid:
   - If moving right or no collision → push into stack.
   - If moving left → compare with stack top:
     - Destroy smaller one.
     - If equal → destroy both.
     - Stop if left asteroid destroyed.
2. Convert stack into array for result.

------------------------------------------------------------------------------------------------------------------------------------------------------------
⏱ Complexity:
- Time: O(n) → Each asteroid pushed/popped at most once.
- Space: O(n) → For the stack.

------------------------------------------------------------------------------------------------------------------------------------------------------------
✅ Code:
*/

import java.util.*;

class Solution {
    public int[] asteroidCollision(int[] arr) {
        // Optimal Approach : Use Stack ✅
        int n = arr.length;
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            int curr = arr[i];
            boolean destroyed = false;

            // Collision check with stack top
            while (!st.isEmpty() && curr < 0 && st.peek() > 0) {
                int last = st.peek();

                if (Math.abs(last) < Math.abs(curr)) {
                    st.pop(); // smaller asteroid destroyed
                    continue;
                } else if (Math.abs(last) == Math.abs(curr)) {
                    st.pop(); // both destroyed
                    destroyed = true;
                    break;
                } else {
                    destroyed = true; // current destroyed
                    break;
                }
            }

            if (!destroyed) {
                st.push(curr);
            }
        }

        return convertStack2Arr(st);
    }

    public int[] convertStack2Arr(Stack<Integer> st) {
        int[] ans = new int[st.size()];
        for (int i = 0; i < st.size(); i++) {
            ans[i] = st.get(i); // Stack extends Vector → direct access
        }
        return ans;
    }
}
