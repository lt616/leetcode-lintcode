/* 
486. Merge K Sorted Arrays

Given k sorted integer arrays, merge them into one sorted array.
Example

Given 3 sorted arrays:

[
  [1, 3, 5, 7],
  [2, 4, 6],
  [0, 8, 9, 10, 11]
]

return [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11].
Challenge

Do it in O(N log k).

    N is the total number of integers.
    k is the number of arrays.
*/ 

class ArrayNode {
    int val; 
    int x; 
    int y; 
    
    public ArrayNode(int val, int x, int y) {
        this.val = val; 
        this.x = x; 
        this.y = y; 
    } 
} 

public class Solution {
    /**
     * @param arrays: k sorted integer arrays
     * @return: a sorted array
     */
    public int[] mergekSortedArrays(int[][] arrays) {
        // write your code here 
        
        int size = 0; 
        for (int i = 0;i < arrays.length;i ++) { 
            size += arrays[i].length; 
        } 
        
        int[] res = new int[size]; 
        
        Queue<ArrayNode> pq = new PriorityQueue(new Comparator<ArrayNode>() {
                                public int compare(ArrayNode a, ArrayNode b) {
                                    return a.val - b.val; 
                                } 
                            }); 
                            
        for (int i = 0;i < arrays.length;i ++) {
            if (0 < arrays[i].length) {
                pq.offer(new ArrayNode(arrays[i][0], i, 0)); 
            } 
        } 
        
        int index = -1; 
        while (! pq.isEmpty()) {
            ArrayNode current = pq.poll(); 
            res[++ index] = current.val; 
            
            if (current.y + 1 < arrays[current.x].length) {
                pq.offer(new ArrayNode(arrays[current.x][current.y + 1], current.x, current.y + 1)); 
            } 
        }
        
        return res; 
    }
} 
