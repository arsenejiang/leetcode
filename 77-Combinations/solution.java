public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        if (k == n || k == 0) {
            List<Integer> row = new LinkedList<>();
            for (int i = 1; i <= k; ++i) {
                row.add(i);
            }
            return new LinkedList<>(Arrays.asList(row));
        }
        
        List<List<Integer>> result = combine(n - 1, k - 1);
        for(List<Integer> list : result) {
            list.add(n);
        }
        res.addAll(combine(n-1, k));
        return res;
    }
}