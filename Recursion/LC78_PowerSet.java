## LeetCode Problem 78 - Subsets
/**
 * Link: https://leetcode.com/problems/subsets/
 * 
 * Given an integer array nums of unique elements, return all possible subsets (the power set).
 * The solution set must not contain duplicate subsets. Return the solution in any order.
 * 
 * Constraints:
 * 1 <= nums.length <= 10
 * -10 <= nums[i] <= 10 
 * All the numbers of nums are unique.
 * 
 * Example 1:
 * Input: nums = [1,2,3]
 * Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 * 
 * Example 2:
 * Input: nums = [0]
 * Output: [[],[0]]
 */

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        // Most Optimal Recursive Approach : Take or Not Take it✅✅✅

        int n = nums.length;
        // To store the final possible list of subsequences
        List<List<Integer>> ans = new ArrayList<>();
        // To store the intermediate possible list of subsequences
        List<Integer> current = new ArrayList<>();
        // Call the Recursive function 
        backtrack(0, ans, current, nums, n);
        return ans;
    }

    // Helper function that recursively calls at each step and finally returns the list of possible subsequences.
    public void backtrack(int index, List<List<Integer>> ans, List<Integer> current, int[] nums, int n) {
        // Point to remember : 
        // ****** 1. Take (OR) 2. Dont Take *******

        // NOTE: For every recursive skeleton Base Case is the first to write

        // Base case: if the index reaches the length of the array,
        // add the current subset to the answer list
        if (index == n) {
            ans.add(new ArrayList<>(current));
            return;
        }

        // DON'T TAKE:
        backtrack(index + 1, ans, current, nums, n);

        // TAKE:
        current.add(nums[index]);
        backtrack(index + 1, ans, current, nums, n);
        // Edge case: 
        current.remove(current.size() - 1);
    }
}
