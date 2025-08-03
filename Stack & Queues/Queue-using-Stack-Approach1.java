/***********************************************************************************************************************************
* 🧠 Problem: 232. Implement Queue using Stacks  
* 🏷️ Platform : LeetCode  
* 📂 Category : Stacks  
* 💪 Difficulty: Easy  
* 🧩 Problem Type: Stack to Queue Conversion  
* 🧾 Problem Statement:
*     Implement a FIFO queue using only two stacks. You must use only standard stack operations:
*     - push to top
*     - peek/pop from top
*     - isEmpty
*     - size
* 
*     Implement the MyQueue class:
*       → void push(int x)        : Pushes element x to the back of the queue.
*       → int pop()               : Removes the element from the front of the queue and returns it.
*       → int peek()              : Returns the element at the front of the queue.
*       → boolean empty()         : Returns true if the queue is empty, false otherwise.
*
* 🧠 Intuition:
*     Since a stack is LIFO and a queue is FIFO, we can simulate queue behavior using two stacks.
*     By reversing order using a temporary stack during push, we ensure the front is always on top.
*
* 🔍 Approach (Costly Push):
*     - Maintain two stacks `s1` and `s2`
*     - For `push(x)`:
*         Step 1: Move all elements from s1 to s2
*         Step 2: Push x to s1 (empty now)
*         Step 3: Move all elements back from s2 to s1 (restores order)
*     - For `pop()` and `peek()`:
*         Directly operate on top of s1, which always has the front of queue
*     - For `empty()`:
*         Return true if s1 is empty
*
* ⏱️ Time Complexity:
*     - push(x): O(n)
*     - pop():   O(1)
*     - peek():  O(1)
*     - empty(): O(1)
*
* 🧮 Space Complexity: O(n) (for the two stacks)
*
* ✅ Constraints:
*     - 1 <= x <= 9
*     - At most 100 calls to push, pop, peek, and empty
*     - All calls to pop and peek are guaranteed to be valid
*
* 📦 Follow-up:
*     → Can you make each operation amortized O(1)? (Yes, with a lazy transfer technique)
*
* 💡 Alternate Approach:
*     - Lazy transfer: push(x) directly into `in`, pop/peek from `out` after transferring if needed
*     - This gives amortized O(1) for all operations
*
* 🧪 Example:
*     Input:  ["MyQueue", "push", "push", "peek", "pop", "empty"]
*             [[],       [1],   [2],    [],     [],    []]
*     Output: [null,     null,  null,   1,      1,     false]
*
**********************************************************************************************************************************/

class MyQueue {
    // Two stacks: s1 holds the queue elements in correct order, s2 is a temporary stack
    public Stack<Integer> s1;
    public Stack<Integer> s2;

    public MyQueue() {
        // Initialize those two stacks : s1, s2
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    public void push(int x) {
        // Step 1: Move all elements from s1 to s2
        while (!s1.isEmpty()) {
            s2.push(s1.pop());
        }

        // Step 2: Push new element into s1 (which is now empty)
        s1.push(x);

        // Step 3: Move everything back from s2 to s1
        while (!s2.isEmpty()) {
            s1.push(s2.pop());
        }
    }

    public int pop() {
        return s1.pop();
    }

    public int peek() {
        return s1.peek();
    }

    public boolean empty() {
        return s1.isEmpty();
    }
}
