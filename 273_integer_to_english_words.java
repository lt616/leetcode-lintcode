/* 
Convert a non-negative integer to its english words representation. Given input is guaranteed to be less than 231 - 1.

Example 1:

Input: 123
Output: "One Hundred Twenty Three"

Example 2:

Input: 12345
Output: "Twelve Thousand Three Hundred Forty Five"

Example 3:

Input: 1234567
Output: "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"

Example 4:

Input: 1234567891
Output: "One Billion Two Hundred Thirty Four Million Five Hundred Sixty Seven Thousand Eight Hundred Ninety One"
*/ 

class Solution { 
    String[] one_digit = {"One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten"}; 
    String[] two_digits_ten = {"Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};  
    String[] two_digits_higher = {"Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"}; 

        public String numberToWords(int num) {
        if (num == 0) {
            return "Zero"; 
        } 
        
        String[] high_names = {"Billion", "Million", "Thousand", ""}; 
        List<String> result = new ArrayList<String>(); 
        for (int i = 0;i < 4;i ++) { 
            int three_digits = num / (int) Math.pow(1000, 3 - i); 
            List<String> billion_digits = parse_three_digits(three_digits); 
            List<String> res = new ArrayList<String>(); 
            if (billion_digits.size() != 0) {
                for (String digit : billion_digits) {
                    result.add(digit); 
                } 
                if (high_names[i] != "") { 
                    result.add(high_names[i]); 
                } 
            } 
            int temp = num / (int) Math.pow(1000, 3 - i); 
            num -= (int) temp * Math.pow(1000, 3 - i); 
        } 
        
        System.out.println(result); 
        StringBuilder sb = new StringBuilder(); 
        for (String word : result) { 
            if (sb.length() != 0) {
                sb.append(" "); 
            }
            sb.append(word); 
        }
        
        return sb.toString();  
    } 
    
    private List<String> parse_three_digits(int num) { 
        List<String> res = new ArrayList<String>(); 
        int hundred = num / 100; 
        if (hundred != 0) {
            res.add(one_digit[hundred - 1]); 
            res.add("Hundred"); 
        } 
        
        num -= (num / 100) * 100; 
        if (num == 0) {
            return res; 
        } 
        
        if (num <= 10) {
            res.add(one_digit[num - 1]); 
        } else if (num < 20) {
            res.add(two_digits_ten[num - 11]); 
        } else {
            int ty = num / 10; 
            if (ty != 0) {
                res.add(two_digits_higher[ty - 2]); 
            } 
            
            num -= (num / 10) * 10; 
            if (num != 0) {
                res.add(one_digit[num - 1]); 
            } 
        } 
        
        return res; 
    }
} 
