/* 
49. Sort Letters by Case

Given a string which contains only letters. Sort it by lower case first and upper case second.
Example

For "abAcD", a reasonable answer is "acbAD"
Challenge

Do it in one-pass and in-place.
Notice

It's NOT necessary to keep the original order of lower-case letters and upper case letters.
*/ 

public class Solution {
    /*
     * @param chars: The letter array you should sort by Case
     * @return: nothing
     */
    public void sortLetters(char[] chars) {
        // write your code here 
        
        if (chars == null || chars.length == 0) {
            return; 
        }
        
        int start = 0, end = chars.length - 1; 
        while (start <= end) {
            while (start <= end && Character.isLowerCase(chars[start])) {
                start ++; 
            } 
            
            while (start <= end && Character.isUpperCase(chars[end])) {
                end --; 
            } 
            
            if (start <= end) {
                swap(chars, start, end); 
                start ++; 
                end --; 
            } 
        } 
    } 
    
    private void swap(char[] chars, int a, int b) {
        char temp = chars[b]; 
        chars[b] = chars[a]; 
        chars[a] = temp; 
    }
} 
