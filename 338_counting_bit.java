class Solution {
    public int[] countBits(int num) {
        if (num == 0) {
            int[] res = new int[1];
            res[0] = 0;
            return res;
        }
        
        if (num == 1) {
            int[] res = new int[2];
            res[0] = 0;
            res[1] = 1;
            return res;
        }
        
        int k = 0;
        int kValue = 2;
        int p = k;
            
        int[] bits = new int[num + 1];
        bits[0] = 0;
        bits[1] = 1;
        
        while (k < num) {
            if (++ k == kValue) {
                p = 0;
                kValue *= 2;
            }
            bits[k] = bits[p++] + 1;
        }
        return bits;
    }
}