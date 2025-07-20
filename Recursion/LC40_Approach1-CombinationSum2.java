## Produced TLE : But my own Intuition ✅✅✅ {124 / 176 testcases passed}
// Platform: Leetcode
// Category: Recursion + Backtracking
// Difficulty: Medium

/**
 * 🔸 Problem Statement:
 * Given a collection of candidate numbers (candidates) and a target number (target), 
 * find all unique combinations in candidates where the candidate numbers sum to target.
 * 
 * Each number in candidates may only be used **once** in the combination.
 * 
 * 🔸 Note:
 * - The solution set must not contain duplicate combinations.
 * - You may return the combinations in any order.
 * 
 * 🔸 Constraints:
 * 1 <= candidates.length <= 100
 * 1 <= candidates[i] <= 50
 * 1 <= target <= 30
 * 
 * 🔸 Examples:
 * Input: candidates = [10,1,2,7,6,1,5], target = 8  
 * Output: [[1,1,6],[1,2,5],[1,7],[2,6]]
 * 
 * Input: candidates = [2,5,2,1,2], target = 5  
 * Output: [[1,2,2],[5]]
 */

/**
 * ✅ Intuition:
 * - At each index, we either take or skip the current element.
 * - We continue building the combination only if it doesn't exceed the target.
 * - All valid combinations are stored, sorted, and duplicates are removed using a HashSet.
 * 
 * ✅ Approach:
 * - Use backtracking to explore all possibilities.
 * - Sort each inner list before adding to the set to ensure duplicate detection.
 * - Convert the set back to a sorted list before returning the result.
 * 
 * ✅ Time Complexity: O(2^n * k), where `n` is number of elements, and `k` is average combination length
 * ✅ Space Complexity: O(2^n) for storing combinations
 */

import java.util.*;

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        int n = candidates.length;
        List<Integer> current = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();

        backtrack(0, target, current, ans, candidates, n);

        // Step 1: Sort each combination
        for (List<Integer> list : ans) {
            Collections.sort(list);
        }

        // Step 2: Remove duplicates using HashSet
        Set<List<Integer>> set = new HashSet<>(ans);

        // Step 3: Convert to list and sort result lexicographically
        List<List<Integer>> result = new ArrayList<>(set);
        result.sort(Comparator.comparing(Object::toString));

        return result;
    }

    public void backtrack(int index, int target, List<Integer> current, List<List<Integer>> ans, int[] nums, int n) {
        if (index == n) {
            if (target == 0) {
                ans.add(new ArrayList<>(current));
            }
            return;
        }

        // Not take the current element
        backtrack(index + 1, target, current, ans, nums, n);

        // Take the current element
        current.add(nums[index]);
        backtrack(index + 1, target - nums[index], current, ans, nums, n);
        current.remove(current.size() - 1);
    }
}
