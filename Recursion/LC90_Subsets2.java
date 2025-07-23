### ✅ 90. Subsets II (Leetcode)
🔗 https://leetcode.com/problems/subsets-ii/  
🟠 Difficulty: Medium  
🧠 Topics: Backtracking, Sorting  
🏢 Companies: Google, Facebook, Amazon  

---

### 🧪 Test Cases

**Input:**  
`[1, 2, 2]`  
**Output:**  
`[[], [1], [1,2], [1,2,2], [2], [2,2]]`

**Input:**  
`[0]`  
**Output:**  
`[[], [0]]`

---

### ✅ Code:
```java
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        // Recursive Approach : ✅✅✅

        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        
        // ✅ Thumb Rule: Always sort before handling duplicates
        Arrays.sort(nums);

        Backtrack(0, current, ans, nums, n);
        
        // ✅ Add empty set explicitly at start
        ans.add(new ArrayList<>());
        return ans;
    }

    public void Backtrack(int index, List<Integer> current, List<List<Integer>> ans, int[] nums, int n) {
        if (index == n) return;

        for (int i = index; i < n; i++) {
            // ✅ Skip duplicate elements at the same recursive level
            if (i > index && nums[i] == nums[i - 1]) continue;

            current.add(nums[i]);
            ans.add(new ArrayList<>(current));
            Backtrack(i + 1, current, ans, nums, n);
            current.remove(current.size() - 1);
        }
    }
}
```
