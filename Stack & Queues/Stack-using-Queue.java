/* 
----------------------------------------
🧠 Problem: 225. Implement Stack using Queues
📚 Platform: LeetCode
🏷️ Category: Stack / Queue
🏷️ Difficulty: Easy
----------------------------------------

📝 Problem Statement:
Implement a last-in-first-out (LIFO) stack using only two queues.
You must use only standard queue operations: push to back, pop from front, peek from front, size, and isEmpty.

📌 Implement the following operations:
- void push(int x)
- int pop()
- int top()
- boolean empty()

🔒 Constraints:
- 1 <= x <= 9
- At most 100 calls will be made to push, pop, top, and empty
- All the calls to pop and top are valid (stack is non-empty at those calls)

----------------------------------------
✅ Intuition:
To simulate a stack using a single queue, we can insert new elements in such a way that the newest element always comes to the front — like a stack's top.

📌 Trick:
After inserting a new element, rotate the existing queue elements behind it.

📦 Example:
push(1) → [1]
push(2) → [2, 1]  ← simulate LIFO
top() → 2
pop() → 2 → queue becomes [1]

----------------------------------------
🛠️ Approach:
1. Use a single queue.
2. When pushing a new element, rotate the rest of the queue behind it using a for loop.
3. For pop and top, just access the front of the queue.

🧩 Time Complexity:
- Push: O(n)
- Pop: O(1)
- Top: O(1)
- Empty: O(1)

----------------------------------------
*/

class MyStack {
    // Declare the internal queue
    public Queue<Integer> queue;

    public MyStack() {
        // Initialize queue
        queue = new LinkedList<>();
    }

    public void push(int x) {
        // Get current size
        int n = queue.size();

        // Add new element to the back
        queue.add(x);

        // Move all existing elements behind the new one
        for (int i = 0; i < n; i++) {
            queue.add(queue.poll());
        }
    }

    public int pop() {
        // Remove and return front (top of stack)
        return queue.poll();
    }

    public int top() {
        // Return front without removing
        return queue.peek();
    }

    public boolean empty() {
        // Return if queue is empty
        return queue.isEmpty();
    }
}

/*
----------------------------------------
🧪 Sample Input / Output:
Input:
["MyStack", "push", "push", "top", "pop", "empty"]
[[], [1], [2], [], [], []]

Output:
[null, null, null, 2, 2, false]

----------------------------------------
🎯 Key Takeaway:
With clever queue manipulation, we can simulate stack behavior efficiently using just a single queue!

----------------------------------------
*/
