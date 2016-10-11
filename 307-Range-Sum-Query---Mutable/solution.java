public class NumArray {
    int[] nums;
    int[] BIT;
    int n;
    
    public NumArray(int[] nums) {
        this.nums = new int[nums.length + 1];
        this.BIT = new int[nums.length + 1];
        for(int i = 1; i <= nums.length; i++) {
            update(i, nums[i-1]);
        }
    }

    void update(int index, int val) {
        int diff = val - nums[index ];
        for(int i = index; i < nums.length; i += (i & -i)) {
            BIT[i] += diff;
        }
        nums[index] = val;
    }

    public int sumRange(int i, int j) {
        return getSum(j + 1) - getSum(i);
    }
    
    private int getSum(int index) {
        int sum = 0;
        for(int i = index; i > 0; i -= lowbit(i)) {
            sum += BIT[i];
        }
        return sum;
    }
    
    private int lowbit(int i) {
        return (i & -i);
    }
}


// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.update(1, 10);
// numArray.sumRange(1, 2);