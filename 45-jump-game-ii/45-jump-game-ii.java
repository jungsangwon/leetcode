class Solution {
    public int jump(int[] nums) {
        int idx = 0;
        int count = 0;
        while(idx<nums.length-1){
            int max = 0;
            int max_idx = -1;
            if(idx + nums[idx]<nums.length-1){
                for(int i=1; i<=nums[idx]; i++){
                    int tmp = i + nums[idx+i];
                    if(tmp>max){
                        max = tmp;
                        max_idx = idx + i;
                    }
                }
                idx = max_idx;
                count++;
            }else{
                count++;
                break;
            }
        }
        
        return count;
    }
}