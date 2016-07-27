public class Solution {
    public boolean isHappy(int n) {
        Set<Integer> visited = new HashSet();
        visited.add(n);
        while(n != 1) {
            int value = 0;
            while (n > 0) {
                value += (n % 10) * (n % 10);
                n = n / 10;
            }
            if (visited.contains(value)) {
                return false;
            }
        }
        
        return true;
    }
}