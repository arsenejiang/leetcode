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
        else if (c != null && val + 1 == c) {
            Interval i = map.get(c);
            i.start = val;
            map.remove(c);
            map.put(val, i);
        }
        else if (f != null && map.get(f).end + 1 >= val) {
            map.get(f).end = Math.max(map.get(f).end, val);
        }
        else {
            Interval i = new Interval(val, val);
            map.put(val, i);
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