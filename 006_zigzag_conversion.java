class Solution {
    public String convert(String s, int numRows) {
        if (s == null || numRows == 0) {
            return null;
        }
        
        if (numRows == 1) {
            return s;
        }
        
        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0;i < numRows;i ++) {
            rows.add(new StringBuilder());
        }
        
        boolean ifZ = false;
        int row = 0;
        
        for (int i = 0;i < s.length();i ++) {
            if (ifZ) {
                // COLUMN LAST CHAR
                rows.get(row).append(s.charAt(i));
                row --;
                if (row == 0) {
                    ifZ = false;
                }
            } else {
                // COLUMN FIRST CHAR
                rows.get(row).append(s.charAt(i));
                row ++;
                if (row == numRows - 1) {
                    ifZ = true;
                }
            }    
        }
        
        StringBuilder resString = new StringBuilder();
        for (int i = 0;i < numRows;i ++) {
            resString.append(rows.get(i).toString());
        }
        
        return resString.toString();
    }
}