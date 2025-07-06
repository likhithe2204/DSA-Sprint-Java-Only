// LeetCode Problem: 160. Intersection of Two Linked Lists
// https://leetcode.com/problems/intersection-of-two-linked-lists/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // Optimal Approach : ✅✅✅

        if (headA == null)
            return headB;
        if (headB == null)
            return headA;
            
        ListNode temp1 = headA;
        ListNode temp2 = headB;
        while (temp1 != temp2) {
            temp1 = temp1.next; // keep on traversing
            temp2 = temp2.next; // keep on traversing
            if (temp1 == temp2)
                return temp1; // any time if they are equal return any of temp1 or temp2
            if (temp1 == null)
                temp1 = headB; // assume temp1 reached null => then point it to the opposite head & keep on traversing 
            if (temp2 == null)
                temp2 = headA; // assume temp2 reached null => then point it to the opposite head & keep on traversing 
        }
        return temp1; // even after opposite traversal => there might be a chance to reach null cuz, there is no intersection at all
    }
}
