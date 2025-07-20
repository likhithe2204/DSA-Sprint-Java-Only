##  ✅ Problem: Count all Subsequences with Sum K (Imp Pattern To Remember 🔴)
// Platform: TUF / Striver Sheet
// Category: Recursion + Backtracking
// Difficulty: Medium

/**
 * Given an array nums and an integer k, return the number of non-empty 
 * subsequences of nums such that the sum of all elements in the subsequence is equal to k.
 * 
 * ✅ Constraints:
 * 1 <= nums.length <= 20
 * 1 <= nums[i] <= 100
 * 1 <= k <= 2000
 * 
 * ✅ Examples:
 * Input: nums = [4, 9, 2, 5, 1], k = 10
 * Output: 2
 * Explanation: Valid subsequences are [9,1] and [4,5,1]
 * 
 * Input: nums = [4, 2, 10, 5, 1, 3], k = 5
 * Output: 3
 * Explanation: Valid subsequences are [4,1], [2,3], [5]
 * 
 * Input: nums = [1, 10, 4, 5], k = 16
 * Output: 1
 * Explanation: Valid subsequence is [1, 10, 5]
 */


// ✅ Approach 2 : Recursive Function returns count directly (Striver's Pattern)
// ✅ Time: O(2^n)  | ✅ Space: O(n) recursion stack

class Solution {
    public int countSubsequenceWithTargetSum(int[] nums, int k) {
        // ✅ Recursive Approach – without using extra array to hold count
        int n = nums.length;
        int sum = 0;

        return backtrack(0, sum, nums, n, k); // ✅
    }

    // ✅ Recursive helper function
    public int backtrack(int index, int sum, int[] nums, int n, int k){

        // Little Optimizations we can make:
        
        // Base case 1 :
        // Strictly Only applied if array contains only non-negative elements
        if (sum > k) return 0;
        
        // Base case 2: 
        // When ever index equals to the lenght of input array 
        // STOP and check if sum == k
        if(index == n){
            if(sum == k){
                // Condition Satisfied✅
                return 1;
            }
            // Condition is'nt Satisfied❌
            return 0;
        } 

        // Two possibilities : Either Take or Don't Take 

        // Dont Take :
        int left = backtrack(index + 1, sum, nums, n, k);

        // Take :
        sum += nums[index];
        int right = backtrack(index + 1, sum, nums, n, k);
        sum -= nums[index]; // Note * After backtrack also remove the last element added from sum 
        //current.remove(current.size() - 1); ❌ No need cuz we aren'nt storing any intermediate subsequences

        return left + right; // total count ✅✅✅
    }
}
