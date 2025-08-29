/*

------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
💡 Problem: Search in Linked List
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
📝 Statement:
You are given the head of a singly linked list and an integer key.  
Return `true` if the key exists in the linked list, otherwise return `false`.

------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
📥 Input / 📤 Output:
Input: head = [1, 2, 3, 4], key = 3  
Output: true  
Explanation: The linked list is 1 → 2 → 3 → 4. The key 3 is present in the list.  

Input: head = [7, 8, 9, 10, 11], key = 5  
Output: false  
Explanation: The key 5 is not present in the list.  

Input: head = [42], key = 42  
Output: true  

------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
🧠 Intuition:
- To check if a key exists, traverse the list node by node.  
- Compare each node’s value with the given key.  
- If a match is found, return `true`. Otherwise, continue until the list ends.  

------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
⚡ Approach:
1. Start traversal from `head`.  
2. At each step, check if `temp.val == key`.  
3. If yes → return `true`.  
4. If traversal ends without a match → return `false`.  

------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
⏱️ Complexity:
- Time: O(n) → Traverse all nodes once.  
- Space: O(1) → No extra space except pointer.  

------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
💻 Code (Java):
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
/* Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode(int value) {
        this.val = value;
        this.next = null;
    }
}
*/

class Solution {
    public boolean searchKey(ListNode head, int key) {
        ListNode temp = head;
        while (temp != null) {
            if (temp.val == key) 
                return true;
            temp = temp.next;
        }
        return false;
    }
}
