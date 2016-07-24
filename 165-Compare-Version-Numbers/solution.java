public class Solution {
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.trim().split("\\.");
        String[] v2 = version2.trim().split("\\.");
        int len1 = v1.length;
        int len2 = v2.length;
        int len = Math.max(len1, len2);
        for(int i = 0; i < len; i++) {
            int n1 = (i >= len1) ? 0 : Integer.parseInt(v1[i]);
            int n2 = (i >= len2) ? 0 : Integer.parseInt(v2[i]);
            if (n1 < n2) {
                return -1;
            }
            else if (n1 > n2) {
                return 1;
            }
        }
        
        return 0;
    }
}