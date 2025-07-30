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
    public int[] arr;
    public int size;
    public int currSize;
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
        if(currSize >= size) {
            System.out.println("Queue is full");
            return;
        }
        if(currSize == 0) {
            start = 0;
            end = 0;
        } else {
            end = (end + 1) % size;
        }
        arr[end] = x;
        currSize++;
    }

    public int pop() {
        if(currSize == 0) return -1;

        int value = arr[start];

        if(currSize == 1) {
            start = -1;
            end = -1;
        } else {
            start = (start + 1) % size;
        }
        currSize--;
        return value;
    }

    public int peek() {
        if(currSize == 0) return -1;
        return arr[start];
    }

    public boolean isEmpty() {
        return currSize == 0;
    }
}
