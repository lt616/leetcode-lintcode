/* 
680. Split String

Give a string, you can choose to split the string after one character or two adjacent characters, and make the string to be composed of only one character or two characters. Output all possible results.
Example

Given the string "123"
return [["1","2","3"],["12","3"],["1","23"]]
*/ 

public class Solution {
    /*
     * @param : a string to be split
     * @return: all possible split string array
     */ 
    
    List<List<String>> res = new ArrayList(); 
    
    public List<List<String>> splitString(String s) {
        // write your code here 
        
        List<String> buffer = new ArrayList(); 
        
        splitDFS(s, 0, buffer); 
        
        return res; 
    } 
    
    private void splitDFS(String s, int index, List<String> buffer) {
        if (index == s.length()) {
            res.add(new ArrayList(buffer)); 
        } 
        
        if (index + 1 <= s.length()) {
            buffer.add(s.substring(index, index + 1)); 
            splitDFS(s, index + 1, buffer); 
            buffer.remove(buffer.size() - 1); 
        } 
        
        if (index + 2 <= s.length()) {
            buffer.add(s.substring(index, index + 2)); 
            splitDFS(s, index + 2, buffer); 
            buffer.remove(buffer.size() - 1); 
        }
    }
} 
