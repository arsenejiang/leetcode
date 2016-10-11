public class NumArray {
    int[] nums;
    int[] BIT;
    
    public NumArray(int[] nums) {
        this.nums = nums;
        n = nums.length;
        this.BIT = new int[n + 1];
        for(int i = 0; i < n; i++) {
            init(i, nums[i]);
        }
    }

    void update(int i, int val) {
        int diff = val - nums[i];
        num[i] = val;
        init(i, diff);
    }

    public int sumRange(int i, int j) {
        return getSum(j) - getSum(i - 1);
    }
    
    private void init(int i, int val) {
        i++;
        while(i <= n) {
            BIT[i] += val;
            i = (i & - i) << 1;
        }
    }
    
    private int getSum(int i) {
        int sum = 0;
        i++;
        while(i > 0) {
            sum += BIT[i];
            i = i << 1;
        }
        return sum;
    }
}


// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.update(1, 10);
// numArray.sumRange(1, 2);