/* 
187. Gas Station

There are N gas stations along a circular route, where the amount of gas at station i is gas[i].

You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station (i+1). You begin the journey with an empty tank at one of the gas stations.

Return the starting gas station's index if you can travel around the circuit once, otherwise return -1.
Example

Given 4 gas stations with gas[i]=[1,1,3,1], and the cost[i]=[2,2,1,1]. The starting gas station's index is 2.
Challenge

O(n) time and O(1) extra space
Notice

The solution is guaranteed to be unique.
*/ 

public class Solution {
    /**
     * @param gas: An array of integers
     * @param cost: An array of integers
     * @return: An integer
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {
        // write your code here 
        
        if (gas == null || gas.length == 0 || cost == null || cost.length == 0) {
            return -1; 
        } 
        
        int[] left = new int[gas.length]; 
        int sum = 0, max = -1, max_index = (gas[0] - cost[0] >= 0) ? -1 : -2; 
        for (int i = 0;i < gas.length;i ++) {
            left[i] = gas[i] - cost[i]; 
            sum += left[i]; 
            
            if (sum < 0) {
                sum = 0; 
                max_index = i; 
                continue; 
            } 
        } 
        max_index ++; 
        
        if (max_index == -1) {
            return max_index; 
        } 

        sum = 0; 
        for (int i = max_index;i < gas.length;i ++) {
            sum += left[i]; 
            if (sum < 0) { 
                return -1; 
            } 
        } 
        
        for (int i = 0;i < max_index;i ++) {
            sum += left[i]; 
            if (sum < 0) { 
                return -1; 
            } 
        } 
        
        return max_index; 
    }
} 
