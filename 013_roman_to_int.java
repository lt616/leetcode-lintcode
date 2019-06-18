class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> dict = initialRomanDict();
        int sum = 0;
        int prev = 0;
        
        for (int i = 0;i < s.length();i ++) {
            char c = s.charAt(i);
            if (dict.containsKey(c)) {
                int value = dict.get(c);
                if (prev >= value) {
                    sum += prev;
                } else {
                    sum -= prev;
                }
                prev = value;
            } else {
                return 0;
            }
        }
        
        sum += prev;
        return sum;
    }
    
    private Map<Character, Integer> initialRomanDict() {
        Map<Character, Integer> dict = new HashMap<>();
        dict.put('I', 1);
        dict.put('V', 5);
        dict.put('X', 10);
        dict.put('L', 50);
        dict.put('C', 100);
        dict.put('D', 500);
        dict.put('M', 1000);
        
        return dict;
    }
}
