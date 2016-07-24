/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
public class Solution {
    public int maxPoints(Point[] points) {
        if (points == null || points.length == 0) {
            return 0;
        }
        else if (points.length == 1) {
            return 1;
        }
        
        int len = points.length;
        int res = 0;
        for(int i = 0; i < len; i++) {
            Map<Double, Integer> map = new HashMap();
            int same = 0;
            int localMax = 1;
            for(int j = 0; j < len; j++) {
                if (i == j) {
                    continue;
                }
                
                if (points[j].x == points[i].x && points[j].y == points[j].y) {
                    same++;
                    continue;
                }
                
                double slop = ((double)(points[j].y - points[i].y))/ (points[j].x - points[i].x);
                if (map.containsKey(slop)) {
                    int count = map.get(slop) + 1;
                    map.put(slop, count);
                }
                else {
                    map.put(slop, 2);
                }
            }
            
            for(Integer value : map.values) {
                localMax = Math.max(localMax, value);
            }
            
            res = Math.max(res, localMax + same);
        }
        
        return res;
    }
}