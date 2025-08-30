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
For each `next(price)` call, we check backward until we hit a greater price.

---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

🔎 Approach:
- Use an ArrayList to store all prices.
- For each new price, iterate backward in the list:
  - Increase count while previous prices <= current price.
  - Stop when a larger price is found.
- Return the count.

---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
⏱️ Complexity:
Time Complexity: O(N²) in the worst case (for each call, may scan all previous elements).
Space Complexity: O(N) for storing the prices.

---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
💻 Code (Java):
---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
*/
class StockSpanner {
    // declare a dynamic List globally.
    ArrayList<Integer> arr;

    public StockSpanner() {
        // initialize the list in constructor.
        arr = new ArrayList<>();
    }

    // for every NEXT call you need to return the "maximum consecutive days for which the stock price is < OR = the current price. "
    public int next(int price) {
        arr.add(price);
        int cnt = 1; // the current day will always be included no matter what!

        for (int i = arr.size() - 2; i >= 0; i--) {
            if (arr.get(i) <= price)
                cnt += 1; // keep the track of CNT -> for each next call & return the MAX CNT
            else
                break;
        }
        return cnt;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */
