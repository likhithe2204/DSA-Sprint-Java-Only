## 🚀 Queue Implementation using Linked List (Custom Queue)
/**
 * 🔸 Problem Statement:
 * Implement a First-In-First-Out (FIFO) queue using a singly linked list.
 * The queue should support the following operations:
 * - push(int x): Adds element x to the end of the queue.
 * - pop(): Removes and returns the front element of the queue.
 * - peek(): Returns the front element of the queue without removing it.
 * - isEmpty(): Returns true if the queue is empty, false otherwise.
 *
 * 🔹 Constraints:
 * - 1 <= number of operations <= 100
 * - 1 <= x <= 100
 *
 * 🔸 Example:
 * Input: ["LinkedListQueue", "push", "push", "peek", "pop", "isEmpty"]
 *        [[], [3], [7], [], [], []]
 * Output: [null, null, null, 3, 3, false]
 *
 * 🔸 Intuition:
 * Use two pointers — `start` and `end` — to maintain the front and rear of the queue.
 * Enqueue at `end`, dequeue from `start`, both in O(1).
 *
 * 🔸 Time Complexity:
 * - push(): O(1)
 * - pop(): O(1)
 * - peek(): O(1)
 * - isEmpty(): O(1)
 *
 * 🔸 Space Complexity:
 * - O(n) for the linked list nodes
 */

class LinkedListQueue {
    // Definition of a Node in a LinkedList
    public class Node{
        int data;
        Node next;

        // Node Constructor
        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    // Declare some variables, that can be accessed througout the class 
    // Since, its a queue maintain two pointers.
    public Node start;
    public Node end;

    public LinkedListQueue() {
        // Initially, both of them will be pointing to null.
        start = null;
        end = null;
    }

    public void push(int x) {
       // Two cases:

       // Case i: What if? we are inserting the first element: (no prior elements as of now)
       if(start == null && end == null){
        // First, create a new Node
        Node newNode = new Node(x);
        // Then, move both the start & end ptr's 
        start = newNode;
        end = newNode;
       }

       // Case ii: Super simple : the List already contain some elements 
       else{
        // Note: Move the end ptr only!

        Node newNode = new Node(x);
        end.next = newNode; // create the link 
        end = newNode;
       } 
    }

    public int pop() {
      if(start == null && end == null){
        System.out.println("LinkedList is empty");
        return -1; // Invalid operation
      }
      // otherwise
      // Store the element to be deleted
      int val = start.data;

      // Simply move the start 
      start = start.next;

      // edge case:
      if(start == null){
        // Means we are removing an element from LinkedList of size 1
        // ~ Destroying the LL 
        // In that case, reset start and end to -1 
        start = null;
        end = null;
      }
      
      return val;
    }

    public int peek() {
      if(start == null && end == null){
        System.out.println("LinkedList is empty");
        return -1; // Invalid operation
      }
      // otheriwse, simply get the val of start 
      return start.data;
    }

    public boolean isEmpty() {
        if(start == null && end == null) return true; // empty 
        return false; // not empty 
    }
}
