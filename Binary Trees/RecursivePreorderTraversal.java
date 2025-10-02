/*
---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
📌 Problem: 144. Binary Tree Preorder Traversal
---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
🚩 Statement:
Given the root of a binary tree, return the preorder traversal of its nodes' values.

---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
🎯 Input/Output:
Example 1:
Input: root = [1,null,2,3]
Output: [1,2,3]

Example 2:
Input: root = [1,2,3,4,5,null,8,null,null,6,7,9]
Output: [1,2,4,5,6,7,3,8,9]

Example 3:
Input: root = []
Output: []

Example 4:
Input: root = [1]
Output: [1]

---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
💡 Intuition:
- Preorder traversal follows Root → Left → Right.
- Recursive implementation is straightforward: visit the root, then traverse left, then right.
- Iterative can be done using a stack, but recursion is simplest for clarity.

---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
⚙️ Recursive Approach:
1. Start from root.
2. Add current node’s value to result.
3. Recurse into left subtree.
4. Recurse into right subtree.

---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
⏱️ Complexity:
- Time: O(n) (each node visited once).
- Space: O(h) recursion stack, where h is tree height (O(n) worst-case skew, O(log n) balanced).

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
    public List<Integer> preorderTraversal(TreeNode root) {
        // Recursive Pre-order Traversal : (root left right) ✅

        List<Integer> ans = new ArrayList<>();
        preorder(root, ans);
        return ans;
    }

    public void preorder(TreeNode root, List<Integer> res) {
        if (root == null)
            return;
            
        res.add(root.val); // ✅root
        preorder(root.left, res); // ✅left 
        preorder(root.right, res); // ✅right
    }
}
