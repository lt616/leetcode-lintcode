class Solution {
    int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    String[] romans = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
    
    public String intToRoman(int num) {
        if (num <= 0 || num > 3999) {
            return null;
        }
        
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < values.length; i++) {
            int count = num / values[i];
            for (int j = 0; j < count; j++) {
                builder.append(romans[i]);
            }
            num %= values[i];
        }
        return builder.toString();
    }
}