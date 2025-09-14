/*
------------------------------------------------------------------------------------------------------------------------------------------------------
Problem: 1248. Count Number of Nice Subarrays
------------------------------------------------------------------------------------------------------------------------------------------------------
Statement:
Given an array of integers nums and an integer k.  
A continuous subarray is called nice if there are exactly k odd numbers in it.  
Return the number of nice subarrays.  

------------------------------------------------------------------------------------------------------------------------------------------------------
Input / Output:
Example 1:
Input: nums = [1,1,2,1,1], k = 3  
Output: 2   
Explanation: The only subarrays with 3 odd numbers are [1,1,2,1] and [1,2,1,1].  

Example 2:
Input: nums = [2,4,6], k = 1  
Output: 0  

Example 3:
Input: nums = [2,2,2,1,2,2,1,2,2,2], k = 2  
Output: 16  

Constraints:
1 <= nums.length <= 50000  
1 <= nums[i] <= 10^5  
1 <= k <= nums.length  

------------------------------------------------------------------------------------------------------------------------------------------------------
Intuition:
Instead of brute force, we can use a sliding window.  
- Count subarrays with **at most k** odd numbers.  
- Count subarrays with **at most (k-1)** odd numbers.  
- Their difference gives the number of subarrays with **exactly k** odds.  

------------------------------------------------------------------------------------------------------------------------------------------------------
Approach:
1. Use a helper function `numberOfSubarraysLessThanEqualToK(nums, k)` to count subarrays with at most k odds.  
2. Iterate with two pointers (l, r).  
   - Expand `r`, adding odds to the count.  
   - Shrink `l` if odd count exceeds k.  
   - Add `(r - l + 1)` to result for every valid window.  
3. Subtract counts for k and (k-1) to get the exact number.  

------------------------------------------------------------------------------------------------------------------------------------------------------
Complexity:
Time: O(N) — each element is processed at most twice.  
Space: O(1) — constant space used.  

------------------------------------------------------------------------------------------------------------------------------------------------------
Code:
*/
class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        return numberOfSubarraysLessThanEqualToK(nums, k) - numberOfSubarraysLessThanEqualToK(nums, k - 1);
    }

    public int numberOfSubarraysLessThanEqualToK(int[] nums, int k) {
        // Sliding Window + 2 Pointers ✅

        int n = nums.length;
        int l = 0, sum = 0, count = 0;

        for (int r = 0; r < n; r++) {
            sum += (nums[r] % 2); // If odd -> returns 1 || If even -> returns 0
            if (sum > k) {
                while (sum > k) {
                    sum -= (nums[l] % 2);
                    l++;
                }
            }
            count += (r - l + 1);
        }

        return count;
    }
}

