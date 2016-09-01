public class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> res = new ArrayList();
        if (n <= 0) {
            return res;
        }
        
        res.add(1);
        int curNum = 1;
        int i = 2;
        while(i <= n) {
            if (curNum * 10 <= n) {
                curNum = curNum * 10;
                res.add(curNum);
                i++;
            }
            else {
                curNum = curNum + 1;
                while(curNum % 10 == 0) {
                    curNum = curNum / 10;
                }
                
                if (curNum <= n) {
                    res.add(curNum);
                    i++;
                }
                else {
                    curNum = curNum - 1;
                    if (curNum / 10 > 0) {
                        curNum = curNum / 10;
                    }
                    
                    curNum = curNum + 1;
                    if (curNum <= n) {
                        res.add(curNum);
                        i++;
                    }
                }
            }
        }
        
        return res;
    }
}