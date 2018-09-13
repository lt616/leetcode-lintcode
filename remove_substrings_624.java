/* 
624. Remove Substrings

Given a string s and a set of n substrings. You are supposed to remove every instance of those n substrings from s so that s is of the minimum length and output this minimum length.
Example

Given s = ccdaabcdbb, substrs = ["ab", "cd"]
Return 2

Explanation:
ccdaabcdbb -> ccdacdbb -> cabb -> cb (length = 2)
*/ 

/* 
	EASY WRONG POINTS: 
		1. Loop through every possible combination of removing string to find the minimum length. 
		2. Solve memory limited exceed: constructing new strings by deleting from the original 
		string, to avoid rubbish Strings produced by String.substring(). 
*/ 


/* Solution 01: DFS, memory limited exceed */ 
public class Solution {
    /*
     * @param s: a string
     * @param dict: a set of n substrings
     * @return: the minimum length
     */ 
    
    int min_len = Integer.MAX_VALUE; 
    Set<String> visited; 
    
    public int minLength(String s, Set<String> dict) {
        // write your code here 
        
        if (s == null || s.length() == 0) {
            return 0; 
        } 
        
        if (dict == null || dict.size() == 0) {
            return s.length(); 
        } 
        
        visited = new HashSet(); 
        
        removeStrDFS(s, dict); 
        
        return min_len; 
    } 
    
    private void removeStrDFS(String s, Set<String> dict) {
        if (visited.contains(s)) {
            return; 
        } 
        
        visited.add(s); 
        int start = 0; 
        
        for (String pattern : dict) { 
            start = s.indexOf(pattern); 
            
            while (start != -1) { 
                StringBuilder sb = new StringBuilder(s); 
                String new_s = sb.delete(start, start + pattern.length()).toString(); 
                if (new_s.length() < min_len) {
                    min_len = new_s.length(); 
                }
                
                removeStrDFS(new_s, dict); 
                
                start = s.indexOf(pattern, start + 1); 
            }  
        } 
    }
} 


/* Solution 02: BFS */ 
public class Solution {
    /*
     * @param s: a string
     * @param dict: a set of n substrings
     * @return: the minimum length
     */ 
    
    int min_len = Integer.MAX_VALUE; 
    Set<String> visited; 
    
    public int minLength(String s, Set<String> dict) {
        // write your code here 
        
        if (s == null || s.length() == 0) {
            return 0; 
        } 
        
        if (dict == null || dict.size() == 0) {
            return s.length(); 
        } 
        
        visited = new HashSet(); 
        
        removeStrBFS(s, dict); 
        
        return min_len; 
    } 
    
    private void removeStrBFS(String s, Set<String> dict) {
        Queue<String> unprocessed = new LinkedList(); 
        unprocessed.offer(s); 
        visited.add(s); 
        
        String str;
        while (! unprocessed.isEmpty()) {
            str = unprocessed.poll(); 
            
            for (String pattern : dict) {
                int start = str.indexOf(pattern); 
                while (start != -1) { 
                    StringBuilder sb = new StringBuilder(str); 
                    String new_str = sb.delete(start, start + pattern.length()).toString();  
                    if (new_str.length() < min_len) {
                        min_len = new_str.length(); 
                    } 
                    
                    if (! visited.contains(new_str)) {
                        unprocessed.offer(new_str); 
                        visited.add(new_str); 
                    }
                    
                    start = str.indexOf(pattern, start + 1); 
                }
            }
        }
    }
}  
