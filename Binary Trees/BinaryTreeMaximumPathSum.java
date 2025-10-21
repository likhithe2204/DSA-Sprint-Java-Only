/*
---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
📌 Problem: 124. Binary Tree Maximum Path Sum
---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
🚩 Statement:
A **path** in a binary tree is a sequence of connected nodes where each node appears **at most once**.  
The **path sum** is the sum of all node values in that path.  
The path **does not need to pass through the root**.  
Given the root of a binary tree, return the **maximum path sum** of any non-empty path.  

---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
🎯 Input/Output:
Example 1:  
Input: root = [1,2,3]  
Output: 6  
Explanation: The optimal path is 2 → 1 → 3 with a sum = 2 + 1 + 3 = 6.  

Example 2:  
Input: root = [-10,9,20,null,null,15,7]  
Output: 42  
Explanation: The optimal path is 15 → 20 → 7 with a sum = 15 + 20 + 7 = 42.  

---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
💡 Intuition:
- For every node, there are two possibilities:
  1. The **maximum path** passing **through** this node = `left + node.val + right`.  
  2. The **maximum path** continuing **upward** (to parent) = `node.val + max(left, right)`.  
- We recursively compute the **maximum gain** from left and right subtrees and update a global variable with the best sum seen so far.  
- If the sum from any side is negative, we ignore it (take `0`) because it reduces the total sum.  

---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
⚙️ Approach:
1. Use a global variable `maxi` to track the **maximum path sum** found so far.  
2. Define a helper function `findMaxPathSum(node)` that:
   - Returns the **max gain** from that node to its parent.  
   - Updates `maxi` with the best path that passes **through** the current node.  
3. Return the global `maxi` after traversal.  

---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
⏱️ Complexity:
- **Time:** O(n), since every node is visited once.  
- **Space:** O(h), recursion stack (where `h` is the tree height).  

---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
💻 Code (Java):
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public static int maxi = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxi = Integer.MIN_VALUE; // Reset before each call ✅
        findMaxPathSum(root);
        return maxi;
    }

    public int findMaxPathSum(TreeNode node) {
        if (node == null)
            return 0;

        int leftMaxPath = Math.max(0, findMaxPathSum(node.left));  // Ignore negatives
        int rightMaxPath = Math.max(0, findMaxPathSum(node.right)); // Ignore negatives

        maxi = Math.max(maxi, leftMaxPath + node.val + rightMaxPath); // Path through node
        return node.val + Math.max(leftMaxPath, rightMaxPath); // Return best single path
    }
}

