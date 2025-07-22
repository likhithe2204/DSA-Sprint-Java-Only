## 40: Combination Sum II (Leetcode - Medium)
// ✅ Problem: Combination Sum II (Leetcode 40)
// Platform: Leetcode
// Category: Recursion + Backtracking
// Difficulty: Medium

/**
 * 🔸 Problem Statement:
 * Given a collection of candidate numbers (candidates) and a target number (target),
 * find all unique combinations in candidates where the candidate numbers sum to target.
 * 
 * Each number in candidates may only be used once in the combination.
 * The solution set must not contain duplicate combinations.
 *
 * 🔸 Constraints: 
 * 1 <= candidates.length <= 100
 * 1 <= candidates[i] <= 50
 * 1 <= target <= 30
 *
 * 🔸 Examples:
 * Input: candidates = [10,1,2,7,6,1,5], target = 8
 * Output:
 * [
 *   [1,1,6],
 *   [1,2,5],
 *   [1,7],
 *   [2,6]
 * ]
 *
 * Input: candidates = [2,5,2,1,2], target = 5
 * Output:
 * [
 *   [1,2,2],
 *   [5]
 * ]
 */

/**
 * ✅ Intuition:
 * - Since elements can only be used once, we must move to the next index after choosing an element.
 * - Duplicates in the array can cause duplicate combinations — to avoid this, we sort the array and skip duplicates at the same recursion level.
 * - We stop early (prune) if the current candidate is greater than the remaining target (since the array is sorted).
 */

/**
 * ✅ Approach:
 * - Sort the array to group duplicates and enable pruning.
 * - Use a backtracking function with current index, target, current combination, and final answer list.
 * - At each step, skip duplicates using `i > index && nums[i] == nums[i - 1]`.
 * - If nums[i] > target, break the loop to avoid unnecessary recursion (pruning).
 * - Recurse with `i + 1` to avoid reusing the same element.
 * - Backtrack by removing the last picked number before going to the next option.
 *
 * ✅ Time Complexity: O(2^n) in the worst case
 * ✅ Space Complexity: O(n) recursion stack + output list
 */

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        int n = candidates.length;
        List<Integer> current = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();

        // Sort the array to handle duplicates and enable pruning
        Arrays.sort(candidates);

        Backtrack(0, target, current, ans, candidates, n);
        return ans;
    }

    public void Backtrack(int index, int target, List<Integer> current, List<List<Integer>> ans, int[] nums, int n) {
        // Base Case: If target is met, store a copy of the current combination
        if (target == 0) {
            ans.add(new ArrayList<>(current));
            return;
        }

        for (int i = index; i < n; i++) {
            // ✅ Skip duplicates at the same tree level
            if (i > index && nums[i] == nums[i - 1])
                continue;

            // ✅ If the current number exceeds the target, stop exploring this path (pruning)
            if (nums[i] > target)
                break;

            // ✅ Choose the current number
            current.add(nums[i]);

            // ✅ Explore further with updated target and next index (i + 1 ensures no reuse)
            Backtrack(i + 1, target - nums[i], current, ans, nums, n);

            // ✅ Backtrack: remove the last added number
            current.remove(current.size() - 1);
        }
    }
}
