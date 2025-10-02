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
- Preorder traversal means visiting nodes in the order: **Root → Left → Right**.  
- We can solve it **recursively** or **iteratively using a stack**.  
- Iterative avoids recursion overhead and is interview-friendly.  

---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
⚙️ Iterative Approach:
1. Use a stack to simulate recursion.  
2. Push the root node into the stack.  
3. While the stack is not empty:  
   - Pop the current node, add its value to result.  
   - Push its right child first, then left child (so left is processed first).  
4. Return the result list.  

---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
⏱️ Complexity:
- Time: O(n), since each node is processed once.  
- Space: O(n), worst case stack usage.  

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
        // ITERATIVE PreOrder Traversal -> (root left right) ✅
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();

        if (root == null)
            return ans;

        st.push(root);

        while (!st.isEmpty()) {
            TreeNode currentNode = st.pop();
            ans.add(currentNode.val);

            if (currentNode.right != null)
                st.push(currentNode.right);
            if (currentNode.left != null)
                st.push(currentNode.left);
        }

        return ans;
    }
}
