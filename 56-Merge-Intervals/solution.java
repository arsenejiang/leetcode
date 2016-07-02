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
        if(intervals == null || intervals.size() <= 1) {
            return intervals;
        }
        
        Comparator<Interval> comp = new Comparator<Interval>() {
            public int compare(Interval a, Interval b) {
                return a.start - b.start;
            }
        };
        
        List<Interval> res = new ArrayList<Interval>();
        Collections.sort(intervals, comp);
        int start = intervals.get(0).start;
        int end = intervals.get(0).end;
        for(int i = 1; i < intervals.size(); i++) {
            if (intervals.get(i).start <= end) {
                end = Math.max(end, intervals.get(i).end);
            }
            else {
                res.add(new Interval(start, end));
                start = intervals.get(i).start;
                end = intervals.get(i).end;
            }
        }
        
        res.add(new Interval(start, end));
        return res;
    }
}