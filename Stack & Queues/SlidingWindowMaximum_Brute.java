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
- For each window of size `k`, check all elements inside it and find the maximum.  
- This is a brute-force way but guarantees correctness.  

------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
⚡ Approach:
1. Traverse each starting index `i` from `0` to `n-k`.  
2. For each window, compute the maximum by checking all `k` elements.  
3. Store the maximum in the result list.  

------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
⏱️ Complexity:
- Time: O(n * k) → since each window requires scanning `k` elements.  
- Space: O(n-k+1) for storing results.  

------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
💻 Code (Brute-Force Java):
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
*/
import java.util.*; 

public class Solution {
    public static ArrayList<Integer> getMaximumOfSubarrays(ArrayList<Integer> arr, int k) {
        // Brute Force Approach ✅
        int n = arr.size();
        ArrayList<Integer> list = new ArrayList<>();

        for(int i = 0; i <= n - k; i++) {
            int maxi = arr.get(i);
            for(int j = i; j <= i + k - 1; j++) {
                maxi = Math.max(maxi, arr.get(j));
            }
            list.add(maxi);
        }
        return list;
    }
}
------------------------------------------------------------
