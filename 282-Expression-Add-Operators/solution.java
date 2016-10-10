public class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<String>();
        helper(num, target, "", 0, 0, 0, res);
        return res;
    }
    
    private void helper(String num, int target, String path, int index, long curVal, long prevNum, List<String> res) {
        if (index == num.length()) {
            if (target == curVal) {
                res.add(path);
            }
            
            return;
        }
        
        for(int i = index; i < num.length(); i++) {
            if (i > index && num.charAt(index) == '0') {
                break;
            }
            
            long cur = Long.parseLong(num.substring(index, i + 1));
            if (index == 0) {
                helper(num, target, path + cur, i + 1, curVal + cur, cur, res);
            }
            else {
                helper(num, target, path + "+" + cur, i + 1, curVal + cur, cur, res);
                helper(num, target, path + "-" + cur, i + 1, curVal - cur, -cur, res);
                helper(num, target, path + "*" + cur, i + 1, curVal - prevNum + prevNum * cur, prevNum * cur, res);
            }
        }
    }
}