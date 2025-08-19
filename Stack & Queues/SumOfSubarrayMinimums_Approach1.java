/*
📝 Problem: Sum of Subarray Minimums
Difficulty: Medium
Platform: Coding Ninjas / LeetCode Style
Category: Subarrays / Brute Force
--------------------------------------------------------------------------------------------------------------------------------------

📌 Problem Statement:
You are given an array 'arr' of length ‘N’.
Let ‘X’ be the minimum element of any contiguous subarray of ‘arr’.
You need to return the sum of 'X' over all the contiguous subarrays of 'arr'.
Since the answer may be large, return it modulo 10^9+7.

--------------------------------------------------------------------------------------------------------------------------------------

🎯 Example 1:
Input: arr = [1, 2, 3, 4], N = 4
Output: 20 ✅

🎯 Example 2:
Input: arr = [1, 5, 3], N = 3
Output: 14 ✅

🎯 Example 3:
Input: arr = [5, 10, 5, 10], N = 4
Output: 60 ✅

--------------------------------------------------------------------------------------------------------------------------------------

⚡ Intuition:
- Generate all possible subarrays.
- For each subarray, find the minimum element.
- Add the minimum to the running sum.
- Take modulo 1e9+7.

--------------------------------------------------------------------------------------------------------------------------------------

🛠 Approach (Brute Force):
1. Loop over all subarray starting indices.
2. For each starting index, loop over ending indices.
3. Track the minimum element of the current subarray.
4. Keep updating the result.

⏱ Time Complexity: O(N^2)
📦 Space Complexity: O(1)

--------------------------------------------------------------------------------------------------------------------------------------

✅ Brute Force Code:
*/
public class Solution {
    public static int sumSubarrayMins(int []arr) {
        int n = arr.length;
        int sum = 0;
        int mod = (int)1e9+7;

        for(int i = 0; i < n; i++){
            int min = arr[i];
            for(int j = i; j < n; j++){
                min = Math.min(min, arr[j]);
                sum = (sum + min) % mod;
            }
        }
        return sum;
    }
}
