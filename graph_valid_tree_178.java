/* 
178. Graph Valid Tree

Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes), write a function to check whether these edges make up a valid tree.
Example

Given n = 5 and edges = [[0, 1], [0, 2], [0, 3], [1, 4]], return true.

Given n = 5 and edges = [[0, 1], [1, 2], [2, 3], [1, 3], [1, 4]], return false.
Notice

You can assume that no duplicate edges will appear in edges. Since all edges are undirected, [0, 1] is the same as [1, 0] and thus will not appear together in edges.
*/ 

public class Solution {
    /**
     * @param n: An integer
     * @param edges: a list of undirected edges
     * @return: true if it's a valid tree, or false
     */
    public boolean validTree(int n, int[][] edges) {
        // write your code here 
        
        /* Check: 1. length = n - 1
                  2. is connected */ 
        
        if (edges == null) {
            return false;  
        } 
        
        if (edges.length != n - 1) {
            return false; 
        } 
        
        if (n == 1) {
            return true; 
        }
        
        Map<Integer, List<Integer>> graph = new HashMap(); 
        for (int i = 0;i < edges.length;i ++) {
            int u = edges[i][0]; 
            int v = edges[i][1]; 
            if (! graph.containsKey(u)) {
                graph.put(u, new ArrayList()); 
            } 
            graph.get(u).add(v); 
            
            if (! graph.containsKey(v)) {
                graph.put(v, new ArrayList()); 
            } 
            graph.get(v).add(u); 
        } 
        
        Queue<Integer> queue = new LinkedList(); 
        Set<Integer> visited_set = new HashSet(); 
        
        int current = edges[0][0]; 
        queue.offer(current); 
        visited_set.add(current); 
        
        while (! queue.isEmpty()) {
            current = queue.poll(); 

            
            List<Integer> neighbors = graph.get(current); 
            
                for (int i = 0;i < neighbors.size();i ++) {
                    if (visited_set.contains(neighbors.get(i))) {
                        continue; 
                    } 
                    queue.offer(neighbors.get(i)); 
                    visited_set.add(neighbors.get(i)); 
                } 
        } 
        
        return (visited_set.size() == n); 
    }
} 
