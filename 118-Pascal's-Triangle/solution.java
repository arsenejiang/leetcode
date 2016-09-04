public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (numRows == 0) {
            return res;
        }
        
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        res.add(list);
        for(int i = 2; i <= numRows; i++) {
            list = new ArrayList<Integer>();
            for(int j = 0; j <= i - 1; j++) {
                if (j == 0 || j == i - 1) {
                    list.add(1);
                }
                else {
                    list.add(res.get(i - 2).get(j - 1) + res.get(i - 2).get(j));
                }
            }
            res.add(list);
        }
        
        return res;
    }
}