/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> res = new ArrayList<Interval>();
        Interval cur = newInterval;
        boolean added = false;
        for(int i = 0; i < intervals.size(); i++) {
            if (!added && cur.end < intervals.get(i).start) {
                res.add(cur);
                added = true;
                res.add(intervals.get(i));
            }
            else if (added || cur.start > intervals.get(i).end) {
                res.add(intervals.get(i));
            }
            else {
                cur = new Interval(Math.min(cur.start, intervals.get(i).start), Math.max(cur.end, intervals.get(i).end));
            }
        }
        
        if (!added) {
            res.add(cur);
        }
        
        return res;
    }
}