public class Solution {
    private final static char[] operators = new char[] {'*', '+', '-'};
    
    public List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<String>();
        if (num == null || num.length() == 0) {
            return res;
        }
        
        Map<String, Long> map = new HashMap<String, Long>();
        Set<String> set = helper(num, 0, num.length() - 1, map);
        
        for(String s : set) {
            if (map.get(s) == target) {
                res.add(s);
            }
        }
        
        return res;
    }
    
    private Set<String> helper(String num, int start, int end, Map<String, Long> map) {
        Set<String> res = new HashSet();
        if (start > end) {
            return res;
        }
        
        String s = num.substring(start, end + 1);
        if (!map.containsKey(s)) {
            map.put(s, Long.parseLong(s));
        }
        res.add(s);
        
        for(int i = start; i <= end - 1; i++) {
            Set<String> left = helper(num, start, i, map);
            Set<String> right = helper(num, i + 1, end, map);
            for(String l : left) {
                int lv = map.get(l);
                for(String r : right) {
                    int rv = map.get(r);
                    String temp;
                    for(char o : operators) {
                        switch(o) {
                            case '*' :
                                temp = l + "*" + r;
                                if (!res.contains(temp)) {
                                    res.add(temp);
                                    if (!map.containsKey(temp)) {
                                        map.put(temp, lv*rv);
                                    }
                                }
                            case '+' :
                                temp = l + "+" + r;
                                if (!res.contains(temp)) {
                                    res.add(temp);
                                    if (!map.containsKey(temp)) {
                                        map.put(temp, lv+rv);
                                    }
                                }
                            case '-' :
                                temp = l + "-" + r;
                                if (!res.contains(temp)) {
                                    res.add(temp);
                                    if (!map.containsKey(temp)) {
                                        map.put(temp, lv-rv);
                                    }
                                }
                        }
                    }
                }
            }
        }
        
        return res;
    }
}