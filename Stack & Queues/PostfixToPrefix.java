/*

🔹 Platform: GeeksforGeeks  
🗂 Category: Stack / Expression Conversion  
📊 Difficulty: Medium  

📝 Problem Statement:  
You are given a string that represents the postfix form of a valid mathematical expression. Convert it into its prefix form.  

💡 Examples:  
Input: "ABC/-AK/L-*"  
Output: "*-A/BC-/AKL"  

Input: "ab+"  
Output: "+ab"  

⏳ Constraints:  
3 <= post_exp.length() <= 16000  
Operands: uppercase (A–Z), lowercase (a–z), digits (0–9)  
Operators: +, -, *, /  
Expression is valid and has no spaces.  

💭 Intuition:  
Traverse the postfix expression from left to right:  
- If the character is an operand, push it onto the stack.  
- If it is an operator, pop the top two elements (first pop → right operand, second pop → left operand), combine them in prefix form as `operator + leftOperand + rightOperand`, and push back onto the stack.  
The final element in the stack is the prefix expression.  

⚙️ Approach:  
1. Initialize an empty stack of strings.  
2. Iterate over each character in the postfix expression:  
   - If operand → push onto stack.  
   - If operator → pop two operands, concatenate as `op + left + right`, push back.  
3. Return top of the stack.  

⏱ Time Complexity: O(n) — each character processed once.  
📦 Space Complexity: O(n) — stack stores intermediate strings.  
*/

import java.util.*;

class Solution {
    static String postToPre(String post_exp) {
        int n = post_exp.length();
        int i = 0;
        Stack<String> st = new Stack<>();

        while (i < n) {
            char ch = post_exp.charAt(i);

            // Operand
            if ((ch >= 'A' && ch <= 'Z') ||
                (ch >= 'a' && ch <= 'z') ||
                (ch >= '0' && ch <= '9')) {
                st.push(String.valueOf(ch));
            }
            // Operator
            else {
                String t1 = st.pop();
                String t2 = st.pop();
                String con = ch + t2 + t1;
                st.push(con);
            }
            i++;
        }
        return st.peek();
    }
}
