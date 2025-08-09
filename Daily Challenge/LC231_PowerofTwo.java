/*
---------------------------------------------------------------------------------------------------------------------------------------------
🧠 Problem Statement:
231. Power of Two (Leetcode)
Given an integer n, return true if it is a power of two. Otherwise, return false.

An integer n is a power of two if there exists an integer x such that n == 2^x.

🗂️ Category: Bit Manipulation
🎯 Difficulty: Easy

---------------------------------------------------------------------------------------------------------------------------------------------

🧠 Intuition:
If a number is a power of two, it has exactly one set bit in its binary representation.
For example:
1 -> 0001
2 -> 0010
4 -> 0100
8 -> 1000

Two ways to verify this:
1. **Count Set Bits** — If exactly one set bit exists → power of two.
2. **n & (n-1) Trick** — For powers of two, subtracting 1 flips all bits after the only set bit,
   making `n & (n-1)` equal to 0.

📌 Approaches:
1. **Using Integer.bitCount(n)**:
   - Return false if n <= 0.
   - Check if `bitCount(n) == 1`.

2. **Using n & (n-1)**:
   - Return false if n <= 0.
   - Check if `(n & (n-1)) == 0`.

---------------------------------------------------------------------------------------------------------------------------------------------

🛠️ Complexity:
Time: O(1) — both bitCount and bitwise operations are constant time
Space: O(1) — no extra data structures used

✅ Constraints Handled:
- Range: -2^31 <= n <= 2^31 - 1 ✅
- Handles negative numbers and zero ✅

---------------------------------------------------------------------------------------------------------------------------------------------
*/

class Solution {
    // Approach 1: Using bit count
    public boolean isPowerOfTwo_bitCount(int n) {
        return n > 0 && Integer.bitCount(n) == 1;
    }

    // Approach 2: Using n & (n-1) == 0
    public boolean isPowerOfTwo_bitwise(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }
}
