/*

---------------------------------------------------------------------------------------------------------------------------------------
🔹 Platform: LeetCode  
🗂 Category: Linked List / Two Pointers  
📊 Difficulty: Easy  

---------------------------------------------------------------------------------------------------------------------------------------
📝 Problem Statement:  
Given the head of a singly linked list, return the middle node of the linked list.  
If there are two middle nodes, return the second middle node.  

---------------------------------------------------------------------------------------------------------------------------------------
💡 Examples:  
Input: head = [1,2,3,4,5]  
Output: [3,4,5]  

Input: head = [1,2,3,4,5,6]  
Output: [4,5,6]  

---------------------------------------------------------------------------------------------------------------------------------------
⏳ Constraints:  
- The number of nodes is in the range [1, 100]  
- 1 <= Node.val <= 100  

---------------------------------------------------------------------------------------------------------------------------------------
💭 Intuition:  
Use the **Tortoise & Hare Algorithm (slow & fast pointers)**:  
- Move `slow` one step at a time.  
- Move `fast` two steps at a time.  
- When `fast` reaches the end, `slow` will be at the middle.  
- If two middles exist, `slow` naturally lands on the second one.  

---------------------------------------------------------------------------------------------------------------------------------------
⚙️ Approach:  
1. Initialize two pointers `slow` and `fast` at head.  
2. Traverse until `fast` reaches the end.  
   - Move `slow = slow.next`  
   - Move `fast = fast.next.next`  
3. Return `slow` (middle node).  

---------------------------------------------------------------------------------------------------------------------------------------
⏱ Time Complexity: O(n) — traverse list once.  
📦 Space Complexity: O(1) — only pointers used.  
*/

---------------------------------------------------------------------------------------------------------------------------------------
👨🏻‍💻 Code:
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode middleNode(ListNode head) {
        // Optimal Approach:
        //                  - Tortoise & Hare Algorithm✅

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
}
