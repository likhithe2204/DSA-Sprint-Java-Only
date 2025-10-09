#dsa_perfectblock

---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
📌 Problem: 120. Triangle
---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
🚩 Statement:
Given a triangle array, return the minimum path sum from top to bottom.  

For each step, you may move to an adjacent number of the row below. More formally, if you are on index i on the current row, you may move to either index i or index i + 1 on the next row.  

---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
🎯 Input/Output: 
Example 1:
Input: triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]   
Output: 11  
Explanation: Path = 2 + 3 + 5 + 1 = 11  

Example 2:
Input: triangle = [[-10]]  
Output: -10  

---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
💡 Intuition:
- Starting from the bottom of the triangle, compute the minimum path sum for each cell.  
- Each cell can move to two adjacent cells in the row below → so update it as:  
  `tri[i][j] = tri[i][j] + min(tri[i+1][j], tri[i+1][j+1])`  
- Keep rolling up until the top is reached.  
- Finally, `tri[0][0]` contains the minimum path sum.  

---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
⚙️ Approach:
1. Start from the second-last row and move upwards.  
2. For each element, choose the smaller of its two adjacent children.  
3. Update the element with current value + chosen minimum.  
4. Return the updated top element.  

---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
⏱️ Complexity:
- Time: O(n²) (we process each element once, where n = number of rows).  
- Space: O(1) extra (in-place DP).  

---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
💻 Code (Java):
class Solution {
    public int minimumTotal(List<List<Integer>> tri) {
        for (int i = tri.size() - 2; i >= 0; i--)
            for (int j = 0; j < tri.get(i).size(); j++)
                tri.get(i).set(j, tri.get(i).get(j) + Math.min(
                    tri.get(i + 1).get(j),
                    tri.get(i + 1).get(j + 1)
                ));
        return tri.get(0).get(0);
    }
}

