/*
------------------------------------------------------------------------------------------------------------------------------------------------------------
🪐 Problem: 2095. Delete the Middle Node of a Linked List
Platform: LeetCode
Difficulty: Medium
Tags: Linked List, Two Pointers

------------------------------------------------------------------------------------------------------------------------------------------------------------
📘 Problem Statement:
You are given the head of a linked list. Delete the middle node, and return the head of the modified linked list.

- The middle node of a linked list of size n is the ⌊n / 2⌋th node (0-based indexing).
- For n = 1, 2, 3, 4, and 5, the middle nodes are 0, 1, 1, 2, and 2 respectively.

------------------------------------------------------------------------------------------------------------------------------------------------------------
🔎 Example:
Input: head = [1,3,4,7,1,2,6]
Output: [1,3,4,1,2,6]

Input: head = [1,2,3,4]
Output: [1,2,4]

Input: head = [2,1]
Output: [2]

------------------------------------------------------------------------------------------------------------------------------------------------------------
🧠 Intuition:
We want to remove the middle node. Using **fast & slow pointers**:
- `fast` moves 2 steps, `slow` moves 1 step.
- When `fast` reaches the end, `slow` is at the middle.
- Keep track of `prev` (node before slow), then unlink `slow`.

------------------------------------------------------------------------------------------------------------------------------------------------------------
💡 Approach:
1. Edge case: if only 1 node → return null.
2. Initialize `slow`, `fast` at head, `prev = null`.
3. Move `fast` by 2 steps, `slow` by 1 step until `fast` reaches end.
4. Unlink middle → `prev.next = prev.next.next`.
5. Return head.

------------------------------------------------------------------------------------------------------------------------------------------------------------
⏱️ Complexity Analysis:
- Time: O(n) → single traversal of the list.
- Space: O(1) → only pointers used.

------------------------------------------------------------------------------------------------------------------------------------------------------------
✅ Code (Java):
*/

class Solution {
    public ListNode deleteMiddle(ListNode head) {
        if (head == null || head.next == null) return null;
        
        ListNode prev = null;
        ListNode slow = head;
        ListNode fast = head;
        
        // Move fast by 2 and slow by 1 until fast reaches end
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        
        // Delete middle node
        prev.next = prev.next.next;
        return head;
    }
}
