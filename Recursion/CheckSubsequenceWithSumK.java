## Problem: Check if there exists a subsequence with sum K (Tuf+)
/**
 * Problem: Check if there exists a subsequence with sum K
 * 
 * Given an array nums and an integer k, return true if there exists a subsequence 
 * such that the sum of its elements is exactly equal to k. Otherwise, return false.
 * 
 * Constraints:
 * 1 <= nums.length <= 20
 * 1 <= nums[i] <= 100
 * 1 <= k <= 2000
 * 
 * Example 1:
 * Input: nums = [1, 2, 3, 4, 5], k = 8
 * Output: Yes
 * Explanation: Subsequences like [1,2,5], [1,3,4], or [3,5] sum up to 8
 * 
 * Example 2:
 * Input: nums = [4, 3, 9, 2], k = 10
 * Output: No
 * Explanation: No subsequence can sum up to 10
 * 
 * Example 3:
 * Input: nums = [1, 10, 4, 5], k = 16
 * Output: Yes
 * 
 * 🔍 Approach:
 * 1. This is a typical subsequence generation problem using recursion (Backtracking).
 * 2. At each index, we either include the element (Take) or skip it (Don't Take).
 * 3. Instead of generating all subsequences, we stop once we find any valid subsequence that matches the target.
 * 4. We use a `count[0]` flag to track if at least one valid subsequence was found.
 */

class Solution {
    public boolean checkSubsequenceSum(int[] nums, int k) {
         // Same as the previous problem : Count all subsequences with sum K ✅🌱
         // But instead of returning count => Return either TRUE or FALSE 

         // Recursive Approach : ✅✅✅

         int n = nums.length;
         int[] count = new int[1]; 
         int sum = 0;

         backtrack(0, count, sum, nums, n, k);
         if(count[0] > 0) return true; // atleast we found one subsequence with sum == k
         return false; // otherwise
    }

    public void backtrack(int index, int[] count, int sum, int[] nums, int n, int k){
        // Base Case : 
        if(index == n){
            if(sum == k){
                count[0]++;
            }
            return;
        }

        // we have two options : Take or Dont Take :

        // Assume we Dont Take :
        backtrack(index + 1, count, sum, nums, n, k);

        // Assume Take :
        sum += nums[index]; // keep a track of sum
        backtrack(index + 1, count, sum, nums, n, k);
    }
}
