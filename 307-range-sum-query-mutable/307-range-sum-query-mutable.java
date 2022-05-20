class NumArray {
    int[][] list;
    int[] sum;
    int len;

    public NumArray(int[] nums) {
        len = (int)Math.sqrt(nums.length);
        if(len*len<nums.length){
            len++;
        }
        list = new int[len][len];
        sum = new int[len];
        for(int i=0; i<nums.length; i++){
            int x = i/len;
            int y = i%len;
            list[x][y] = nums[i];
            sum[x] += nums[i];
        }
    }
    
    public void update(int index, int val) {
        int x = index/len;
        int y = index%len;
        int differ = val - list[x][y];
        if(differ!=0){
            list[x][y] = val;
            sum[x] += differ;
        }
    }
    
    public int sumRange(int left, int right) {
        int result = 0;
        int lx = left/len;
        int ly = left%len;
        int rx = right/len;
        int ry = right%len;
        for(int i=lx+1; i<rx; i++){
            result += sum[i];
        }
        if(lx==rx){
            for(int i=ly; i<=ry; i++){
                result+=list[lx][i];
            }
        }else{
            for(int i=ly; i<len; i++){
                result += list[lx][i];
            }
            for(int i=0; i<=ry; i++){
                result += list[rx][i];
            }
        }
        
        return result;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */