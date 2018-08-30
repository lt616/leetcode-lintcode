/* 
616. Course Schedule II

There are a total of n courses you have to take, labeled from 0 to n - 1.
Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

Given the total number of courses and a list of prerequisite pairs, return the ordering of courses you should take to finish all courses.

There may be multiple correct orders, you just need to return one of them. If it is impossible to finish all courses, return an empty array.
Example

Given n = 2, prerequisites = [[1,0]]
Return [0,1]

Given n = 4, prerequisites = [1,0],[2,0],[3,1],[3,2]]
Return [0,1,2,3] or [0,2,1,3]
*/ 

public class Solution {
    /*
     * @param numCourses: a total of n courses
     * @param prerequisites: a list of prerequisite pairs
     * @return: the course order
     */
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // write your code here 
        
        if (numCourses < 0) {
            return null; 
        } 
        
        int[] res = new int[numCourses]; 
        int index = -1; 
        
        Queue<Integer> queue = new LinkedList(); 
        
        Map<Integer, Integer> course_degree = new HashMap(); 
        Map<Integer, List<Integer>> course_relation = new HashMap(); 
        for (int[] course_pair : prerequisites) {
            if (! course_degree.containsKey(course_pair[0])) {
                course_degree.put(course_pair[0], 0); 
            } 
            if (! course_relation.containsKey(course_pair[1])) {
                course_relation.put(course_pair[1], new ArrayList()); 
            } 
            course_degree.put(course_pair[0], course_degree.get(course_pair[0]) + 1); 
            course_relation.get(course_pair[1]).add(course_pair[0]); 
        } 
        
        for (int i = 0;i < numCourses;i ++) {
            if (! course_degree.containsKey(i)) {
                queue.offer(i); 
            } 
        } 
        
        while (! queue.isEmpty()) {
            int current = queue.poll(); 
            res[++ index] = current; 
            
            if (! course_relation.containsKey(current)) {
                continue; 
            }
            
            for (Integer next : course_relation.get(current)) {
                course_degree.put(next, course_degree.get(next) - 1); 
                if (course_degree.get(next) == 0) {
                    queue.offer(next); 
                } 
            } 
        } 
        
        if (index == numCourses - 1) {
            return res;
        } else {
            return new int[0]; 
        }
    }
} 
