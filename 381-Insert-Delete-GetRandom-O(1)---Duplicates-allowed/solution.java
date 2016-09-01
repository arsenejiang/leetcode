public class RandomizedCollection {
    private ArrayList<Integer> nums;
    private HashMap<Integer, HashSet<Integer>> map;
    private Random rand;

    /** Initialize your data structure here. */
    public RandomizedCollection() {
        nums = new ArrayList<Integer>();
        map = new HashMap<Integer, HashSet<Integer>>();
        rand = new Random();
    }
    
    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        if (map.containsKey(val)) {
            nums.add(val);
            map.get(val).add(nums.size() - 1);
            return false;
        }
        else {
            HashSet<Integer> set = new HashSet<Integer>();
            nums.add(val);
            set.add(nums.size() - 1);
            map.put(val, set);
            return true;
        }
    }
    
    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if (map.containsKey(val)) {
            if (val == nums.get(nums.size() - 1)) {
            	map.get(val).remove(nums.size() - 1);
            }
            else {
            	int index = map.get(val).iterator().next();
	            if (index < nums.size() - 1) {
	                int endValue = nums.get(nums.size() - 1);
	                nums.set(index, endValue);
	                map.get(endValue).remove(nums.size() - 1);
	                map.get(endValue).add(index);
	            }

	            map.get(val).remove(index);
            }
            
            if (map.get(val).size() == 0) {
                map.remove(val);
            }
            
            nums.remove(nums.size() - 1);
            return true;
        }
        else {
            return false;
        }
    }
    
    /** Get a random element from the collection. */
    public int getRandom() {
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