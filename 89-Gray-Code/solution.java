public class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<Integer>();
        res.add(0);
        if (n == 0) {
            return res;
        }
        
        res.add(1);
        for(int i = 2; i <= n; i++) {
            int size = res.size();
            for(int j = size - 1; j >= 0; j--) {
                int val = res.get(j) | (1 << (i - 1));
                res.add(val);
            }
        }
        
        return res;
    }
}