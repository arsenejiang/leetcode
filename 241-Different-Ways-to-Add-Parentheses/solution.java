public class Solution {
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> res = new ArrayList<Integer>();
        if (input == null || input.length() == 0) {
            return res;
        }
        
        HashMap<String, List<Integer>> map = new HashMap<String, List<Integer>>();
        return helper(input, map);
    }
    
    private List<Integer> helper(String input, HashMap<String, List<Integer>> map) {
        if (map.containsKey(input)) {
            return map.get(input);
        }
        
        boolean isNumber = true;
        List<Integer> list = new ArrayList<Integer>();
        for(int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (!Character.isDigit(c)) {
                isNumber = false;
                List<Integer> left = helper(input.substring(0, i), map);
                List<Integer> right = helper(input.substring(i + 1), map);
                for(int l : left) {
                    for(int r : right) {
                        int val = 0;
                        if (c == '*') {
                            val = l * r;
                        }
                        else if (c == '-') {
                            val = l - r;
                        }
                        else if (c == '+') {
                            val = l + r;
                        }
                        
                        list.add(val);
                    }
                }
            }
        }
        
        if (isNumber) {
            list.add(Integer.valueOf(input));
        }
        
        map.put(input, list);
        
        return list;
    }
}