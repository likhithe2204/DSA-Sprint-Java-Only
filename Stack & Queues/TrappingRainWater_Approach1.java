/*
🔹 Problem: Trapping Rain Water
🔹 Platform: GeeksforGeeks / LeetCode
🔹 Difficulty: Hard
🔹 Category: Arrays / Prefix-Suffix / Two Pointers

------------------------------------------------------------------------------------------------------------------------------------------
📖 Problem Statement:
Given an array arr[] with non-negative integers representing the height of blocks.  
If the width of each block is 1, compute how much water can be trapped between the blocks during the rainy season.

------------------------------------------------------------------------------------------------------------------------------------------
📝 Examples:
Input: arr[] = [3, 0, 1, 0, 4, 0, 2]  
Output: 10  
Explanation: Total water trapped = 0 + 3 + 2 + 3 + 0 + 2 + 0 = 10 units.  

Input: arr[] = [3, 0, 2, 0, 4]  
Output: 7  
Explanation: Total water trapped = 0 + 3 + 1 + 3 + 0 = 7 units.  

Input: arr[] = [1, 2, 3, 4]  
Output: 0  

------------------------------------------------------------------------------------------------------------------------------------------
⚡ Constraints:
1 < arr.length <= 10^5  
0 <= arr[i] <= 10^3  

------------------------------------------------------------------------------------------------------------------------------------------
💡 Intuition:
Water above index i is trapped only if there exist taller (or equal) buildings  
on both left and right sides.  
Trapped water at i = min(max height to the left, max height to the right) - height[i].

------------------------------------------------------------------------------------------------------------------------------------------
🛠️ Approach (Prefix-Suffix Optimization):
1️⃣ Compute prefix max array → leftMax[i]  
2️⃣ Compute suffix max array → rightMax[i]  
3️⃣ Traverse array → For each index, trapped water = min(leftMax[i], rightMax[i]) - height[i]  
4️⃣ Sum all contributions → return total.  

------------------------------------------------------------------------------------------------------------------------------------------
⏱️ Complexity Analysis:
Time Complexity: O(n) ✅  
Space Complexity: O(n) ✅  

------------------------------------------------------------------------------------------------------------------------------------------
💻 Code:
*/

class Solution {
    // helper: compute prefix max
    public int[] findPrefixMax(int[] arr, int n) {
        int[] prefixMax = new int[n];
        prefixMax[0] = arr[0];
        for (int i = 1; i < n; i++) {
            prefixMax[i] = Math.max(prefixMax[i - 1], arr[i]);
        }
        return prefixMax;
    }

    // helper: compute suffix max
    public int[] findSuffixMax(int[] arr, int n) {
        int[] suffixMax = new int[n];
        suffixMax[n - 1] = arr[n - 1];
        for (int i = n - 2; i >= 0; i--) {   
            suffixMax[i] = Math.max(suffixMax[i + 1], arr[i]);
        }
        return suffixMax;
    }

    public int maxWater(int height[]) {
        int n = height.length;
        int total = 0;

        int[] leftMax = findPrefixMax(height, n);
        int[] rightMax = findSuffixMax(height, n);

        for (int i = 0; i < n; i++) {
            if (height[i] < leftMax[i] && height[i] < rightMax[i]) {
                total += (Math.min(leftMax[i], rightMax[i]) - height[i]);
            }
        }
        return total;
    }
}
