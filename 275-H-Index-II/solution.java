public class Solution {
    public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0) {
            return 0;
        }
        
        int left = 0;
        int len = citations.length;
        int right = len - 1;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if (citations[mid] == len - mid) {
                return len - mid;
            }
            if (citations[mid] < len - mid) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }
        
        return len - left;
    }
}