/* 
120. Word Ladder

Given two words (start and end), and a dictionary, find the length of shortest transformation sequence from start to end, such that:

    Only one letter can be changed at a time
    Each intermediate word must exist in the dictionary

Example

Given:
start = "hit"
end = "cog"
dict = ["hot","dot","dog","lot","log"]

As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
return its length 5.
Notice

    Return 0 if there is no such transformation sequence.
    All words have the same length.
    All words contain only lowercase alphabetic characters.
*/ 

/* 
	EASY WRONG POINTS: 
		1. Can be optimised! replacing a letter in current word to get the next one, 
		in stead of comparing every two words. 
*/ 

public class Solution {
    /*
     * @param start: a string
     * @param end: a string
     * @param dict: a set of string
     * @return: An integer
     */
    public int ladderLength(String start, String end, Set<String> dict) {
        // write your code here 
        
        if (dict == null) {
            return 0; 
        } 
        
        if (start.equals(end)) {
            return 1; 
        }
        
        Map<String, List<String>> graph = new HashMap(); 
        Queue<String> queue = new LinkedList(); 
        Set<String> set = new HashSet(); 
        
        dict.add(start); 
        dict.add(end); 
        
        while (! dict.isEmpty()) { 
            String current = getFirstElement(dict); 
            dict.remove(current); 
            
            for (String next : dict) {
                if (string_diff(current, next) == 1) {
                    if (! graph.containsKey(current)) {
                        graph.put(current, new ArrayList()); 
                    } 
                    graph.get(current).add(next); 
                    
                    if (! graph.containsKey(next)) {
                        graph.put(next, new ArrayList()); 
                    } 
                    graph.get(next).add(current); 
                } 
            } 
        } 
        
        queue.add(start); 
        set.add(start); 
        int num_step = 0; 
        while (! queue.isEmpty()) { 
            int level_size = queue.size(); 
            num_step ++; 
            
            for (int i = 0;i < level_size;i ++) {
                String current = queue.poll(); 
                if (current.equals(end)) { 
                    return num_step; 
                } 
                
                if (! graph.containsKey(current)) {
                    continue; 
                } 
                
                for (String next : graph.get(current)) {
                    if (set.contains(next)) { 
                        continue; 
                    } 
                    queue.offer(next); 
                    set.add(next); 
                } 
            } 
        } 
        
        return 0; 
    } 
    
    private String getFirstElement(Set<String> set) {
        return set.iterator().next();
    }
    
    private int string_diff(String current, String next) { 
        int diff = 0; 
        for (int i = 0;i < current.length();i ++) {
            if (current.charAt(i) != next.charAt(i)) {
                diff ++; 
            } 
        } 
        return diff; 
    }
} 
