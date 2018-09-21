/* 
1413. Tree

Two list x, y, representing an edge between x[i] and y[i], the entire set of edges is a tree, and the 1 is the root, and now there is a list a, B, which indicates what the node a[i] and b[i] are, if a[i] and b[i] are brothers, that is, the same parent output 1, if it is a father son relationship, output 2, otherwise output 0.
Example

Given x = [1,1], y = [2,3], a = [1,2], b = [2,3], return[2,1].

Explanation:
1 and 2 are father son relations, 2 and 3 are brothers, and their common parent nodes are 1.

Given x = [1,1,2], y = [2,3,4], a = [1,2,1], b = [2,3,4], return[2,1,0].

Explanation:
1 and 2 are father son relations, 2 and 3 are brothers, their common parent nodes are 1, 1 and 4 are not brothers or paternity.

Notice

    the number of nodes is not more than 100000

    all the numbers are positive integers that is not more than 100000
*/ 

public class Solution {
    /**
     * @param x: The x
     * @param y: The y
     * @param a: The a
     * @param b: The b
     * @return: The Answer
     */ 
    
    Map<Integer, List<Integer>> edges; 
    Map<Integer, Integer> tree_parents; 
    
    public int[] tree(int[] x, int[] y, int[] a, int[] b) {
        // Write your code here 
        
        edges = new HashMap<Integer, List<Integer>>(); 
        tree_parents = new HashMap<Integer, Integer>(); 
        for (int i = 0;i < x.length;i ++) { 
            int u = x[i]; 
            int v = y[i]; 
            
            if (! edges.containsKey(u)) {
                edges.put(u, new ArrayList<Integer>()); 
            } 
            edges.get(u).add(v); 
            
            if (! edges.containsKey(v)) {
                edges.put(v, new ArrayList<Integer>()); 
            } 
            edges.get(v).add(u); 
        } 
        
        buildTree(1); 
        
        int[] res = new int[a.length]; 
        for (int i = 0;i < a.length;i ++) {
            if (! tree_parents.containsKey(a[i]) || ! tree_parents.containsKey(b[i])) {
                res[i] = -1; 
                continue; 
            } 
            
            int parent_a = tree_parents.get(a[i]); 
            int parent_b = tree_parents.get(b[i]); 
            
            if (parent_a == b[i] || parent_b == a[i]) {
                res[i] = 2; 
            } else if (parent_a == parent_b) {
                res[i] = 1; 
            } else {
                res[i] = 0; 
            } 
        } 
        
        return res; 
    } 
    
    private void buildTree(int root) {
        Queue<Integer> queue = new LinkedList<Integer>(); 
        Set<Integer> visited = new HashSet<Integer>(); 
        
        tree_parents.put(root, -1); 
        
        queue.offer(root); 
        visited.add(root); 
        while (! queue.isEmpty()) {
            int current = queue.poll(); 
            
            if (! edges.containsKey(current)) {
                continue; 
            } 
            
            for (Integer child : edges.get(current)) {
                if (! visited.contains(child)) {
                    queue.offer(child); 
                    visited.add(child); 
                    
                    tree_parents.put(child, current); 
                } 
            } 
        } 
    }
} 
