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
 */

  ## Solution Approach:
/*
 * - Use a recursive method with exponentiation by squaring.
 * - Convert n to long to avoid integer overflow when n = -2^31.
 * - If n < 0, invert x and make n positive by returning 1.0 / power().
 * - When power is odd, multiply result by base and reduce power by 1.
 * - When power is even, square the base and halve the power.
 */

class Solution {
    public double myPow(double x, int n) {
        // Most Optimal Approach : {Recursive}

        // Edge case:
        // What happens when 'n' is negative

        if (n < 0) {
            // convert n to long before negating to avoid overflow
            return 1.0 / power(x, -(long) n);

            /*
                How this line works : return 1.0 / power(x, -(long)n);

                ✅ Example:
                => x = 2.0, n = -3
                => return 1.0 / power(2.0, 3L); // -> 1.0 / (2*2*2) = 1.0 / 8 = 0.125
            */
        }

        // If 'n' is non-negative then perform recursion
        return power(x, n);
    }

    public double power(double x, long n) {

        // BaseCase:
        if (x == 1.0 || n == 0)
            return 1.0;

        if (n % 2 == 1) {
            // what happens when the power is odd
            // Extract the base & reduce the power by 1
            return x * power(x, n - 1); // Recursive call
        }

        // otherwise n is even
        // what happens when the power is even
        // Multiply base by itself & power gets reduced by halve
        return power(x * x, n / 2); // Recursive call
    }
}
