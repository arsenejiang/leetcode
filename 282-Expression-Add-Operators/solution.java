public class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<String>();
        if (num == null || num.length() == 0) {
            return res;
        }
        
        helper(num, target, 0, 0, 0, "", res);
        return res;
    }
    
    private void helper(String num, int target, int startIndex, long curVal, long prevNum, String path, List<String> res) {
          int len = num.length();
          if (startIndex == len) {
              if (curVal == target) {
                  res.add(path);
              }
              return;
          }
          
          long val = 0;
          int pLen = path.length();
          for(int i = startIndex; i < len; i++) {
              if (i > startIndex && num.charAt(startIndex) == '0') {
                  break;
              }
              
              String cur = num.substring(startIndex, i + 1);
              val = val * 10 + num.charAt(i) - '0';
              if (pLen > 0) {
                  helper(num, target, i + 1, curVal + val, val, path + "+" + cur, res);
                  helper(num, target, i + 1, curVal - val, -val, path + "-" + cur, res);
                  helper(num, target, i + 1, curVal - prevNum + prevNum * val, prevNum * val, path + "*" + cur, res);
              }
              else {
                  helper(num, target, i + 1, curVal + val, val, path + cur, res);
              }
          }
    }
}