public class Solution {
    public boolean isRectangleCover(int[][] rectangles) {
        if (rectangles == null || rectangles.length == 0 || rectangles[0].length == 0) {
            return false;
        }
        
        long areaSum = 0;
        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE;
        int maxY = Integer.MIN_VALUE;
        HashSet<String> map = new HashSet<String>();
        for(int[] rect : rectangles) {
            areaSum += (rect[3] - rect[1]) * (rect[2] - rect[0]);
            minX = Math.min(minX, rect[0]);
            minY = Math.min(minY, rect[1]);
            maxX = Math.max(maxX, rect[2]);
            maxY = Math.max(maxY, rect[3]);
            
            String s1 = rect[0] + " " + rect[1];
            String s2 = rect[2] + " " + rect[3];
            if (set.contains(s1)) {
                set.remove(s1);
            }
            else {
                set.add(s1);
            }
            
            if (set.contains(s2)) {
                set.remove(s2);
            }
            else {
                set.add(s2);
            }
        }
        
        if (!set.contains(minX + " " + minY) || !set.contains(minx + " " + maxY) || !set.contains(maxX + " " + minY) || !set.contains(maxX + " " + maxY)) {
            return false;
        }
        
        return areaSum == (maxY - minY) * (maxX - minX);
    }
}