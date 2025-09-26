/*
---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
📌 Problem: 611. Valid Triangle Number
---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
🚩 Statement:
Given an integer array nums, return the number of triplets chosen from the array that can make triangles if we take them as side lengths of a triangle.  

---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
🎯 Input/Output:
Example 1:
Input: nums = [2,2,3,4]  
Output: 3  
Explanation: Valid combinations are: (2,3,4), (2,3,4), (2,2,3)  

Example 2:
Input: nums = [4,2,3,4]  
Output: 4  

---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
💡 Intuition:
- A valid triangle requires: nums[a] + nums[b] > nums[c] (where c is the largest side).  
- Sort the array → then for each largest side, use two pointers to count valid pairs.  
- If nums[left] + nums[right] > nums[i], then all pairs between left and right are valid.  

---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
⚙️ Approach:
1. Sort the array.  
2. Fix the largest side at index `i` (from right to left).  
3. Use two pointers `left = 0`, `right = i-1`.  
4. If nums[left] + nums[right] > nums[i], add `(right - left)` to count, move `right--`.  
5. Else, move `left++`.  
6. Continue until all triplets are checked.  

---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
⏱️ Complexity:
- Time: O(n²) (nested loop with two pointers).  
- Space: O(1).  

---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
💻 Code (Java):
*/
class Solution {
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int count = 0;

        for (int i = n - 1; i >= 2; i--) {
            int left = 0, right = i - 1;
            while (left < right) {
                if (nums[left] + nums[right] > nums[i]) {
                    count += right - left;
                    right--;
                } else {
                    left++;
                }
            }
        }
        return count;
    }
}
