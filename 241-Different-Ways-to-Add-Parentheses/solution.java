public class Solution {
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> res = new ArrayList();
        if (input == null || input.length() == 0) {
            return res;
        }
        
        int len = input.length();
        for(int i = 0; i < len; i++) {
            char c = input.charAt(i);
            if (c == '*' || c == '+' || c == '-') {
                List<Integer> left = diffWaysToCompute(input.substring(0, i));
                List<Integer> right = diffWaysToCompute(input.substring(i+1));
                for(int l : left) {
                    for(int r : right) {
                        switch(c) {
                            case '*':
                                res.add(l*r);
                                break;
                            case '+':
                                res.add(l+r);
                                break;
                            case '-':
                                res.add(l-r);
                                break;
                        }
                    }
                }
            }
        }
        
        if (res.size() == 0) {
            res.add(Integer.parseInt(input));
        }
        
        return res;
    }
}