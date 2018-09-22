/* 
1448. Card Game

A card game that gives you two non-negative integers: totalProfit, totalCost, and n cards'information. The ith card has a profit value a[i] and a cost value b[i].It is possible to select any number of cards from these cards, form a scheme. Now we want to know how many schemes are satisfied that all selected cards' profit values are greater than totalProfit and the costs are less than totalCost.
Example

Given n = 2，totalProfit = 3，totalCost = 5，a = [2,3]，b = [2,2] ，return1.

Explanation:
At this time, there is only one legal scheme, which is to select both cards. At this time, a[1]+a[2] = 5 > totalProfit and b[1] + b[2] < totalCost.

Given n = 3，totalProfit = 5，totalCost = 10，a = [6,7,8]，b = [2,3,5]，return6.

Explanation:
Suppose a legal scheme (i,j) indicates that the i-th card and the j-th card are selected.
The legal solutions at this time are:
(1),(2),(3),(1,2),(1,3),(2,3)

Notice

    Since this number may be large, you only need to return the solution number mod 1e9 + 7.
    0≤n≤1000 \leq n \leq 1000≤n≤100
    0≤a[i]≤1000 \leq a[i] \leq 1000≤a[i]≤100
    0≤b[i]≤1000 \leq b[i] \leq 1000≤b[i]≤100
    0≤totalProfit≤1000 \leq totalProfit\leq 1000≤totalProfit≤100
    0≤totalCost≤1000 \leq totalCost \leq 1000≤totalCost≤100
*/ 

/* 
	EASY WRONG POINTS: 
		1. Classic DP backpack problem. O(n∗totalProfit∗totalCost) 
		2. Cannot use DFS since the result number is sooo big!  
*/ 

/* Solution 01: DFS, TLE */ 
public class Solution {
    /**
     * @param n: The number of cards
     * @param totalProfit: The totalProfit
     * @param totalCost: The totalCost
     * @param a: The profit of cards
     * @param b: The cost of cards
     * @return: Return the number of legal plan
     */ 
    
    int MOD = 1000000007; 
    long num; 
    
    public int numOfPlan(int n, int totalProfit, int totalCost, int[] a, int[] b) {
        // Write your code here 
        
        num = 0; 
        
        findPropNum(totalProfit, totalCost, a, b, 0, 0, 0); 
        
        return (int) (num % MOD); 
    } 
    
    private void findPropNum(int min_profit, int max_cost, int[] profits, int[] costs, int index, int profit_buffer, int cost_buffer) {

        if (profit_buffer > min_profit && cost_buffer < max_cost) {
            num ++; 
        } 
        
        int profit, cost; 
        for (int i = index;i < profits.length;i ++) {
            findPropNum(min_profit, max_cost, profits, costs, i + 1, profit_buffer + profits[i], cost_buffer + costs[i]); 
        } 
    }
} 


/* Solution 02: DP_backpack */ 
public class Solution {
    /**
     * @param n: The number of cards
     * @param totalProfit: The totalProfit
     * @param totalCost: The totalCost
     * @param a: The profit of cards
     * @param b: The cost of cards
     * @return: Return the number of legal plan
     */ 
    
    long MOD = 1000000007; 
    
    public int numOfPlan(int n, int totalProfit, int totalCost, int[] a, int[] b) {
        // Write your code here 
        
        long[][][] dp_array = new long[105][105][105]; 
        dp_array[0][0][0] = 1; 
        
        for (int k = 0; k < n; k++) {
            for (int i = 0;i <= totalProfit + 1;i ++) {
                for (int j = 0;j <= totalCost;j ++) {
                    if (dp_array[k][i][j] <= 0) {
                        continue; 
                    }
                    
                    dp_array[k + 1][i][j] += dp_array[k][i][j]; 
                    dp_array[k + 1][i][j] %= MOD; 
                    
                    if (j + b[k] < totalCost) {
                        dp_array[k + 1][min(totalProfit + 1, i + a[k])][j + b[k]] += dp_array[k][i][j]; 
                        dp_array[k + 1][min(totalProfit + 1, i + a[k])][j + b[k]] %= MOD; 
                    } 
                } 
            } 
        } 
        
        long num = 0; 
        for (int i = 0;i < totalCost;i ++) {
            num += dp_array[n][totalProfit + 1][i]; 
            num %= MOD; 
        }
        
        return (int) num; 
    } 
    
    private int min(int a, int b) {
        return (a < b) ? a : b; 
    }
} 
