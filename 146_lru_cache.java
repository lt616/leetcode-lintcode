class Node {
    int key;
    int val;
    Node prev;
    Node next;
    
    public Node(int key, int val) {
        this.key = key;
        this.val = val;
    }
}

class LRUCache {
    private Node start;
    private Node end;
    private Map<Integer, Node> dict;
    private int capacity;
    
    public LRUCache(int capacity) {
        this.start = null;
        this.end = null;
        this.dict = new HashMap<>();
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if (! this.dict.containsKey(key))
            return -1;
        
        /* Move the node to the end */
        Node current = this.dict.get(key);
        removeNode(current);
        appendNode(current);
        
        return current.val;
    }
    
    public void put(int key, int value) {
        if (this.dict.containsKey(key)) {
            this.dict.get(key).val = value;
            removeNode(this.dict.get(key));
            appendNode(this.dict.get(key));
            return;
        }
        
        Node current = new Node(key, value);
        this.dict.put(key, current);
        appendNode(current);
        
        if (this.dict.size() > this.capacity) {
            dict.remove(this.start.key);
            removeNode(this.start);
        }
    }
    
    private void removeNode(Node current) {
        if (this.start == current && this.end == current) {
            this.start = null;
            this.end = null;
        } else if (this.start == current) {
            this.start = current.next;
            current.next.prev = null;
        } else if (this.end == current) {
            this.end = current.prev;
            current.prev.next = null;
        } else {
            current.prev.next = current.next;
            current.next.prev = current.prev;
        }
        
        current.prev = null;
        current.next = null;
    }
    
    private void appendNode(Node current) {
        if (this.start == null) {
            this.start = current;
            this.end = current;
        } else {
            current.prev = this.end;
            this.end.next = current;
            this.end = current;
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */