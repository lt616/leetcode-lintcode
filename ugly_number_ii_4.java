/* 
4. Ugly Number II

Ugly number is a number that only have factors 2, 3 and 5.

Design an algorithm to find the nth ugly number. The first 10 ugly numbers are 1, 2, 3, 4, 5, 6, 8, 9, 10, 12...
Example

If n=9, return 10.
Challenge

O(n log n) or O(n) time.
Notice

Note that 1 is typically treated as an ugly number.
*/ 

/* 
	EASY WRONG POINTS: 
		1. Multiplication may cuz overflow. 
*/ 

class Node {
    int val; 
    int used_times; 
    boolean multi_2; 
    boolean multi_3; 
    boolean multi_5; 
    
    public Node (int val) {
        this.val = val; 
        this.multi_2 = false; 
        this.multi_3 = false; 
        this.multi_5 = false; 
        this.used_times = 0; 
    }
}


public class Solution {
    /**
     * @param n: An integer
     * @return: the nth prime number as description.
     */
    public int nthUglyNumber(int n) {
        // write your code here 
        
        if (n <= 0) {
            return -1; 
        }
        
        if (n == 1) {
            return 1; 
        }
        
        Queue<Long> pq = new PriorityQueue(); 
        
        Set<Long> hash = new HashSet(); 
        
        pq.offer((long) 1); 

        long current = 1; 
        while (n > 0) {
            current = pq.poll(); 
            n --; 
            
            long next; 
            next = current * 2; 
            if (! hash.contains(next) && next >= Integer.MIN_VALUE && next <= Integer.MAX_VALUE) {
                pq.offer(next); 
                hash.add(next); 
            }
            
            next = current * 3; 
            if (! hash.contains(next) && next >= Integer.MIN_VALUE && next <= Integer.MAX_VALUE) {
                pq.offer(next); 
                hash.add(next); 
            } 
            
            next = current * 5; 
            if (! hash.contains(next) && next >= Integer.MIN_VALUE && next <= Integer.MAX_VALUE) {
                pq.offer(next); 
                hash.add(next); 
            } 
        } 
        
        return (int) current; 
    }
} 
