## LeetCode Problem: 1922. Count Good Numbers
/*
 * Difficulty: Medium
 *
 * A digit string is good if:
 * - Digits at even indices (0-based) are even => [0, 2, 4, 6, 8] => 5 options
 * - Digits at odd indices are prime => [2, 3, 5, 7] => 4 options
 *
 * Examples:
 * Input: n = 1
 * Output: 5
 *
 * Input: n = 4
 * Output: 400
 *
 * Input: n = 50
 * Output: 564908303
 *
 * Constraints:
 * 1 <= n <= 10^15
 * Return answer modulo 10^9 + 7
 */

class Solution {
    public int countGoodNumbers(long n) {
        // Optimal Approach : MATH (Similar to Leetcode 50. Pow(x, n)) ✅✅✅

        // Step1 : Find out even and odd places for given n
        // Note: For even, n => { ✅ Even = Odd = n / 2 }
        //       For odd,  n => { ✅ Even = Math.ceil(n / 2) & Odd = n / 2}

        // *** NOTE *** : Since answer may be large, return it modulo 109 + 7.

        long mod = 1000000007L;
        long even = (n + 1) / 2; // works well for both even & odd n
        long odd = n / 2;

        // Step2 : Observe 
        // => Digits at even indices are even => [0, 2, 4, 6, 8] => 5 options
        // => Digits at odd indices are prime => [2, 3, 5, 7] => 4 options

        // Step3 : Now multiply 5^even * 4^odd under modulo✅
        long evenPow = myPow(5, even, mod);
        long oddPow = myPow(4, odd, mod);

        // Step4 : Get final result by multiplying both 5^n * 4^n under modulo✅
        long result = (evenPow * oddPow) % mod;
        return (int) result;
    }

    public long myPow(long x, long n, long mod) {
        // Just as same as Leetcode 50. Pow(x, n)

        // Base Case
        if (x == 1 || n == 0)
            return 1;

        // Edge Case : What if the power is negative 
        if (x < 0) {
            x = 1 / x;
            n = -1L * n;
        }

        // Iterative Logic
        long ans = 1;

        while (n > 0) {
            // At first, check to see if n is even or odd?

            // Assume n is odd
            if (n % 2 == 1) {
                // Extract the Base First !
                ans = (ans * x) % mod;
                // & Then reduce the Power by 1 !
                n = n - 1;
            }
            // Otherwise n is even
            else {
                // Multiply the base by itself
                x = (x * x) % mod;
                // Reduce the power by 2
                n = n / 2;
            }
        }
        return ans;
    }
}
