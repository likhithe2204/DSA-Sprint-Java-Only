/*
---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
📌 Problem: 110. Balanced Binary Tree
---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
🚩 Statement:
Given a binary tree, determine if it is **height-balanced**.  
A binary tree is height-balanced if the depth of the two subtrees of every node never differs by more than one.  

---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
🎯 Input/Output:
Example 1:  
Input: root = [3,9,20,null,null,15,7]  
Output: true  

Example 2:  
Input: root = [1,2,2,3,3,null,null,4,4]  
Output: false  

Example 3:  
Input: root = []  
Output: true  

---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
💡 Intuition:
- For every node, check if the difference in height between left and right subtrees is more than 1.  
- If any node violates this condition, the tree is **not balanced**.  
- Use recursion to compute subtree heights and propagate `-1` when imbalance is detected.  

---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
⚙️ Approach:
1. Create a helper function `maxDepth()` that returns the subtree height if balanced, otherwise `-1`.  
2. If any recursive call returns `-1`, it means imbalance exists.  
3. The main function checks if the returned value is `-1` → `false`, else `true`.  

---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
⏱️ Complexity:
- Time: O(n), each node visited once.  
- Space: O(h), recursion stack where `h` is tree height.  

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
    public boolean isBalanced(TreeNode root) {
        int ans = maxDepth(root);
        if (ans == -1)
            return false;
        else
            return true;
    }

    // HelperFunction -> If Balanced BT returns height : else -1 ✅
    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;

        int lh = maxDepth(root.left);
        int rh = maxDepth(root.right);

        if (lh == -1 || rh == -1)
            return -1; // It's not Balanced BT 
        if (Math.abs(lh - rh) > 1)
            return -1; // It's not Balanced BT 

        return 1 + Math.max(lh, rh); // It's Balanced BT ✅
    }
}

