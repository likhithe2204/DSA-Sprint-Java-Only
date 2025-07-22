## 1695. Maximum Erasure Value (LeetCode - Medium)
/*
✅ Problem: Maximum Erasure Value (LeetCode - 1695 - Medium)

📝 Problem Statement:
You are given an array of positive integers `nums` and want to erase a subarray containing only unique elements. 
The score of that subarray is the sum of its elements.
Return the **maximum score** possible by erasing exactly one subarray.

An array `b` is a subarray of `a` if it forms a contiguous subsequence of `a`.

🔸 Example 1:
Input: nums = [4,2,4,5,6]
Output: 17

🔸 Example 2:
Input: nums = [5,2,1,2,5,2,1,2,5]
Output: 8

🔹 Constraints:
- 1 <= nums.length <= 10^5
- 1 <= nums[i] <= 10^4

🔍 Approach:
- Brute force each subarray from i to j.
- Check for duplicates using HashSet.
- Track max sum of subarray with unique elements.

🧠 Time Complexity: O(n^2)
🧠 Space Complexity: O(n)
*/

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[] arr = new int[size];

        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }

        int max = 0;

        for (int i = 0; i < size; i++) {
            HashSet<Integer> set = new HashSet<>(); // to store unique elements
            int sum = 0;

            for (int j = i; j < size; j++) {
                if (!set.contains(arr[j])) {
                    set.add(arr[j]); // add unique element
                    sum += arr[j]; // add value to sum
                    max = Math.max(max, sum); // update max if greater
                } else {
                    break; // if duplicate found, break inner loop
                }
            }
        }

        System.out.println(max); // print the maximum sum
    }
}
