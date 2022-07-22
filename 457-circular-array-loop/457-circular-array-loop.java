class Solution {
    public boolean circularArrayLoop(int[] nums) {
        boolean[] visit = new boolean[nums.length];
        for(int i=0; i<nums.length; i++){
            if(!visit[i]){
                if(circularArrayLoop(nums,visit,i,nums[i]<0)){
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean circularArrayLoop(int[] nums, boolean[] visit, int idx, boolean minus) {
        int first = idx;
        int before = idx;
        boolean[] now = new boolean[nums.length];
        int len = 0;
        now[idx] = true;
        while(!visit[idx]){
            now[idx] = true;
            before = idx;
            idx = move(idx,nums);
            if(minus){
                if(nums[idx]>0){
                    break;
                }
            }else{
                if(nums[idx]<0){
                    break;
                }
            }
            len++;
            if(before==idx){
                break;
            }else if(now[idx]){
                return len!=1;
            }
        }
        for(int i=0; i<nums.length; i++){
            visit[i] |= now[i];
        }
        return false;
    }
    
    public int move(int idx, int[] nums){
        idx += nums[idx];
        if(idx>=nums.length){
            while(idx>=nums.length){
                idx-=nums.length;
            }
        }else if(idx<0){
            while(idx<0){
                idx += nums.length;
            }
        }
        return idx;
    }
}