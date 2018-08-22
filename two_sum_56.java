/* 
56. Two Sum

Given an array of integers, find two numbers such that they add up to a specific target number.

The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are zero-based.
Example

numbers=[2, 7, 11, 15], target=9

return [0, 1]
Challenge

Either of the following solutions are acceptable:

    O(n) Space, O(nlogn) Time
    O(n) Space, O(n) Time

Notice

You may assume that each input would have exactly one solution
*/ 

/* 
	EASY WRONG POINTS: 
		1. If duplicate: because of the hash order. 
		2. Solution O(n): Hash. 
		3. Solution O(nlog n): 2-pointer. 
		4. The usage of hashmap in java; 
		5. Difference between hashtable & hashmap: hashtable is synchronized, 
		and hashmap is non-synchronized. As a result, hashmap is more 
		effective than hashtable in a non-threaded program.  
*/ 

import java.util.HashMap;
import java.util.Map;

/* Solution 01: Hash */ 
public class Solution {
    /**
     * @param numbers: An array of Integer
     * @param target: target = numbers[index1] + numbers[index2]
     * @return: [index1, index2] (index1 < index2)
     */
    public int[] twoSum(int[] numbers, int target) {
        // write your code here 
        
        if (numbers == null || numbers.length == 0) 
            return new int[0]; 
        
        int[] res = new int[2]; 
        
        Map<Integer, Integer> numbers_hash = new HashMap();   
        for (int i = 0;i < numbers.length;i ++) 
            numbers_hash.put(numbers[i], i); 
        
        int first, second; 
        for (int i = 0;i < numbers.length;i ++) { 
            first = numbers[i]; 
            second = target - first; 
            if (numbers_hash.containsKey(second)) {
                res[0] = i;  
                res[1] = numbers_hash.get(second);  
                return res; 
            } 
        } 
        
        return new int[0]; 
    }
} 

/* Solution 02: 2-pointer */ 
import java.util.HashMap;
import java.util.Map; 

class Pair {
    int num; 
    int index; 
    
    public Pair(int num, int index) {
        this.num = num; 
        this.index = index; 
    }
}

public class Solution {
    /**
     * @param numbers: An array of Integer
     * @param target: target = numbers[index1] + numbers[index2]
     * @return: [index1, index2] (index1 < index2)
     */
    public int[] twoSum(int[] numbers, int target) {
        // write your code here 
        
        if (numbers == null || numbers.length == 0) 
            return new int[0]; 
        
        int[] res = new int[2]; 
        Pair[] numbersPairs = new Pair[numbers.length]; 
        for (int i = 0;i < numbers.length;i ++) {
            numbersPairs[i] = new Pair(numbers[i], i);  
        } 
        
        Arrays.sort(numbersPairs, new Comparator<Pair>(){
            public int compare(Pair p1, Pair p2){
                return p1.num - p2.num;
            } 
        }); 
        
        int start = 0, end = numbers.length - 1; 
        int sum; 
        while (start + 1 < end) {
            sum = numbersPairs[start].num + numbersPairs[end].num; 
            if (sum == target) {
                res[0] = (numbersPairs[start].index <= numbersPairs[end].index) ? numbersPairs[start].index : numbersPairs[end].index;  
                res[1] = (numbersPairs[end].index >= numbersPairs[start].index) ? numbersPairs[end].index : numbersPairs[start].index;   
                
                return res; 
            } else if (sum < target) {
                start ++; 
            } else {
                end --; 
            } 
        } 
        
        if (numbersPairs[start].num + numbersPairs[end].num == target) { 
            res[0] = (numbersPairs[start].index <= numbersPairs[end].index) ? numbersPairs[start].index : numbersPairs[end].index;  
            res[1] = (numbersPairs[end].index >= numbersPairs[start].index) ? numbersPairs[end].index : numbersPairs[start].index;  
            return res; 
        } 
        
        return new int[0]; 
    }
} 
