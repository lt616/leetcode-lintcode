/* 
960. First Unique Number in a Stream II

We need to implement a data structure named DataStream. There are two methods required to be implemented:

    void add(number) // add a new number
    int firstUnique() // return first unique number

Example

add(1)
add(2)
firstUnique() => 1
add(1)
firstUnique() => 2

Notice

You can assume that there must be at least one unique number in the stream when calling the firstUnique.
*/ 

class Node {
    int val; 
    Node next; 
    
    public Node(int val) {
        this.val = val; 
        this.next = null; 
    } 
} 

public class DataStream {
    
    Map<Integer, Node> map; 
    Set<Integer> dupNums; 
    Node first, last; 
    
    public DataStream(){
        // do intialization if necessary
    
        map = new HashMap(); 
        dupNums = new HashSet(); 
        Node new_node = new Node(-1); 
        first = new_node; 
        last = new_node; 
    }
    /**
     * @param num: next number in stream
     * @return: nothing
     */
    public void add(int num) {
        // write your code here 
        
        if (dupNums.contains(num)) {
            return; 
        } 
        
        if (map.containsKey(num)) {
            Node prev_node = map.get(num); 
            prev_node.next = prev_node.next.next; 
            if (prev_node.next == null) {
                last = prev_node; 
            } else {
                map.put(prev_node.next.val, prev_node); 
            } 
            map.remove(num); 
            dupNums.add(num); 
            return; 
        } 
        
        Node new_node = new Node(num); 
        last.next = new_node; 
        map.put(num, last); 
        last = new_node; 
    } 
    
    /**
    * @return: the first unique number in stream
    */
    public int firstUnique() {
        // write your code here 
        
        return first.next.val; 
    }
} 
