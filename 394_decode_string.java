class Solution {
    private int index;
    public String decodeString(String s) {
        if (s == null || s.length() == 0) 
            return "";
        
        this.index = 0;
        return extractSubstring(s);
    }
    
    private int extractNum(String s) {
        StringBuilder numBuilder = new StringBuilder();
        while (s.charAt(this.index) != '[') {
            numBuilder.append(s.charAt(this.index));
            this.index ++;
        }
        return Integer.valueOf(numBuilder.toString());
    }
    
    private String extractSubstring(String s) {
        if (this.index >= s.length())
            return "";
        
        StringBuilder builder = new StringBuilder();
        while (this.index < s.length() && s.charAt(this.index) != ']') {
            char c = s.charAt(this.index);
            if (c >= '0' && c <= '9') {
                int num = extractNum(s);
                this.index ++;
                String str = extractSubstring(s);
                builder.append(concateDecodedString(num, str));
            } else {
                builder.append(c);
            }
            this.index ++;
        }
        return builder.toString();
    }
    
    private String concateDecodedString(int num, String substring) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < num; i++)
            builder.append(substring);
        return builder.toString();
    }
}
