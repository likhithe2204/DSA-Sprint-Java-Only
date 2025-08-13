/*

🔹 Platform: GeeksforGeeks  
🗂 Category: Stack / Expression Conversion  
📊 Difficulty: Medium  

📝 Problem Statement:  
You are given a string that represents the prefix form of a valid mathematical expression. Convert it into its postfix form.  

💡 Examples:  
Input: "*-A/BC-/AKL"  
Output: "ABC/-AK/L-*"  

Input: "ab+"  
Output: "ab+"  

⏳ Constraints:  
3 <= pre_exp.length() <= 100  
Operands: uppercase (A–Z), lowercase (a–z), digits (0–9)  
Operators: +, -, *, /  
Expression is valid and has no spaces.  

💭 Intuition:  
Traverse the prefix expression from right to left:  
- If the character is an operand, push it onto the stack.  
- If it is an operator, pop two elements (first pop → left operand, second pop → right operand), combine them in postfix form as `leftOperand + rightOperand + operator`, and push back onto the stack.  
The final element in the stack is the postfix expression.  

⚙️ Approach:  
1. Initialize an empty stack of strings.  
2. Iterate from the last character to the first in the prefix string:  
   - If operand → push onto stack.  
   - If operator → pop two operands, concatenate as `left + right + operator`, push back.  
3. Return the top element of the stack.  

⏱ Time Complexity: O(n) — each character processed once.  
📦 Space Complexity: O(n) — stack stores intermediate strings.  
*/

import java.util.*;

class Solution {
    static String preToPost(String pre_exp) {
        int n = pre_exp.length();
        int i = n - 1;
        Stack<String> st = new Stack<>();
        
        while(i >= 0){
            char ch = pre_exp.charAt(i);
            
            // ~ Operand
            if((ch >= 'A' && ch <= 'Z')||
               (ch >= 'a' && ch <= 'z')||
               (ch >= '0' && ch <= '9')){
                   st.push(String.valueOf(ch));
            }
            else{ // ~ Operator
                String t1 = st.pop();
                String t2 = st.pop();
                String con = t1 + t2 + ch;
                st.push(con);
            }
            i--;
        }
        return st.peek();
    }
}
