## LC17: Letter Combinations of a Phone Number (Leetcode - Medium)
// ✅ Problem: Letter Combinations of a Phone Number (Leetcode 17)
// Platform: Leetcode
// Category: Recursion + Backtracking
// Difficulty: Medium

/**
 * 🔸 Problem Statement:
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations 
 * that the number could represent. Return the answer in any order.
 *
 * Each digit maps to a set of letters like on a traditional telephone keypad.
 * Digits 0 and 1 do not map to any letters.
 *
 * 🔸 Constraints:
 * 0 <= digits.length <= 4
 * digits[i] is a digit in the range ['2', '9']
 *
 * 🔸 Examples:
 * Input: digits = "23"
 * Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
 *
 * Input: digits = ""
 * Output: []
 *
 * Input: digits = "2"
 * Output: ["a","b","c"]
 */

/**
 * ✅ Intuition:
 * - Each digit maps to multiple characters.
 * - The total combinations = product of letters for each digit.
 * - A clean way to explore all combinations is through recursive backtracking.
 */

/**
 * ✅ Approach:
 * - Use a digit-to-letter mapping array (like the phone keypad).
 * - Backtrack through the digits recursively:
 *   → At each index, loop over all possible letters for the current digit.
 *   → Add each letter to the current string and move to next digit.
 *   → If index reaches end of digits, add the current string to the result.
 * - Edge case: If the input string is empty, return an empty list.
 *
 * ✅ Time Complexity: O(3^n * 4^m) where n is count of digits with 3 letters & m with 4 letters
 * ✅ Space Complexity: O(n) for recursion stack + output list
 */

class Solution {
    private final String[] map;

    // ✅ Call an constructor : To use the methods inside all over the program
    public Solution() {

        // ✅ Mapping Digits to their corresponding characters
        // ✅ Leave the first 2 {0th index , 1st index} strings empty as : Given a string consisting of digits from 2 to 9 (inclusive).
        map = new String[] {
                "", // 0th index
                "", // 1st index
                "abc", // 2nd index
                "def", // 3rd index
                "ghi", // 4rt index
                "jkl", // 5th index
                "mno", // 6th index
                "pqrs", // 7th index
                "tuv", // 8th index
                "wxyz" // 9th index
        };
    }

    public List<String> letterCombinations(String digits) {
        // Recursive Approach : ✅✅

        int n = digits.length();
        List<String> ans = new ArrayList<>();
        String current = "";

        // ✅ Edge Case: What is the given input string is empty 
        // eg: digits : "" -> then return []
        if (digits == null || digits.length() == 0)
            return ans;

        backtrack(0, current, ans, digits, n);
        return ans;
    }

    public void backtrack(int index, String current, List<String> ans, String digits, int n) {

        // Base Case:
        // If index reaches length of the digits n , store that current sequence into ans list []
        if (index == n) {
            ans.add(current);
            return;
        }

        // I am standing at that index of given string 
        // We need that digit to map to its corresponding string combo & explore all paths 
        // ✅✅ So, we need to convert that current character into integer form 

        // In java, we cannot directly take digits[index] 
        // ✅ Instead do this :
        // ✅ Get the character corresponding to the current digit 
        String s = map[digits.charAt(index) - '0'];

        // So, once you have the number => explore its all its combinations :
        // ✅ Note : Since for each digit there are 3 possible ways to go 
        // ✅ Thus, we have to go through "3" possible recursions 

        // Instead of manually writing 3 recursions , lets do it within a loop 
        // ✅ Loop through the corresponding characters
        for (int i = 0; i < s.length(); i++) {
            // Recursively call function with next index 
            // Add the current charcaters to the string {✅ concatenation method }
            backtrack(index + 1, current + s.charAt(i), ans, digits, n);
        }
    }
}
