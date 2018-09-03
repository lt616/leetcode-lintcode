/* 
209. First Unique Character in a String

Find the first unique character in a given string. You can assume that there is at least one unique character in the string.
Example

For "abaccdeff", return 'b'.
*/ 

/* Solution 01: HashMap */ 
public class Solution {
    /**
     * @param str: str: the given string
     * @return: char: the first unique character in a given string
     */
    public char firstUniqChar(String str) {
        // Write your code here 
        char res = '\0'; 
        
        Map<Character, Integer> visited = new HashMap();  
        for (int i = 0;i < str.length();i ++) { 
            char current = str.charAt(i); 
            if (! visited.containsKey(current)) {
                visited.put(current, 1); 
            } else {
                visited.put(current, visited.get(current) + 1); 
            } 
        } 
        
        for (int i = 0;i < str.length();i ++) { 
            char current = str.charAt(i); 
            
            if (visited.get(current) == 1) {
                return current; 
            }
        } 
        
        return res; 
    }
} 


/* Solution 02: Hash & LinkedList */ 
class Node {
    char c; 
    Node next; 
    
    public Node(char c) {
        this.c = c; 
        this.next = null; 
    }
}


class DataStream {
    
    Map<Character, Node> dict; 
    Set<Character> dupChars; 
    Node first = null, last = null; 
    
    public DataStream() {
        dict = new HashMap(); 
        dupChars = new HashSet(); 
    } 
    
    public void add(char c) {
        if (dupChars.contains(c)) {
            return; 
        } 
        
        if (dict.containsKey(c)) {
            /* Remove node */ 
            if (dict.get(c) == null) {
                if (last == first) {
                    last = null; 
                    first = null; 
                } else { 
                    Node next_node = first.next; 
                    dict.put(next_node.c, null); 
                    first = next_node;    
                }

            } else { 
                Node prev_node = dict.get(c); 
                Node current_node = prev_node.next; 
                
                prev_node.next = current_node.next; 
                if (current_node.next != null) { 
                    dict.put(current_node.next.c, prev_node); 
                } else {
                    last = prev_node; 
                }
            } 
            
            dupChars.add(c); 
            dict.remove(c); 
            
            return; 
        } 
        
        if (first == null) {
            Node new_node = new Node(c); 
            
            first = new_node; 
            last = new_node; 
            dict.put(c, null); 
        } else {
            Node new_node = new Node(c); 
            
            Node prev_node = last; 
            prev_node.next = new_node; 
            dict.put(c, prev_node); 
            last = new_node; 
        } 
    } 
    
    public char getFirstUnique() {
        return first.c; 
    }
}



public class Solution {
    /** 
     * @param str: str: the given string
     * @return: char: the first unique character in a given string
     */ 
    public char firstUniqChar(String str) {
        // Write your code here 
        
        DataStream ds = new DataStream(); 
        for (int i = 0;i < str.length();i ++) {
            ds.add(str.charAt(i)); 
        } 
        
        return ds.getFirstUnique(); 
    }
} 
