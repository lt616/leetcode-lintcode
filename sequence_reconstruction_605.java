/* 
605. Sequence Reconstruction

Check whether the original sequence org can be uniquely reconstructed from the sequences in seqs. The org sequence is a permutation of the integers from 1 to n, with 1 ≤ n ≤ 10^4. Reconstruction means building a shortest common supersequence of the sequences in seqs (i.e., a shortest sequence so that all sequences in seqs are subsequences of it). Determine whether there is only one sequence that can be reconstructed from seqs and it is the org sequence.
Example

Given org = [1,2,3], seqs = [[1,2],[1,3]]
Return false
Explanation:
[1,2,3] is not the only one sequence that can be reconstructed, because [1,3,2] is also a valid sequence that can be reconstructed.

Given org = [1,2,3], seqs = [[1,2]]
Return false
Explanation:
The reconstructed sequence can only be [1,2].

Given org = [1,2,3], seqs = [[1,2],[1,3],[2,3]]
Return true
Explanation:
The sequences [1,2], [1,3], and [2,3] can uniquely reconstruct the original sequence [1,2,3].

Given org = [4,1,5,2,6,3], seqs = [[5,2,6,3],[4,1,5,2]]
Return true
*/ 

public class Solution {
    /**
     * @param org: a permutation of the integers from 1 to n
     * @param seqs: a list of sequences
     * @return: true if it can be reconstructed only one or false
     */
    public boolean sequenceReconstruction(int[] org, int[][] seqs) {
        // write your code here 
        
        if ((org.length == 0 && seqs.length == 0) || (org.length == 0 && seqs[0].length == 0)) {
            return true; 
        } 
        
        if (org == null || seqs == null || seqs.length == 0 || org.length == 0) {
            return false; 
        } 
        
        Queue<Integer> queue = new LinkedList(); 
        Map<Integer, Integer> map = new HashMap(); 
        Map<Integer, List<Integer>> seq_graph = new HashMap(); 
        Set<Integer> set = new HashSet(); 
        for (int i = 0;i < seqs.length;i ++) { 
            for (int j = 1;j < seqs[i].length;j ++) {
                if (! map.containsKey(seqs[i][j])) {
                    map.put(seqs[i][j], 0); 
                } 
                
                if (! seq_graph.containsKey(seqs[i][j - 1])) {
                    seq_graph.put(seqs[i][j - 1], new ArrayList()); 
                } 
                map.put(seqs[i][j], map.get(seqs[i][j]) + 1); 
                seq_graph.get(seqs[i][j - 1]).add(seqs[i][j]); 

                System.out.println(seqs[i][j - 1] + ", " + seqs[i][j]); 
            } 
            if (seqs[i].length > 0) {
                set.add(seqs[i][0]); 
            } 
        } 
        
        int index = 0; 
        int current = org[0]; 
        
        /* Check if there are more than 1 starting_element */ 
        int count = 0; 
        for (Integer num : set) {
            if (! map.containsKey(num)) {
                count ++; 
            }
        } 
        if (count > 1) {
            return false; 
        }
        
        
        if (map.containsKey(current) || ! set.contains(current)) { 
            return false; 
        } else {
            queue.offer(current); 
        } 
        
        while (! queue.isEmpty()) {
            current = queue.poll(); 
            if (queue.size() > 0) {
                return false; 
            }
            
            if (! seq_graph.containsKey(current)) { 
                break; 
            }
            for (Integer next : seq_graph.get(current)) {
                map.put(next, map.get(next) - 1); 
                if (map.get(next) == 0) {
                    if (index >= org.length - 1 || next != org[++ index]) { 
                        System.out.println("Inter" + next + ", " + index); 
                        return false; 
                    } else {
                        queue.offer(next); 
                        System.out.println(next); 
                    }
                }
            }
        } 
        
        System.out.println(index); 
        
        return (index == org.length - 1);    
    }
} 
