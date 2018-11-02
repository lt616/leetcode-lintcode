/* 
Given a string containing only digits, restore it by returning all possible valid IP address combinations.

Example:

Input: "25525511135"
Output: ["255.255.11.135", "255.255.111.35"]
*/ 

class Solution { 
    List<String> res; 
    public List<String> restoreIpAddresses(String s) { 
        res = new ArrayList<String>(); 
        if (s == null || s.length() == 0) {
            return res; 
        } 
        
        restoreIpDFS(s, 0, 3, ""); 
        
        return res; 
    } 
    
    private void restoreIpDFS(String s, int index, int n, String buffer) {
        if (n == 0) {
            if (isValid(s.substring(index, s.length()))) {
                res.add(buffer + "." + s.substring(index, s.length())); 
            } 
            return; 
        } 
        
        for (int i = 1;i <= 3;i ++) { 
            if (index + i > s.length()) {
                break; 
            } 
            
            String sub_str = s.substring(index, index + i); 
            if (isValid(sub_str)) { 
                String delimit = (n == 3) ? "" : "."; 
                restoreIpDFS(s, index + i, n - 1, buffer + delimit + sub_str); 
            } 
        } 
    } 
    
    private boolean isValid(String s) {
        if (s.length() == 0 || s.length() > 3 ||(s.length() != 1 && s.charAt(0) == '0')) {
            return false; 
        } 
        
        try {
            int count = Integer.parseInt(s); 
            return (count >= 0 && count < 256); 
        } catch (Exception e) {
            return false; 
        }
    }
} 
