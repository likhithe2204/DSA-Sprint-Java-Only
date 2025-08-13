/*

🔹 Platform: Tuf+, GFG, Naukri (Prefix to Infix Conversion)  
🗂 Category: Stack / Expression Conversion  
📊 Difficulty: Easy  

📝 Problem Statement:  
You are given a valid arithmetic expression in prefix notation. Convert it into a fully parenthesized infix expression.  
Prefix notation places the operator before its operands. Infix notation places the operator between operands.  
Operands are lowercase letters (a–z) or digits (0–9). Operators can be +, -, *, /, ^.  

💡 Examples:  
Input: "+ab"  
Output: "(a+b)"  

Input: "*+ab-cd"  
Output: "((a+b)*(c-d))"  

⏳ Constraints:  
1 <= expression.length <= 10^4  
Expression is guaranteed to be valid.  

💭 Intuition:  
Traverse the prefix expression from right to left.  
- If it's an operand → push to stack.  
- If it's an operator → pop two operands, combine as "(operand1 operator operand2)", push back.  
Finally, the stack will have the complete infix expression.  

⚙️ Approach:  
1. Iterate from end of string to start.  
2. If operand → push to stack.  
3. If operator → pop two, merge with parentheses, push back.  
4. Return top of stack.  

⏱ Time Complexity: O(n) — process each character once.  
📦 Space Complexity: O(n) — stack stores partial results.  
*/

class Solution {
    public String prefixToInfix(String s) {
        int n = s.length();
        int i = n - 1;
        Stack<String> st = new Stack<>();

        while (i >= 0) {
            char ch = s.charAt(i);

            // Operand (letter or digit)
            if ((ch >= 'A' && ch <= 'Z') ||
                (ch >= 'a' && ch <= 'z') ||
                (ch >= '0' && ch <= '9')) {
                st.push(String.valueOf(ch));
            }
            // Operator
            else {
                String t1 = st.pop();
                String t2 = st.pop();
                String con = "(" + t1 + ch + t2 + ")";
                st.push(con);
            }
            i--;
        }
        return st.peek();
    }
}
