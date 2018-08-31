/* 
431. Connected Component in Undirected Graph

Find the number connected component in the undirected graph. Each node in the graph contains a label and a list of its neighbors. (a connected component (or just component) of an undirected graph is a subgraph in which any two vertices are connected to each other by paths, and which is connected to no additional vertices in the supergraph.)
Example

Given graph:

A------B  C
 \     |  | 
  \    |  |
   \   |  |
    \  |  |
      D   E

Return {A,B,D}, {C,E}. Since there are two connected component which is {A,B,D}, {C,E}
Clarification

Learn more about representation of graphs
Notice

Each connected component should sort by label.
*/ 

/**
 * Definition for Undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     ArrayList<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */


public class Solution {
    /*
     * @param nodes: a array of Undirected graph node
     * @return: a connected set of a Undirected graph
     */
    public List<List<Integer>> connectedSet(List<UndirectedGraphNode> nodes) {
        // write your code here 
        
        List<List<Integer>> res = new ArrayList(); 
        
        if (nodes == null) {
            return res;  
        } 
        
        Set<UndirectedGraphNode> nodes_list = new HashSet(); 
        for (UndirectedGraphNode node : nodes) {
            nodes_list.add(node); 
        } 
        
        Queue<UndirectedGraphNode> queue = new LinkedList();  
        
        while (! nodes_list.isEmpty()) {
            UndirectedGraphNode current_first = getFirstElementFromSet(nodes_list); 
            queue.offer(current_first); 
            nodes_list.remove(current_first);   
            
            List<Integer> component = new ArrayList(); 
            while (! queue.isEmpty()) {
                UndirectedGraphNode current = queue.poll(); 
                component.add(current.label);  
                
                for (UndirectedGraphNode neighbor : current.neighbors) { 
                    if (! nodes_list.contains(neighbor)) {
                        continue; 
                    } 
                    queue.offer(neighbor); 
                    nodes_list.remove(neighbor); 
                } 
            } 
            
            Collections.sort(component); 
            res.add(component); 
        } 
        
        return res; 
    } 
    
    private UndirectedGraphNode getFirstElementFromSet(Set<UndirectedGraphNode> set) {
        for (UndirectedGraphNode node : set) {
            return node; 
        } 
        
        return null; 
    }
} 0
