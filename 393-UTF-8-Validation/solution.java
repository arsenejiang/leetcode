public class Solution {
    public boolean validUtf8(int[] data) {
        return helper(data, 0);
    }
    
    private boolean helper(int[] data, int start) {
        if (start == data.length) {
            return true;
        }
        
        int count = numberOfLeadingOnes(data[start]);
        if (count == 0) {
            return helper(data, start + 1);
        }
        else if (count == 1) {
            return false;
        }
        else {
            int i = 1;
            while(i < count) {
                if ((data[start + i] & 0x80) != 0x80) {
                    return false;
                }
                i++;
            }
            
            return helper(data, start + count);
        }
    }
    
    private int numberOfLeadingOnes(int num) {
        int count = 0;
        int start = 0x80;
        while((num & start) != 0) {
            count++;
            start = start >>> 1;
        }
        
        return count;
    }
}