/* 
 Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:

[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]
*/ 

class Solution { 
    List<String> res; 
    public List<String> generateParenthesis(int n) {
        res = new ArrayList<String>(); 
        if (n <= 0) {
            return res; 
        } 
        
        backtracking("", 0, 0, n); 
        
        return res; 
    } 
    
    private void backtracking(String buffer, int open, int close, int limit) {
        if (open + close == limit * 2) {
            res.add(buffer.toString()); 
            return; 
        } 
        
        if (open < limit) {
            backtracking(buffer + "(", open + 1, close, limit); 
        } 
        
        if (close < open) {
            backtracking(buffer + ")", open, close + 1, limit); 
        } 
    }
} 
