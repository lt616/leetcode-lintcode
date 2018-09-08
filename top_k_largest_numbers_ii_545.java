/* 
545. Top k Largest Numbers II

Implement a data structure, provide two interfaces:

    add(number). Add a new number in the data structure.
    topk(). Return the top k largest numbers in this data structure. k is given when we create the data structure.

Example

s = new Solution(3);
>> create a new data structure.
s.add(3)
s.add(10)
s.topk()
>> return [10, 3]
s.add(1000)
s.add(-99)
s.topk()
>> return [1000, 10, 3]
s.add(4)
s.topk()
>> return [1000, 10, 4]
s.add(100)
s.topk()
>> return [1000, 100, 10]
*/ 

/* Solution 01: priority queue */ 
public class Solution { 
    
    Queue<Integer> pq; 
    int size; 
    
    /*
    * @param k: An integer
    */public Solution(int k) {
        // do intialization if necessary 
        
        pq = new PriorityQueue(); 
        size = k; 
    }

    /*
     * @param num: Number to be added
     * @return: nothing
     */ 
    public void add(int num) {
        // write your code here 
        pq.offer(num); 
        
        if (pq.size() == size + 1) { 
            pq.poll(); 
        } 
    }

    /*
     * @return: Top k element
     */
    public List<Integer> topk() {
        // write your code here 
        
        List<Integer> res = new ArrayList(); 
        Queue<Integer> new_pq = new PriorityQueue(); 
        
        int pq_size = pq.size(); 
        for (int i = 0;i < pq_size;i ++) {
            res.add(pq.peek()); 
            new_pq.offer(pq.poll()); 
        } 
        
        pq = new_pq; 
        
        Collections.reverse(res); 
        
        return res; 
    }
} 
