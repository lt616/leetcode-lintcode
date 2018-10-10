/* 
Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, determine if s can be segmented into a space-separated sequence of one or more dictionary words.

Note:

    The same word in the dictionary may be reused multiple times in the segmentation.
    You may assume the dictionary does not contain duplicate words.

Example 1:

Input: s = "leetcode", wordDict = ["leet", "code"]
Output: true
Explanation: Return true because "leetcode" can be segmented as "leet code".

Example 2:

Input: s = "applepenapple", wordDict = ["apple", "pen"]
Output: true
Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
             Note that you are allowed to reuse a dictionary word.

Example 3:

Input: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
Output: false
*/ 

/* Solution 01: Combination-based DFS, TLE */ 
class Solution { 
    Set<String> dict; 
    public boolean wordBreak(String s, List<String> wordDict) {
        if (s == null || s.length() == 0) {
            return false; 
        } 

        dict = new HashSet<String>(wordDict); 
        
        return combinationDFS(s, 0); 
    } 
    
    private boolean combinationDFS(String s, int index) {
        if (index == s.length()) {
            return true; 
        } 
        
        String temp = s.substring(index, s.length()); 
        for (String word : dict) {
            if (temp.startsWith(word)) { 
                if (combinationDFS(s, index + word.length())) {
                    return true; 
                } 
            }
        }
        
        return false; 
    }
} 


/* Solution 02: BFS + memo */ 
class Solution { 
    Set<String> dict; 
    public boolean wordBreak(String s, List<String> wordDict) {
        if (s == null || s.length() == 0) {
            return false; 
        } 
        
        dict = new HashSet<String>(wordDict); 
        
        boolean[] visited = new boolean[s.length()]; 

        Queue<Integer> queue = new LinkedList<Integer>(); 
        queue.add(0); 
        
        while (! queue.isEmpty()) {
            int start = queue.poll(); 
            if (visited[start]) {
                continue; 
            } 
            
            visited[start] = true; 
            
            String current = s.substring(start, s.length()); 
            for (String word : dict) {
                if (current.startsWith(word)) { 
                    int end = start + word.length(); 
                    if (end == s.length()) {
                        return true; 
                    } 
                    queue.offer(end); 
                }
            }
        } 
        
        return false; 
    } 
} 


/* Solution 03: DP */ 
class Solution { 
 
    public boolean wordBreak(String s, List<String> wordDict) {
        if (s == null || s.length() == 0) {
            return false; 
        } 
        
        Set<String> dict = new HashSet<String>(wordDict); 
        
        boolean[] dp_array = new boolean[s.length() + 1]; 
        dp_array[0] = true; 
        
        for (int i = 1;i <= s.length();i ++) {
            for (int j = 0;j < i;j ++) {
                if (dp_array[j] && dict.contains(s.substring(j, i))) {
                    dp_array[i] = true; 
                    break; 
                } 
            } 
        } 
        
        return dp_array[s.length()]; 
    } 
} 
