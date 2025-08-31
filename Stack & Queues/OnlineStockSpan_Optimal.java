/*

---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
📌 Problem: Online Stock Span (LeetCode 901)
---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
🚩 Statement:
Design an algorithm that collects daily stock price quotes and returns the span of the stock's price for the current day.
The span is the maximum number of consecutive days (including today) the price has been <= today's price.

---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
📥 Input/ 📥 Output:
Input:
["StockSpanner", "next", "next", "next", "next", "next", "next", "next"]
[[], [100], [80], [60], [70], [60], [75], [85]]

Output:
[null, 1, 1, 1, 2, 1, 4, 6]

---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
💡 Intuition:
The span for today's price is simply the count of consecutive days backward where the stock price is less than or equal to today’s price.
Instead of scanning all elements every time, we can use a stack to store **previous greater elements (PGE)** efficiently.

---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
🔎 Approach:
- Maintain a stack of pairs `(price, index)`.
- For each incoming price:
  - Pop from the stack while the top has a value ≤ current price.
  - If stack is empty → span = current index - (-1).
  - Else → span = current index - index of top element in stack.
- Push `(price, index)` into the stack.
- Return span.

---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
⏱️ Complexity:
Time Complexity: O(N) amortized (each element pushed/popped once).
Space Complexity: O(N) for the stack.

---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
💻 Code (Java):
---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
*/

class StockSpanner {
    public class Pair {
        int first; // stores the stock price
        int second; // stores the index (day number)

        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    int curInd; // tracks current day index
    Stack<Pair> st; // stack to maintain previous greater element property

    public StockSpanner() {
        curInd = -1;
        st = new Stack<>();
    }

    public int next(int price) {
        curInd += 1; // move to next day

        // Pop all smaller or equal prices to maintain PGE
        while (!st.isEmpty() && st.peek().first <= price) {
            st.pop();
        }

        int ans;
        if (st.isEmpty()) {
            ans = curInd - (-1); // no greater element → span till day 0
        } else {
            ans = curInd - st.peek().second; // difference from last greater element
        }

        // Push current day’s price and index
        st.push(new Pair(price, curInd));

        return ans;
    }
}
