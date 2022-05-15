class Solution {
    public void rotate(int[] nums, int k) {
        boolean[] check = new boolean[nums.length];
        int before=nums[0];
        int idx = 0;
        k = k%nums.length;
        if(k!=0){
            for(int i=0; i<nums.length; i++){
                idx += k;
                idx = idx%nums.length;
                if(check[idx]){
                    while(check[idx]){
                        idx++;
                        if(idx==nums.length){
                            idx = 0;
                        }
                    }
                    before = nums[idx];
                    idx += k;
                    idx = idx%nums.length;
                }
                int tmp = nums[idx];
                nums[idx] = before;
                before = tmp;
                check[idx]=true;
            }
        }
    }
}