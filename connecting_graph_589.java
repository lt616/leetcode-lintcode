/* 
589. Connecting Graph

Given n nodes in a graph labeled from 1 to n. There is no edges in the graph at beginning.

You need to support the following method:

    connect(a, b), add an edge to connect node a and node b`.
    query(a, b), check if two nodes are connected

Example

5 // n = 5
query(1, 2) return false
connect(1, 2)
query(1, 3) return false
connect(2, 4)
query(1, 4) return true
*/ 

public class ConnectingGraph {
    /*
    * @param n: An integer
    */ 
    
    int[] roots; 
    
    public ConnectingGraph(int n) {
        // do intialization if necessary 
        
        roots = new int[n + 1]; 
        
        for (int i = 1;i <= n;i ++) {
            roots[i] = i; 
        } 
    }

    /*
     * @param a: An integer
     * @param b: An integer
     * @return: nothing
     */
    public void connect(int a, int b) {
        // write your code here 
        
        int root_a = find(a); 
        int root_b = find(b); 
        
        if (root_a == root_b) {
            return; 
        } 
        
        roots[root_a] = root_b; 
    } 

    /*
     * @param a: An integer
     * @param b: An integer
     * @return: A boolean
     */
    public boolean query(int a, int b) {
        // write your code here 
        int root_a = find(a); 
        int root_b = find(b); 
        
        return root_a == root_b; 
    } 
    
    private int find(int index) {
        if (roots[index] == index) {
            return index; 
        } 
        
        return roots[index] = find(roots[index]); 
    }
} 
