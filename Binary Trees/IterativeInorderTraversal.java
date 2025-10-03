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
- Inorder traversal means visiting nodes in the order: **Left → Root → Right**.  
- Recursive solution is simple, but we can also do this iteratively using a stack.  
- The idea is to traverse to the leftmost node first, process it, then move to the right subtree.  

---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
⚙️ Iterative Approach:
1. Create a stack and a pointer `node` starting at root.  
2. Traverse to the leftmost node, pushing nodes into the stack.  
3. When `node` becomes null:  
   - Pop from stack → this is the current node to process.  
   - Add its value to result.  
   - Move to its right child.  
4. Repeat until both stack and node are empty.  

---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
⏱️ Complexity:
- Time: O(n), each node is visited exactly once.  
- Space: O(n), stack usage in worst case (skewed tree).  

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
        // ITERATIVE InOrder Traversal (left root right) ✅
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();

        TreeNode node = root;

        while (true) {
            if (node != null) {
                st.push(node);
                node = node.left;
            } else {
                if (st.isEmpty())
                    break;

                node = st.pop();
                ans.add(node.val);
                node = node.right;
            }
        }

        return ans;
    }
}

