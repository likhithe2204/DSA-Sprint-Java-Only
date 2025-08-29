/*

------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
💡 Problem: Insertion In A Singly Linked List
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
📝 Statement:
You are given a Singly Linked List of ‘N’ positive integers.   
Your task is to add a node having the value `VAL` at position `POS` in the linked list.  
Indexing starts from 0.

------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
📥 Input:
N = 5  
LIST = [1, 1, 2, 3, 4, -1]  
VAL = 2, POS = 1  

📤 Output:
1 -> 2 -> 1 -> 2 -> 3 -> 4  

------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
🧠 Intuition:
- If `POS = 0`, simply insert the new node at the head.  
- Otherwise, traverse the list until position `POS - 1`.  
- Adjust pointers to insert the new node at the correct position.  

------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
⚡ Approach:
1. If list is empty, return new node.  
2. If `POS = 0`, link new node before current head and return it.  
3. Otherwise, move a pointer until `POS - 1`.  
4. Insert the new node by changing links:  
   - `newNode.next = temp.next`  
   - `temp.next = newNode`  
5. Return head.  

------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
⏱️ Complexity:
- Time: O(N) → may need to traverse entire list.  
- Space: O(1) → only one new node created.  

------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
💻 Code (Java):
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
*/

/************************************************************************************************************************************************************************************

 Following is the linkedList class structure:

 class Node<T> {
     T data;
     Node<T> next;

     public Node(T data) {
         this.data = data;
     }
 }

 ************************************************************************************************************************************************************************************/
public class Solution {
    static Node insert(Node head, int n, int pos, int val) {
        Node newNode = new Node(val);

        // Case 1: Empty list
        if (head == null) {
            return newNode;
        }

        // Case 2: Insert at head
        if (pos == 0) {
            newNode.next = head;
            return newNode;
        }

        // Case 3: Insert at position POS
        Node temp = head;
        int cnt = 0;
        while (temp != null && cnt < pos - 1) {
            temp = temp.next;
            cnt++;
        }

        // Insert after temp
        newNode.next = temp.next;
        temp.next = newNode;

        return head;
    }
}
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
