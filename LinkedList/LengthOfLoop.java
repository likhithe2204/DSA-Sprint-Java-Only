/*  
---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
📌 Problem: Find Length of Loop in Linked List
---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
🚩 Statement:  
Given the head of a linked list, determine whether the list contains a loop.  
If a loop is present, return the number of nodes in the loop; otherwise, return 0.  

⚠️ Note: `pos` (1-based index) denotes the node position that the tail connects to.  
If `pos = 0`, then there is no loop.  
`pos` is for internal reference only and is not passed to the function.  

---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
📥 Input/Output:  

Example 1:  
Input: pos = 2  
Output: 4  
Explanation: There exists a loop of length 4.  

Example 2:  
Input: pos = 3  
Output: 3  
Explanation: The loop is 19 → 33 → 10, so length = 3.  

Example 3:  
Input: pos = 0  
Output: 0  
Explanation: No loop exists.  

Constraints:  
- 1 ≤ number of nodes ≤ 10^5  
- 1 ≤ node->data ≤ 10^4  
- 0 ≤ pos < number of nodes  

---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
💡 Intuition:  
This is an extension of **Floyd’s Cycle Detection Algorithm**.  
- First detect if a cycle exists (slow & fast pointer meet).  
- Once detected, move one pointer ahead until it comes back to the meeting point → count steps.  

---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
🔎 Approach:  
1. Initialize `slow = head`, `fast = head`.  
2. Move `slow` by 1 step, `fast` by 2 steps.  
3. If they meet → cycle detected.  
4. Keep moving one pointer around the cycle until it returns to the same node, counting steps.  
5. Return count = length of loop.  
6. If no cycle → return 0.  

---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
⏱️ Complexity:  
- Time: O(n), each node visited at most twice.  
- Space: O(1), only two pointers used.  

---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
💻 Code (Java ✅):
---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
*/

/*
class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}
*/

class Solution {
    public int lengthOfLoop(Node head) {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) { // cycle detected
                int cnt = 1;
                slow = slow.next;

                while (slow != fast) {
                    slow = slow.next;
                    cnt++;
                }
                return cnt; // length of loop
            }
        }
        return 0; // no cycle
    }
}
