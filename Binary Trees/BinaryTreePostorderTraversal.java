/*
---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
📌 Problem: 145. Binary Tree Postorder Traversal
---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
🚩 Statement:
Given the root of a binary tree, return the postorder traversal of its nodes' values.  

---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
🎯 Input/Output:
Example 1:  
Input: root = [1,null,2,3]  
Output: [3,2,1]  

Example 2:  
Input: root = [1,2,3,4,5,null,8,null,null,6,7,9]  
Output: [4,6,7,5,2,9,8,3,1]  

Example 3:  
Input: root = []  
Output: []  

Example 4:  
Input: root = [1]  
Output: [1]  

---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
💡 Intuition:
- Postorder traversal follows **Left → Right → Root**.  
- Recursive solution is very simple: traverse left, then right, then visit root.  
- Iterative approaches use two stacks or reversed preorder.  

---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
⚙️ Approach:
1. Start from the root node.  
2. Recursively traverse the left subtree.  
3. Recursively traverse the right subtree.  
4. Add the current node’s value.  

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
    public List<Integer> postorderTraversal(TreeNode root) {
        // Post-order Traversal : (left right root) ✅
        List<Integer> ans = new ArrayList<>();
        postorder(root, ans);
        return ans;
    }

    public void postorder(TreeNode node, List<Integer> res) {
        if (node == null)
            return;
        postorder(node.left, res);  // ✅ left
        postorder(node.right, res); // ✅ right
        res.add(node.val);          // ✅ root
    }
}

