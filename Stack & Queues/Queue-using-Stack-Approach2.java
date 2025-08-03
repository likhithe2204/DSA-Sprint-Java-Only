/*
 🔍 Problem: Leetcode 232. Implement Queue using Stacks
 🔗 Link: https://leetcode.com/problems/implement-queue-using-stacks/
 🗂️ Category: Stack, Queue
 🎯 Difficulty: Easy

🧠 Intuition:
To simulate a queue (FIFO) using two stacks (LIFO), we can use one stack for inserting (`s1`) and the other (`s2`) for removing/peeking in correct order. We only move elements from `s1` to `s2` when `s2` is empty, optimizing for amortized O(1) operations.

🛠️ Approach:
- `push(x)`: Push to `s1` directly.
- `pop()`: If `s2` is empty, transfer all from `s1` to `s2`. Then pop from `s2`.
- `peek()`: If `s2` is empty, transfer all from `s1` to `s2`. Then peek from `s2`.
- `empty()`: Return true only if both stacks are empty.

⏱️ Time Complexity:
- Push: O(1)
- Pop: Amortized O(1)
- Peek: Amortized O(1)
- Empty: O(1)

🛠 Code:
*/

class MyQueue {
    // Approach:2 ✅✅

    // Two stacks: s1 holds the queue elements in correct order, s2 is a temporary stack
    public Stack<Integer> s1;
    public Stack<Integer> s2;

    public MyQueue() {
        // Initialize those two stacks : s1, s2
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    public void push(int x) {
        // Directly insert into s1
        s1.push(x);
    }

    public int pop() {
        // Check if the transfer {s1 -> s2} is already completed?
        if (!s2.isEmpty()) {
            // ~ transfer already completed 
            // ~ then, simply perform pop operation 
            return s2.pop();
        } else {
            // ~ transfer NOT completed 
            // ~ then, first transfer all ele's from s1 -> s2
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
            // ~ & then perform the pop operation
            return s2.pop();
        }
    }

    public int peek() {
        // Check if the transfer {s1 -> s2} is already completed?
        if (!s2.isEmpty()) {
            // ~ transfer already completed 
            // ~ then, simply perform peek operation 
            return s2.peek();
        } else {
            // ~ transfer NOT completed 
            // ~ then, first transfer all ele's from s1 -> s2
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
            // ~ & then perform the peek operation
            return s2.peek();
        }
    }

    public boolean empty() {
        // If both stacks are emptied ~ no more elements to perform any operations = return true
        // Otherwise, contains some ele's = return false
        return s1.isEmpty() && s2.isEmpty();
    }
}
