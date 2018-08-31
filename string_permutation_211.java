/* 
211. String Permutation

Given two strings, write a method to decide if one is a permutation of the other.
Example

abcd is a permutation of bcad, but abbe is not a permutation of abe
*/ 

public class Solution {
    /**
     * @param A: a string
     * @param B: a string
     * @return: a boolean
     */
    public boolean Permutation(String A, String B) {
        // write your code here 
        
        if (A == null || B == null || A.length() != B.length()) {
            return false; 
        } 
        
        Map<Character, Integer> map = new HashMap(); 
        for (int i = 0;i < A.length();i ++) {
            if (! map.containsKey(A.charAt(i))) {
                map.put(A.charAt(i), 1); 
            } else {
                map.put(A.charAt(i), map.get(A.charAt(i)) + 1); 
            } 
        } 
        int num = map.size(); 
        
        int visited_num = 0; 
        for (int i = 0;i < A.length();i ++) {
            if (! map.containsKey(B.charAt(i))) {
                return false; 
            } else { 
                map.put(B.charAt(i), map.get(B.charAt(i)) - 1); 
                if (map.get(B.charAt(i)) == 0) {
                    visited_num ++; 
                }
            }
        }
        
        return (num == visited_num);  
    }
} 
