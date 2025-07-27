## ✅ Sudoku Solver (CodeStudio : Hard)

/**
 * 🔸 Problem Statement:
 * You have been given a 9x9 2D integer matrix `MAT` representing a Sudoku puzzle.
 * The empty cells of the Sudoku are filled with 0s, and the rest are filled with integers from 1 to 9.
 * Your task is to fill all the empty cells such that the final matrix represents a valid Sudoku solution.
 *
 * 🔸 Rules:
 * 1. Each digit 1–9 must occur exactly once in each row.
 * 2. Each digit 1–9 must occur exactly once in each column.
 * 3. Each digit 1–9 must occur exactly once in each of the 9 3×3 sub-grids.
 * ✅ You can assume there will be only **one solution**.
 *
 * 🔸 Constraints:
 * - Size of MAT is 9x9
 * - 0 <= MAT[i][j] <= 9
 *
 * 🔸 Sample Input:
 * 3 0 6 5 0 8 4 0 0
 * 5 2 0 0 0 0 0 0 0
 * 0 8 7 0 0 0 0 3 1
 * 0 0 3 0 1 0 0 8 0
 * 9 0 0 8 6 3 0 0 5
 * 0 5 0 0 9 0 6 0 0
 * 1 3 0 0 0 0 2 5 0
 * 0 0 0 0 0 0 0 7 4
 * 0 0 5 2 0 6 3 0 0
 *
 * 🔸 Sample Output:
 * 3 1 6 5 7 8 4 9 2
 * 5 2 9 1 3 4 7 6 8
 * 4 8 7 6 2 9 5 3 1
 * 2 6 3 4 1 5 9 8 7
 * 9 7 4 8 6 3 1 2 5
 * 8 5 1 7 9 2 6 4 3
 * 1 3 8 9 4 7 2 5 6
 * 6 9 2 3 5 1 8 7 4
 * 7 4 5 2 8 6 3 1 9
 *
 * 🔸 Intuition:
 * Try placing numbers [1-9] in every empty cell using backtracking.
 * Only place a number if it is valid (not in same row, column, or 3x3 box).
 * If no number is valid, backtrack and try a different number in the previous cell.
 *
 * 🔸 Approach:
 * - Find the next empty cell.
 * - Try digits 1 to 9.
 * - If valid, place and move forward recursively.
 * - If stuck, reset cell and try next digit.
 *
 * 🔸 Time Complexity: O(9^(n*n)) in worst case (brute-force over grid)
 * 🔸 Space Complexity: O(1) — in-place changes to the input board
 */

import java.util.* ;
import java.io.*; 

public class Solution {
    public static void solveSudoku(int[][] sudoku) {
        solve(sudoku);
    }

    public static boolean solve(int[][] board) {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                if (board[row][col] == 0) {
                    for (int num = 1; num <= 9; num++) {
                        if (isValid(board, row, col, num)) {
                            board[row][col] = num;

                            if (solve(board))
                                return true;
                            else
                                board[row][col] = 0;
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isValid(int[][] board, int row, int col, int num) {
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == num) return false;
            if (board[i][col] == num) return false;
            if (board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == num) return false;
        }
        return true;
    }
}
