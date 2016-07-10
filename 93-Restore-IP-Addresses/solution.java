public class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList();
        if (s == null || s.length() == 0) {
            return result;
        }
        
        List<StringBuilder> sbList = new ArrayList();
        sbList = helper(s, 4);
        for(StringBuilder sb : sbList) {
            result.add(sb.toString());
        }
        
        return result;
    }
    
    private List<StringBuilder> helper(String s, int part) {
        List<StringBuilder> res = new ArrayList();
        if (s.length() == 0) {
            return res;
        }
        
        int len = s.length();
        
        if (part == 1) {
            int val = Integer.parseInt(s);
            if (val >= 0 && val <= 255) {
                res.add(new StringBuilder(s));
            }
        }
        else {
            for(int i = 1; i <= 3 && i <= len; i++) {
                String sub = s.substring(0, i);
                int val = Integer.parseInt(sub);
                if (val < 0 && val > 255) {
                    continue;
                }
                
                List<StringBuilder> subList = helper(s.substring(i), part - 1);
                if (!subList.isEmpty()) {
                    for(StringBuilder sb : subList) {
                        sb.insert(0, sub + ".");
                    }
                }
                
                res.addAll(subList);
            }
        }
        
        return res;
    }
}