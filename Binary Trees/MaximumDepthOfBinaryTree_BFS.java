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
- The depth of a tree increases by 1 each time we move one level down.  
- We can calculate it using **Level Order Traversal (BFS)** by counting the number of levels.  
- Alternatively, this can also be done using recursion (DFS), but BFS helps visualize each level.  

---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
⚙️ Approach:
1. If `root` is `null`, return 0.  
2. Initialize a queue for level-order traversal.  
3. For each level:
   - Record the number of nodes at that level (`n = q.size()`).
   - Process all nodes, pushing their left and right children to the queue.
   - After processing one level, increment depth by 1.
4. Return the total depth after the traversal ends.  

---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
⏱️ Complexity:
- Time: O(n) — every node is visited once.  
- Space: O(n) — queue stores nodes level-wise.  

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
        // Level Order Traversal (BFS) ✅
        if (root == null)
            return 0;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int depth = 0;

        while (!q.isEmpty()) {
            int n = q.size();

            for (int i = 0; i < n; i++) {
                TreeNode node = q.poll();

                if (node.left != null)
                    q.add(node.left);
                if (node.right != null)
                    q.add(node.right);
            }
            depth++;
        }
        return depth;
    }
}

