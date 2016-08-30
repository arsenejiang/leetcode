public class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> res = new ArrayList();
        if (nums == null || nums.length == 0) {
            return res;
        }
        
        Arrays.sort(nums);
        
        List<List<Integer>> sets = new ArrayList();
        for(int i = 0; i < nums.length; i++) {
            helper(nums, i, sets);
        }
        
        int maxSize = 0;
        for(List<Integer> list : sets) {
            if (list.size() > maxSize) {
                maxSize = list.size();
                res = list;
            }
        }
        return res;
    }
    
    private void helper(int[] nums, int index, List<List<Integer>> set) {
        int size = set.size();
        for(int i = 0; i < size; i++) {
            List<Integer> list = set.get(i);
            boolean valid = true;
            for(int j = list.size() - 1; j >= 0; j--) {
                if (!isValidPair(nums[index], list.get(j))) {
                    valid = false;
                    break;
                }
            }
            
            if (valid) {
                set.add(new ArrayList(list));
                list.add(nums[index]);
            }
        }
        
        List<Integer> emptyList = new ArrayList();
        emptyList.add(nums[index]);
        set.add(emptyList);
    }
    
    private boolean isValidPair(int a, int b) {
        return a % b == 0;
    }
}