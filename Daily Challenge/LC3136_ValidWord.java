/*
✅ Problem: Valid Word (Leetcode 3136 - Easy)

📝 Problem Statement:
A word is considered valid if:
1. It contains a minimum of 3 characters.
2. It contains only digits (0-9), and English letters (uppercase and lowercase).
3. It includes at least one vowel.
4. It includes at least one consonant.

Return true if the word is valid, otherwise, return false.

🔸 Example 1:
Input: word = "234Adas"
Output: true
Explanation: This word has 7 characters, includes both vowels and consonants, and contains only allowed characters.

🔸 Example 2:
Input: word = "b3"
Output: false
Explanation: Length < 3 and has no vowel.

🔸 Example 3:
Input: word = "a3$e"
Output: false
Explanation: Contains '$' and no consonant.

🔹 Constraints:
- 1 <= word.length <= 20
- word consists of English uppercase and lowercase letters, digits, '@', '#', and '$'
*/

class Solution {
    public boolean isValid(String word) {
        // ✅ Optimal & Clean Approach:

        // Rule 1: Word length must be at least 3
        if (word.length() < 3) return false;

        // Counters for vowels and consonants
        int vowelsCnt = 0;
        int consonantsCnt = 0;

        char[] chars = word.toCharArray();
        for (char c : chars) {
            // Check if character is a letter
            if (Character.isLetter(c)) {
                if (isVowel(c)) vowelsCnt++;       // Vowel check
                else consonantsCnt++;              // If not vowel but a letter => consonant
            }
            // If not letter, check if digit
            else if (!Character.isDigit(c)) {
                return false;                      // Invalid character found
            }
        }

        // Rule 3 & Rule 4: Must have at least one vowel and one consonant
        return vowelsCnt >= 1 && consonantsCnt >= 1;
    }
    // Note (Helper function) :

    /*
    1. "aeiouAEIOU"
            This is a string that contains all vowels, both lowercase and uppercase.

    2. .indexOf(c)
            The indexOf() method checks if the character c exists in the string.
            * If c is found, it returns the index (position) of its first occurrence.
            * If c is not found, it returns -1.

    3. != -1
            This checks whether the character was found:
            * If indexOf(c) returns something other than -1, that means c is a vowel.
            * So != -1 will be true for vowels, and false for non-vowels.

    */

    // ✅ Helper function to check if character is vowel (both lowercase and uppercase)
    public boolean isVowel(char c) {
        return "aeiouAEIOU".indexOf(c) != -1;
    }
}
