/* Solution: Linked list */
class Node {
    int val;
    int min;
    Node next;
    
    public Node(int val) {
        this.val = val;
        this.next = null;
        this.min = val;
    }
    
    public void updateMin(int preMin) {
        this.min = (preMin < this.min) ? preMin : this.min;
    }
}

class MinStack {
    private PriorityQueue<Integer> pq;
    private Node end;
    
    /** initialize your data structure here. */
    public MinStack() {
        end = null;
    }
    
    public void push(int x) {
        Node node = new Node(x);
        if (end == null) {
            node.updateMin(Integer.MAX_VALUE);
            end = node;
        } else {
            node.updateMin(end.min);
            node.next = end;
            end = node;
        }
    }
    
    public void pop() {
        if (end == null)
            return;
        
        end = end.next;
    }
    
    public int top() {
        return end.val;
    }
    
    public int getMin() {
        return end.min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */