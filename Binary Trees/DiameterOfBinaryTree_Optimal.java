---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
📌 Problem: 543. Diameter of Binary Tree
---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
🚩 Statement:
Given the root of a binary tree, return the **length of the diameter** of the tree.  
The diameter of a binary tree is the length of the longest path between any two nodes in the tree.  
This path may or may not pass through the root.  
The **length** of a path is defined as the **number of edges** between the two nodes.  

---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
🎯 Input/Output:
Example 1:  
Input: root = [1,2,3,4,5]  
Output: 3  
Explanation: The longest paths are [4,2,1,3] or [5,2,1,3].  

Example 2:  
Input: root = [1,2]  
Output: 1  

---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
💡 Intuition:
- The **diameter** represents the **longest path** between any two nodes in the binary tree.  
- For each node, the **longest path passing through it** is the sum of the **heights** of its left and right subtrees (`lh + rh`).  
- The idea is to calculate height recursively and update the **maximum diameter** during traversal.  

---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
⚙️ Approach:
1. Use a global variable `maxDiameter` to store the maximum diameter found so far.  
2. For each node, compute:
   - `lh = height(left subtree)`
   - `rh = height(right subtree)`
3. Update `maxDiameter = max(maxDiameter, lh + rh)` at every step.  
4. Return height as `1 + max(lh, rh)` for recursion.  
5. Finally, return `maxDiameter` as the result.  

---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
⏱️ Complexity:
- **Time:** O(n), each node is visited once.  
- **Space:** O(h), recursion stack space where `h` is the height of the tree.  

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

import java.util.*;

class Solution {
    public static int maxDiameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        // Optimal Approach ✅

        maxDiameter = 0; // Reset in case of multiple calls.
        findHeight(root);
        return maxDiameter;
    }

    public int findHeight(TreeNode root) {
        if (root == null)
            return 0;

        int lh = findHeight(root.left);
        int rh = findHeight(root.right);

        maxDiameter = Math.max(maxDiameter, lh + rh); // Update the diameter if current path is longest.
        return 1 + Math.max(lh, rh); // Return height of current subtree.
    }
}

