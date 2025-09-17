/*
---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
📌 Problem: 1423. Maximum Points You Can Obtain from Cards
---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
🚩 Statement:
There are several cards arranged in a row, and each card has an associated number of points.  
In one step, you can take one card from the beginning or from the end of the row.  
You have to take exactly `k` cards.  

Return the maximum score you can obtain.  

---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
📥 Input/Output:

Example 1:
Input: cardPoints = [1,2,3,4,5,6,1], k = 3  
Output: 12  

Example 2:
Input: cardPoints = [2,2,2], k = 2  
Output: 4  

Example 3:
Input: cardPoints = [9,7,7,9,7,7,9], k = 7  
Output: 55  

Constraints:  
1 <= cardPoints.length <= 10⁵  
1 <= cardPoints[i] <= 10⁴  
1 <= k <= cardPoints.length  

---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
💡 Intuition:
- You can only take cards from **left side** or **right side**.  
- Equivalent to choosing a **split of k cards** between left and right.  
- Start with all `k` from left, then gradually shift one-by-one to right, keeping track of best sum.  

---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
🔎 Approach (Sliding Window Trick):
1. Compute sum of first `k` cards from left (initial window).  
2. Iteratively remove cards from left end, add from right end.  
3. Track maximum sum across all such partitions.  

---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
⏱️ Complexity:
- Time: O(k), since we only slide `k` times.  
- Space: O(1), constant extra variables.  

---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
💻 Code (Java):
---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
*/
  class Solution {
    public int maxScore(int[] arr, int k) {
        // Sliding Window Partitioning ✅

        int n = arr.length;
        int leftSum = 0, rightSum = 0, maxSum = 0;

        // take all cards from left initially
        for (int i = 0; i < k; i++) {
            leftSum += arr[i];
        }
        maxSum = leftSum;

        // shift window: remove left, add from right
        int rightIndex = n - 1;
        for (int i = k - 1; i >= 0; i--) {
            leftSum -= arr[i];
            rightSum += arr[rightIndex];
            rightIndex--;

            maxSum = Math.max(maxSum, leftSum + rightSum);
        }

        return maxSum;
    }
}

