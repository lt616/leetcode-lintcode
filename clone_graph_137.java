/* 
137. Clone Graph

Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors.

How we serialize an undirected graph:

Nodes are labeled uniquely.

We use # as a separator for each node, and , as a separator for node label and each neighbor of the node.

As an example, consider the serialized graph {0,1,2#1,2#2,2}.

The graph has a total of three nodes, and therefore contains three parts as separated by #.

    First node is labeled as 0. Connect node 0 to both nodes 1 and 2.
    Second node is labeled as 1. Connect node 1 to node 2.
    Third node is labeled as 2. Connect node 2 to node 2 (itself), thus forming a self-cycle.

Visually, the graph looks like the following:

   1
  / \
 /   \
0 --- 2
     / \
     \_/

Example

return a deep copied graph.
*/ 

/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     ArrayList<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */


public class Solution {
    /*
     * @param node: A undirected graph node
     * @return: A undirected graph node
     */
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        // write your code here 
        
        if (node == null) {
            return null; 
        } 
        
        Map<Integer, UndirectedGraphNode> visited = new HashMap(); 
        Set<UndirectedGraphNode> is_visited = new HashSet(); 
        Queue<UndirectedGraphNode> queue = new LinkedList(); 
        
        queue.offer(node); 
        UndirectedGraphNode first = new UndirectedGraphNode(node.label); 
        visited.put(first.label, first); 
        is_visited.add(node); 
        
        while (! queue.isEmpty()) {
            UndirectedGraphNode origin = queue.poll(); 
            UndirectedGraphNode current = visited.get(origin.label); 
            
            for (UndirectedGraphNode neighbor : origin.neighbors) { 
                UndirectedGraphNode next; 
                if (! visited.containsKey(neighbor.label)) {
                    next = new UndirectedGraphNode(neighbor.label); 
                    visited.put(neighbor.label, next); 
                } else {
                    next = visited.get(neighbor.label); 
                } 
                
                current.neighbors.add(next); 
                if (is_visited.contains(neighbor)) {
                    continue; 
                } 
                
                queue.offer(neighbor); 
                is_visited.add(neighbor); 
            }
        } 
        
        return first; 
    }
} 
