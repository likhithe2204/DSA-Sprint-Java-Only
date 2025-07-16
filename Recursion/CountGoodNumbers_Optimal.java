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
        // Optimal Approach : Using Modular Exponentiation✅✅✅

        // Step1 : Find how many even places are there (n+1)/2✅
        // Step2 : Find how many odd places are there n/2✅
        // Step3 : Now multiply 5^even * 4^odd under modulo✅

        long mod = 1_000_000_007;

        long evenCnt = (n + 1) / 2;
        long oddCnt = n / 2;

        long evenPow = myPow(5, evenCnt, mod);
        long oddPow = myPow(4, oddCnt, mod);

        long result = (evenPow * oddPow) % mod;
        return (int) result;
    }

    public long myPow(long x, long n, long mod) {
        // Most Optimal Iterative Approach : 

        // BaseCase
        if (x == 1 || n == 0)
            return 1;

        // Iterative Logic
        long ans = 1;
        x = x % mod;

        while (n > 0) {
            if (n % 2 == 1) {
                ans = (ans * x) % mod;
                n = n - 1;
            } else {
                x = (x * x) % mod;
                n = n / 2;
            }
        }
        return ans;
    }
}
