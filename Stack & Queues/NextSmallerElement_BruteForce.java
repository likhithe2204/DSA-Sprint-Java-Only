/*
---------------------------------------------------------------------------------------------------------------------------------------

🔥 Problem: Next Smaller Element  
Difficulty: Medium  
Platform: LeetCode / GFG , Tuf+ 
---------------------------------------------------------------------------------------------------------------------------------------

📝 Problem Statement:  
Given an array of integers `arr`, find the Next Smaller Element (NSE) for every element.  
The NSE for an element x is the first element to the right of x that is smaller than x.  
If there is no smaller element to the right, return -1 for that index.  
---------------------------------------------------------------------------------------------------------------------------------------

🔍 Example:  
Input: arr = [4, 8, 5, 2, 25]  
Output: [2, 5, 2, -1, -1]  
---------------------------------------------------------------------------------------------------------------------------------------

💡 Intuition:  
For each element, we need to look to the right and check if a smaller element exists.  
The first smaller element we encounter becomes the answer for that index.  
If no smaller element is found, return -1.  
---------------------------------------------------------------------------------------------------------------------------------------

🚀 Approach (Brute Force):  
- Iterate through each element `arr[i]`.  
- For every element, loop through the right subarray (`arr[j], j > i`) to find the first smaller element.  
- Store the result in `nse[]`.  
- If no smaller element exists, store -1.  
---------------------------------------------------------------------------------------------------------------------------------------

⏱️ Complexity Analysis:  
- **Time:** O(n²) → Two nested loops (worst case).  
- **Space:** O(n) → Extra array to store results.   
---------------------------------------------------------------------------------------------------------------------------------------
*/

class Solution {
    public int[] nextSmallerElements(int[] arr) {
        // Brute-Force Approach : Using Two Pointers. ✅

        int n = arr.length;
        int[] nse = new int[n];

        for (int i = 0; i < n; i++) {
            int nextSmaller = -1;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[i]) {
                    nextSmaller = arr[j];
                    break;
                }
            }
            nse[i] = nextSmaller;
        }

        return nse;
    }
}
