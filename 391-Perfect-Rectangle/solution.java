public class Solution {
    public boolean isRectangleCover(int[][] rectangles) {
        if (rectangles == null || rectangles.length == 0 || rectangles[0].length == 0) {
            return true;
        }
        
        int x1 = Integer.MAX_VALUE;
        int y1 = Integer.MAX_VALUE;
        int x2 = Integer.MIN_VALUE;
        int y2 = Integer.MIN_VALUE;
        int area = 0;
        HashSet<String> set = new HashSet<String>();
        for(int[] rect : rectangles) {
            x1 = Math.min(rect[0], x1);
            y1 = Math.min(rect[1], y1);
            x2 = Math.max(rect[2], x2);
            y2 = Math.max(rect[3], y2);
            
            area += (rect[3] - rect[1]) * (rect[2] - rect[0]);
            String[] strs = new String[] {rect[0] + " " + rect[1], rect[0] + " " + rect[3], rect[2] + " " + rect[1], rect[2] + " " + rect[3]};
            for(String str : strs) {
                if (set.contains(str)) {
                    set.remove(str);
                }
                else {
                    set.add(str);
                }
            }
        }
        
        if (!set.contains(x1 + " " + y1) || !set.contains(x1 + " " + y2) || !set.contains(x2 + " " + y1) || !set.contains(x2 + " " + y2) || set.size() != 4) {
            return false;
        }
        
        int totalArea = (y2 - y1) * (x2 - x1);
        return totalArea == area;
    }
}