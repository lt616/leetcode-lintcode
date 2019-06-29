/* Solution 01: looping midpoint */

class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        
        String maxSubString = "";
        for (int i = 0; i < s.length(); i++) {
            String str= findLongestPalindrome(s, i, i + 1);
            if (str != null && str.length() > maxSubString.length()) {
                maxSubString = str;
            }
            
            str = findLongestPalindrome(s, i - 1, i + 1);
            if (str != null && str.length() > maxSubString.length()) {
                maxSubString = str;
            }
        }
        
        return maxSubString;
    }
    
    private String findLongestPalindrome(String s, int start, int end) {
        /* even length */
        while (start >= 0 && end < s.length()) {
            if (s.charAt(start) != s.charAt(end)) {
                break;
            }
            start --;
            end ++;
        }
        start ++;
        end --;
        return s.substring(start, end + 1);
    }
}


/* Solution 02: Dynamic DP */
class Solution {
    boolean[][] visited;
    boolean[][] memo;
    
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        
        visited = new boolean[s.length()][s.length()];
        memo = new boolean[s.length()][s.length()];
        
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < s.length();j ++) {
                visited[i][j] = false;
                memo[i][j] = false;
            }
        }
        
        String maxSubString = s.substring(0, 1);
        for (int i = 0; i < s.length(); i++) {
            for (int j = i - 1; j >= 0; j --) {
                if (isPalindrome(s, j, i) && (i - j + 1) > maxSubString.length()) {
                    maxSubString = s.substring(j, i + 1);
                }
            }
        }
        return maxSubString;
    }
    
    private boolean isPalindrome(String s, int start, int end) {
        if (start < 0 || start >= s.length() || end < 0 || end >= s.length() || start > end) {
            return true;
        }

        if (visited[start][end]) {
            return memo[start][end];
        }
        
        visited[start][end] = true;
        if (start == end) {
            memo[start][end] = true;
            return true;
        }
        
        if (s.charAt(start) == s.charAt(end)) {
            memo[start][end] = isPalindrome(s, start + 1, end - 1);
            return memo[start][end];
        }
        
        memo[start][end] = false;
        return memo[start][end];
    }
}