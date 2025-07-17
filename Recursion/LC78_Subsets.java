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

import java.util.*;

public class LC78_Subsets {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>(); // List to store all subsets
        List<Integer> current = new ArrayList<>();   // Temporary list to store the current subset
        backtrack(0, nums.length, nums, current, ans); // Start the recursive process
        return ans; // Return the list of all subsets
    }

    // Helper function to generate all subsets
    private void backtrack(int index, int n, int[] nums, List<Integer> current, List<List<Integer>> ans) {
        // Base case: if the index reaches the length of the array,
        // add the current subset to the answer list
        if (index == n) {
            ans.add(new ArrayList<>(current));
            return;
        }

        // Recursive case: Exclude the current element and move to the next element
        backtrack(index + 1, n, nums, current, ans);

        // Include the current element in the subset and move to the next element
        current.add(nums[index]);
        backtrack(index + 1, n, nums, current, ans);

        // Backtrack: remove the last added element to explore other subsets
        current.remove(current.size() - 1);
    }

    // For local testing
    public static void main(String[] args) {
        LC78_Subsets solution = new LC78_Subsets();
        int[] nums = {1, 2, 3};
        List<List<Integer>> result = solution.subsets(nums);
        System.out.println(result);
    }
}
