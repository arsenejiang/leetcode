public class RandomizedSet {
    HashMap<Integer, Integer> map;
    ArrayList<Integer> list;
    Random rand;
    /** Initialize your data structure here. */
    public RandomizedSet() {
        map = new HashMap<Integer, Integer>();
        list = new ArrayList<Integer>();
        rand = new Random();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }
        else {
            list.add(val);
            map.put(val, list.size() - 1);
            return true;
        }
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (map.containsKey(val)) {
            int index = map.get(val);
            map.remove(val);
            if (index != list.size() - 1) {
                int endValue = list.get(list.size() - 1);
                map.put(endValue, index);
                list.set(index, endValue);
            }
            
            list.remove(list.size() - 1);
            return true;
        }
        else {
            return false;
        }
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        return list.get(rand.nextInt(list.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */