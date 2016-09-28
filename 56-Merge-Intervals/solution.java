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
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> res = new ArrayList<Interval>();
        if (intervals == null || intervals.size() == 0) {
            return res;
        }
        
        Comparator<Interval> comp = new Comparator<Interval>() {
            @Override
            public int compare(Interval a, Interval b) {
                if (a.start != b.start) {
                    return a.start - b.start;
                }
                
                return b.end - a.end;
            }
        };
        
        Collections.sort(intervals, comp);
        
        Interval cur = intervals.get(0);
        for(int i = 1; i < intervals.size(); i++) {
            if (intervals.get(i).start > cur.end) {
                res.add(new Interval(cur.start, cur.end));
                cur = intervals.get(i);
            }
            else {
                cur.end = Math.max(cur.end, intervals.get(i).end);
            }
        }
        
        res.add(new Interval(cur.start, cur.end));
        return res;
    }
}