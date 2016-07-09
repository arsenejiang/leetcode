public class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<Integer>();
        if (n < 0) {
            return res;
        }
        
        res.add(0);
        
        if (n == 0) {
            return res;
        }
        
        res.add(1);
        for(int i = 2; i <= n; i++) {
            List<Integer> newList = new ArrayList(res);
            int add = 1 << (i - 1);
            for(int j = newList.size() - 1; j >= 0; j--) {
                res.add(newList.get(j) + add); 
            }
        }
        
        return res;
    }
}