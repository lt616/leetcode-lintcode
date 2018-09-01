/* 
10. String Permutation II

Given a string, find all permutations of it without duplicates.
Example

Given "abb", return ["abb", "bab", "bba"].

Given "aabb", return ["aabb", "abab", "baba", "bbaa", "abba", "baab"].
*/ 

public class Solution {
    /**
     * @param str: A string
     * @return: all permutations
     */ 
    
    List<String> res_string = new ArrayList(); 
    
    public List<String> stringPermutation2(String str) {
        // write your code here 
        
        if (str == null || str.length() == 0) { 
            res_string.add(new String()); 
            return res_string; 
        } 
        
        char[] str_content = str.toCharArray(); 
        Arrays.sort(str_content); 
        
        StringBuilder buffer = new StringBuilder(); 
        boolean[] is_visited = new boolean[str.length()]; 
        for (int i = 0;i < str.length();i ++) {
            is_visited[i] = false; 
        }
        
        permuteDFS(str_content, buffer, is_visited);  
        
        return res_string; 
    } 
    
    private void permuteDFS(char[] str_content, StringBuilder buffer, boolean[] is_visited) {
        if (buffer.length() == str_content.length) {
            res_string.add(buffer.toString()); 
        } 
        
        for (int i = 0;i < str_content.length;i ++) {
            if (is_visited[i]) {
                continue; 
            } 
            
            if (i > 0 && str_content[i - 1] == str_content[i] && ! is_visited[i - 1]) {
                continue; 
            }
            
            is_visited[i] = true; 
            buffer.append(str_content[i]); 
            
            permuteDFS(str_content, buffer, is_visited); 
            
            is_visited[i] = false; 
            buffer.deleteCharAt(buffer.length() - 1); 
        }
    }
} 
