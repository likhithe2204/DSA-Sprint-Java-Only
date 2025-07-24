### ✅ 216. Combination Sum III (Leetcode)
🔗 https://leetcode.com/problems/combination-sum-iii/  
🟠 Difficulty: Medium  
🧠 Topics: Backtracking  
🏢 Companies: Amazon, Facebook, Microsoft  
 
---

### 📘 Problem Statement:

Find all valid combinations of `k` numbers that sum up to `n` such that the following conditions are true:

- Only numbers `1` through `9` are used.
- Each number is used **at most once**.

Return a list of all possible valid combinations.  
The list must not contain the same combination twice, and the combinations may be returned in any order.

---

### 🧪 Test Cases:

**Test Case 1:**  
`k = 3, n = 7`  
✅ Output: `[[1,2,4]]`

**Test Case 2:**  
`k = 3, n = 9`  
✅ Output: `[[1,2,6],[1,3,5],[2,3,4]]`

**Test Case 3:**  
`k = 4, n = 1`  
✅ Output: `[]`

**Test Case 4:**  
`k = 6, n = 25`  
✅ Output includes:  
`[1,2,3,4,7,8]`,  
`[1,2,3,5,6,8]`,  
`[1,2,4,5,6,7]`,  
`...` (others valid too)

---

### 📌 Constraints:
- `2 <= k <= 9`
- `1 <= n <= 60`

---

### ✅ Approach:

- Use **recursion + backtracking** to explore all combinations from 1 to 9.
- For each number `i`, we can choose to include it in the current combination only if it does not exceed the remaining sum.
- Once the current list has `k` elements and their sum equals `n`, we store that combination.
- We stop recursion early if:
  - The remaining sum becomes negative
  - Or the number of elements exceeds `k`
- We **never reuse** numbers and **always move forward** in the search space.

---

### ✅ Code:
```java
class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        // Try and explore all possibilities : 
        // Recursive Approach : ✅✅✅

        // To keep a track of sum for each sequence✅
        int sum = n;
        // To store the intermediate sequences✅
        List<Integer> current = new ArrayList<>();
        // To store the final subsequences that equal to sum n with length k✅
        List<List<Integer>> ans = new ArrayList<>();

        backtrack(1, sum, current, ans, k, n);
        return ans;
    }

    public void backtrack(int index, int sum, List<Integer> current, List<List<Integer>> ans, int k, int target) {
        // ✅ Base Case:
        // Whenever you found a sequence that equals target & also sequence length is same a given k. STOP that's one of your possible ans✅
        if (sum == 0 && current.size() == k) {
            ans.add(new ArrayList<>(current));
            return;
        }

        // ✅ Edge Case: what if summation at any point becomes -ve OR element within intermediate list has exceeded the length k
        // Stop the Recursive call then and there!
        if (sum < 0 || current.size() > k)
            return;

        // ✅ if the sequence is empty start picking from index 1
        // otherwise, start picking from last element in sequence + 1
        int element = current.isEmpty() ? index : current.get(current.size() - 1) + 1;

        // ✅ Pick all possible combinations from i = ele -> 9
        // Make sure you ignore ths duplicate combinations..
        for (int i = element; i <= 9; i++) {
            // ✅ Pick up only if that number is less than given sum
            // No point in picking some element that goes beyond the sum  
            if (i <= sum) {
                // If you pick that specific element, then first add it into the sequence
                current.add(i);
                // Then Recursively explore other possibilities by reducing the sum from that specific value
                backtrack(i + 1, sum - i, current, ans, k, target);
                // After backtrack make sure, you remove the last element
                current.remove(current.size() - 1);
            }
        }
    }
}
```
