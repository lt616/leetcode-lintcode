/* 
415. Valid Palindrome

Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
Example

"A man, a plan, a canal: Panama" is a palindrome.

"race a car" is not a palindrome.
Challenge

O(n) time without extra memory.
Notice

Have you consider that the string might be empty? This is a good question to ask during an interview.

For the purpose of this problem, we define empty string as valid palindrome.
*/ 

/* 
	EASY WRONG POINTS 
	1. alphanumeric == alpha + numeric 
*/ 

public class Solution {
    /**
     * @param s: A string
     * @return: Whether the string is a valid palindrome
     */
    public boolean isPalindrome(String s) {
        // write your code here 

        
        /* Remove non-alpha letters */ 
        String alpha_string = s.replaceAll("[^A-Za-z0-9]", ""); 
        
        /* Convert to lower letters */ 
        String lower_string = alpha_string.toLowerCase(); 
        
        if (lower_string.length() == 0 || lower_string == null) 
            return true; 
        
        /* Check if valid palindrome */ 
        return checkIfValidPalindrome(lower_string); 
    } 
    
    private boolean checkIfValidPalindrome(String s) {
        int left = 0; 
        int right = s.length() - 1; 
        boolean flag = true; 
        
        while (right - left > 1 && s.charAt(left) == s.charAt(right)) {
            right --; 
            left ++; 
        } 
        
        /* palindrome.length() is even */ 
        if (right - left == 1) 
            return (s.charAt(left) == s.charAt(right)); 
        /* palindrome.length() is odd */ 
        else if (left == right) 
            return true; 
        else 
            return false; 
    }
}

