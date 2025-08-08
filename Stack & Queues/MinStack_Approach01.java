/*
---------------------------------------------------------------------------------------------------------------------------------------------
🧠 Problem Statement:
155. Min Stack (Leetcode)
Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

🗂️ Category: Stack
🎯 Difficulty: Medium

---------------------------------------------------------------------------------------------------------------------------------------------

🧠 Intuition:
To get the minimum in O(1) time, we store not just the value in the stack, 
but also the current minimum at that point. So each stack element is a pair of (val, minSoFar).

📌 Approach:
- Define a custom `Pair` class with `first` = value, and `second` = minimum till now.
- Each push operation compares the current value with the top's minimum and pushes the updated minimum.
- Stack stores only such pairs.
- All operations become O(1) because we always peek the top for both value and min.

---------------------------------------------------------------------------------------------------------------------------------------------

🛠️ Complexity:
Time: O(1) for all operations: push, pop, top, getMin
Space: O(n) for storing pairs in stack

✅ Constraints Handled:
- pop, top, getMin always called on non-empty stacks ✅
- val range: handled with primitive int ✅

---------------------------------------------------------------------------------------------------------------------------------------------
*/

class Pair {
    int first;
    int second;

    public Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}

class MinStack {
    Stack<Pair> st;

    public MinStack() {
        st = new Stack<>();
    }

    public void push(int val) {
        if (st.isEmpty()) {
            st.push(new Pair(val, val));
        } else {
            int currentMin = Math.min(val, st.peek().second);
            st.push(new Pair(val, currentMin));
        }
    }

    public void pop() {
        if (!st.isEmpty()) {
            st.pop();
        }
    }

    public int top() {
        return st.isEmpty() ? -1 : st.peek().first;
    }

    public int getMin() {
        return st.isEmpty() ? -1 : st.peek().second;
    }
}
