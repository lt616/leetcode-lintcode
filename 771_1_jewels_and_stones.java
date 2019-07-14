class Solution {
    public int numJewelsInStones(String J, String S) {
        if (J == null || S == null || J.length() == 0 || S.length() == 0) {
            return 0;
        }
        
        int jewelCount = 0;
        Set<Character> jewels = new HashSet<>();
        for (int i = 0; i < J.length(); i++)
            jewels.add(J.charAt(i));
        
        for (int i = 0; i < S.length(); i++) {
            if (jewels.contains(S.charAt(i)))
                jewelCount ++;
        }
        
        return jewelCount;
    }
}