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
    TreeSet<Interval> set;
    /** Initialize your data structure here. */
    public SummaryRanges() {
        Comparator<Interval> comp = new Comparator<Interval>() {
            @Override
            public int compare(Interval a, Interval b) {
                return a.start - b.start;
            }
        };
        
        set = new TreeSet<Interval>(comp);
    }
    
    public void addNum(int val) {
        Interval i = new Interval(val, val);
        if (set.size() == 0) {
            set.add(i);
            return;
        }
        
        Interval floor = set.floor(i);
        Interval ceil = set.ceiling(i);
        if (floor != null && ceil != null && floor.end + 1 == val && ceil.start == val + 1) {
            set.remove(floor);
            set.remove(ceil);
            i.start = floor.start;
            i.end = ceil.end;
            set.add(i);
        }
        else if (ceil != null && ceil.start == val + 1) {
            ceil.start = val;
        }
        else if (floor != null && floor.end == val - 1) {
            floor.end = val;
        }
        else if (floor != null && floor.start <= val && floor.end >= val) {
            
        }
        else {
            set.add(i);
        }
    }
    
    public List<Interval> getIntervals() {
        List<Interval> res = new ArrayList<Interval>();
        for(Interval i : set) {
            res.add(i);
        }
        return res;
    }
}

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(val);
 * List<Interval> param_2 = obj.getIntervals();
 */