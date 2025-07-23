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
        // Explore all possible paths : at the same time keep a track of sequence & its sum 
        //      & whenever the summation equals n & its respective sequence size equals k
        //      That is one of your possible ans ✅

        // Recursive Approach : ✅✅✅ 

        int sum = n; // start from the total target given 
        List<Integer> current = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();

        backtrack(1, sum, current, ans, k, n);
        return ans;
    }

    public void backtrack(int index, int sum, List<Integer> current, List<List<Integer>> ans, int k, int n) {
        // Base Case : 
        // Check if condition satisfied?
        if (sum == 0 && current.size() == k) {
            ans.add(new ArrayList<>(current));
            // Otherwise 
            return;
        }
        // What if summation at any point is < 0 (or) list has exceeded k elements
        if (sum < 0 || current.size() > k)
            return; // STOP then & there.

        // Modified Recursive Logic : Pick all possible combinations by ignoring the duplicates 

        // Which is the element you start from?
        // If yes => then you start from 1 
        // Otherwise => start from whatever is the list's last element
        int element = current.isEmpty() ? index : current.get(current.size() - 1) + 1;

        // Explore from (index) itself -> (9) possibilities for each recursive call 
        for (int i = element; i <= 9; i++) {
            // Pick up only if that number is less than given sum
            // No point in picking some element that goes beyond the sum  
            if (i <= sum) {
                current.add(i);
                backtrack(i + 1, sum - i, current, ans, k, n);
                current.remove(current.size() - 1);
            }
        }
    }
}
```
