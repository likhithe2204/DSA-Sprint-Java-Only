## 🚀 Stack Implementation using Array (Custom Stack)  
/**
 * 🔸 Problem Statement:
 * Implement a Last-In-First-Out (LIFO) stack using an array. The stack should support:
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
 * Input: ["ArrayStack", "push", "push", "top", "pop", "isEmpty"]
 *        [[], [5], [10], [], [], []]
 * Output: [null, null, null, 10, 10, false]
 *
 * 🔸 Intuition:
 * Maintain a `top` pointer to track the top index of the array-based stack.
 *
 * 🔸 Approach:
 * - Use an array of fixed size.
 * - Push increments the `top` and inserts.
 * - Pop returns the value at `top` and decrements it.
 * - Top simply returns the value at `top`.
 * - isEmpty checks if `top == -1`.
 *
 * 🔸 Time Complexity:
 * - push(): O(1)
 * - pop(): O(1)
 * - top(): O(1)
 * - isEmpty(): O(1)
 *
 * 🔸 Space Complexity:
 * - O(n) for array size (default 1000 unless specified)
 */

class ArrayStack {
    // Array to hold elements
    public int[] arr;
    // Maximum capacity
    public int n;
    // Index of top element
    public int top;

    // Constructor with size
    public ArrayStack(int size) {
        n = size;
        arr = new int[n];
        top = -1;
    }

    // Default constructor
    public ArrayStack(){
        this(1000);
    }

    // Push element onto the stack
    public void push(int x) {
        if (top >= n - 1) {
            System.out.println("Stack overflow");
            return;
        }
        top = top + 1;
        arr[top] = x;
    }

    // Pop and return top element
    public int pop() {
        if (top == -1) {
            System.out.println("Stack is empty");
            return -1;
        }
        return arr[top--];
    }

    // Return top element without removing
    public int top() {
        if (top == -1) {
            System.out.println("Stack is empty");
            return -1;
        }
        return arr[top];
    }

    // Check if stack is empty
    public boolean isEmpty() {
        if (top == -1) return true;
        else return false;
    }
}
