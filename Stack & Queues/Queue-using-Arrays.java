## 🚀 Queue Implementation using Array (Custom Queue)
/**
 * 🔸 Problem Statement:
 * Implement a First-In-First-Out (FIFO) queue using an array. The queue should support:
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
 * Input: ["ArrayQueue", "push", "push", "peek", "pop", "isEmpty"]
 *        [[], [5], [10], [], [], []]
 * Output: [null, null, null, 5, 5, false]
 *
 * 🔸 Intuition:
 * Use a circular array to efficiently implement queue operations.
 *
 * 🔸 Approach:
 * - Maintain `start` and `end` pointers.
 * - Use modulo to achieve circular increment.
 * - Handle edge cases when queue becomes empty or full.
 *
 * 🔸 Time Complexity:
 * - push(): O(1)
 * - pop(): O(1)
 * - peek(): O(1)
 * - isEmpty(): O(1)
 *
 * 🔸 Space Complexity:
 * - O(n) for array size (default 1000 unless specified)
 */

class ArrayQueue {
    // Initialize a QueueArray
    public int[] arr;
    // Total capacity of the QueueArray
    public int size;
    // To keep a track of size after performing push pop operations
    public int currSize;
    // Pointers to keep a track and begining and ending of QueueArray
    public int start;
    public int end;

    public ArrayQueue(int capacity) {
        size = capacity;
        arr = new int[size];
        currSize = 0;
        start = -1;
        end = -1;
    }

    public ArrayQueue(){
        this(1000);
    }

    public void push(int x) {
       // To push elements into QueueArray, first we need to check is the array empty?
       if(currSize >= size - 1){
        System.out.println("Queue is full");
        return;
       }

       // Otherwise the queue is empty and we can insert elements 

       // Case i: As of now there is no single element in array 
       //         Then, move both start, end & insert ele
       if(currSize == 0){
        start = start + 1;
        end = end + 1;
        
       }

       // Case ii: Queue already contain some elements in it.
       //          Then, move end & insert ele 
       else{
        end = (end + 1) % size; // move in a Circular rotation manner 
       }

       // Irresspective of that, always insert element where end is pointing 
       arr[end] = x;
       currSize = currSize + 1;
    }

    public int pop() {
      if(currSize == 0) return -1; // queue is empty 

      // Otherwise, deal with lot of edge cases:
      // store ele where start is pointing 
      int value = arr[start];

      // Case i: We are basically destroying the Queue
      if(currSize == 1){
        start = -1;
        end = -1;
      }
      // Case ii: QueueArray already contains more than 1 element 
      else{
        // move start 
        start = (start + 1) % size;
      }
      // As you are removing one element => remember to shrink the currSize too!
      currSize = currSize - 1;
      return value;
    }

    public int peek() {
        // No elements in the QueueArray
        if(currSize == 0) return -1; // queue is empty 
        // Otherwise
        return arr[start];
    }

    public boolean isEmpty() {
        if(start == -1 && end == -1 || currSize == 0) return true; // Queue is empty 
        return false; // otheriwse
    }
}
