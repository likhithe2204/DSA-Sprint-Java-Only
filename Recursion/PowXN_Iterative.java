## LeetCode Problem: 50. Pow(x, n)
/*
 * Difficulty: Medium
 *
 * Implement pow(x, n), which calculates x raised to the power n (i.e., x^n).
 *
 * Examples:
 * Input: x = 2.00000, n = 10
 * Output: 1024.00000
 *
 * Input: x = 2.10000, n = 3
 * Output: 9.26100
 *
 * Input: x = 2.00000, n = -2
 * Output: 0.25000
 * Explanation: 2^-2 = 1/2^2 = 1/4 = 0.25
 *
 * Constraints:
 * -100.0 < x < 100.0
 * -2^31 <= n <= 2^31-1
 * Either x is not zero or n > 0
 * -10^4 <= x^n <= 10^4
 *
*/
  
 ## Solution Approach:
/*
 * - Use an iterative method with exponentiation by squaring.
 * - Convert n to long to avoid integer overflow when n = -2^31.
 * - If n < 0, invert x and make n positive.
 * - Multiply result with base when power is odd, otherwise square the base and halve the power.
 */

class Solution {
    public double myPow(double x, int n) {
        // Most Optimal Approach : {Iterative}

        // BaseCase:
        if (x == 1.0 || n == 0)
            return 1.0;

        long num = n;
        double ans = 1.0;

        // EdgeCase
        if (n < 0) {
            x = 1 / x;
            num = -1L * n; // To avoid IntegerOverflow
        }

        // Stopping Condition = When 'n' reaches 0
        while (num > 0) {
            if (num % 2 == 1) {
                // Extract the base first & store in answer
                // eg : 2^49 = 2^1 * 2^48
                ans = ans * x;
                num = num - 1; // after extracting base 'n' get reduced by 1
            } else {
                // eg : 2^48 = (2^2)^24
                //      4^24 = (4^2)^12
                //          ..
                x = x * x; // observe: Base always gets Multiplied by itslef
                num = num / 2; // & power is always getting reduced by halve
            }
        }
        return ans;
    }
}
