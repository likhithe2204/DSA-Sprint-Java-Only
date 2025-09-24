/*
---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
📌 Problem: 166. Fraction to Recurring Decimal
---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
🚩 Statement:
Given two integers representing the numerator and denominator of a fraction, return the fraction in string format.  

If the fractional part is repeating, enclose the repeating part in parentheses.  
If multiple answers are possible, return any of them.  

It is guaranteed that the length of the answer string is less than 10⁴ for all the given inputs.
---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
🎯 Input/Output:
Example 1:
Input: numerator = 1, denominator = 2  
Output: "0.5"  

Example 2:
Input: numerator = 2, denominator = 1  
Output: "2"  

Example 3:
Input: numerator = 4, denominator = 333  
Output: "0.(012)"  
---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
💡 Intuition:
- First, handle the sign of the result separately.  
- Use `long` to avoid integer overflow (since `|numerator|` and `|denominator|` can go up to 2³¹-1).  
- Perform integer division for the integral part.  
- For the decimal part, simulate long division:  
  - Keep track of remainders and the index at which each remainder was first seen.  
  - If a remainder repeats, that means the digits start repeating from that index → place parentheses around the repeating sequence.  
---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
⚙️ Approach:
1. Handle zero numerator (answer is `"0"`).  
2. Handle negative sign cases with XOR.  
3. Compute integer part using `dividend / divisor`.  
4. Compute remainder → if zero, return result.  
5. Otherwise, start generating decimal digits.  
6. Use a hashmap to detect repeating remainders and insert parentheses accordingly.  
---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
⏱️ Complexity:
- Time: O(n) where n is the number of digits in the decimal expansion (limited by remainder repeats).  
- Space: O(n) for storing remainders in the hashmap.  
---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
💻 Code (Java):
  */
class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0)
            return "0";

        StringBuilder fraction = new StringBuilder();
        if (numerator < 0 ^ denominator < 0)
            fraction.append("-");

        long dividend = Math.abs(Long.valueOf(numerator));
        long divisor = Math.abs(Long.valueOf(denominator));
        fraction.append(dividend / divisor);
        long remainder = dividend % divisor;
        if (remainder == 0) {
            return fraction.toString();
        }

        fraction.append(".");
        Map<Long, Integer> map = new HashMap<>();
        while (remainder != 0) {
            if (map.containsKey(remainder)) {
                fraction.insert(map.get(remainder), "(");
                fraction.append(")");
                break;
            }
            map.put(remainder, fraction.length());
            remainder *= 10;
            fraction.append(remainder / divisor);
            remainder %= divisor;
        }

        return fraction.toString();
    }
}

