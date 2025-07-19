## Problem: Count all subsequences with sum K (Tuf+)
/**
 * Problem: Count all subsequences with sum K
 * 
 * Given an array nums and an integer k. Return the number of non-empty subsequences 
 * of nums such that the sum of all elements in the subsequence is equal to k.
 * 
 * Constraints:
 * 1 <= nums.length <= 20
 * 1 <= nums[i] <= 100
 * 1 <= k <= 2000
 * 
 * Example 1:
 * Input: nums = [4, 9, 2, 5, 1], k = 10
 * Output: 2
 * Explanation: Valid subsequences are [9, 1] and [4, 5, 1]
 * 
 * Example 2:
 * Input: nums = [4, 2, 10, 5, 1, 3], k = 5
 * Output: 3
 * Explanation: Valid subsequences are [4, 1], [2, 3], [5]
 * 
 * Example 3:
 * Input: nums = [1, 10, 4, 5], k = 16
 * Output: 1
 */

class Solution {
    public int countSubsequenceWithTargetSum(int[] nums, int k) {
        // Recursive Approach : ✅✅✅

        int n = nums.length;
        // Mutable counter to store how many subsequences sum to k
        int[] count = new int[1]; // initial count how many subsequence sum = k
        int sum = 0;

        backtrack(0, sum, count, nums, n, k);
        return count[0];
    }

    public void backtrack(int index, int sum, int[] cnt, int[] nums, int n, int k){
        // Base case: 
        // When ever index equals to the length of input array 
        // STOP and check if sum == k
        if(index == n){
            if(sum == k){
                cnt[0]++;
            }
            return;
        } 

        // Two possibilities : Either Take or Don't Take 

        // Dont Take :
        backtrack(index + 1, sum, cnt, nums, n, k);

        // Take :
        sum += nums[index];
        backtrack(index + 1, sum, cnt, nums, n, k);
        //current.remove(current.size() - 1); ❌ No need cuz we aren'nt storing any intermediate subsequences
    }
}
