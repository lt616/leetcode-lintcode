/* 
425. Letter Combinations of a Phone Number

Given a digit string excluded 01, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below.

Cellphone
Example

Given "23"

Return ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"]
Notice

Although the above answer is in lexicographical order, your answer could be in any order you want.
*/ 

public class Solution {
    /**
     * @param digits: A digital string
     * @return: all posible letter combinations
     */ 
    
    List<String> res; 
    
    public List<String> letterCombinations(String digits) {
        // write your code here 
        
        res = new ArrayList(); 
        
        if (digits == null || digits.length() == 0) {
            return res; 
        } 
        
        String[] map = initMapping(); 
        
        StringBuilder buffer = new StringBuilder(); 
        permutationDFS(digits, 0, map, buffer); 
        
        return res; 
    }  
    
    private void permutationDFS(String digits, int index, String[] map, StringBuilder buffer) {
        if (index == digits.length()) {
            res.add(buffer.toString()); 
            return; 
        } 
        
        String chars = map[digits.charAt(index) - 50]; 
        for (int i = 0;i < chars.length();i ++) {
            buffer.append(chars.charAt(i)); 
            permutationDFS(digits, index + 1, map, buffer); 
            buffer.deleteCharAt(buffer.length() - 1); 
        } 
    } 
    
    private String[] initMapping() {
        String[] map = new String[8]; 
        
        map[0] = "abc"; 
        map[1] = "def"; 
        map[2] = "ghi"; 
        map[3] = "jkl"; 
        map[4] = "mno"; 
        map[5] = "pqrs"; 
        map[6] = "tuv"; 
        map[7] = "wxyz"; 
        
        return map; 
    }
} 
