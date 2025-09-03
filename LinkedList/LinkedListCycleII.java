/*  

---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
📌 Problem: Linked List Cycle II (LeetCode 142)
---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
🚩 Statement:  
Given the head of a linked list, return the node where the cycle begins.  
If there is no cycle, return `null`.  

A cycle exists if a node in the list can be reached again by continuously following the `next` pointer.  
`pos` denotes the index of the node that tail connects to (-1 if no cycle).  
`pos` is not passed as a parameter.  

⚠️ Do not modify the linked list.  

---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
📥 Input/Output:  

Example 1:  
Input: head = [3,2,0,-4], pos = 1  
Output: tail connects to node index 1  
Explanation: There is a cycle where tail connects to the second node.  

Example 2:  
Input: head = [1,2], pos = 0  
Output: tail connects to node index 0  
Explanation: Cycle exists at the head node.  

Example 3:  
Input: head = [1], pos = -1  
Output: no cycle  
Explanation: There is no cycle in the linked list.  

Constraints:  
- Number of nodes in the list: [0, 10^4]  
- Node values: [-10^5, 10^5]  
- `pos` = -1 or a valid index  

---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
💡 Intuition:  
This is a **Floyd’s Tortoise and Hare Algorithm** problem.  
- First detect if a cycle exists using two pointers (`slow`, `fast`).  
- If they meet, reset one pointer to `head` and move both one step at a time.  
- The point where they meet again is the start of the cycle.  

---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
🔎 Approach:  
1. Initialize `slow` and `fast` pointers at `head`.  
2. Move `slow` by 1 and `fast` by 2 until they meet or `fast` reaches null.  
3. If no cycle → return `null`.  
4. If they meet, reset `slow` to `head`.  
5. Move both one step at a time until `slow == fast`.  
6. Return the node → cycle start.  

---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
⏱️ Complexity:  
- Time: O(n), where `n` is the number of nodes.  
- Space: O(1), constant memory used.  

---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
💻✅ Code:
---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
*/

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                slow = head;
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow; // cycle entry point
            }
        }
        return null; // no cycle
    }
}
