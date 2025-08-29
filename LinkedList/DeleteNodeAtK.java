/*
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
💡 Problem: Delete in a Singly Linked List
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
📝 Statement:
You are given the head of a singly linked list and an integer `x`.  
Delete the **xth node** (1-based indexing) from the singly linked list and return the updated head.

------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
📥 Input:
x = 1, list = 1 -> 2 -> 3 -> 1 -> 7  

📤 Output:
2 -> 3 -> 1 -> 7  

Explanation: After deleting the node at the 1st position, the updated list is `2 -> 3 -> 1 -> 7`.

---------------------------------------------------------------------------------------------------------------------------
📥 Input:
x = 5, list = 1 -> 2 -> 3 -> 4 -> 5 -> 6  

📤 Output:
1 -> 2 -> 3 -> 4 -> 5  

Explanation: After deleting the node at the 5th position, the updated list is `1 -> 2 -> 3 -> 4 -> 5`.

------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
🧠 Intuition:
- If `x = 1`, the head node must be deleted → simply return `head.next`.  
- Otherwise, traverse until the `(x-1)`th node and skip the `x`th node.  
- Edge cases:
  - Empty list → return `null`.  
  - Deleting first node → handle separately.  

------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
⚡ Approach:
1. Check if list is empty → return `null`.  
2. If `x == 1`, return `head.next` (deleting the head).  
3. Traverse until reaching `(x-1)`th node.  
4. Modify `(x-1)`th node’s `next` pointer to skip the `x`th node.  
5. Return the updated head.  

------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
⏱️ Complexity:
- Time: O(N) → Single traversal to find the node.  
- Space: O(1) → No extra space used.  

------------------------------------------------------------
💻 Code (Java):
------------------------------------------------------------
/*
class Node {
    int data;
    Node next;

    Node(int d) {
        this.data = d;
        this.next = null;
    }
}
*/
class Solution {
    Node deleteNode(Node head, int x) {
        // Case 1: Empty list
        if (head == null) {
            return null;
        }

        // Case 2: Delete head node
        if (x == 1) {
            return head.next;
        }

        // Case 3: Traverse to (x-1)th node
        Node temp = head;
        int count = 1;

        while (temp.next != null && count < x - 1) {
            temp = temp.next;
            count++;
        }

        // Delete xth node by skipping it
        if (temp.next != null) {
            temp.next = temp.next.next;
        }

        return head;
    }
}
