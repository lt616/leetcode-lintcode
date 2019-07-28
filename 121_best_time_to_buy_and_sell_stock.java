class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int price : prices) {
            if (min > price) {
                min = price;
                max = price;
            }
            max = (price > max) ? price : max;
            maxProfit = (max - min > maxProfit) ? max - min : maxProfit;
        }
        
        return maxProfit;
    }
}