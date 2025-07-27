## Leetcode : 51. N-Queens (Hard)
/*
    🔹 Platform: Leetcode
    🔹 Problem Name: N-Queens
    🔹 Category: Backtracking
    🔹 Difficulty: Hard

    🔸 Intuition:
    Place one queen per column and try all rows. For every valid placement,
    recursively try placing a queen in the next column. Backtrack if needed.

    🔸 Approach:
    - For each column, try placing a queen in each row.
    - Check if it's safe by checking upper-left diagonal, left row, and lower-left diagonal.
    - If safe, place the queen and move to next column.
    - If we reach column == n, store the current board configuration.
    - Backtrack after each recursive call.

    🔸 Time Complexity: O(N!)
    🔸 Space Complexity: O(N^2) for the board + O(N) recursion stack
*/

class Solution {
    public List<List<String>> solveNQueens(int n) {
        // Recursive approach: ✅

        // To store the final list of combinations of possible answers
        List<List<String>> ans = new ArrayList<>();
        List<String> board = new ArrayList<>();
        String s = "";
        // Mark all the strings empty (initially.)
        for (int i = 0; i < n; i++) {
            s = s + ".";
        }
        // Now wrap these empty strings into a chess board
        for (int i = 0; i < n; i++) {
            board.add(s);
        }
        // As of now your chess board is ready with all empty cells

        // call the recursive function to fill all the queens
        solve(0, board, ans, n);
        return ans;
    }

    // Recursive helper function that fills each col with a 'Q'
    public void solve(int col, List<String> board, List<List<String>> ans, int n) {

        // Base case:
        // When index tracker reached last col i.e. n ~ means we were able to place all the queens successfully.
        if (col == n) {
            ans.add(new ArrayList<>(board));
            return;
        }

        // Go through each row and fill each cell with 1 Queen. 
        for (int row = 0; row < n; row++) {
            // Check is it safe to place a Queen in that cell of not
            if (isSafe(row, col, board, n) == true) {
                // place the queen in that cell
                char[] charArray = board.get(row).toCharArray();
                charArray[col] = 'Q';
                board.set(row, new String(charArray));

                // call the recursion for next col
                solve(col + 1, board, ans, n);

                // After backtrack make sure you remove the placed queen
                charArray[col] = '.';
                board.set(row, new String(charArray));
            }
        }
    }

    // Helper function that tells whether is it SAFE to place a Queen in that cell ?
    public boolean isSafe(int row, int col, List<String> board, int n) {

        // Make sure you store { # of rows & # of cols } in temp variables 
        int r = row;
        int c = col;

        // Upper diagonal :
        while (r >= 0 && c >= 0) {
            if (board.get(r).charAt(c) == 'Q')
                return false;
            r--;
            c--;
        }

        // Rest -> Original
        r = row;
        c = col;

        // Left side :
        while (c >= 0) {
            if (board.get(r).charAt(c) == 'Q')
                return false;
            c--;
        }

        // Reset -> Original
        r = row;
        c = col;

        // Lower diagonal :
        while (r < n && c >= 0) {
            if (board.get(r).charAt(c) == 'Q')
                return false;
            r++;
            c--;
        }

        // If and Only If all these 3 direcrtions were safe, then that cell is safe to place a Queen
        return true;
    }
}
