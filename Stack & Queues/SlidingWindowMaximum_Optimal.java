/*
  
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
💡 Problem: Sliding Window Maximum (LeetCode 239)
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
📝 Statement:
You are given an array of integers `nums`, and a sliding window of size `k` which moves from left to right.  
Return the maximum in each window as it slides.

------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
📥 Input:
nums = [1,3,-1,-3,5,3,6,7], k = 3  

📤 Output:
[3,3,5,5,6,7]  

------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
🧠 Intuition:
- A brute-force scan of each window is too slow (O(n*k)).  
- Instead, we maintain a **monotonic deque** that stores indices of elements in decreasing order.  
- The front of the deque always gives the maximum of the current window.  

------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
⚡ Approach:
1. Use a deque to keep track of indices of useful elements.  
2. Remove indices that are out of the current window (`i - k`).  
3. Before inserting a new element, remove all smaller elements from the back of the deque.  
4. Once the first `k` elements are processed, add the maximum (front of deque) to the result.  
5. Continue this until the end.  

------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
⏱️ Complexity:
- Time: O(n) → each element is pushed and popped at most once.  
- Space: O(k) for the deque.  

------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
💻 Code (Optimal Java - Deque):
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
*/

import java.util.*;

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        // Optimal Approach using Monotonic Deque ✅

        int n = nums.length;
        int ansInd = 0;
        int[] ans = new int[n - k + 1]; // result size = number of windows = (n - k + 1)
        Deque<Integer> dq = new LinkedList<>(); // stores indices, not values

        for (int i = 0; i < n; i++) {

            // 1. Remove indices that are out of the current window
            if (!dq.isEmpty() && dq.peekFirst() <= i - k) {
                dq.pollFirst();
            }

            // 2. Maintain decreasing order in deque 
            // (remove smaller elements from the back, since they can never be max)
            while (!dq.isEmpty() && nums[dq.peekLast()] <= nums[i]) {
                dq.pollLast();
            }

            // 3. Insert the current index
            dq.offerLast(i);

            // 4. Once we have a full window, store the max (front of deque)
            if (i >= k - 1) {
                ans[ansInd] = nums[dq.peekFirst()];
                ansInd++;
            }
        }

        return ans;
    }
}

------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
