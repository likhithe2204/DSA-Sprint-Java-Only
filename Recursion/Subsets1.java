## Problem : Subsets I (Tuf+)
/*
🧠 Problem: Subset Sums (Subsets I)

📄 Statement:
Given an array of integers `nums`, return **all possible subset sums** (i.e., the sum of each subset including the empty set).
The result should include all subset sums without any duplicates.

📥 Input:
- An array `nums` of integers (1 <= nums.length <= 10)

📤 Output:
- A list of integers representing all possible subset sums

🧪 Test Cases:
Input: [2, 3]
Output: [0, 3, 2, 5]

Input: [5, 2, 1]
Output: [0, 1, 2, 3, 5, 6, 7, 8]

Input: [1]
Output: [0, 1]

🔍 Approach:
- Use Backtracking to explore all subset combinations
- For each index, you can either:
  1. Exclude the current element (sum remains same)
  2. Include the current element (add to sum)
- Base case: when index == array length, add current sum to result
- This is similar to generating all subsequences or the power set, but instead we track the sum

👨‍💻 Code:
*/

class Solution {
    public List<Integer> subsetSums(int[] nums) {
        // Kinda similar to Print All Subsequences (or) Power Set 

        int n = nums.length; 
        int sum = 0;
        // To store the final result of Sums of their Subsequences
        List<Integer> res = new ArrayList<>();

        backtrack(0, sum, res, nums, n);
        return res;
    }
    public void backtrack(int index, int sum, List<Integer> res, int[] nums, int n){
        // Base Case:
        if(index == n){
            res.add(sum);
            return;
        }

        // Two Possibilities : Either Take or Not Take:

        // Not Take:
        // If you are not taking any then the sum remains unchanged too! 
        backtrack(index + 1, sum, res, nums, n);

        // Take:
        // But if you are taking the element into the sequence, make sure keep a track of sum too !
        sum += nums[index]; 
        backtrack(index + 1, sum, res, nums, n);
        sum -= nums[index]; 
    }
}
