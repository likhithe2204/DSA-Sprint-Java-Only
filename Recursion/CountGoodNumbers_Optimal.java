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

        long evenPow = modPow(5, evenCnt, mod); // 5^evenCnt
        long oddPow = modPow(4, oddCnt, mod);   // 4^oddCnt

        long result = (evenPow * oddPow) % mod;
        return (int) result;
    }

    // Helper Function: Modular Exponentiation✅
    public long modPow(long base, long exp, long mod) {
        long res = 1;
        base %= mod;

        while (exp > 0) {
            if (exp % 2 == 1) {
                res = (res * base) % mod;
            }
            base = (base * base) % mod;
            exp = exp / 2;
        }
        return res;
    }
}
