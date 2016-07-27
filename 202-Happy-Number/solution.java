public class Solution {
    public boolean isHappy(int n) {
        Set<Integer> visited = new HashSet();
        while(n != 1) {
            if (visited.contains(n)) {
                return false;
            }
            
            n = getNext(n);
        }
        
        return true;
    }
    
    private int getNext(int n) {
        int sum = 0;
        while(n > 0) {
            sum += (n % 10) * (n % 10);
            n = n / 10;
        }
        
        return sum;
    }
}