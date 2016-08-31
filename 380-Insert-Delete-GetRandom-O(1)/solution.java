public class RandomizedSet {
    private ArrayList<Integer> array;
    private HashMap<Integer, Integer> map;
    private int size;
    private Random rand;

    /** Initialize your data structure here. */
    public RandomizedSet() {
        array = new ArrayList<Integer>();
        map = new HashMap<Integer, Integer>();
        size = 0;
        rand = new Random();
        rand.setSeed(0);
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }
        else {
            array.add(size, val);
            map.put(val, size);
            size++;
            return true;
        }
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (map.containsKey(val)) {
            int index = map.get(val);
            map.remove(val);
            array.add(index, array.get(size - 1));
            map.put(array.get(index), index);
            size--;
            return true;
        }
        else {
            return false;
        }
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        int index = rand.nextInt(size);
        return array.get(index);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */