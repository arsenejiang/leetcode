public class Solution {
    private int[] factorial;
    
    public String getPermutation(int n, int k) {
        if (n <= 0) {
            return "";
        }
        
        factorial = new int[n+1];
        factorial[0] = 1;
        for(int i = 1; i < n+1; i++) {
            factorial[i] = i*factorial[i-1];
        }
        
        StringBuilder sb = new StringBuilder();
        List<Integer> list = new ArrayList();
        for(int i = 1; i <= n; i++) {
            list.add(i);
        }
        sb.append(helper(list, k - 1));
        return sb.toString();
    }
    
    private String helper(List<Integer> candidates, int k) {
        int size = candidates.size();
        if (size == 0) {
            return "";
        }
        
        // size of each group
        int stepLength = factorial[size]/size; 
        
        // group index
        int index = k / stepLength;
        
        // leftover numbers
        int left = k - index * stepLength;
        
        int val = candidates.remove(index);
        return val + helper(candidates, left);
    }
}