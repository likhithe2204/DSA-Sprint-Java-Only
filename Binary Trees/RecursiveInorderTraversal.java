/*
---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
📌 Problem: 94. Binary Tree Inorder Traversal
---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
🚩 Statement:
Given the root of a binary tree, return the inorder traversal of its nodes' values.  

---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
🎯 Input/Output:
Example 1:  
Input: root = [1,null,2,3]  
Output: [1,3,2]  

Example 2:  
Input: root = [1,2,3,4,5,null,8,null,null,6,7,9]  
Output: [4,2,6,5,7,1,3,9,8]  

Example 3:  
Input: root = []  
Output: []  

Example 4:  
Input: root = [1]  
Output: [1]  

---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
💡 Intuition:
- Inorder traversal follows **Left → Root → Right**.  
- Recursive solution is straightforward: traverse left, visit root, traverse right.  
- Iterative approach can be done using a stack, but recursion is simplest.  

---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
⚙️ Recursive Approach:
1. Start from the root node.  
2. Recursively traverse the left subtree.  
3. Add the current node’s value.  
4. Recursively traverse the right subtree.  

---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
⏱️ Complexity:
- Time: O(n), where n = number of nodes (visit each once).  
- Space: O(h) recursion stack, where h = tree height (O(n) worst-case skew, O(log n) balanced).  

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
    public List<Integer> inorderTraversal(TreeNode root) {
        // Recursive In-order traversal : (left root right) ✅
        List<Integer> ans = new ArrayList<>();
        inorder(root, ans);
        return ans;
    }

    public void inorder(TreeNode node, List<Integer> res) {
        if (node == null)
            return;
        inorder(node.left, res); // ✅ left
        res.add(node.val);       // ✅ root
        inorder(node.right, res);// ✅ right
    }
}

