/* 
657. Insert Delete GetRandom O(1)

Design a data structure that supports all following operations in average O(1) time.

    insert(val): Inserts an item val to the set if not already present.
    remove(val): Removes an item val from the set if present.
    getRandom: Returns a random element from current set of elements. Each element must have the same probability of being returned.

Example

// Init an empty set.
RandomizedSet randomSet = new RandomizedSet();

// Inserts 1 to the set. Returns true as 1 was inserted successfully.
randomSet.insert(1);

// Returns false as 2 does not exist in the set.
randomSet.remove(2);

// Inserts 2 to the set, returns true. Set now contains [1,2].
randomSet.insert(2);

// getRandom should return either 1 or 2 randomly.
randomSet.getRandom();

// Removes 1 from the set, returns true. Set now contains [2].
randomSet.remove(1);

// 2 was already in the set, so return false.
randomSet.insert(2);

// Since 2 is the only number in the set, getRandom always return 2.
randomSet.getRandom();
*/ 

/* 
	EASY WRONG POINTS: 
		1. Array + Hash. 
			1). O(1) add 
			2). O(1) remove 
			3). O(1) getRandom 
		2. Random generator can be initialized only once at initial phrase. 
*/ 

public class RandomizedSet { 
    
    private List<Integer> nums; 
    private Map<Integer,Integer> nums_indexs;  
    private int size; 
    Random rand; 
    
    public RandomizedSet() {
        // do intialization if necessary 
        
        nums = new ArrayList(); 
        nums_indexs = new HashMap(); 
        size = 0; 
        rand = new Random(); 
    }

    /*
     * @param val: a value to the set
     * @return: true if the set did not already contain the specified element or false
     */
    public boolean insert(int val) {
        // write your code here 
        
        if (! nums_indexs.containsKey(val)) {
            nums.add(val); 
            nums_indexs.put(val, size); 
            size ++; 
            
            return true; 
        } 
        
        return false; 
    }

    /*
     * @param val: a value from the set
     * @return: true if the set contained the specified element or false
     */
    public boolean remove(int val) { 
        // write your code here 
        
        if (! nums_indexs.containsKey(val)) {
            return false; 
        } 
        
        int index = nums_indexs.get(val); 
        if (index != size - 1) { 
            int last_val = nums.get(size - 1); 
            nums.set(index, last_val); 
            nums_indexs.put(last_val, index); 
        }
        
        nums.remove(size - 1); 
        nums_indexs.remove(val); 
        size --;
        
        return true; 
    }

    /*
     * @return: Get a random element from the set
     */
    public int getRandom() {
        // write your code here 
        
        return nums.get(rand.nextInt(size)); 
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param = obj.insert(val);
 * boolean param = obj.remove(val);
 * int param = obj.getRandom();
 */ 
