## LeetCode Problem: 3136. Valid Word
/*
 * Difficulty: Easy
 *
 * A word is valid if:
 * 1. It contains at least 3 characters.
 * 2. It contains only digits and English letters.
 * 3. It contains at least one vowel.
 * 4. It contains at least one consonant.
 *
 * Input: word = "234Adas"
 * Output: true
 *
 * Input: word = "a3$e"
 * Output: false
 *
 * Solution Approach:
 * - Use a switch-case to handle each character.
 * - Track presence of vowels and consonants using boolean flags.
 * - If any character is not a letter or digit, return false immediately.
 * - After the loop, return true only if both vowel and consonant exist.
 */

class Solution {
    public boolean isValid(String word) {
        // Most Optimal & Best Approach": 

        // Rule No.1
        if (word.length() < 3)
            return false;

        // Rule No.2
        boolean hasVowel = false;
        boolean hasConsonant = false;

        for (int i = 0; i < word.length(); i++) {
            switch (word.charAt(i)) {
                // Case Vowels :
                case 'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U':
                    hasVowel = true;
                    break;

                // Case Consonants :
                case 'b', 'c', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'm', 'n', 'p', 'q', 'r', 's', 't', 'v', 'w', 'x', 'y',
                        'z', 'B', 'C', 'D', 'F', 'G', 'H', 'J', 'K', 'L', 'M', 'N', 'P', 'Q', 'R', 'S', 'T', 'V', 'W',
                        'X', 'Y', 'Z':
                    hasConsonant = true;
                    break;

                // Case Digits :
                case '0', '1', '2', '3', '4', '5', '6', '7', '8', '9':
                    break;

                // Case Default:
                default:
                    return false;
            }
        }

        // Rule No.3 + Rule No.4 
        return hasVowel && hasConsonant;
    }
}
