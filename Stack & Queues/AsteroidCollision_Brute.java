/*
--------------------------------------------------------------------------------------------------------------------------------------

📝 Problem: Asteroid Collision
Difficulty: Medium
Platform: GeeksForGeeks / LeetCode Style
Category: Simulation
--------------------------------------------------------------------------------------------------------------------------------------

📌 Problem Statement:
We are given an integer array `asteroids` of size `N` representing asteroids in a row.
- Absolute value = size of asteroid
- Sign = direction (positive → right, negative → left)
If two asteroids meet:
 - smaller one explodes
 - if equal, both explode
Two asteroids moving in the same direction never meet.
Return the final state of asteroids after all collisions.

--------------------------------------------------------------------------------------------------------------------------------------

🎯 Example 1:
Input: N = 3, asteroids = [3, 5, -3]
Output: [3, 5]
Explanation: 5 and -3 collide → 5 survives. 3 and 5 never collide.

🎯 Example 2:
Input: N = 2, asteroids = [10, -10]
Output: []
Explanation: 10 and -10 collide and destroy each other.

--------------------------------------------------------------------------------------------------------------------------------------

⚡ Intuition:
Simulate collisions by maintaining a dynamic list of surviving asteroids.
For each asteroid:
 - If it moves right (positive) — append it.
 - If it moves left (negative) — check collisions with the last survivor(s) while the last survivor moves right.
Resolve collisions by comparing absolute sizes until current asteroid is destroyed or no collision possible.

--------------------------------------------------------------------------------------------------------------------------------------

🛠 Approach (Brute-Force Simulation):
1. Iterate asteroids left → right.
2. For current asteroid `curr`, while there is a last survivor and they move towards each other:
   - If |last| < |curr| → last explodes (remove last) and continue checking.
   - If |last| == |curr| → both explode (remove last, discard curr).
   - If |last| > |curr| → curr explodes.
3. If curr survives, append to survivors list.
4. Convert survivors list → int[] and return.

⏱ Time Complexity: Amortized O(N)
📦 Space Complexity: O(N)

--------------------------------------------------------------------------------------------------------------------------------------

✅ Brute-Force Simulation Code:
*/
import java.util.*;

class Solution {
    public static int[] asteroidCollision(int N, int[] asteroids) {
        // Brute-Force Simulation Approach:

        int n = asteroids.length;
        ArrayList<Integer> ans = new ArrayList<>();

        // edge case : if array contain single element || no elements:
        if (n == 0) {
            return converList2Arr(ans);
        }
        if (n == 1) {
            ans.add(asteroids[0]);
            return converList2Arr(ans);
        }

        // iterate over all asteroids
        for (int i = 0; i < n; i++) {
            int curr = asteroids[i];
            boolean destroyed = false;

            // check collision with last element in ans
            while (!ans.isEmpty() && curr < 0 && ans.get(ans.size() - 1) > 0) {
                int last = ans.get(ans.size() - 1);

                // case (i): if two asteroids meet, the smaller one will explode.
                if (Math.abs(last) < Math.abs(curr)) {
                    ans.remove(ans.size() - 1); // remove last and continue checking
                    continue;
                }

                // case (ii): if two asteroids met, & both are same size, both will explode.
                else if (Math.abs(last) == Math.abs(curr)) {
                    ans.remove(ans.size() - 1); // remove last
                    destroyed = true; // curr also destroyed
                    break;
                }

                // case (iii): last is bigger, curr destroyed
                else {
                    destroyed = true;
                    break;
                }
            }

            // if curr asteroid survives → add into result
            if (!destroyed) {
                ans.add(curr);
            }
        }

        return converList2Arr(ans); // convert ArrayList<> into int[] array.
    }

    public static int[] converList2Arr(ArrayList<Integer> ans) {
        // return type : array[]

        // Step1: Create an int[] array of same size
        int n = ans.size();
        int[] arr = new int[n];

        // Step2: Copy the elements manually.
        for (int i = 0; i < n; i++) {
            arr[i] = ans.get(i);
        }

        return arr;
    }
}
