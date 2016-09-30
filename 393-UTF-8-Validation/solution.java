public class Solution {
    public boolean validUtf8(int[] data) {
        if (data == null || data.length == 0) {
            return true;
        }
        
        for(int i = 0; i < data.length; i++) {
            int count = countOfLeadingOneBit(data[i]);
            if (count == 0) {
                continue;
            }
            else if (count >= 2 && count <= 4) {
                int j = 0;
                for(j = i + 1; j < i + count && j < data.length; j++) {
                    if (countOfLeadingOneBit(data[j]) != 1) {
                        return false;
                    }
                }
                
                if (j != i + count) {
                    return false;
                }
                
                i = i + count - 1;
            }
            else {
                return false;
            }
        }
        
        return true;
    }
    
    private int countOfLeadingOneBit(int data) {
        if ((data >> 7) == 0) {
            return 0;
        }
        else if ((data >> 6) == 0b10) {
            return 1;
        }
        else if ((data >> 5) == 0b110) {
            return 2;
        }
        else if ((data >> 4) == 0b1110) {
            return 3;
        }
        else if ((data >> 3) == 0b11110) {
            return 4;
        }
        else {
            return 5;
        }
    }
}