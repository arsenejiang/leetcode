public class RandomizedCollection {
    Map<Integer, Set<Integer>> map;
    ArrayList<Integer> list;
    Random rand;
    
    /** Initialize your data structure here. */
    public RandomizedCollection() {
        map = new HashMap<Integer, Set<Integer>>();
        list = new ArrayList<Integer>();
        rand = new Random();
    }
    
    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        if(!map.containsKey(val)) {
            list.add(val);
            HashSet<Integer> set = new HashSet<Integer>();
            set.add(list.size() - 1);
            map.put(val, set);
            return false;
        }
        else {
            return true;
        }
    }
    
    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }
        else {
            Set<Integer> set = map.get(val);
            if (set.contains(list.size() - 1)) {
                set.remove(list.size() - 1);
            }
            else {
                int removeIndex = set.iterator().next();
                set.remove(removeIndex);
                int lastValue = list.get(list.size() - 1);
                list.set(removeIndex, lastValue);
                map.get(lastValue).remove(list.size() - 1);
                map.get(lastValue).add(removeIndex);
            }
            
            if (set.size() == 0) {
                map.remove(val);
            }

            list.remove(list.size() - 1);
            return true;
        }
    }
    
    /** Get a random element from the collection. */
    public int getRandom() {
        return list.get(rand.nextInt(list.size()));
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */