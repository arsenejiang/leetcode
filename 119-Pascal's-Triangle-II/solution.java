public class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList();
        if (rowIndex < 0) {
            return res;
        }
        
        Integer[] arr = new Integer[rowIndex + 1];
        for(int i = 0; i <= rowIndex; i++) {
            arr[i] = 1;
            for(int j = i - 1; j > 0; j--) {
                arr[j] = arr[j] + arr[j-1];
            }
        }
        
        return Arrays.asList(arr);
    }
}