/*
---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
📌 Problem: 152. Maximum Product Subarray
---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
🚩 Statement:
Given an integer array `nums`, find a subarray that has the largest product, and return the product.  
A subarray is a contiguous non-empty sequence of elements within an array.

---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
📥 Input/Output:

Example 1:  
Input: nums = [2,3,-2,4]  
Output: 6  
Explanation: [2,3] has the largest product 6.  

Example 2:  
Input: nums = [-2,0,-1]  
Output: 0  
Explanation: The result cannot be 2, because [-2,-1] is not a subarray.  

Constraints:  
1 <= nums.length <= 2 * 10^4  
-10 <= nums[i] <= 10  
The product of any subarray of nums is guaranteed to fit in a 32-bit integer.  

---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
💡 Intuition:
- We want the **maximum product subarray**.  
- Brute force way:  
  - Try every possible subarray by fixing start index `i`.  
  - Multiply elements from `i` to `j`.  
  - Keep track of the maximum product seen so far.  

---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
🔎 Approach (Brute Force):
1. Initialize `maxProductSubarray` to `nums[0]`.  
2. Iterate over all start indices `i`.  
3. For each `i`, iterate over all end indices `j >= i` and multiply the elements to get `currentProductSubarray`.  
4. Update `maxProductSubarray` if `currentProductSubarray` is greater.  
5. Return `maxProductSubarray`.  

---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
⏱️ Complexity:
- Time: O(N²) → double loop for all subarrays.  
- Space: O(1) → only variables to track product and maximum.  

---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
💻 Code (Java):
---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
*/

class Solution {
    public int maxProduct(int[] nums) {
        // Brute force Approach : Generate all possible subarrays ✅

        int n = nums.length;
        int maxProductSubarray = nums[0];

        for (int i = 0; i < n; i++) {
            int currentProductSubarray = 1;
            for (int j = i; j < n; j++) {
                currentProductSubarray *= nums[j];
                maxProductSubarray = Math.max(maxProductSubarray, currentProductSubarray);
            }
        }

        return maxProductSubarray;
    }
}

