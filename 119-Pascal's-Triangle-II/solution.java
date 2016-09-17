public class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<Integer>();
        if (rowIndex < 0) {
            return res;
        }
        
        int[] arr = new int[rowIndex + 1];
        arr[0] = 1;
        for(int i = 0; i <= rowIndex; i++) {
            arr[i] = 1;
            for(int j = i - 1; j > 0; j--) {
                arr[j] = arr[j] + arr[j-1];
            }
        }
        
        for(int num : arr) {
            res.add(num);
        }
        
        return res;
    }
}