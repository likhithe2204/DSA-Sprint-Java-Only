// ✅ Problem: Leetcode 20 - Valid Parentheses (or) Balanced Parantheses.
// Category: Stack
// Difficulty: Easy

// ✅ Problem Statement:
// Given a string `s` containing just the characters '(', ')', '{', '}', '[' and ']',
// determine if the input string is valid.

// A string is valid if:
// - Open brackets must be closed by the same type of brackets.
// - Open brackets must be closed in the correct order.
// - Every close bracket has a corresponding open bracket of the same type.

// ✅ Intuition:
// Use a stack to keep track of opening brackets. For every closing bracket, pop from the stack and ensure the bracket matches the correct type.
// If at the end the stack is empty, the string is valid.

// ✅ Approach:
// 1. Traverse each character in the string.
// 2. If it is an opening bracket, push onto the stack.
// 3. If it is a closing bracket:
//    - Check if the stack is empty (invalid).
//    - Else, pop from the stack and compare types.
// 4. After the loop, ensure the stack is empty (all brackets closed).

// ✅ Time Complexity: O(n) — where n is the length of the string
// ✅ Space Complexity: O(n) — for the stack used to store opening brackets

class Solution {
    public boolean isValid(String s) {
        int n = s.length();
        Stack<Character> st = new Stack<>(); 

        for(int i = 0; i < n; i++){
            if(s.charAt(i) == '(' ||
               s.charAt(i) == '{' ||
               s.charAt(i) == '[' ){
                st.push(s.charAt(i));
            }
            else{
                if(st.isEmpty()) return false; 
                else{
                    char ch = st.peek();
                    st.pop();

                    if(s.charAt(i) == ')' && ch == '(' ||
                       s.charAt(i) == '}' && ch == '{' ||
                       s.charAt(i) == ']' && ch == '['){
                        continue;
                    }
                    else return false;
                }
            }
        }
        return st.isEmpty();
    }
}
