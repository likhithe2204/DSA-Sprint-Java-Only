/*
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
💡 Problem: Find the Length of the Linked List
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
📝 Statement:
You are given the head of a singly linked list. Your task is to return the number of nodes in the linked list.

------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
📥 Input / 📤 Output:
Input: head = [1, 2, 3, 4, 5]  
Output: 5  

Input: head = [8, 6]  
Output: 2  

Input: head = [1]  
Output: 1  

------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
🧠 Intuition:
- The length of a linked list is simply the count of nodes until the end (`null`) is reached.
- Traverse the list node by node while maintaining a counter.

------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
⚡ Approach:
1. Initialize a counter `cnt = 0`.
2. Start traversing from head node.
3. For every node, increment counter by 1.
4. Stop once the node pointer reaches `null`.
5. Return counter.

------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
⏱️ Complexity:
- Time: O(n) → Traverse all nodes once.  
- Space: O(1) → Only a counter variable is used.

------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
💻 Code (Java):
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int val) { this.val = val; }
 * }
 */
class Solution {
    public int getLength(ListNode head) {
        ListNode temp = head;
        int cnt = 0;
        while (temp != null) {
            cnt++;
            temp = temp.next;
        }
        return cnt;
    }
}
