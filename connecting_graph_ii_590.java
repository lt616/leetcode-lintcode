/* 
590. Connecting Graph II

Given n nodes in a graph labeled from 1 to n. There is no edges in the graph at beginning.

You need to support the following method:

    connect(a, b), an edge to connect node a and node b
    query(a), Returns the number of connected component nodes which include node a.

Example

5 // n = 5
query(1) return 1
connect(1, 2)
query(1) return 2
connect(2, 4)
query(1) return 3
connect(1, 4)
query(1) return 3
*/ 

public class ConnectingGraph2 {
    /*
    * @param n: An integer
    */
    
    int[] roots; 
    int[] roots_count; 
    
    public ConnectingGraph2(int n) {
        // do intialization if necessary 
        
        roots = new int[n + 1]; 
        roots_count = new int[n + 1]; 
        
        for (int i = 1;i < n + 1;i ++) {
            roots[i] = i; 
            roots_count[i] = 1; 
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
        roots_count[root_b] += roots_count[root_a]; 
    } 

    /*
     * @param a: An integer
     * @return: An integer
     */
    public int query(int a) {
        // write your code here 
        
        int root_a = find(a); 
        
        return roots_count[root_a]; 
    } 
    
    private int find(int a) {
        if (roots[a] == a) {
            return a; 
        } 
        
        return roots[a] = find(roots[a]); 
    }
} 
