class NumArray {
    int[] nums;
    int[] sum;

    public NumArray(int[] nums) {
        this.nums = nums;
        sum = new int[nums.length+1];
        for(int i=0; i<nums.length; i++){
            sum[i+1]=sum[i] + nums[i];
        }
    }
    
    public int sumRange(int left, int right) {
        return sum[right+1]-sum[left];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */