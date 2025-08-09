/*
✅ Platform: Tuf+
🗂️ Category: Stack
🎯 Difficulty: Medium

---------------------------------------------------------------------------------------------------------------------------------------------
🧠 Problem Statement:
You are given a valid infix expression consisting of:
 - Operands: single lowercase letters (a–z) or single-digit numbers (0–9)
 - Binary operators: +, -, *, /, ^
 - Parentheses: ( and )
Your task is to convert it into postfix (Reverse Polish Notation) without spaces.

---------------------------------------------------------------------------------------------------------------------------------------------

🧠 Operator Precedence:
^ > * / > + -
Associativity:
^ is right-associative, all others are left-associative.

---------------------------------------------------------------------------------------------------------------------------------------------

Examples:
Input:  a+b*c
Output: abc*+

Input:  (a+b)*c
Output: ab+c*

---------------------------------------------------------------------------------------------------------------------------------------------

🧠 Intuition:
Use a stack to temporarily store operators and parentheses. 
Push '(' to stack, pop until '(' when ')' is found, and pop operators according to precedence & associativity rules before pushing a new one.

---------------------------------------------------------------------------------------------------------------------------------------------

📌 Approach:
1. Traverse the expression character by character.
2. If operand → append to result.
3. If '(' → push to stack.
4. If ')' → pop until '('.
5. If operator → pop from stack to result while:
      - Top of stack has higher precedence, OR
      - Same precedence and operator is left-associative.
   Then push current operator.
6. Pop all remaining operators at the end.

--------------------------------------------------------------------------------------------------------------------------------------

Time Complexity: O(n) — Each character is processed at most twice.
Space Complexity: O(n) — Stack may hold all operators in the worst case.

---------------------------------------------------------------------------------------------------------------------------------------------

✅ Code:
*/

import java.util.*;
class Solution {
    private int priority(char ch) {
        switch (ch) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
            default:
                return -1;
        }
    }

    public String infixToPostfix(String s) {
        int n = s.length();
        int i = 0;
        Stack<Character> st = new Stack<>();
        String ans = "";

        while(i < n) {
            if(s.charAt(i) >= 'A' && s.charAt(i) <= 'Z' ||
               s.charAt(i) >= 'a' && s.charAt(i) <= 'z' ||
               s.charAt(i) >= '0' && s.charAt(i) <= '9' ) {
                    ans += s.charAt(i);
            }
            else if(s.charAt(i) == '(') {
                st.push(s.charAt(i));
            }
            else if(s.charAt(i) == ')') {
                while(!st.isEmpty() && st.peek() != '(') {
                    ans += st.peek();
                    st.pop();
                }
                st.pop();
            }
            else {
                while(!st.isEmpty() && priority(s.charAt(i)) <= priority(st.peek())) {
                    ans += st.peek();
                    st.pop();
                }
                st.push(s.charAt(i));
            }
            i++;
        }

        while(!st.isEmpty()) {
            ans += st.peek();
            st.pop();
        }

        return ans;
    }
}
