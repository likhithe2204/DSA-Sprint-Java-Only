/*
---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
📌 Problem: 3484. Design Spreadsheet
---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
🚩 Statement:  
A spreadsheet is a grid with 26 columns (labeled from 'A' to 'Z') and a given number of rows. Each cell in the spreadsheet can hold an integer value between 0 and 10⁵.  

Implement the `Spreadsheet` class:  

- `Spreadsheet(int rows)`: Initializes a spreadsheet with 26 columns and `rows` rows, all set to 0.  
- `void setCell(String cell, int value)`: Sets the value of the specified cell.  
- `void resetCell(String cell)`: Resets the specified cell to 0.  
- `int getValue(String formula)`: Evaluates a formula of the form `"=X+Y"`, where `X` and `Y` are either integers or valid cell references. Returns their sum.  

If a cell hasn’t been explicitly set, its value is considered `0`.  

---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
📥 Input/Output:  

Example 1:  
Input:  
["Spreadsheet", "getValue", "setCell", "getValue", "setCell", "getValue", "resetCell", "getValue"]  
[[3], ["=5+7"], ["A1", 10], ["=A1+6"], ["B2", 15], ["=A1+B2"], ["A1"], ["=A1+B2"]]  

Output:  
[null, 12, null, 16, null, 25, null, 15]  

---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
💡 Intuition:  
- Use a `HashMap<String, Integer>` to store only explicitly set cell values.  
- If a cell hasn’t been set, return `0`.  
- Parse the formula `"=X+Y"`, and check whether each token is a **cell reference** (starts with capital letter) or an **integer**.  
- Compute and return the sum.  

---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
🔎 Approach:  
1. Maintain a map for cell → value.  
2. `setCell`: put the value in map.  
3. `resetCell`: put `0` in map.  
4. `getValue`: remove the `"="`, split on `"+"`, evaluate each part (check if integer or cell reference), return sum.  

---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
⏱️ Complexity:  
- `setCell`: O(1)  
- `resetCell`: O(1)  
- `getValue`: O(1) (just two lookups/parses)  
- Space: O(N) for at most all set cells.  

---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
💻 Code (Java):  
---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
*/
  class Spreadsheet {
    HashMap<String, Integer> mpp = new HashMap<>();
    int rows;

    public Spreadsheet(int rows) {
        this.rows = rows; // stored but not strictly needed
    }

    public void setCell(String cell, int value) {
        mpp.put(cell, value);
    }

    public void resetCell(String cell) {
        mpp.put(cell, 0);
    }

    public int getValue(String formula) {
        formula = formula.substring(1); // remove '='
        String[] parts = formula.split("\\+");
        String s1 = parts[0], s2 = parts[1];

        int left = Character.isUpperCase(s1.charAt(0)) 
                     ? mpp.getOrDefault(s1, 0) 
                     : Integer.parseInt(s1);
        int right = Character.isUpperCase(s2.charAt(0)) 
                     ? mpp.getOrDefault(s2, 0) 
                     : Integer.parseInt(s2);

        return left + right;
    }
}

