/* 
1445. Delete Characters

Input two strings s and t，determine if s can get t after deleting some characters.
Example

Given s="abc", t="c" , return True.

Explanation:
s delete 'a' and 'b' to get t.

Given s="a", t="c" , return False.

Explanation:
s cannot get t after deleting some characters.

Notice

    1≤∣s∣,∣t∣≤1051 \leq |s|, |t| \leq 10^51≤∣s∣,∣t∣≤10​5​​
    String contains only lowercase letters
*/ 

public class Solution {
    /**
     * @param s: The string s
     * @param t: The string t
     * @return: Return if can get the string t
     */
    public boolean canGetString(String s, String t) {
        // Write your code here 
        
        int index = 0; 
        for (int i = 0;i < s.length();i ++) {
            if (index < t.length() && s.charAt(i) == t.charAt(index)) {
                index ++; 
            } 
        }
        
        return (index == t.length());  
    }
} 
