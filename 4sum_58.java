/* 
58. 4Sum

Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target?

Find all unique quadruplets in the array which gives the sum of target.
Example

Given array S = {1 0 -1 0 -2 2}, and target = 0. A solution set is:

(-1, 0, 0, 1)
(-2, -1, 1, 2)
(-2, 0, 0, 2)

Notice

Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a ≤ b ≤ c ≤ d)
The solution set must not contain duplicate quadruplets.
*/ 

/* 
	EASY WRONG POINTS: 
		1. Sort array first of all. 
		2. Fixed n - 2 numbers and do 2-sum. 
*/ 

public class Solution {
    /**
     * @param numbers: Give an array
     * @param target: An integer
     * @return: Find all unique quadruplets in the array which gives the sum of zero
     */ 
    
    List<List<Integer>> res; 
    
    public List<List<Integer>> fourSum(int[] numbers, int target) {
        // write your code here 
        
        res = new ArrayList(); 
        
        if (numbers == null || numbers.length == 0) {
            return res; 
        } 
        
        Arrays.sort(numbers); 
        
        for (int i = 0;i < numbers.length - 3;i ++) { 
            if (i > 0 && numbers[i] == numbers[i - 1]) {
                continue; 
            } 
            
            for (int j = i + 1;j < numbers.length - 2;j ++) { 
                if (j > i + 1 && numbers[j] == numbers[j - 1]) {
                    continue; 
                }
                
                int start = j + 1, end = numbers.length - 1; 
                while (start < end) { 
                    int sum = numbers[i] + numbers[j] + numbers[start] + numbers[end]; 
                    if (sum == target) {
                        addResult(numbers[i], numbers[j], numbers[start], numbers[end]); 
                        
                        start ++; 
                        while (start < end && numbers[start] == numbers[start - 1]) {
                            start ++; 
                        } 
                        
                        end --; 
                        while (start < end && numbers[end] == numbers[end + 1]) {
                            end --; 
                        }
                    } else if (sum < target) {
                        start ++; 
                    } else {
                        end --; 
                    } 
                }
            }
        }

        return res; 
    } 
    
    private void addResult(int a, int b, int c, int d) {
        List<Integer> one_res = new ArrayList(); 
        one_res.add(a); 
        one_res.add(b); 
        one_res.add(c); 
        one_res.add(d); 
        
        res.add(one_res); 
    }
} 
