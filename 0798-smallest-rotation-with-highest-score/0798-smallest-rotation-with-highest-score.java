class Solution {
    public int bestRotation(int[] nums) {
        int result = 0;
        int max = 0;
        int[] count = new int[nums.length];
        for(int i=0; i<nums.length; i++){
            if(nums[i]==0){
                continue;
            }
            int idx = i-nums[i]+1;
            if(idx<0){
                idx += nums.length;
            }
            // System.out.println(i+", "+nums[i]+" -> "+idx);
            count[idx]--;
        }
        int now = 0;
        for(int i=0; i<nums.length; i++){
            if(i>=nums[i]){
                now++;
            }
        }
        max = now;
        // System.out.println("0 = "+now);
        for(int i=1; i<count.length; i++){
            if(nums[i-1]>0){
                now++;
            }
            now += count[i];
            // System.out.println(i+" = "+now);
            if(max<now){
                max = now;
                result = i;
            }
        }
        return result;
    }
}