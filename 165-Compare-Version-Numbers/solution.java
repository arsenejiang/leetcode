public class Solution {
    public int compareVersion(String version1, String version2) {
        if (version1 == null && version2 == null) {
            return 0;
        }
        else if (version1 == null) {
            return -1;
        }
        else if (version2 == null) {
            return 1;
        }
        
        if (version1.equals(version2)) {
            return 0;
        }
        
        String[] arr1 = version1.split("\\.");
        String[] arr2 = version2.split("\\.");
        
        int i = 0, j = 0;
        while(i < arr1.length || j < arr2.length) {
            int v1 = i < arr1.length ? Integer.valueOf(arr1[i]) : 0;
            int v2 = j < arr2.length ? Integer.valueOf(arr2[j]) : 0;
            if (v1 < v2) {
                return -1;
            }
            else if (v1 > v2) {
                return 1;
            }
            else {
                i++;
                j++;
            }
        }
        
        return 0;
    }
}