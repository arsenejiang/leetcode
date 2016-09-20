public class Solution {
    public boolean isHappy(int n) {
        if (n <= 0) {
            return false;
        }
        
        HashSet<Integer> set = new HashSet<Integer>();
        while(n != 1) {
            int val = 0;
            while(n != 0) {
                val += (n % 10) * (n % 10);
                n = n / 10;
            }
            
            n = val;
            if (n == 1) {
                return true;
            }
            else if (set.contains(n)) {
                return false;
            }
            else {
                set.add(n);
            }
        }
        
        return true;
    }
}