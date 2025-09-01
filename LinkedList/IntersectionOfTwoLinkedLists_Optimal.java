/*

---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
📌 Problem: Intersection of Two Linked Lists (LeetCode 160)
---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
🚩 Statement:
Given the heads of two singly linked lists `headA` and `headB`, return the node at which the two lists intersect. 
If the two linked lists have no intersection at all, return null. 
The linked lists must retain their original structure after the function returns.

---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
📥 Input/ 📥 Output:

Example 1:
Input: listA = [4,1,8,4,5], listB = [5,6,1,8,4,5], intersectVal = 8
Output: Intersected at '8'

Example 2:
Input: listA = [1,9,1,2,4], listB = [3,2,4], intersectVal = 2
Output: Intersected at '2'

Example 3:
Input: listA = [2,6,4], listB = [1,5], intersectVal = 0
Output: No intersection

---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
💡 Intuition:
If two lists intersect, the nodes after the intersection are the same by reference.
By iterating both lists and switching heads when reaching null, we align both lists to traverse equal lengths.
Eventually, both pointers will meet at the intersection or at null if there is none.

---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
🔎 Approach:
- Initialize two pointers `temp1 = headA` and `temp2 = headB`.
- Traverse the lists simultaneously:
    - Move `temp1` and `temp2` one step ahead.
    - If a pointer reaches the end, redirect it to the head of the other list.
- Continue until `temp1 == temp2`.
- Return `temp1` (or `temp2`) as the intersection node or null if no intersection exists.

---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
⏱️ Complexity:
Time Complexity: O(m + n), where m and n are lengths of the two lists.
Space Complexity: O(1), only two pointers used.

---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
💻 Code (Java):
---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
*/

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // Edge case
        if (headA == null) return headB;
        if (headB == null) return headA;

        ListNode temp1 = headA;
        ListNode temp2 = headB;

        while (temp1 != temp2) {
            temp1 = temp1.next;
            temp2 = temp2.next;
            if (temp1 == temp2) return temp1; // or temp2 (any) ✅
            if (temp1 == null) temp1 = headB;
            if (temp2 == null) temp2 = headA;
        }

        return temp1; // Intersection node or null ✅
    }
}
