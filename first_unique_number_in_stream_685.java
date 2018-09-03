/* 
685. First Unique Number In Stream

Given a continuous stream of numbers, write a function that returns the first unique number whenever terminating number is reached(include terminating number). If there no unique number before terminating number or you can't find this terminating number, return -1.
Example

Given a stream [1, 2, 2, 1, 3, 4, 4, 5, 6] and a number 5
return 3

Given a stream [1, 2, 2, 1, 3, 4, 4, 5, 6] and a number 7
return -1
*/ 


class Node {
    int v; 
    Node next; 
    
    public Node(int value) {
        this.v = value; 
    }
} 


class DataStream { 
    
    Map<Integer, Node> dict; 
    Set<Integer> dup_nums; 
    Node first, last; 
    
    public DataStream() {
        dict = new HashMap(); 
        dup_nums = new HashSet(); 
        first = new Node(-1); 
        last = first; 
    } 
    
    public void add(int num) {
        if (dup_nums.contains(num)) {
            return; 
        } 
        
        if (dict.containsKey(num)) {
            /* remove num */ 
            Node prev_node = dict.get(num); 
            prev_node.next = prev_node.next.next;  

            if (prev_node.next == null) { 
                last = prev_node; 
            } else {
                dict.put(prev_node.next.v, prev_node); 
            }
            
            dict.remove(num); 
            dup_nums.add(num); 
            return; 
        } 
        
        Node new_node = new Node(num); 
        last.next = new_node; 
        dict.put(num, last); 
        last = new_node; 
    } 
    
    public int getFirstUnique() {
        Node res = first.next; 
        
        return (res != null) ? res.v : -1; 
    }
}


public class Solution {
    /**
     * @param nums: a continuous stream of numbers
     * @param number: a number
     * @return: returns the first unique number
     */
    public int firstUniqueNumber(int[] nums, int number) {
        // Write your code here 
        
        if (nums == null || nums.length == 0) {
            return -1; 
        } 
        
        DataStream ds = new DataStream(); 
        
        for (int i = 0;i < nums.length;i ++) {
            ds.add(nums[i]); 
            
            if (nums[i] == number) {
                return ds.getFirstUnique(); 
            } 
        } 
        
        return -1; 
    }
} 
