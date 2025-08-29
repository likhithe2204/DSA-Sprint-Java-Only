/*
  
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
💡 Problem: Linked List Insertion At End
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
📝 Statement:
You are given the head of a Singly Linked List and a value `x`.  
Insert that value `x` at the **end** of the Linked List and return the head of the modified list.

------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
📥 Input:
head = 1 -> 2 -> 3 -> 4 -> 5, x = 6  

📤 Output:
1 -> 2 -> 3 -> 4 -> 5 -> 6  

------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
🧠 Intuition:
- To insert at the tail, we need to traverse until the last node.  
- Once at the tail, link its `next` to the new node.  
- Special case: if the list is empty, the new node becomes the head.  

------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
⚡ Approach:
1. If head is `null`, create and return a new node.  
2. Otherwise, traverse until the last node.  
3. Append the new node at the end (`tail.next = newNode`).  
4. Return the unchanged head.  

------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
⏱️ Complexity:
- Time: O(n) → must traverse to the last node.  
- Space: O(1) → only one extra node created.  

------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
💻 Code (Java):
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
*/

class Solution {
    public Node insertAtEnd(Node head, int x) {
        // Case 1: Empty list
        if (head == null) {
            return new Node(x);
        }
        
        // Traverse to the last node
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        
        // Append new node at the end
        temp.next = new Node(x);
        return head;
    }
}
------------------------------------------------------------

