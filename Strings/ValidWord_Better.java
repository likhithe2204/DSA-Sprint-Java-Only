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
 * - Use helper method to check for vowels.
 * - Iterate through characters to count vowels and consonants.
 * - Reject if any invalid character found.
 * - Return true if all conditions met.
 */

class Solution {
    public boolean isValid(String word) {
        // Better Approach": 

        // Rule No.1
        if(word.length() < 3) return false;

        // Rule No.2
        int vowelsCnt = 0;
        int consonantsCnt = 0;

        char[] chars = word.toCharArray();
        for(char c : chars){
            // letter Check
            if(Character.isLetter(c)){
                // Vowel Check
                if(isVowel(c)) vowelsCnt++; // vowel✅
                else consonantsCnt++; // consonant✅
            }
            // If NOT letter => Digit Check
            else if(!Character.isDigit(c)) return false; // If NOT both => not valid WORD
        }

        // Rule No.3 + Rule No.4 
        if(vowelsCnt >= 1 && consonantsCnt >= 1) return true;
        else return false;
    }
    // Helper function :

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
    public boolean isVowel(char c){
        // check for Both Uppercase & Lowercase vowels:
        return "aeiouAEIOU".indexOf(c) != -1;
    }
}
