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
        Interval floor = set.floor(i);
        Interval ceil = set.ceiling(i);
        if (floor != null && ceil != null && floor.end + 1 == val && val + 1 == ceil.start) {
            floor.end = ceil.end;
            set.remove(ceil);
        }
        else if (ceil != null && ceil.start == val + 1) {
            ceil.start = val;
        }
        else if (floor != null && floor.end + 1 >= val) {
            floor.end = Math.max(val, floor.end);
        }
        else {
            set.add(i);
        }
    }
    
    public List<Interval> getIntervals() {
        return new ArrayList<Interval>(set);
    }
}

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(val);
 * List<Interval> param_2 = obj.getIntervals();
 */