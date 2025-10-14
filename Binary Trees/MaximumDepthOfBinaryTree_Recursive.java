/*
---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
📌 Problem: 104. Maximum Depth of Binary Tree
---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
🚩 Statement:
Given the root of a binary tree, return its **maximum depth**.  
A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.  

---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
🎯 Input/Output:
Example 1:  
Input: root = [3,9,20,null,null,15,7]  
Output: 3  

Example 2:  
Input: root = [1,null,2]  
Output: 2  

---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
💡 Intuition:
- The maximum depth of a binary tree can be found recursively by exploring both left and right subtrees.  
- For every node, the maximum depth equals `1 + max(leftDepth, rightDepth)`.  
- The base case is when the node is `null`, meaning no depth (return 0).  

---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
⚙️ Approach:
1. If `root` is `null`, return 0.  
2. Recursively find the maximum depth of the left and right subtrees.  
3. Return `1 + max(leftDepth, rightDepth)` for each node.  
4. This ensures we accumulate the longest possible path from root to leaf.  

---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
⏱️ Complexity:
- Time: O(n), since every node is visited once.  
- Space: O(h), where `h` is the height of the tree (recursion stack).  

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
    public int maxDepth(TreeNode root) {
        // Most Optimal Approach : 1 + max(left, right) ✅

        if (root == null)
            return 0;

        int lh = maxDepth(root.left);
        int rh = maxDepth(root.right);
        
        return 1 + Math.max(lh, rh);
    }
}

