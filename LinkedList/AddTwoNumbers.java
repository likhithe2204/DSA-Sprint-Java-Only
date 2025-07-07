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
import java.util.*;

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;

        ListNode temp1 = l1;
        ListNode temp2 = l2;
        List<Integer> res = new ArrayList<>();
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
                res.add(value);
                carry = 0;
                flag = false;
            } else {
                value = value % 10;
                res.add(value);
                carry = 1;
                flag = true;
            }
            if (temp1 != null)
                temp1 = temp1.next;
            if (temp2 != null)
                temp2 = temp2.next;
        }

        ListNode head = convertArr2LL(res);
        return head;
    }

    public ListNode convertArr2LL(List<Integer> res) {
        ListNode head = new ListNode(res.get(0));
        ListNode mover = head;
        for (int i = 1; i < res.size(); i++) {
            ListNode temp = new ListNode(res.get(i));
            mover.next = temp;
            mover = temp;
        }
        return head;
    }
}
