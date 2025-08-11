/*
---------------------------------------------------------------------------------------------------------------------------------------------
🧠 Problem Statement:
Given a valid arithmetic expression in infix notation, return its equivalent prefix (Polish) notation.

The expression can contain:
- Lowercase letters a–z as operands
- The four binary operators +, -, *, /
- Round parentheses ( ) for evaluation order
- No whitespace in the input

Constraints:
1 ≤ infix.length ≤ 1000
The input is guaranteed to be valid.

📌 Examples:
Input: "(a+b)*c"        → Output: "*+abc"
Input: "a+b*c"          → Output: "+a*bc"
Input: "((a-(b/c))*((a/k)-l))" → Output: "*-a/bc-/akl"

---------------------------------------------------------------------------------------------------------------------------------------------
🗂️ Category: Stack
🎯 Difficulty: Medium

---------------------------------------------------------------------------------------------------------------------------------------------
🧠 Intuition:
To convert infix to prefix, we can:
1. Reverse the infix expression.
2. Swap '(' with ')' and vice versa.
3. Convert the modified infix to postfix using the standard stack-based algorithm.
4. Reverse the resulting postfix to get the final prefix expression.

---------------------------------------------------------------------------------------------------------------------------------------------
📝 Approach:
1. Reverse the given infix expression.
2. Replace every '(' with ')' and every ')' with '('.
3. Use a stack to convert the modified infix to postfix:
   - If operand → append to result.
   - If '(' → push to stack.
   - If ')' → pop until '('.
   - If operator → pop from stack until precedence is maintained, then push current operator.
4. Reverse the postfix result to obtain the prefix form.

---------------------------------------------------------------------------------------------------------------------------------------------
⏱️ Complexity Analysis:
- Time Complexity: O(N)  — each character is processed a constant number of times.
- Space Complexity: O(N) — stack and result string.

---------------------------------------------------------------------------------------------------------------------------------------------
📜 Code:
*/

class Solution {
    // Define the priority order of operators.
    public int priority(char ch) {
        if(ch == '^') return 3;
        else if(ch == '*' || ch == '/') return 2;
        else if(ch == '+' || ch == '-') return 1;
        else return -1;
    }

    // Helper function that returns reversed string.
    public String reverse(String s) {
        char[] chars = s.toCharArray();

        int start = 0;
        int end = chars.length - 1;

        while(start <= end) {
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;

            start++;
            end--;
        }
        return new String(chars);
    }

    public String infixToPrefix(String s) {

        // 1. Reverse the input string
        s = reverse(s); 

        int n = s.length();
        
        int i = 0;
        Stack<Character> st = new Stack<>();
        String ans = "";

        // 2. Replace '(' with ')' & ')' with '('
        char[] arr = s.toCharArray();
        for(int j = 0; j < arr.length; j++) {
            if(arr[j] == '(') arr[j] = ')';
            else if(arr[j] == ')') arr[j] = '(';
        }
        s = new String(arr);

        // 3. Convert to postfix expression under controlled condition
        while(i < n) {
            if(s.charAt(i) >= 'A' && s.charAt(i) <= 'Z' ||
               s.charAt(i) >= 'a' && s.charAt(i) <= 'z' ||
               s.charAt(i) >= '0' && s.charAt(i) <= '9') {
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
                // Controlled condition
                if(s.charAt(i) == '^') {
                    while(!st.isEmpty() && priority(s.charAt(i)) <= priority(st.peek())){
                        ans += st.peek();
                        st.pop();
                    }
                    st.push(s.charAt(i));
                }
                else {
                    while(!st.isEmpty() && priority(s.charAt(i)) < priority(st.peek())){
                        ans += st.peek();
                        st.pop();
                    }
                    st.push(s.charAt(i));
                }
            }
            i++;
        }
        while(!st.isEmpty()){
            ans += st.peek();
            st.pop();
        }

        // 4. Reverse back obtained postfix expression back to its original.
        ans = reverse(ans);

        return ans;
    }
}
