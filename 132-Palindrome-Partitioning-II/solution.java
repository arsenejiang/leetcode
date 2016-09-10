public class Solution {
    public int minCut(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        
        char[] arr = s.toCharArray();
        int[] dp = new int[s.length() + 1];
        dp[0] = -1;
        for(int i = 0; i < s.length(); i++) {
            int localMin = dp[i] + 1;
            for(int j = 0; j < i; j++) {
                if (isPalindrome(arr, j, i)) {
                    localMin = Math.min(localMin, dp[j] + 1);
                }
            }
            dp[i + 1] = localMin;
        }
        
        return dp[s.length()];
    }
    
    private boolean isPalindrome(char[] arr, int left, int right) {
        if (left >= right) {
            return true;
        }
        
        while(left < right) {
            if (arr[left] == arr[right]) {
                left++;
                right--;
            }
            else {
                return false;
            }
        }
        
        return true;
    }
}