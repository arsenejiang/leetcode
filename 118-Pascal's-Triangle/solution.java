public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList();
        if (numRows <= 0) {
            return res;
        }
        
        for(int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList();
            int j = 0;
            while(j < i + 1) {
                if (j == 0 || j == i) {
                    row.add(1);
                }
                else {
                    row.add(res.get(i-1).get(j-1) + res.get(i-1).get(j));
                }
                j++;
            }
            res.add(row);
        }
        
        return res;
    }
}