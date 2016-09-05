public class Solution {
    /*
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<String>();
        if (s == null || s.length() < 4) {
            return res;
        }
        
        List<String> path = new ArrayList<String>();
        helper(s, 0, path, res);
        return res;
    }
    
    private void helper(String s, int start, List<String> path, List<String> res) {
        if (start == s.length() || path.size() >= 4) {
            if (start == s.length() && path.size() == 4) {
                StringBuilder sb = new StringBuilder(path.get(0));
                for(int i = 1; i < 4; i++) {
                    sb.append('.');
                    sb.append(path.get(i));
                }
                res.add(sb.toString());
            }
            return;
        }
        
        for(int j = start; j < s.length() && j < start + 3; j++) {
            if (s.charAt(start) == '0' && j > start) {
                break;
            }
            
            int val = Integer.valueOf(s.substring(start, j + 1));
            if (val >= 0 && val <= 255) {
                path.add(Integer.toString(val));
                helper(s, j + 1, path, res);
                path.remove(path.size() - 1);
            }
        }
    }
    */
    
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<String>();
        int len = s.length();
        for(int i = 1; i<4 && i<len-2; i++){
            for(int j = i+1; j<i+4 && j<len-1; j++){
                for(int k = j+1; k<j+4 && k<len; k++){
                    String s1 = s.substring(0,i), s2 = s.substring(i,j), s3 = s.substring(j,k), s4 = s.substring(k,len);
                    if(isValid(s1) && isValid(s2) && isValid(s3) && isValid(s4)){
                        res.add(s1+"."+s2+"."+s3+"."+s4);
                    }
                }
            }
        }
        return res;
    }
    public boolean isValid(String s){
        if(s.length()>3 || s.length()==0 || (s.charAt(0)=='0' && s.length()>1) || Integer.parseInt(s)>255)
            return false;
        return true;
    }
}