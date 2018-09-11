/* 
823. Input Stream

Give two input stream inputA and inputB, which have Backspace. If the final result of the two input streams is equal, output YES, otherwise output NO.
Example

Given inputA = “abcde<<”, inputB = “abcd<e<”, return "YES".

Explanation:
The final result of inputA and inputB is abc, so return "YES".

Given inputA = “a<<bc”, inputB = “abc<”, return "NO"

Explanation:
The final result of inputA is "bc", and the final result of inputB is "ab", so return "NO".

Notice

    Input characters include only lowercase letters and '<'
    The length of input stream does not exceed 10000.
*/ 

public class Solution {
    /**
     * @param inputA: Input stream A
     * @param inputB: Input stream B
     * @return: The answer
     */
    public String inputStream(String inputA, String inputB) {
        // Write your code here 
        
        if (inputA.length() == 0 && inputB.length() == 0) {
            return "YES"; 
        }
        
        if (inputA == null || inputB == null) {
            return "NO"; 
        } 
        
        Stack<Character> stack_a = new Stack(); 
        Stack<Character> stack_b = new Stack(); 
        
        processDataStream(inputA, stack_a); 
        processDataStream(inputB, stack_b); 
        
        while (! stack_a.isEmpty() && ! stack_b.isEmpty()) {
            if (stack_a.pop() != stack_b.pop()) {
                return "NO"; 
            } 
        } 
        
        System.out.println(stack_a.size() + ", " + stack_b.size()); 
        
        if (stack_a.size() == 0 && stack_b.size() == 0) {
            return "YES"; 
        } else {
            return "NO"; 
        }
    } 
    
    private void processDataStream(String ds, Stack<Character> stack) {
        for (int i = 0;i < ds.length();i ++) {
            if (ds.charAt(i) == '<' && ! stack.isEmpty()) {
                stack.pop(); 
            } else if (ds.charAt(i) != '<') {
                stack.push(ds.charAt(i)); 
            } 
        } 
    }
} 
