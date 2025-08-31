/*

---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
📌 Problem: Reverse a Linked List
---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
🚩 Statement:
Given the head of a singly linked list, reverse the list and return its head.

---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
📥 Input/ 📥 Output:

Example 1:
Input: head = [1, 2, 3, 4, 5]
Output: [5, 4, 3, 2, 1]

Example 2:
Input: head = [10, 20, 30]
Output: [30, 20, 10]

Example 3:
Input: head = []
Output: []

---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
💡 Intuition:
To reverse a linked list, we need to "flip" the direction of all `next` pointers.
At each step, make the current node point to the previous node while moving forward.

---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
🔎 Approach:
- Initialize three pointers: `prev = null`, `curr = head`, `next = null`.
- Traverse through the list:
  - Store `curr.next` in `next`.
  - Set `curr.next = prev`.
  - Move `prev = curr`, `curr = next`.
- At the end, `prev` will be the new head of the reversed list.

---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
⏱️ Complexity:
Time Complexity: O(N) (one traversal of the list).
Space Complexity: O(1) (in-place reversal, no extra space).

---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
💻 Code (Java):
---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
*/

class Solution {
    // Function to reverse a linked list
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode temp = head;

        while (temp != null) {
            ListNode front = temp.next; // temporarily store next node
            temp.next = prev;          // reverse the pointer
            prev = temp;               // move prev forward
            temp = front;               // move curr forward
        }
        return prev; // new head after reversal
    }
}
