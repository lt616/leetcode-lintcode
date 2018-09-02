/* 
121. Word Ladder II

Description

Given two words (start and end), and a dictionary, find all shortest transformation sequence(s) from start to end, such that:

    Only one letter can be changed at a time
    Each intermediate word must exist in the dictionary

    All words have the same length.
    All words contain only lowercase alphabetic characters.

Have you met this question in a real interview?  
Example

Given:
start = "hit"
end = "cog"
dict = ["hot","dot","dog","lot","log"]

Return

  [
    ["hit","hot","dot","dog","cog"],
    ["hit","hot","lot","log","cog"]
  ]

    DifficultyHard
    Total Accepted14811
    Total Submitted68719
    Accepted Rate21%

 Show Tags
 Company
Leaderboard - Java
steve.kang.n
445ms
GuMingDiaoYu
503ms
qilinx
503ms
wangdeve
520ms
zhili28
557ms
Discuss
supremepromise · Last reply by · supremepromise · 3 days ago
Related Problems
Medium
790. Parser
27%
Medium
120. Word Ladder
23%
121. Word Ladder II

Given two words (start and end), and a dictionary, find all shortest transformation sequence(s) from start to end, such that:

    Only one letter can be changed at a time
    Each intermediate word must exist in the dictionary

Example

Given:
start = "hit"
end = "cog"
dict = ["hot","dot","dog","lot","log"]

Return

  [
    ["hit","hot","dot","dog","cog"],
    ["hit","hot","lot","log","cog"]
  ]

Notice

    All words have the same length.
    All words contain only lowercase alphabetic characters.

"a"
"c"
["a","b","c"]
*/ 

/* 
	EASY WRONG POINTS: 
		1. BFS search minimum depth, DFS search all solutions. 
		2. BFS search in order, DFS search in reverse order to prue branches. 
		3. DFS search in descending depth order to get closer to the start point. 
*/ 


public class Solution {
    /*
     * @param start: a string
     * @param end: a string
     * @param dict: a set of string
     * @return: a list of lists of string
     */ 
    
    List<List<String>> res = new ArrayList(); 
    Map<String, Set<String>> map = new HashMap(); 
    Map<String, Integer> degrees = new HashMap(); 
    
    public List<List<String>> findLadders(String start, String end, Set<String> dict) {
        // write your code here 
        
        if (start.equals(end)) {
            return res; 
        } 
        
        dict.add(start); 
        dict.add(end); 
        
        int depth = searchMinDepthBFS(dict, start, end); 

        List<String> buffer = new ArrayList(); 
        buffer.add(end); 
        
        limitDepthDFS(dict, end, start, buffer, depth); 
        
        return res; 
    } 
    
    private int searchMinDepthBFS(Set<String> dict, String start, String end) { 
        Queue<String> queue = new LinkedList(); 
        queue.offer(start); 


        int depth = -1; 
        degrees.put(start, depth + 1); 
        int min_depth = -1;
        while (! queue.isEmpty()) { 
            int level_size = queue.size(); 
            depth ++; 
            
            for (int m = 0;m < level_size;m ++) { 
                String current = queue.poll(); 
                
                for (int i = 0;i < current.length();i ++) { 
                    char origin = current.charAt(i); 
                    for (char j = 'a';j <= 'z';j ++) {
                        if (j == origin) {
                            continue; 
                        } 
                        String next = setCharAt(current, i, j); 

                        if (dict.contains(next)){ 
                            if (! map.containsKey(next)) {
                                map.put(next, new HashSet());
                            } 
                            map.get(next).add(current); 
                            
                            if (degrees.containsKey(next)) {
                                continue; 
                            } 
                            queue.offer(next); 
                            degrees.put(next, depth + 1); 
                        } 
                    } 
                } 
                
                if (current.equals(end) && min_depth == -1) {
                    min_depth = depth; 
                }
            } 
            
            if (min_depth != -1) {
                return min_depth; 
            }
        } 
        
        return min_depth; 
    }
    
    private void limitDepthDFS(Set<String> dict, String start, String end, List<String> buffer, int limit) { 
        if (limit == 0) { 

            if (start.equals(end)) { 
                List<String> res_reverse = new ArrayList(buffer); 
                Collections.reverse(res_reverse); 
                res.add(res_reverse); 
            } 
            
            return; 
        } 
        
        if (! map.containsKey(start)) {
            return;     
        } 
        
        for (String next : map.get(start)) { 
            if (degrees.get(next) >= limit) {
                continue; 
            } 
            
            buffer.add(next); 
            limitDepthDFS(dict, next, end, buffer, limit - 1); 
            buffer.remove(buffer.size() - 1);                 
        } 
    }
    
    private String setCharAt(String str, int index, char c) {
        return (str.substring(0, index) + c + str.substring(index + 1, str.length())); 
    }
} 
