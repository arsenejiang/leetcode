public class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList();
        int[] pos = new int[n];
        helper(res, pos, 0);
        return res;
    }
    
    private void helper(List<List<String>> res, int[] pos, int row) {
        if (row == pos.length) {
            List<String> list = new ArrayList();
            for(int i = 0; i < pos.length; i++) {
                StringBuilder sb = new StringBuilder();
                for(int j = 0; j < pos[i]; j++) {
                    sb.append('.');
                }
                sb.append('Q');
                for(int j = pos[i] + 1; j < pos.length; j++) {
                    sb.append('.');
                }
                list.add(sb.toString());
            }
            res.add(list);
        }
        else {
            for(int i = 0; i < pos.length; i++) {
                pos[row] = i;
                if (isValid(pos, row)) {
                    helper(res, pos, row + 1);
                }
            }
        }
    }
    
    private boolean isValid(int[] pos, int row) {
        for(int i = 0; i < row; i++) {
            if (pos[i] == pos[row] || Math.abs(pos[i] - pos[row]) == Math.abs(i - row)) {
                return false;
            }
        }
        
        return true;
    }
}