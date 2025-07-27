/**
 * 🔸 Problem Statement:
 * Write a program to solve a Sudoku puzzle by filling the empty cells.
 * A sudoku solution must satisfy:
 * 1. Each of the digits 1–9 must occur exactly once in each row.
 * 2. Each of the digits 1–9 must occur exactly once in each column.
 * 3. Each of the digits 1–9 must occur exactly once in each of the 9 3x3 sub-boxes of the grid.
 * The '.' character indicates empty cells.
 *
 * 🔹 Input:
 * A 9x9 2D char array with '.' for blanks and digits '1'–'9'.
 *
 * 🔹 Output:
 * Modify the input board in-place to the solved Sudoku.
 *
 * 🔹 Constraints:
 * - board.length == 9
 * - board[i].length == 9
 * - board[i][j] is a digit or '.'.
 * - Only one unique solution exists.
 */

class Solution {
    public void solveSudoku(char[][] board) {
        solve(board);
    }

    public boolean solve(char[][] board) {
        // Find the first empty cell
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                if (board[row][col] == '.') {
                    // Try to fill digits [1-9]
                    for (char c = '1'; c <= '9'; c++) {
                        // Check valid or Not 
                        if (isValid(board, row, col, c) == true) {
                            board[row][col] = c;

                            // Check next empty place & check is it valid to place there
                            if (solve(board) == true)
                                return true;
                            // If Not, backtrack and remove the last placed digit
                            else
                                board[row][col] = '.';
                        }
                    }
                    return false; // Stop exploring that path 
                }
            }
        }
        // If all cells were filled : row & col ptrs come out of grid
        return true; // 1 Valid Sudoko Found ✅
    }

    public boolean isValid(char[][] board, int row, int col, char c) {
        // Iterate over indices of grid (0 -> 8)
        for (int i = 0; i < 9; i++) {
            // entire row:
            if (board[row][i] == c)
                return false;
            // entire col:
            if (board[i][col] == c)
                return false;
            // entire 3x3 sub-grid 
            if (board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == c)
                return false;
        }
        // ✅ It is valid to place there.
        return true;
    }
}
