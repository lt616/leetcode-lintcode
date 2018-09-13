/* 
958. Palindrome Data Stream

There is a data stream, one letter at a time, and determine whether the current stream's arrangement can form a palindrome.
Example

Given s = ['a','a','a','a','a'], return [1,1,1,1,1].

Explanation:
“a” can form a palindrome
“aa” can form a palindrome
“aaa” can form a palindrome
“aaaa” can form a palindrome
“aaaaa” can form a palindrome

Given s = ['a','b','a']，return [1,0,1].

Explanation:
“a” can form a palindrome
“ab” can't form a palindrome
“aba” can form a palindrome

Notice

    1 <= |s| <= 10^5
*/ 

public class Solution {
    /**
     * @param s: The data stream
     * @return: Return the judgement stream
     */ 
    public int[] getStream(String s) {
        // Write your code here 
        
        int[] res = new int[s.length()]; 
        
        Set<Character> unique_chars = new HashSet(); 
        
        for (int i = 0;i < s.length();i ++) { 
            char c = s.charAt(i); 
            if (unique_chars.contains(c)) {
                unique_chars.remove(c); 
            } else {
                unique_chars.add(c); 
            } 
            
            res[i] = (unique_chars.size() == 0 || unique_chars.size() == 1) ? 1 : 0; 
        } 
        
        return res;  
    }
} 
