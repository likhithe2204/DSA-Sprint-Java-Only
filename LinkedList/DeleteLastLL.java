/*

------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
💡 Problem: Delete Last Node of Linked List
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
📝 Statement:
You are given the head of a singly linked list of size `N`.  
Your task is to delete the **last node** of the linked list and return the updated head.

------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
📥 Input:
N = 4, list = 4 -> 2 -> 5 -> 1  

📤 Output:
4 -> 2 -> 5  

------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
🧠 Intuition:
- The last node can be deleted by making the second-last node’s `next` pointer `null`.  
- We need to traverse until the second-last node (`temp.next.next == null`).  
- Handle edge cases:
  - If the list has only one node, return `null`.  

------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
⚡ Approach:
1. If head is `null` or has only one node, return `null`.  
2. Traverse using a pointer until reaching the second-last node.  
3. Set its `next` to `null`, effectively removing the last node.  
4. Return the updated head.  

------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
⏱️ Complexity:
- Time: O(N) → One traversal through the list.  
- Space: O(1) → No extra space used.  

------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
💻 Code (Java):
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
*/
/****************************************************************
 Following is the class structure of the Node class:

 class Node {
     public int data;
     public Node next;

     Node() {
         this.data = 0;
         this.next = null;
     }

     Node(int data) {
         this.data = data;
         this.next = null;
     }

     Node(int data, Node next) {
         this.data = data;
         this.next = next;
     }
 };
*****************************************************************/

public class Solution {
    public static Node deleteLast(Node head) {
        // Case 1: Empty list or single node
        if (head == null || head.next == null) return null;

        // Case 2: Traverse till second-last node
        Node temp = head;
        while (temp.next.next != null) {
            temp = temp.next;
        }

        // Delete last node
        temp.next = null;
        return head;
    }
}
