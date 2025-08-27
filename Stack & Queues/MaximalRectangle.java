/*  

------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------  

📌 Problem: Maximum Rectangle in a Binary Matrix  
🔹 Platform: LeetCode Hard (85. Maximal Rectangle)  
🔹 Category: Dynamic Programming + Stack  
🔹 Difficulty: Hard  

------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------  

📝 Problem Statement:  
Given an m x n binary matrix filled with 0's and 1's,  
find the largest rectangle containing only 1's and return its area.  

------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------ 

💡 Examples:  
Input: matrix = [[1,0,1,0,0],  
                 [1,0,1,1,1],  
                 [1,1,1,1,1],  
                 [1,0,0,1,0]]  
Output: 6  

Input: matrix = [[1]]  
Output: 1  

------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------ 

🎯 Intuition:  
- Treat each row as a histogram.  
- Heights represent consecutive 1’s vertically.  
- Apply "Largest Rectangle in Histogram" (LRH) for each row.  

------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------ 

⚡ Approach:  
1. Build prefix heights for each column.  
2. For each row → apply LRH using stack.  
3. Find Previous Smaller Element (PSE) and Next Smaller Element (NSE).  
4. Compute area = height[i] * (nse[i] - pse[i] - 1).  
5. Track maximum area.  

------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------ 

⏱️ Complexity Analysis:  
- Time: O(n*m)  
- Space: O(n*m) (prefix matrix)  

------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------ 

✅ Code (Java):  
*/

import java.util.*;

class Solution {
    public int maximalAreaOfSubMatrixOfAll1(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] prefixSum = new int[n][m];
        int maxArea = 0;

        // Build prefix sum heights column-wise
        for (int j = 0; j < m; j++) {
            int sum = 0;
            for (int i = 0; i < n; i++) {
                sum += matrix[i][j];
                if (matrix[i][j] == 0) sum = 0;
                prefixSum[i][j] = sum;
            }
        }

        // Apply Largest Rectangle in Histogram for each row
        for (int row = 0; row < n; row++) {
            maxArea = Math.max(maxArea, largestRectangleArea(prefixSum[row]));
        }
        return maxArea;
    }

    public int largestRectangleArea(int[] heights) {
        int[] nse = findNSE(heights);
        int[] pse = findPSE(heights);
        int n = heights.length, maxi = 0;

        for (int i = 0; i < n; i++) {
            maxi = Math.max(maxi, heights[i] * (nse[i] - pse[i] - 1));
        }
        return maxi;
    }

    // Next Smaller Element
    public int[] findNSE(int[] arr) {
        int n = arr.length;
        int[] nse = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) st.pop();
            nse[i] = (st.isEmpty()) ? n : st.peek();
            st.push(i);
        }
        return nse;
    }

    // Previous Smaller Element
    public int[] findPSE(int[] arr) {
        int n = arr.length;
        int[] pse = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) st.pop();
            pse[i] = (st.isEmpty()) ? -1 : st.peek();
            st.push(i);
        }
        return pse;
    }
}
