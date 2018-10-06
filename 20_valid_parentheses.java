/* 
Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

    Open brackets must be closed by the same type of brackets.
    Open brackets must be closed in the correct order.

Note that an empty string is also considered valid.

Example 1:

Input: "()"
Output: true

Example 2:

Input: "()[]{}"
Output: true

Example 3:

Input: "(]"
Output: false

Example 4:

Input: "([)]"
Output: false

Example 5:

Input: "{[]}"
Output: true

*/ 

class Solution {
    public boolean isValid(String s) {
        if (s == null) {
            return true; 
        } 
        
        Stack<Character> stack = new Stack<Character>(); 
        Map<Character, Character> map = new HashMap<Character, Character>(); 
        map.put(')', '('); 
        map.put('}', '{'); 
        map.put(']', '['); 
        
        for (int i = 0;i < s.length();i ++) { 
            char c = s.charAt(i); 
            if (! map.containsKey(c)) {
                stack.push(c); 
            } else {
                if (stack.isEmpty() || stack.pop() != map.get(c)) {
                    return false; 
                } 
            } 
        } 
        
        return stack.isEmpty(); 
    }
} 
