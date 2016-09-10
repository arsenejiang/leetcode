public class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> res = new ArrayList<Integer>();
        if (n <= 0) {
            return res;
        }
        
        res.add(1);
        int i = 2;
        int curNum = 1;
        while(i <= n) {
            if (curNum * 10 <= n) {
                curNum = curNum * 10;
                res.add(curNum);
            }
            else {
                curNum = curNum + 1;
                while(curNum % 10 == 0) {
                    curNum = curNum / 10;
                }
                
                if (curNum <= n) {
                    res.add(curNum);
                }
                else {
                    curNum = curNum / 10 + 1;
                    res.add(curNum);
                }
            }
            
            i++;
        }
        
        return res;
    }
}