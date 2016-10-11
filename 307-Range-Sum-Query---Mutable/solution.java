public class NumArray {
    int[] nums;
    int[] BIT;
    int n;
    
    public NumArray(int[] nums) {
        this.nums = nums;
        n = nums.length + 1;
        this.BIT = new int[n];
        for(int i = 0; i < nums.length; i++) {
            init(i, nums[i]);
        }
    }

    void update(int i, int val) {
        int diff = val - nums[i];
        nums[i] = val;
        init(i, diff);
    }

    public int sumRange(int i, int j) {
        return getSum(j + 1) - getSum(i);
    }
    
    private int init(int index, int val) {
        index++;
        for(int i = index; i < n; i += (i & -i)) {
            BIT[i] += val;
        }
    }
    
    private int getSum(int index) {
        int sum = 0;
        for(int i = index; i > 0; i -= (i & -i)) {
            sum += BIT[i];
        }
        return sum;
    }
}


// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.update(1, 10);
// numArray.sumRange(1, 2);