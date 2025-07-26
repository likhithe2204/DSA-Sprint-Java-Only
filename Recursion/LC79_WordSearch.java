## LC 79. Word Search (Leetcode : Medium)
/**
 * 🔸 Problem Statement:
 * Given an m x n grid of characters `board` and a string `word`, return `true` if `word` exists in the grid.
 * The word can be constructed from letters of sequentially adjacent cells (horizontally or vertically).
 * The same letter cell may not be used more than once.
 *
 * 🔸 Constraints:
 * - 1 <= m, n <= 6
 * - 1 <= word.length <= 15
 * - board[i][j] and word consist of only lowercase and uppercase English letters.
 *
 * 🔸 Examples:
 * Input: board = [["A","B","C","E"],
 *                 ["S","F","C","S"],
 *                 ["A","D","E","E"]], word = "ABCCED"
 * Output: true
 *
 * Input: board = [["A","B","C","E"],
 *                 ["S","F","C","S"],
 *                 ["A","D","E","E"]], word = "SEE"
 * Output: true
 *
 * Input: board = [["A","B","C","E"],
 *                 ["S","F","C","S"],
 *                 ["A","D","E","E"]], word = "ABCB"
 * Output: false
 */

/**
 * ✅ Intuition:
 * - Try starting from every cell in the grid.
 * - Use DFS to check if we can match all characters of the word.
 * - Temporarily mark a cell as visited to avoid reusing it in the same path.
 */

/**
 * ✅ Approach:
 * - Traverse the board and for each matching first character, run a recursive DFS.
 * - Base case: if all characters match, return true.
 * - At each step: check bounds, match char, mark visited, try 4 directions, backtrack.
 */

/**
 * ✅ Time Complexity: O(m * n * 4^L), where L is length of the word.
 * ✅ Space Complexity: O(L) recursion stack.
 */

class Solution {
    // Main function to check if the word exists in the board
    public boolean exist(char[][] board, String word) {

        int n = board.length; // ✅ Row
        int m = board[0].length; // ✅ Col
        // ✅ Go through every possible cell in the board
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // ✅ Find the very first starting point in board, that matches with starting char in word 
                if (board[i][j] == word.charAt(0)) {
                    // If the starting point is found :
                    // ✅Start the word search from that starting point
                    if (wordSearch(board, i, j, word, 0) == true) {
                        // ✅ The word is found :)
                        return true;
                    }
                }
            }
        }
        return false; // Even after all those iterations if word is not found :(
    }

    // Helper function to check if the word exists starting from cell (i, j)
    public boolean wordSearch(char[][] board, int i, int j, String word, int index) {

        // ✅ Boundary Conditions and character mismatch check 
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || word.charAt(index) != board[i][j])
            return false;

        // ✅ Base Case:
        // If you were able to match along all the way until last character in word 
        if (index == word.length() - 1)
            return true; // Boom! Word is found ✅

        // Otheriwse, there is a match ✅:
        // Before trying out all possible combinations.. 
        // ✅ Mark that cell as visisted Temporarily.. {mark it empty before moving on}
        char temp = board[i][j];
        board[i][j] = '#';

        // ✅ Try All possible combinations {up, bottom, left, right}
        boolean ans = false;
        // ⬆️ Top :
        if (i - 1 >= 0)
            ans = ans || wordSearch(board, i - 1, j, word, index + 1);
        // ⬇️ Bottom :
        if (i + 1 < board.length)
            ans = ans || wordSearch(board, i + 1, j, word, index + 1);
        // ⬅️ Left :
        if (j - 1 >= 0)
            ans = ans || wordSearch(board, i, j - 1, word, index + 1);
        // ➡️ Right :
        if (j + 1 < board[0].length)
            ans = ans || wordSearch(board, i, j + 1, word, index + 1);

        // * Note: we must not tamper input *
        // Even though we did we must restore any changes made 

        // Restore the original charcater in the cell
        board[i][j] = temp;

        return ans; // ✅ If any of the function call returns True, then the final ans will return True
    }
}
