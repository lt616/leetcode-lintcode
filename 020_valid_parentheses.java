class Solution {
    public boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        
        Map<Character, Character> dict = new HashMap<>();
        dict.put(')', '(');
        dict.put(']', '[');
        dict.put('}', '{');
        
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (dict.containsKey(s.charAt(i))) {
                if (stack.size() == 0 || dict.get(s.charAt(i)) != stack.pop()) {
                    return false;
                }
            } else {
                stack.push(s.charAt(i));
            }
        }
        return (stack.size() == 0);
    }
}