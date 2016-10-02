public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<String>();
        if (n == 0) {
            return res;
        }
        
        helper(n, n, 0, "", res);
        return res;
    }
    
    private void helper(int left, int right, int count, String cur, List<String> res) {
        if (left == 0 && right == 0 && count == 0) {
            res.add(cur);
            return;
        }
        
        if (count < 0 || left < 0 || right < 0) {
            return;
        }
        
        helper(left - 1, right, count + 1, cur + "(", res);
        helper(left, right - 1, count - 1, cur + ")", res);
    }
}