/* 
591. Connecting Graph III

Given n nodes in a graph labeled from 1 to n. There is no edges in the graph at beginning.

You need to support the following method:

    connect(a, b), an edge to connect node a and node b
    query(), Returns the number of connected component in the graph

Example

5 // n = 5
query() return 5
connect(1, 2)
query() return 4
connect(2, 4)
query() return 3
connect(1, 4)
query() return 3
*/ 

public class ConnectingGraph3 {
    /**
     * @param a: An integer
     * @param b: An integer
     * @return: nothing
     */ 
    
    int[] roots; 
    int count; 
    
    public ConnectingGraph3(int n) { 
        roots = new int[n + 1]; 
        count = n; 
        
        for (int i = 1;i <= n;i ++) {
            roots[i] = i; 
        } 
    } 
    
    public void connect(int a, int b) { 
        // write your code here 
        
        int root_a = find(a); 
        int root_b = find(b); 
        
        if (root_a == root_b) {
            return; 
        } 
        
        count --; 
        roots[root_a] = root_b; 
    }

    /**
     * @return: An integer
     */
    public int query() {
        // write your code here 
        
        return count; 
    } 
    
    private int find(int a) {
        if (roots[a] == a) {
            return a; 
        } 
        
        return roots[a] = find(roots[a]); 
    }
} 
