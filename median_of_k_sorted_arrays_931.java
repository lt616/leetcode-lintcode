/* 
931. Median of K Sorted Arrays

There are k sorted arrays nums. Find the median of the given k sorted arrays.
Example

Given nums = [[1],[2],[3]], return 2.00.
Notice

The length of the given arrays may not equal to each other.
The elements of the given arrays are all positive number.
Return 0 if there are no elements in the array.
*/ 

/* Solution 01: heap, but memory limited exceed. */ 

class Node {
    int val; 
    int i; 
    int j; 
    
    public Node(int val, int i, int j) {
        this.val = val; 
        this.i = i; 
        this.j = j; 
    } 
} 

public class Solution {
    /**
     * @param nums: the given k sorted arrays
     * @return: the median of the given k sorted arrays
     */
    public double findMedian(int[][] nums) {
        // write your code here 
        
        if (nums == null || nums.length == 0) {
            return 0; 
        } 

        int index = -1; 
        Queue<Node> pq = new PriorityQueue(new Comparator<Node>() {
                            public int compare(Node n1, Node n2) {
                                return n1.val - n2.val; 
                            } 
                        }); 
        
        int size = 0; 
        for (int i = 0;i < nums.length;i ++) {
            size += nums[i].length; 
            if (nums[i].length > 0) {
                pq.offer(new Node(nums[i][0], i, 0)); 
            } 
        } 
        
        int median_first, median_second; 
        double first = 0, second = 0; 
        if (size % 2 == 0) {
            median_first = size / 2 - 1; 
            median_second = size / 2; 
        } else {
            median_first = size / 2; 
            median_second = size / 2; 
        } 
        
        System.out.println(size + ", " + median_first + ", " + median_second); 
        
        while (! pq.isEmpty()) {
            Node current = pq.poll(); 
            index ++; 
            
            if (index == median_first) {
                first = current.val; 
            } 
            
            if (index == median_second) {
                second = current.val; 
                break; 
            } 
            
            if (current.j + 1 < nums[current.i].length) {
                pq.offer(new Node(nums[current.i][current.j + 1], current.i, current.j + 1)); 
            } 
        } 
        
        System.out.println(first + ", " + second); 

        return (first + second) / 2; 
    }
} 


/* Solution 02: binary search */ 
public class Solution {
    /**
     * @param nums: the given k sorted arrays
     * @return: the median of the given k sorted arrays
     */
    public double findMedian(int[][] nums) {
        int n = getTotal(nums);
        if (n == 0) {
            return 0;
        }
        
        if (n % 2 != 0) {
            return findKth(nums, n / 2 + 1);
        }
        
        return findKth(nums, n / 2) / 2.0 + findKth(nums, n / 2 + 1) / 2.0;
    }
    
    private int getTotal(int[][] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i].length;
        }
        return sum;
    }
    
    // k is not zero-based, it starts from 1.
    private int findKth(int[][] nums, int k) {
        int start = 0, end = Integer.MAX_VALUE;
        
        // find the last number x that >= k numbers are >= x. 
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (getGTE(nums, mid) >= k) {
                start = mid;
            } else {
                end = mid;
            }
        }
        
        if (getGTE(nums, start) >= k) {
            return start;
        }
        
        return end;
    }
    
    // get how many numbers greater than or equal to val in 2d array
    private int getGTE(int[][] nums, int val) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += getGTE(nums[i], val);
        }
        return sum;
    }
    
    // get how many numbers greater than or equal to val in an array
    private int getGTE(int[] nums, int val) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int start = 0, end = nums.length - 1;
        
        // find first element >= val 
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] >= val) {
                end = mid;
            } else {
                start = mid;
            }
        }
        
        if (nums[start] >= val) {
            return nums.length - start;
        }
        
        if (nums[end] >= val) {
            return nums.length - end;
        }
        
        return 0;
    }
} 
