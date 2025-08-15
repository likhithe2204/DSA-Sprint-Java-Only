/**
 * Problem: Next Greater Element
 * Platform: GeeksforGeeks
 * Category: Arrays / Brute Force
 * Difficulty: Medium
 *
 * Problem Statement:
 * Given an array arr[] of integers, the task is to find the next greater element 
 * for each element in the array in order of their appearance.
 * Next greater element of an element is the nearest element on the right 
 * which is greater than the current element.
 * If there does not exist next greater of current element, then -1.
 *
 * Examples:
 * Input:  arr = [1, 3, 2, 4]
 * Output: [3, 4, 4, -1]
 *
 * Input:  arr = [6, 8, 0, 1, 3]
 * Output: [8, -1, 1, 3, -1]
 *
 * Constraints:
 * 1 ≤ arr.length ≤ 10^6
 * 0 ≤ arr[i] ≤ 10^9
 *
 * Intuition:
 * For each element, check all elements to its right and find the first one 
 * that is greater. If none found, assign -1.
 *
 * Approach:
 * 1. Loop over each element arr[i].
 * 2. From i+1 to n-1, search for first element > arr[i].
 * 3. If found, store it; else store -1.
 *
 * Time Complexity:  O(n^2)
 * Space Complexity: O(n) (for output list)
 */

import java.util.*;

class Solution {
    public ArrayList<Integer> nextLargerElement(int[] arr) {
        int n = arr.length;
        ArrayList<Integer> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int nextGreater = -1;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] > arr[i]) {
                    nextGreater = arr[j];
                    break;
                }
            }
            ans.add(nextGreater);
        }

        return ans;
    }
}
