## 412. FizzBuzz (LeetCode - Easy)
/*
✅ Problem: FizzBuzz (LeetCode - Easy)

📝 Problem Statement:
Given an integer `n`, return a string array `answer` (1-indexed) such that:
- answer[i] == "FizzBuzz" if i is divisible by 3 and 5
- answer[i] == "Fizz" if i is divisible by 3
- answer[i] == "Buzz" if i is divisible by 5
- answer[i] == i (as a string) if none of the above conditions are true

🔸 Example 1:
Input: n = 3
Output: ["1", "2", "Fizz"]

🔸 Example 2:
Input: n = 5
Output: ["1", "2", "Fizz", "4", "Buzz"]

🔸 Example 3:
Input: n = 15
Output: ["1", "2", "Fizz", "4", "Buzz", "Fizz", "7", "8", "Fizz", "Buzz", "11", "Fizz", "13", "14", "FizzBuzz"]

🔹 Constraints:
1 <= n <= 10^4
*/

import java.util.*;

class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> ans = new ArrayList<>();

        // Note : Traverse String from {1 -> n}✅ NOT from {0 -> n-1}❌
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0)
                ans.add("FizzBuzz");
            else if (i % 3 == 0)
                ans.add("Fizz");
            else if (i % 5 == 0)
                ans.add("Buzz");
            else
                ans.add(Integer.toString(i));
        }

        return ans;
    }
}
