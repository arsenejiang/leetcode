public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        return helper(s1, 0, s2, 0, s3, 0);
    }
    
    private boolean helper(String s1, int i1, String s2, int i2, String s3, int i3) {
        int l1 = s1.length();
        int l2 = s2.length();
        int l3 = s3.length();
        if (l1 - i1 + l2 - i2 != l3 - i3) {
            return false;
        }
        
        if (l1 == i1) {
            return s2.substring(i2).equals(s3.substring(i3));
        }
        else if (l2 == i2) {
            return s1.substring(i1).equals(s3.substring(i3));
        }
        
        if(s1.charAt(i1) != s3.charAt(i3) && s2.charAt(i2) != s3.charAt(i3)) {
            return false;
        }
        
        boolean r1 = false, r2 = false;
        if (s1.charAt(i1) == s3.charAt(i3)) {
            r1 = helper(s1, i1 + 1, s2, i2, s3, i3 + 1);
        }
        
        if (r1 == true) {
            return true;
        }
        
        if (s2.charAt(i2) == s3.charAt(i3)) {
            r2 = helper(s1, i1, s2, i2 + 1, s3, i3 + 1);
        }
        
        return r2;
    }
}