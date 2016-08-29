/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class SummaryRanges {
    TreeMap<Integer, Interval> map;

    /** Initialize your data structure here. */
    public SummaryRanges() {
        map = new TreeMap<Integer, Interval>();
    }
    
    public void addNum(int val) {
        if (map.containsKey(val)) {
            return;
        }
        
        Integer c = map.ceilingKey(val);
        Integer f = map.floorKey(val);
        if (c != null && f != null && map.get(f).end + 1 == val && val + 1 == c) {
            map.get(f).end = map.get(c).end;
            map.remove(c);
        }
        else if (f != null && map.get(f).end + 1 >= val) {
            map.get(f).end = Math.max(map.get(f).end, val);
        }
        else if (c != null && val + 1 == c) {
            map.put(val, new Interval(val, map.get(c).end));
            map.remove(c);
        }
        else {
            map.put(val, new Interval(val, val));
        }
    }
    
    public List<Interval> getIntervals() {
        return new ArrayList<Interval>(map.values());
    }
}

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(val);
 * List<Interval> param_2 = obj.getIntervals();
 */