## Problem: Print any 1 subsequence with sum K
/**
 * Problem: Print any 1 subsequence with sum K
 * 
 * Given an array nums and an integer k, print any 1 non-empty subsequence 
 * of nums such that the sum of all elements in the subsequence is equal to k.
 * 
 * You must return only one valid subsequence — stop further recursion once one valid match is found.
 * 
 * Constraints:
 * 1 <= nums.length <= 20
 * 1 <= nums[i] <= 100
 * 1 <= k <= 2000
 * 
 * Example 1:
 * Input: nums = [4, 9, 2, 5, 1], k = 10
 * Output: [9, 1]
 * Explanation: Valid subsequences that sum to 10 are [9, 1] and [4, 5, 1], but return any one of them.
 * 
 * Example 2:
 * Input: nums = [4, 2, 10, 5, 1, 3], k = 5
 * Output: [2, 3]
 * Explanation: Other valid subsequences include [4, 1], [5] — return any one.
 * 
 * Example 3:
 * Input: nums = [1, 10, 4, 5], k = 16
 * Output: [1, 10, 5]
 */

class Solution {
    public List<List<Integer>> printAnySubsequenceWithTargetSum(int[] nums, int k) {
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

    public boolean backtrack(int index, List<Integer> current, int sum, List<List<Integer>> ans, int[] nums, int n, int k){
        // Base case: 
        // When ever index equals to the length of input array 
        // STOP and check if sum == k
        if(index == n){
            if(sum == k){
              // Condition Satisfied✅  
              ans.add(new ArrayList<>(current)); // ✅ Add the found subsequence
              return true; // ✅ Stop recursion once one valid subsequence is found
            }
            // Otherwise => Condition Not Satisfied❌
            return false; // ✅ Stop recursion once one valid subsequence is found
        } 

        // Two possibilities : Either Take or Don't Take 

        // Dont Take :
        if(backtrack(index + 1, current, sum, ans, nums, n, k) ==  true){
          return true; // STOP. then and there are return true, cuz we just require any of the subsequence that equals k
        }
        // otherwise perform the recursive calls normally
      
        // Take :
        current.add(nums[index]);
        sum += nums[index];
      
        if(backtrack(index + 1, current, sum, ans, nums, n, k) == true){
          return true; // STOP. then and there are return true, cuz we just require any of the subsequence that equals k
        }
      
        sum -= nums[index]; // Note * After backtrack also remove the last element added from sum 
        current.remove(current.size() - 1); // ✅ Backtrack since we're storing the intermediate subsequence

        // If none of the Take or Not Take recursive calls ever produced any sequence simply return false❌
        return false;
    }
}
