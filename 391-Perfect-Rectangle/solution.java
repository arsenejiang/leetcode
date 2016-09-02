public class Solution {
    public boolean isRectangleCover(int[][] rectangles) {
        if (rectangles == null || rectangles.length == 0 || rectangles[0].length == 0) {
            return false;
        }
        
        int areaSum = 0;
        int x1 = Integer.MAX_VALUE;
        int y1 = Integer.MAX_VALUE;
        int x2 = Integer.MIN_VALUE;
        int y2 = Integer.MIN_VALUE;
        HashSet<String> set = new HashSet<String>();
        for(int[] rect : rectangles) {
            areaSum += (rect[3] - rect[1]) * (rect[2] - rect[0]);
            x1 = Math.min(x1, rect[0]);
            y1 = Math.min(y1, rect[1]);
            x2 = Math.max(x2, rect[2]);
            y2 = Math.max(y2, rect[3]);
            
            String[] s = new String[] { rect[0] + " " + rect[1], rect[0] + " " + rect[3], 
                rect[2] + " " + rect[1], rect[2] + " " + rect[3]};
            
            for(String str : s) {
                if (set.contains(str)) {
                    set.remove(str);
                }
                else {
                    set.add(str);
                }
            }
        }
        
        if (!set.contains(x1 + " " + y1) || !set.contains(x2 + " " + y2) || !set.contains(x1 + " " + y2) || !set.contains(x2 + " " + y1) || set.size() != 4){
            return false;
        }
        
        return areaSum == (y2 - y1) * (x2 - x1);
    }
}