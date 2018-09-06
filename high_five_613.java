/* 
613. High Five

There are two properties in the node student id and scores, to ensure that each student will have at least 5 points, find the average of 5 highest scores for each person.
Example

Given results = [[1,91],[1,92],[2,93],[2,99],[2,98],[2,97],[1,60],[1,58],[2,100],[1,61]]

Return 
*/ 

/* 
	EASY WRONG POINTS: 
		1. Use a list of queue assoicated with Hash. 
*/ 

/* Solution 01: single queue & Hash */ 
/**
 * Definition for a Record
 * class Record {
 *     public int id, score;
 *     public Record(int id, int score){
 *         this.id = id;
 *         this.score = score;
 *     }
 * }
 */
public class Solution {
    /**
     * @param results a list of <student_id, score>
     * @return find the average of 5 highest scores for each person
     * Map<Integer, Double> (student_id, average_score)
     */
    public Map<Integer, Double> highFive(Record[] results) {
        // Write your code here 
        
        Map<Integer, Double> res = new HashMap(); 
        Queue<Integer> queue; 
        
        Map<Integer, List<Integer>> map = new HashMap(); 
        for (Record result : results) {
            if (! map.containsKey(result.id)) {
                map.put(result.id, new ArrayList()); 
            } 
            map.get(result.id).add(result.score); 
        } 
        
        for (Integer id : map.keySet()) {
            queue = new PriorityQueue(new Comparator<Integer>() {
                public int compare(Integer d1, Integer d2) { 
                    return d2 - d1; 
                } 
            }); 
            
            for (Integer score : map.get(id)) { 
                System.out.println(id); 
                queue.offer(score); 
            } 
            
            double sum = 0; 
            for (int i = 0;i < 5;i ++) {
                sum += (double) queue.poll(); 
            } 
            res.put(id, sum / 5); 
        }
        
        return res; 
    }
} 


/* Solution 02: list of queues */ 
/**
 * Definition for a Record
 * class Record {
 *     public int id, score;
 *     public Record(int id, int score){
 *         this.id = id;
 *         this.score = score;
 *     }
 * }
 */
public class Solution {
    /**
     * @param results a list of <student_id, score>
     * @return find the average of 5 highest scores for each person
     * Map<Integer, Double> (student_id, average_score)
     */
    public Map<Integer, Double> highFive(Record[] results) {
        // Write your code here 
        
        Map<Integer, Double> res = new HashMap(); 
        
        Map<Integer, Queue<Integer>> map = new HashMap(); 
        for (Record result : results) {
            if (! map.containsKey(result.id)) {
                map.put(result.id, new PriorityQueue(new Comparator<Integer>() {
                    public int compare(Integer d1, Integer d2) { 
                        return d2 - d1; 
                    } 
                })); 
            } 
            map.get(result.id).offer(result.score); 
        } 
        
        for (Integer id : map.keySet()) { 
            Queue<Integer> queue = map.get(id); 
            double sum = 0; 
            for (int i = 0;i < 5;i ++) {
                sum += (double) queue.poll(); 
            } 
            res.put(id, sum / 5); 
        }
        
        return res; 
    }
} 
