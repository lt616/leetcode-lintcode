/* 
127. Topological Sorting

Given an directed graph, a topological order of the graph nodes is defined as follow:

    For each directed edge A -> B in graph, A must before B in the order list.
    The first node in the order can be any node in the graph with no nodes direct to it.

Find any topological order for the given graph.
Example

For graph as follow:

picture

The topological order can be:

[0, 1, 2, 3, 4, 5]
[0, 2, 3, 1, 5, 4]
...

Challenge

Can you do it in both BFS and DFS?
Clarification

Learn more about representation of graphs
Notice

You can assume that there is at least one topological order in the graph.
*/ 

/* 
	EASY WRONG POINTS: 
		1. Calculate in-degree: if in-degree == 0, the node is one of the 
		starting nodes. After starting nodes are removed, find out starting 
		nodes in the rest of graph. Until no node left in the graph. 
*/ 

/* Solution 01: BFS */ 
/**
 * Definition for Directed graph.
 * class DirectedGraphNode {
 *     int label;
 *     ArrayList<DirectedGraphNode> neighbors;
 *     DirectedGraphNode(int x) { label = x; neighbors = new ArrayList<DirectedGraphNode>(); }
 * };
 */

public class Solution {
    /*
     * @param graph: A list of Directed graph node
     * @return: Any topological order for the given graph.
     */
    public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
        // write your code here 
        
        ArrayList<DirectedGraphNode> res = new ArrayList(); 
        
        if (graph == null || graph.size() == 0) {
            return res; 
        } 
        
        int size = graph.size(); 
        
        Map<DirectedGraphNode, Integer> map = new HashMap(); 
        for (DirectedGraphNode node : graph) { 
            for (DirectedGraphNode neighbor : node.neighbors) {
                if (map.containsKey(neighbor)) {
                    map.put(neighbor, map.get(neighbor) + 1); 
                }  else {
                    map.put(neighbor, 1); 
                } 
            } 
        } 

        Queue<DirectedGraphNode> queue = new LinkedList(); 
       
        for (DirectedGraphNode node : graph) {
            if (! map.containsKey(node)) {
                res.add(node); 
                queue.offer(node); 
            } 
        } 
        
        while (! queue.isEmpty()) {
            DirectedGraphNode current = queue.poll(); 
            for (DirectedGraphNode neighbor : current.neighbors) {
                map.put(neighbor, map.get(neighbor) - 1); 
                if (map.get(neighbor) == 0) {
                    res.add(neighbor); 
                    queue.offer(neighbor); 
                }
            } 
        } 
        
        for (DirectedGraphNode node : res) {
            System.out.println(node.label); 
        }
        
        return res; 
    } 
} 
