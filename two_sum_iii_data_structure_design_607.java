/* 
607. Two Sum III - Data structure design

Design and implement a TwoSum class. It should support the following operations: add and find.

add - Add the number to an internal data structure.
find - Find if there exists any pair of numbers which sum is equal to the value.
Example

add(1); add(3); add(5);
find(4) // return true
find(7) // return false
*/ 

/* 
	EASY WRONG POINTS: 
		1. Operators time complexity analysis: 
		Using 2-pointer: add() O(1); find() O(nlog n). 
		Using Hash: add() O(1); find() O(1). 
*/ 

import java.util.*;

public class TwoSum {
     
    Map<Integer, Integer> numbers = new HashMap();  
    ArrayList<Integer> numbersArray = new ArrayList(); 
    int count = 0; 
    
    /*
     * @param number: An integer
     * @return: nothing
     */
    public void add(int number) { 
        // write your code here 
        this.numbers.put(number, count); 
        this.numbersArray.add(number); 
        
        this.count ++; 
    }

    /*
     * @param value: An integer
     * @return: Find if there exists any pair of numbers which sum is equal to the value.
     */
    public boolean find(int value) { 
        // write your code here 
        
        for (int i = 0;i < numbersArray.size();i ++) { 
            int num_to_find = value - numbersArray.get(i);  
            if (numbers.containsKey(num_to_find)) { 
                if (numbers.get(num_to_find) == i) {
                    continue; 
                } 
                return true; 
            } 
        }
        
        return false; 
    } 
    

}
