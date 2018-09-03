/* 
954. Insert Delete GetRandom O(1) - Duplicates allowed

Design a data structure that supports all following operations in average O(1) time.
Example

// Init an empty collection.
RandomizedCollection collection = new RandomizedCollection();

// Inserts 1 to the collection. Returns true as the collection did not contain 1.
collection.insert(1);

// Inserts another 1 to the collection. Returns false as the collection contained 1. Collection now contains [1,1].
collection.insert(1);

// Inserts 2 to the collection, returns true. Collection now contains [1,1,2].
collection.insert(2);

// getRandom should return 1 with the probability 2/3, and returns 2 with the probability 1/3.
collection.getRandom();

// Removes 1 from the collection, returns true. Collection now contains [1,2].
collection.remove(1);

// getRandom should return 1 and 2 both equally likely.
collection.getRandom();

Notice

Duplicate elements are allowed.

    insert(val): Inserts an item val to the collection.
    remove(val): Removes an item val from the collection if present.
    getRandom: Returns a random element from current collection of elements. The probability of each element being returned is linearly related to the number of same value the collection contains.
*/ 

class RandomizedCollection {

    private List<Integer> nums; 
    private Map<Integer, Set<Integer>> nums_indexs; 
    Random rand; 

    /** Initialize your data structure here. */
    public RandomizedCollection() {
        
        nums = new ArrayList(); 
        nums_indexs = new HashMap(); 
        rand = new Random(); 
    }
    
    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        // write your code here 
        boolean res = false; 
        
        nums.add(val); 
        if (! nums_indexs.containsKey(val)) { 
            nums_indexs.put(val, new HashSet()); 
            res = true; 
        } 
        
        nums_indexs.get(val).add(nums.size() - 1); 
        
        return res; 
    }
    
    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        // write your code here 
        if (! nums_indexs.containsKey(val)) {
            return false; 
        } 

        int index = nums_indexs.get(val).iterator().next();    
        if (index != nums.size() - 1) { 
            int last_value = nums.get(nums.size() - 1); 
            nums.set(index, last_value); 
            nums_indexs.get(last_value).remove(nums.size() - 1); 
            nums_indexs.get(last_value).add(index); 
            nums_indexs.get(val).remove(index); 
            if (nums_indexs.get(val).isEmpty()) {
                nums_indexs.remove(val); 
            } 
        } 
        
        return true; 
    }
    
    /** Get a random element from the collection. */
    public int getRandom() {
        // write your code here 
        
        return nums.get(rand.nextInt(nums.size())); 
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */ 
