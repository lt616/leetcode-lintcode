/* 
136. Palindrome Partitioning

Given a string s, partition s such that every substring of the partition is a palindrome.

Return all possible palindrome partitioning of s.
Example

Given s = "aab", return:

[
  ["aa","b"],
  ["a","a","b"]
]
*/ 

/* 
	EASY WRONG POINTS: 
		1. Add memorization to speed up validating palindrome. 
*/ 

public class Solution {
    /*
     * @param s: A string
     * @return: A list of lists of string
     */ 
    
    List<List<Integer>> res = new ArrayList(); 
    List<List<String>> res_string = new ArrayList(); 
    
    public List<List<String>> partition(String s) {
        // write your code here 
        
        if (s == null || s.length() == 0) {
            return res_string;  
        }
        
        List<Integer> buffer = new ArrayList(); 
        combinationDFS(s, 1, buffer); 
        
        int start_index;  
        for (List<Integer> combination : res) { 
            start_index = 0; 
            List<String> split_string = new ArrayList(); 
            for (Integer end_index : combination) { 
                System.out.println(start_index + ", " + end_index); 
                split_string.add(s.substring(start_index, end_index)); 
                start_index = end_index; 
            } 
            res_string.add(split_string); 
        }
        
        return res_string;  
    } 
    
    private void combinationDFS(String s, int index, List<Integer> buffer) { 
        if (buffer.size() != 0 && buffer.get(buffer.size() - 1) == s.length()) {
            res.add(new ArrayList(buffer)); 
        } 
        
        for (int i = index;i <= s.length();i ++) {
            int start_index = (buffer.size() != 0) ? buffer.get(buffer.size() - 1) : 0; 
            if (! isValidPalindrome(s.substring(start_index, i))) {
                continue; 
            } 
            
            buffer.add(i); 
            combinationDFS(s, i + 1, buffer); 
            buffer.remove(buffer.size() - 1); 
        } 
    }
    
    private boolean isValidPalindrome(String s) {
        int start = 0, end = s.length() - 1; 
        while (start < end) {
            if (s.charAt(start ++) != s.charAt(end --)) {
                return false; 
            } 
        } 
        
        return true; 
    }
} 

/* Optimisation: add-on memorization */ 
public class Solution {
    /*
     * @param s: A string
     * @return: A list of lists of string
     */ 
    
    List<List<Integer>> res = new ArrayList(); 
    List<List<String>> res_string = new ArrayList(); 
    
    boolean[][] memorization; 
    boolean[][] is_visited; 
    
    public List<List<String>> partition(String s) {
        // write your code here 
        
        if (s == null || s.length() == 0) {
            return res_string;  
        }
        
        memorization = new boolean[s.length()][s.length()]; 
        is_visited = new boolean[s.length()][s.length()]; 
        
        List<Integer> buffer = new ArrayList(); 
        combinationDFS(s, 1, buffer); 
        
        for (int i = 0;i < s.length();i ++) {
            for (int j = 0;j < s.length();j ++) {
                is_visited[i][j] = false; 
            }
        }
        
        int start_index;  
        for (List<Integer> combination : res) { 
            start_index = 0; 
            List<String> split_string = new ArrayList(); 
            for (Integer end_index : combination) { 
                split_string.add(s.substring(start_index, end_index)); 
                start_index = end_index; 
            } 
            res_string.add(split_string); 
        }
        
        return res_string;  
    } 
    
    private void combinationDFS(String s, int index, List<Integer> buffer) { 
        if (buffer.size() != 0 && buffer.get(buffer.size() - 1) == s.length()) {
            res.add(new ArrayList(buffer)); 
        } 
        
        for (int i = index;i <= s.length();i ++) {
            int start_index = (buffer.size() != 0) ? buffer.get(buffer.size() - 1) : 0; 
            if (! isValidPalindrome(s, start_index, i - 1)) {
                continue; 
            } 
            
            buffer.add(i); 
            combinationDFS(s, i + 1, buffer); 
            buffer.remove(buffer.size() - 1); 
        } 
    }
    
    private boolean isValidPalindrome(String s, int start_index, int end_index) { 
        if (is_visited[start_index][end_index]) { 
            return memorization[start_index][end_index]; 
        } 

        boolean temp; 
        is_visited[start_index][end_index] = true; 
        if (start_index == end_index) { 
            temp = true; 
        } else if (start_index + 1 == end_index) { 
            temp = (s.charAt(start_index) == s.charAt(end_index)); 
        } else { 
            temp = ((s.charAt(start_index) == s.charAt(end_index)) && isValidPalindrome(s, start_index + 1, end_index - 1)); 
        } 
        memorization[start_index][end_index] = temp; 
        return temp;  
    }
}  
