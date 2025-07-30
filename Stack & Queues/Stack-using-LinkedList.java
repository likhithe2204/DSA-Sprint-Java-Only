## 🚀 Stack Implementation using Linked List (Custom Stack)
/**
 * 🔸 Problem Statement:
 * Implement a Last-In-First-Out (LIFO) stack using a singly linked list.
 * The stack should support the following operations:
 * - push(int x): Pushes element x onto the stack.
 * - pop(): Removes and returns the top element of the stack.
 * - top(): Returns the top element of the stack without removing it.
 * - isEmpty(): Returns true if the stack is empty, false otherwise.
 *
 * 🔹 Constraints:
 * - 1 <= number of operations <= 100
 * - 1 <= x <= 100
 *
 * 🔸 Example:
 * Input: ["LinkedListStack", "push", "push", "pop", "top", "isEmpty"]
 *        [[], [3], [7], [], [], []]
 * Output: [null, null, null, 7, 3, false]
 *
 * 🔸 Intuition:
 * Use the head of the linked list as the top of the stack.
 * - Insertions/removals happen at the head to mimic stack behavior.
 *
 * 🔸 Time Complexity:
 * - push(): O(1)
 * - pop(): O(1)
 * - top(): O(1)
 * - isEmpty(): O(1)
 *
 * 🔸 Space Complexity:
 * - O(n) for the linked list nodes
 */

class LinkedListStack {
    // Definition of a node in a Linked List
    public class Node{
        int data;
        Node next;

        // Constructor
        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    public Node top;

    public LinkedListStack() {
        // initially top is pointing to null 
        top = null;
    }

    public void push(int x) {
       // Create a new Node with value x 
       Node newNode = new Node(x);
       // make sure you point new node's next ptr to top 
       newNode.next = top;
       // & move top 
       top = newNode;
    }

    public int pop() {
        if(top == null){
            System.out.println("Linked List is empty");
            return -1; // invalid
        }
        // Otherwise
        // Store the top element
        int val = top.data;
        // move the top ptr to prev node 
        top = top.next;
        // return the stored val as deleted element 
        return val;
    }

    public int top() {
        if(top == null){
            System.out.println("Linked List is empty");
            return -1; // invalid
        }
        // Otherwise
        return top.data; // LIFO
    }

    public boolean isEmpty() {
        if(top == null) return true; // LinkedList is empty 
        return false; // LinkedList is'nt empty 
    }
}
