class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        
        Set<Character> set = new HashSet<>();
        int maxLength = 0;
        int j = 0;
        for (int i = 0;i < s.length();i ++) {
            char c = s.charAt(i);
            if (! set.contains(c)) {
                set.add(c);
                maxLength = (set.size() > maxLength) ? set.size() : maxLength;
            } else {
                while (j < i && s.charAt(j) != c) {
                    set.remove(s.charAt(j));
                    j ++;
                }
                j ++;
            }
        }
        
        return maxLength;
    }
}