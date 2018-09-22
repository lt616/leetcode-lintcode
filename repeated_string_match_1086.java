/* 
1086. Repeated String Match

Given two strings A and B, find the minimum number of times A has to be repeated such that B is a substring of it. If no such solution, return -1.
Example

with A = "abcd" and B = "cdabcdab".

Return 3, because by repeating A three times (“abcdabcdabcd”), B is a substring of it; and B is not a substring of A repeated two times ("abcdabcd").
Notice

The length of A and B will be between 1 and 10000.
*/ 

/* 
	EASY WRONG POINTS: 
		1. Use StringBuilder instead of String, in case of MLE. 
*/ 

public class Solution {
    /**
     * @param A: a string
     * @param B: a string
     * @return: return an integer
     */
    public int repeatedStringMatch(String A, String B) {
        // write your code here 
        
        if (A == null || B == null) {
            return -1; 
        } 
        
        StringBuilder str; 
        int count = 0, min_count = Integer.MAX_VALUE; 
        for (int i = 0;i < A.length();i ++) { 
            str = new StringBuilder(); 
            count = 0; 
            while (str.length() - i < B.length()) {
                count ++; 
                str.append(A); 
            } 
            
            if (str.substring(i, i + B.length()).equals(B)) {
                min_count = (count < min_count) ? count : min_count;  
            } 
        } 
        
        return (min_count != Integer.MAX_VALUE) ? min_count : -1;  
    }
} 
