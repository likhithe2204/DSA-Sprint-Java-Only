/*
---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
📌 Problem: 102. Binary Tree Level Order Traversal
---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
🚩 Statement:
Given the root of a binary tree, return the level order traversal of its nodes' values.  
(i.e., from left to right, level by level).  

---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
🎯 Input/Output:
Example 1:  
Input: root = [3,9,20,null,null,15,7]   
Output: [[3],[9,20],[15,7]]  

Example 2:  
Input: root = [1]  
Output: [[1]]  

Example 3:  
Input: root = []  
Output: []  

---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
💡 Intuition:
- We need to traverse the tree level by level.  
- This can be efficiently achieved using **Breadth-First Search (BFS)** with a queue.  
- For each level, process all nodes at that level before moving to the next.  

---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
⚙️ Approach:
1. Use a queue to store nodes level by level.  
2. For each level:  
   - Record the size of the queue (`n`).  
   - Process `n` nodes, pushing their children into the queue.  
   - Add all values of that level into a temporary list.  
3. Append each level’s list into the final result.  

---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
⏱️ Complexity:
- Time: O(n), where n = number of nodes.  
- Space: O(n), queue + output list.  

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
    public List<List<Integer>> levelOrder(TreeNode root) {
        // Level Order Traversal using BFS ✅
        Queue<TreeNode> q = new LinkedList<>();
        List<List<Integer>> ans = new LinkedList<>();

        if (root == null)
            return ans;

        q.add(root);

        while (!q.isEmpty()) {
            int n = q.size();
            List<Integer> sublist = new LinkedList<>();

            for (int i = 0; i < n; i++) {
                TreeNode node = q.poll();
                sublist.add(node.val);

                if (node.left != null)
                    q.add(node.left);

                if (node.right != null)
                    q.add(node.right);
            }
            ans.add(sublist);
        }
        return ans;
    }
}

