/* 
57. 3Sum

Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
Example

For example, given array S = {-1 0 1 2 -1 -4}, A solution set is:

(-1, 0, 1)
(-1, -1, 2)

Notice

Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)

The solution set must not contain duplicate triplets.
*/ 

/* 
	EASY WRONG POINTS: 
		1. When using 2-pointer, order is very very important. 
		In 3 sum problem, transit a + b + c = 0 to a + b = -c, therefore actually 
		a 2 sum problem. However, when picking c, always choose the smallest / largest 
		element for avoiding repeation. 
*/ 

public class Solution {
    /**
     * @param numbers: Give an array numbers of n integer
     * @return: Find all unique triplets in the array which gives the sum of zero.
     */
    public List<List<Integer>> threeSum(int[] numbers) {
        // write your code here 
        
        List<List<Integer>> res = new ArrayList();  
        
        if (numbers == null || numbers.length == 0) {
            return res; 
        } 
        
        Arrays.sort(numbers); 
        
        int target; 
        for (int i = 0;i < numbers.length;i ++) { 
            /* If duplicate and not the first 1 */ 
            if (i > 0 && numbers[i] == numbers[i - 1]) {
                continue; 
            } 
            
            /* The smallest number is the value at index i */ 
            target = 0 - numbers[i]; 
            for (List<Integer> res_element : findTwoElements(numbers, target, i)) {
                res.add(res_element);    
            } 
        } 
        return res; 
    } 
    
    private List<List<Integer>> findTwoElements(int[] numbers, int target, int index_limit) {
        int start = index_limit + 1, end = numbers.length - 1; 
        int sum; 
        List<List<Integer>> res = new ArrayList(); 

        while (start < end) {
            sum = numbers[start] + numbers[end]; 
            if (sum == target) { 
                List<Integer> res_element = new ArrayList(); 
                res_element.add(numbers[index_limit]); 
                res_element.add(numbers[start]);  
                res_element.add(numbers[end]); 
                
                res.add(res_element);  
                
                System.out.println(numbers[start] + ", " + numbers[index_limit] + ", " + numbers[end]); 
                
                /* move start to the next non-duplicate value */ 
                start ++; 
                while (start < numbers.length && numbers[start] == numbers[start - 1]) { 
                    start ++;  
                } 
                
            } else if (sum < target) {
                start ++; 
            } else { 
                end --; 
            } 
        } 
        
        return res; 
    }
} 
