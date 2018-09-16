/* 
119. Edit Distance

Given two words word1 and word2, find the minimum number of steps required to convert word1 to word2. (each operation is counted as 1 step.)

You have the following 3 operations permitted on a word:

    Insert a character
    Delete a character
    Replace a character

Example

Given word1 = "mart" and word2 = "karma", return 3.
*/ 

public class Solution {
    /**
     * @param word1: A string
     * @param word2: A string
     * @return: The minimum number of steps.
     */
    public int minDistance(String word1, String word2) {
        // write your code here 
        
        if (word1 == null && word2 == null) {
            return 0; 
        } 
        
        if (word1.length() == 0) {
            return word2.length(); 
        } 
        
        if (word2.length() == 0) {
            return word1.length(); 
        } 
        
        int[][] path_len = new int[word1.length() + 1][word2.length() + 1]; 
        path_len[0][0] = 0; 
        for (int i = 1;i <= word1.length();i ++) {
            path_len[i][0] = i; 
        } 
        
        for (int i = 1;i <= word2.length();i ++) {
            path_len[0][i] = i; 
        } 
        
        for (int i = 1;i <= word1.length();i ++) {
            for (int j = 1;j <= word2.length();j ++) {
                int temp = (word1.charAt(i - 1) != word2.charAt(j - 1)) ? 1 : 0; 
                path_len[i][j] = min(path_len[i][j - 1] + 1, path_len[i - 1][j] + 1, path_len[i - 1][j - 1] + temp); 
            } 
        }
        
        return path_len[word1.length()][word2.length()]; 
    } 
    
    private int min(int a, int b, int c) {
        int res = (a < b) ? a : b; 
        return (res < c) ? res : c; 
    }
} 
