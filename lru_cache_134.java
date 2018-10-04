/* 
134. LRU Cache

Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and set.

get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
set(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item. 
*/ 

/* 
	EASY WRONG POINTS: 
		

*/ 

/* Solution 01: my best solution */ 
class Node {
    int key; 
    int val; 
    Node next; 
    
    public Node (int key, int val) {
        this.key = key; 
        this.val = val; 
        this.next = null; 
    } 
} 

class LRUCache { 
    Node dummy, last; 
    int capacity, size; 
    Map<Integer, Node> preNodes; 

    public LRUCache(int capacity) {
        dummy = new Node(-1, 0); 
        last = dummy; 
        size = 0; 
        preNodes = new HashMap<Integer, Node>(); 
        
        this.capacity = capacity; 
    }
    
    public int get(int key) {
        if (! preNodes.containsKey(key)) {
            return -1; 
        } 
        
        moveToTail(key); 
        
        return preNodes.get(key).next.val; 
    }
    
    public void put(int key, int value) { 
        
        if (! preNodes.containsKey(key)) { 
            Node new_node = new Node(key, value); 
            appendNode(new_node); 
            size ++;      
            if (size > capacity) {
                removeFirstNode(); 
                size --; 
            } 
        } else {
            moveToTail(key); 
            preNodes.get(key).next.val = value; 
        }
    } 
    
    private void moveToTail(int key) {
        Node current, pre; 
        pre = preNodes.get(key); 
        current = pre.next; 
        
        if (current == last) {
            return; 
        } 
        
        pre.next = current.next; 
        if (pre.next == null) {
            last = pre; 
        } else {
            preNodes.put(pre.next.key, pre); 
        } 
        
        appendNode(current); 
    } 
    
    private void appendNode(Node node) { 
        last.next = node; 
        node.next = null; 
        preNodes.put(node.key, last); 
        last = node;  
    }
    
    private void removeFirstNode() {
        Node current, next; 
        current = dummy.next; 
        next = current.next; 
        
        dummy.next = next; 
        if (dummy.next == null) {
            last = dummy; 
        } 
        
        preNodes.remove(current.key); 
        preNodes.put(next.key, dummy); 
    }
} 


/* Solution 02: optimised */ 
public class LRUCache {
    class ListNode {
        public int key, val;
        public ListNode next;
        
        public ListNode(int key, int val) {
            this.key = key;
            this.val = val;
            this.next = null;
        }
    }
    
    private int capacity, size;
    private ListNode dummy, tail;
    private Map<Integer, ListNode> keyToPrev;

    /*
    * @param capacity: An integer
    */
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.keyToPrev = new HashMap<Integer, ListNode>();
        this.dummy = new ListNode(0, 0);
        this.tail = this.dummy;
    }

    private void moveToTail(int key) {
        ListNode prev = keyToPrev.get(key);
        ListNode curt = prev.next;
        
        if (tail == curt) {
            return;
        }
        
        prev.next = prev.next.next;
        tail.next = curt;
        
        if (prev.next != null) {
            keyToPrev.put(prev.next.key, prev);
        }
        keyToPrev.put(curt.key, tail);
        
        tail = curt;
    }
    
    /*
     * @param key: An integer
     * @return: An integer
     */
    public int get(int key) {
        if (!keyToPrev.containsKey(key)) {
            return -1;
        }
        
        moveToTail(key);
        
        // the key has been moved to the end
        return tail.val;
    }
    
    /*
     * @param key: An integer
     * @param value: An integer
     * @return: nothing
     */
    public void set(int key, int value) {
        // get method will move the key to the end of the linked list
        if (get(key) != -1) {
            ListNode prev = keyToPrev.get(key);
            prev.next.val = value;
            return;
        }
        
        if (size < capacity) {
            size++;
            ListNode curt = new ListNode(key, value);
            tail.next = curt;
            keyToPrev.put(key, tail);
            
            tail = curt;
            return;
        }
        
        // replace the first node with new key, value
        ListNode first = dummy.next;
        keyToPrev.remove(first.key);
        
        first.key = key;
        first.val = value;
        keyToPrev.put(key, dummy);
        
        moveToTail(key);
    }
} 
