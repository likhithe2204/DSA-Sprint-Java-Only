## Problem: Print all subsequences with sum K
/**
 * Problem: Print all subsequences with sum K
 * 
 * Given an array nums and an integer k, print all non-empty subsequences 
 * of nums such that the sum of all elements in the subsequence is equal to k.
 * 
 * Constraints:
 * 1 <= nums.length <= 20
 * 1 <= nums[i] <= 100
 * 1 <= k <= 2000
 * 
 * Example 1:
 * Input: nums = [4, 9, 2, 5, 1], k = 10
 * Output: [[9, 1], [4, 5, 1]]
 * Explanation: Valid subsequences are [9, 1] and [4, 5, 1]
 * 
 * Example 2:
 * Input: nums = [4, 2, 10, 5, 1, 3], k = 5
 * Output: [[4, 1], [2, 3], [5]]
 * 
 * Example 3:
 * Input: nums = [1, 10, 4, 5], k = 16
 * Output: [[1, 10, 5]]
 */

class Solution {
    public List<List<Integer>> printSubsequenceWithTargetSum(int[] nums, int k) {
        // Recursive Approach : ✅✅✅

        int n = nums.length;
        int sum = 0;

        // To store the final possible list of subsequences ✅
        List<List<Integer>> ans = new ArrayList<>();

        // To store the intermediate possible list of subsequences ✅
        List<Integer> current = new ArrayList<>();

        backtrack(0, current, sum, ans, nums, n, k);
        return ans;
    }

    public void backtrack(int index, List<Integer> current, int sum, List<List<Integer>> ans, int[] nums, int n, int k){
        // Base case: 
        // When ever index equals to the length of input array 
        // STOP and check if sum == k
        if(index == n){
            if(sum == k){
                ans.add(new ArrayList<>(current));
            }
            return;
        } 

        // Two possibilities : Either Take or Don't Take 

        // Dont Take :
        backtrack(index + 1, current, sum, ans, nums, n, k);

        // Take :
        current.add(nums[index]);
        sum += nums[index];
        backtrack(index + 1, current, sum, ans, nums, n, k);
        sum -= nums[index]; // Note * After backtrack also remove the last element added from sum 
        current.remove(current.size() - 1); // ✅ Backtrack since we're storing the intermediate subsequence
    }
}
