/* 
526. Load Balancer

Implement a load balancer for web servers. It provide the following functionality:

    Add a new server to the cluster => add(server_id).
    Remove a bad server from the cluster => remove(server_id).
    Pick a server in the cluster randomly with equal probability => pick().

Example

At beginning, the cluster is empty => {}.

add(1)
add(2)
add(3)
pick()
>> 1         // the return value is random, it can be either 1, 2, or 3.
pick()
>> 2
pick()
>> 1
pick()
>> 3
remove(1)
pick()
>> 2
pick()
>> 3
pick()
>> 3
*/ 


/* Solution 01: not good. 
	LinkedList 
	O(1) add / O(1) remove / O(n) pickup */ 

class Node {
    int val; 
    Node next; 
    
    public Node(int val) {
        this.val = val; 
        this.next = null; 
    }
}

public class LoadBalancer { 
    Map<Integer, Node> prevNodes; 
    Node first, last; 
    Random rand; 
    
    public LoadBalancer() { 
        // do intialization if necessary 
        prevNodes = new HashMap(); 
        rand = new Random(); 
        
        Node new_node = new Node(-1); 
        first = new_node; 
        last = new_node; 
    } 

    /*
     * @param server_id: add a new server to the cluster
     * @return: nothing
     */
    public void add(int server_id) {
        // write your code here 
        
        if (prevNodes.containsKey(server_id)) {
            return; 
        } 
        

        Node new_node = new Node(server_id); 
        last.next = new_node; 
        prevNodes.put(server_id, last); 
        last = new_node; 
    } 

    /*
     * @param server_id: server_id remove a bad server from the cluster
     * @return: nothing
     */
    public void remove(int server_id) {
        // write your code here 
        if (prevNodes.containsKey(server_id)) {
            Node prev_node = prevNodes.get(server_id); 
            prev_node.next = prev_node.next.next; 
            if (prev_node.next == null) {
                last = prev_node; 
            } else {
                prevNodes.put(prev_node.next.val, prev_node); 
            } 
            
            prevNodes.remove(server_id); 
            
            return; 
        } 
        
    }

    /*
     * @return: pick a server in the cluster randomly with equal probability
     */
    public int pick() {
        // write your code here 
        
        int num = rand.nextInt(prevNodes.size()) + 1; 
        Node current = first; 
        while (num != 0) {
            current = current.next; 
            num --; 
        } 
        
        return current.val; 
    }
} 


/* Solution 02: 
	Array + Hash 
	O(1) add / O(1) remove / O(1) pick */ 
public class LoadBalancer { 
    Map<Integer, Integer> nums_indexs; 
    List<Integer> nums; 
    Random rand; 
    
    public LoadBalancer() {
        // do intialization if necessary 
        
        nums_indexs = new HashMap(); 
        nums = new ArrayList(); 
        rand = new Random(); 
    }

    /*
     * @param server_id: add a new server to the cluster
     * @return: nothing
     */
    public void add(int server_id) {
        // write your code here 
        
        nums.add(server_id); 
        nums_indexs.put(server_id, nums.size() - 1); 
    } 

    /*
     * @param server_id: server_id remove a bad server from the cluster
     * @return: nothing
     */
    public void remove(int server_id) {
        // write your code here 
        
        if (! nums_indexs.containsKey(server_id)) {
            return; 
        } 
        
        int index = nums_indexs.get(server_id); 
        int last = nums.get(nums.size() - 1); 
        
        nums.set(index, last); 
        nums.remove(nums.size() - 1); 
        
        nums_indexs.put(last, index); 
        nums_indexs.remove(server_id); 
    }

    /*
     * @return: pick a server in the cluster randomly with equal probability
     */
    public int pick() {
        // write your code here 
        
        int index = rand.nextInt(nums.size()); 
        return nums.get(index); 
    }
} 
