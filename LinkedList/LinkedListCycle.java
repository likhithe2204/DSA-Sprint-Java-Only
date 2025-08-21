/*

---------------------------------------------------------------------------------------------------------------------------------------------
🧩 Problem: Linked List Cycle  
🔹 Platform: LeetCode  
🗂 Category: Linked List / Two Pointers  
📊 Difficulty: Easy  

---------------------------------------------------------------------------------------------------------------------------------------------
📝 Problem Statement  
Given the head of a singly linked list, determine if the linked list has a cycle in it.  
A cycle exists if a node can be revisited by continuously following the `next` pointer.  
Return **true** if there is a cycle; otherwise, return **false**.  
`pos` denotes the index where the tail connects (internal, not a parameter).

---------------------------------------------------------------------------------------------------------------------------------------------
💡 Examples  
• head = [3,2,0,-4], pos = 1 → true
• head = [1,2], pos = 0 → true  
• head = [1], pos = -1 → false  

---------------------------------------------------------------------------------------------------------------------------------------------
⏳ Constraints  
• 0 ≤ n ≤ 10⁴  
• -10⁵ ≤ Node.val ≤ 10⁵  
• pos = -1 or a valid index  

---------------------------------------------------------------------------------------------------------------------------------------------
💭 Intuition  
Use **Floyd’s Cycle Detection (Tortoise & Hare)**.  
Move `slow` by 1 and `fast` by 2. If they ever meet, there is a cycle.  
If `fast` hits `null`, the list ends → no cycle.

---------------------------------------------------------------------------------------------------------------------------------------------
⚙️ Approach  
1) Initialize `slow = head`, `fast = head`.  
2) While `fast != null && fast.next != null`:  
   - `slow = slow.next`  
   - `fast = fast.next.next`  
   - If `slow == fast` → return **true**  
3) If loop ends, return **false**.  

---------------------------------------------------------------------------------------------------------------------------------------------
⏱ Time Complexity: O(n)  
📦 Space Complexity: O(1)  

---------------------------------------------------------------------------------------------------------------------------------------------
👨🏻‍💻 Code
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
    public boolean hasCycle(ListNode head) {
        // Most Optimal Approach : 
        //                         - Tortoise & Hare Algorithm ✅
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast)
                return true; // Cycle Detected.
        }
        return false; // No Cycle Detected.
    }
}
