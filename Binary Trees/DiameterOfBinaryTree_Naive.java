/*
---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
📌 Problem: 543. Diameter of Binary Tree
---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
🚩 Statement:
Given the root of a binary tree, return the **length of the diameter** of the tree.  
The diameter of a binary tree is the length of the longest path between any two nodes in the tree.  
This path may or may not pass through the root.  

---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
🎯 Input/Output:
Example 1:  
Input: root = [1,2,3,4,5]  
Output: 3  
Explanation: The longest path is [4,2,1,3] or [5,2,1,3].  

Example 2:  
Input: root = [1,2]  
Output: 1  

---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
💡 Intuition:
- The **diameter** represents the **maximum number of edges** between any two nodes.  
- For each node, the longest path passing through it is `leftHeight + rightHeight`.  
- To find the true diameter, compute this value for all nodes and return the maximum.  

---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
⚙️ Approach:
1. For each node, find the **height of its left** and **right** subtrees.  
2. The potential diameter through that node = `leftHeight + rightHeight`.  
3. Recursively compute the diameter for all nodes.  
4. Return the **maximum diameter** found across all subtrees.  

---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
⏱️ Complexity:
- Time: O(n²), since `height()` is called for each node recursively.  
- Space: O(h), recursion stack where `h` is the tree height.  

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
    public int diameterOfBinaryTree(TreeNode root) {
        // Naive Approach : for each current node compute Sum(lh , rh) ✅

        if (root == null)
            return 0;

        // get left & right subtree heights separately to find path length through this node
        int lh = height(root.left);
        int rh = height(root.right);

        int diameter = lh + rh;

        // Recursively calculate the diameters of left and right subtrees.
        int ld = diameterOfBinaryTree(root.left);
        int rd = diameterOfBinaryTree(root.right);

        // pick the max diameter — either through this node, or entirely in left/right subtree ✅
        return Math.max(diameter, Math.max(ld, rd));
    }

    // helper function : To compute the height of subtree.
    public int height(TreeNode root) {
        if (root == null)
            return 0;

        return 1 + Math.max(height(root.left), height(root.right));
    }
}

