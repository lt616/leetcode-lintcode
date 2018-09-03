/* 
134. LRU Cache

Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and set.

get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
set(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item. 
*/ 

class Node { 
    int key; 
    int val; 
    Node next; 
    public Node(int key, int val) { 
        this.key = key; 
        this.val = val; 
        this.next = null; 
    }
}

public class LRUCache { 
    
    Map<Integer, Node> cache = new HashMap(); 
    Map<Integer, Node> parent = new HashMap(); 
    Node linked_list_first = null, linked_list_last = null; 
    int cache_size, current_size; 
    
    /*
    * @param capacity: An integer
    */public LRUCache(int capacity) {
        // do intialization if necessary 
        cache_size = capacity; 
    }

    /*
     * @param key: An integer
     * @return: An integer
     */
    public int get(int key) {
        // write your code here 
        
        if (! cache.containsKey(key)) { 
            // System.out.println("MATCH"); 
            return -1; 
        }

        Node current = cache.get(key); 
        int value = current.val; 
        
        if (linked_list_last == current) {
            return value; 
        } 
        
        if (linked_list_first == current) { 
            parent.remove(current.next.key); 
            linked_list_first = current.next; 
            current.next = null; 
        } else {
            parent.put(current.next.key, parent.get(current.key)); 
            // System.out.println(key); 
            parent.get(key).next = current.next; 
            current.next = null; 
            parent.remove(current.key); 
        }

        linked_list_last.next = current; 
        parent.put(current.key, linked_list_last); 
        linked_list_last = current; 
        
        return value; 
    }

    /*
     * @param key: An integer
     * @param value: An integer 
     * @return: nothing
     */
    public void set(int key, int value) {
        // write your code here 

        Node current; 
        if (cache.containsKey(key)) {
            /* remove current node */ 
            current = cache.get(key); 
            if (linked_list_last == current) {
                current.val = value; 
                cache.put(key, current); 
                return; 
            }
            if (parent.containsKey(key)) { 
                parent.get(key).next = current.next; 
                parent.put(current.next.key, parent.get(key)); 
                parent.remove(key); 
            } else { 
                parent.remove(current.next.key); 
                linked_list_first = current.next; 
                current.next = null; 
            } 

            current.val = value; 
            cache.put(key, current); 
        } else {
        
            if (current_size == cache_size) { 
                /* remove LRU element */ 
                cache.remove(linked_list_first.key); 

                linked_list_first = linked_list_first.next; 
                if (linked_list_first != null) { 
                    parent.remove(linked_list_first.key); 
                } 
                current_size --; 
            } 
            
            current = new Node(key, value); 
            cache.put(key, current); 
            
            current_size ++; 
        }
        
        /* append new element */ 
        if (linked_list_first == null) {
            linked_list_first = current; 
            linked_list_last = current; 
        } else {
            linked_list_last.next = current; 
            parent.put(current.key, linked_list_last); 
            linked_list_last = current; 
        }
        
        
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
