/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class Solution {
    // recursive solution
    /*
    public NestedInteger deserialize(String s) {
        NestedInteger res = new NestedInteger();
        if (s == null || s.length() == 0) {
            return res;
        }
        
        if (s.charAt(0) != '[') {
            res.setInteger(Integer.valueOf(s));
        }
        else if (s.length() > 2) {
            int start = 1, count = 0;
            for(int i = 1; i < s.length(); i++) {
                char c = s.charAt(i);
                if (count == 0 && (c == ',' || i == s.length() - 1)) {
                    res.add(deserialize(s.substring(start, i)));
                    start = i + 1;
                }
                else if (c == '[') {
                    count++;
                }
                else if (c == ']') {
                    count--;
                }
            }
        }
        
        return res;
    }
    */
    
    public NestedInteger deserialize(String s) {
        if (s == null) {
            return null;
        }
        else if (s.isEmpty()) {
            return new NestedInteger(Integer.valueOf(s));
        }
        
        Stack<NestedInteger> stack = new Stack<NestedInteger>();
        NestedInteger cur = null;
        int start = 0;
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '[') {
                if (cur != null) {
                    stack.push(cur);
                }
                cur = new NestedInteger();
                start = i + 1;
            }
            else if (c == ']') {
                String num = s.substring(start, i);
                if (!num.isEmpty()) {
                    cur.add(new NestedInteger(Integer.valueOf(num)));
                }
                if (!stack.isEmpty()) {
                    NestedInteger pop = stack.pop();
                    pop.add(cur);
                    cur = pop;
                }
                
                start = i + 1;
            } else if (ch == ',') {
                if (s.charAt(i-1) != ']') {
                    String num = s.substring(start, i);
                    curr.add(new NestedInteger(Integer.valueOf(num)));
                }
                start = i + 1;
            }
        }
    
        return curr;
    }
}