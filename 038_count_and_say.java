class Solution {
    public String countAndSay(int n) {
        if (n <= 0) {
            return "";
        }
        
        String str = "1";
        for (int i = 2; i <= n; i++) {
            str = readString(str);            
        }
        return str;
    }
    
    private String readString(String s) {
        char c = s.charAt(0);
        int count = 1;
        StringBuilder builder = new StringBuilder();
        for (int i = 1; i < s.length(); i++) {
            if (c == s.charAt(i)) {
                count ++;
            } else {
                builder.append(String.valueOf(count));
                builder.append(c);
                c = s.charAt(i);
                count = 1;
            }
        }
        builder.append(String.valueOf(count));
        builder.append(c);
        return builder.toString();
    }
}