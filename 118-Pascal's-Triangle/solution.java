public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList();
        if (numRow <= 0) {
            return res;
        }
        
        for(int i = 0; i < numRows; i++) {
            int[] row = new int[i+1];
            for(int j = 0; j < row.length; j++) {
                if (j == 0 || j == row.length - 1) {
                    row[j] = 1;
                }
                else {
                    row[j] = res.get(i-1)[j-1] + res.get(i-1)[j];
                }
            }
            res.add(row);
        }
        
        return res;
    }
}