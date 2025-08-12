/*
---------------------------------------------------------------------------------------------------------------------------------------------
🧠 Problem Statement:
Given a postfix expression (operands: A–Z, a–z, 0–9; operators: +, -, *, /, etc.), convert it to its equivalent fully parenthesized infix expression.

🗂️ Category: Stack
🎯 Difficulty: Easy

---------------------------------------------------------------------------------------------------------------------------------------------

🧠 Intuition:
Postfix evaluation works left to right.  
When encountering an operand → push it to stack.  
When encountering an operator → pop two operands (second popped = left operand, first popped = right operand) and combine them into `(left operator right)` format, then push back the result.  
The order matters because reversing it changes the meaning of the expression.

---------------------------------------------------------------------------------------------------------------------------------------------

📝 Approach:
1. Initialize an empty stack of strings.
2. Traverse each character in the expression:
   - If it's an operand (A–Z, a–z, 0–9), push it to the stack.
   - If it's an operator, pop top element → **right operand (t1)**, pop next top → **left operand (t2)**.
   - Form a string as `(t2 + operator + t1)` and push back.
3. At the end, the stack's top will contain the fully parenthesized infix expression.

⚠️ Important:
`t2` is **left operand** and `t1` is **right operand**.  
If you swap them, you'll reverse operand order, which changes the actual mathematical meaning.

---------------------------------------------------------------------------------------------------------------------------------------------

⏱️ Complexity Analysis:
- Time: O(n) — single pass through the expression.
- Space: O(n) — stack stores partial expressions.

---------------------------------------------------------------------------------------------------------------------------------------------

💻 Code:
*/

class Solution {
    static String postToInfix(String exp) {
        int n = exp.length();
        Stack<String> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            char ch = exp.charAt(i);

            // Operand
            if ((ch >= 'A' && ch <= 'Z') ||
                (ch >= 'a' && ch <= 'z') ||
                (ch >= '0' && ch <= '9')) {
                st.push(String.valueOf(ch)); // convert char -> string
            }
            // Operator
            else {
                String t1 = st.pop(); // right operand
                String t2 = st.pop(); // left operand
                String con = "(" + t2 + ch + t1 + ")";
                st.push(con);
            }
        }
        return st.peek();
    }
}
