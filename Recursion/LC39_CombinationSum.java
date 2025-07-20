✅ Problem: Combination Sum (Leetcode 39)
// Platform: Leetcode
// Category: Recursion + Backtracking
// Difficulty: Medium

/**
 * 🔸 Problem Statement:
 * Given an array of distinct integers `candidates` and a target integer `target`, 
 * return a list of all unique combinations of candidates where the chosen numbers sum to target.
 * 
 * You may return the combinations in any order.
 * The same number may be chosen from candidates an unlimited number of times.
 * 
 * Two combinations are unique if the frequency of at least one of the chosen numbers is different.
 * 
 * 🔸 Constraints:
 * 1 <= candidates.length <= 30
 * 2 <= candidates[i] <= 40
 * All elements of candidates are distinct.
 * 1 <= target <= 40
 * 
 * 🔸 Examples:
 * Input: candidates = [2,3,6,7], target = 7
 * Output: [[2,2,3],[7]]
 * 
 * Input: candidates = [2,3,5], target = 8
 * Output: [[2,2,2,2],[2,3,3],[3,5]]
 * 
 * Input: candidates = [2], target = 1
 * Output: []
 */

/**
 * ✅ Intuition:
 * - We explore all possible combinations using recursion and backtracking.
 * - For each index, we decide whether to **pick** the element (and stay at the same index) or **not pick** it (and move to the next index).
 * - We pick an element multiple times only if it does not overshoot the current `target`.
 * - We stop exploring when either the target becomes 0 (valid combination) or index exceeds bounds.
 */

/**
 * ✅ Approach:
 * - Use a recursive function with index, target, current combination, and final answer list.
 * - When `target == 0`, add the current list to the answer.
 * - When `arr[index] <= target`, we can pick the element and recurse with reduced target.
 * - Backtrack properly to explore other branches.
 * 
 * ✅ Time Complexity: O(2^target) in worst case
 * ✅ Space Complexity: O(target) stack space due to recursion
 */

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        int n = candidates.length;
        List<Integer> current = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();

        combinationSum(0, target, current, ans, candidates, n);
        return ans;
    }

    public void combinationSum(int index, int target, List<Integer> current, List<List<Integer>> ans, int[] arr, int n) {
        // ✅ Base Case:
        if (index == n) {
            // ✅ Condition satisfied?
            if (target == 0) {
                ans.add(new ArrayList<>(current));
            }
            return;
        }

        // ✅ Not Pick:
        // If you are not picking any element then move to next element 
        combinationSum(index + 1, target, current, ans, arr, n);

        // ✅ Pick:
        // If you are picking that element then you can pick 'n' # of times unless 
        // that particular index value from candidates[] is Not exceeding the Target sum
        if (arr[index] <= target) {
            current.add(arr[index]); // ✅ keep on adding ..
            combinationSum(index, target - arr[index], current, ans, arr, n); // stay on same index
            current.remove(current.size() - 1); // ✅ backtrack
        }
    }
}
