// LeetCode Problem: 2. Add Two Numbers
// https://leetcode.com/problems/add-two-numbers/

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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // Optimal Approach : Instead of using external data structure
        //                    Use Dummy Node concept✅✅✅

        // Edge Cases: 
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;

        ListNode temp1 = l1;
        ListNode temp2 = l2;
        ListNode dummyNode = new ListNode(-1); // create a dummyNode
        ListNode curr = dummyNode; // also take another pointer, initially pointing to dummyNode
        boolean flag = false;
        int carry = 0;
        while (temp1 != null || temp2 != null || carry != 0) {
            int v1 = 0;
            int v2 = 0;
            int value = 0;
            if (temp1 != null)
                v1 = temp1.val;
            if (temp2 != null)
                v2 = temp2.val;
            value = v1 + v2 + carry;
            if (value <= 9) {
                ListNode newNode = new ListNode(value); // create a new node with that value
                curr.next = newNode; // and connect the link b/w dummyNode.next and our first node with sum of digits
                curr = newNode; // make sure you move curr as well for next link to connect
                carry = 0;
                flag = false;
            } else {
                value = value % 10;
                ListNode newNode = new ListNode(value); // create a new node of that digits sum
                curr.next = newNode; // similarly make the link
                curr = newNode; // and move curr as well for future nodes to connect
                carry = 1;
                flag = true;
            }
            if (temp1 != null)
                temp1 = temp1.next;
            if (temp2 != null)
                temp2 = temp2.next;
        }
        return dummyNode.next; // just return the head => which is dummyNode.next
    }
}
