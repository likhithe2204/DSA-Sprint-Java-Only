## LC 131. Palindrome Partitioning (Leetcode : Medium)
/**
 * 🔸 Problem Statement:
 * Given a string `s`, partition `s` such that every substring of the partition is a palindrome.
 * Return all possible palindrome partitioning of `s`.
 *
 * 🔸 Constraints:
 * 1 <= s.length <= 16
 * s contains only lowercase English letters.
 *
 * 🔸 Examples:
 * Input: s = "aab"
 * Output: [["a","a","b"],["aa","b"]]
 *
 * Input: s = "a"
 * Output: [["a"]]
 */

/**
 * ✅ Intuition:
 * - We're asked to generate all combinations of substrings where each substring is a palindrome.
 * - So, at every index, we explore all possible substrings starting from that index.
 * - For each valid palindrome substring, we recursively try the rest of the string.
 * - Backtracking helps explore all such valid combinations.
 */

/**
 * ✅ Approach:
 * - Use backtracking starting from index 0.
 * - At each step, try all substrings s[index...i] and check if it’s a palindrome.
 * - If yes, add to current partition list and recurse for next index.
 * - Backtrack by removing last added string.
 *
 * ✅ Time Complexity: O(2^n) for all possible partitions (in worst case, all characters are palindromes)
 * ✅ Space Complexity: O(n) for recursion + O(k) for storing partitions
 */

## ✅ Code :

class Solution {
    public List<List<String>> partition(String s) {
        // Simple Recursive Approach : ✅

        int n = s.length();
        // To store the intermediate sequence
        List<String> current = new ArrayList<>();
        // To store all the possible subsequences
        List<List<String>> ans = new ArrayList<>();

        // call 'Partition Recursive Function'
        backtrack(0, s, current, ans, n);
        return ans;
    }

    public void backtrack(int index, String s, List<String> current, List<List<String>> ans, int n) {

        // ✅ Base Case:
        if (index == n) {
            ans.add(new ArrayList<>(current));
            return;
        }

        // ✅ Run the recursive calls through loop (ind --> s.len())
        for (int i = index; i < n; i++) {
            // ✅ Take the substring from {ind --> i}
            // ✅ & Check whether it is a Palindrome Or Not
            if (isPalindrome(s, index, i)) {
                // Yes! = It's a Palindrome

                // ✅ Add that substring[inclusive] into the current sequence
                current.add(s.substring(index, i + 1));

                // ✅ Then only perform the next index partitioning & explore recursively
                backtrack(i + 1, s, current, ans, n);

                // ✅ After backtrack remove last element from sequence
                current.remove(current.size() - 1);
            }
        }
    }

    // Helper function : To check whether the passed string is Palindrome Or Not
    public boolean isPalindrome(String s, int start, int end) {
        while (start <= end) {
            if (s.charAt(start++) != s.charAt(end--))
                return false; // Not Palindrome.
        }
        return true; // ✅ Palindrome.
    }
}
