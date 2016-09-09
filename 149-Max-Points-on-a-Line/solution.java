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
        
        int maxPoint = 0;
        for (int i = 0; i < points.length; i++) {
            int localMax = 0;
            int same = 1;
            int vertical = 0, horizontal = 0;
            Map<Double, Integer> map = new HashMap<Double, Integer>();
            for (int j = i + 1; j < points.length; j++) {
                if (points[i].x == points[j].x && points[i].y == points[j].y) {
                    same++;
                    continue;
                }
                
                if (points[i].x == points[j].x) {
                    vertical++;
                    continue;
                }
                
                if (points[j].y == points[i].y) {
                    horizontal++;
                    continue;
                }
                
                double slop = (double)(points[j].y - points[i].y) / (points[j].x - points[i].x);
                if (map.containsKey(slop)) {
                    map.put(slop, map.get(slop) + 1);
                }
                else {
                    map.put(slop, 1);
                }
            }
            
            if (vertical > localMax) {
                localMax = vertical;
            }
            
            if (horizontal > localMax) {
                localMax = horizontal;
            }
            
            for(int v : map.values()) {
                if (v > localMax) {
                    localMax = v;
                }
            }
            
            maxPoint = Math.max(maxPoint, localMax + same);
        }
        
        return maxPoint;
    }
}