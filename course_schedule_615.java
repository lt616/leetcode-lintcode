/* 
615. Course Schedule

There are a total of n courses you have to take, labeled from 0 to n - 1.

Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?
Example

Given n = 2, prerequisites = [[1,0]]
Return true

Given n = 2, prerequisites = [[1,0],[0,1]]
Return false
*/ 

public class Solution {
    /*
     * @param numCourses: a total of n courses
     * @param prerequisites: a list of prerequisite pairs
     * @return: true if can finish all courses or false
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // write your code here 
        
        if (prerequisites == null || prerequisites.length == 0) {
            return true;  
        } 
        
        Queue<Integer> queue = new LinkedList(); 
        List<Integer>[] edges = new ArrayList[numCourses]; 
        int[] map = new int[numCourses]; 
        for (int i = 0;i < numCourses;i ++) {
            map[i] = 0; 
            edges[i] = new ArrayList(); 
        } 
    
        for (int i = 0;i < prerequisites.length;i ++) { 
            map[prerequisites[i][0]] ++; 
            edges[prerequisites[i][1]].add(prerequisites[i][0]); 
        } 
        
        for (int i = 0;i < numCourses;i ++) {
            if (map[i] == 0) {
                queue.offer(i); 
            } 
        } 
        
        int count = 0; 
        while (! queue.isEmpty()) {
            int current = queue.poll(); 
            count ++; 

            for (Integer course : edges[current]) {
                map[course] --; 
                if (map[course] == 0) {
                    queue.offer(course); 
                }
            }
        } 
        
        if (count == numCourses) { 
            return true; 
        } else {
            return false; 
        }
    }
} 
