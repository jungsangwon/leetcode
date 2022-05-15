class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int len = Integer.MAX_VALUE;
        int sum = 0;
        int start = 0;
        int end = 0;
        while(end<nums.length){
            sum += nums[end];
            if(sum==target){
                int tmp = end - start +1;
                if(tmp<len){
                    len = tmp;
                }
                end = start;
                start++;
                sum=0;
            }else if(sum>target){
                while(sum>=target){
                    int tmp = end - start +1;
                    if(tmp<len){
                        len = tmp;
                    }
                    sum -= nums[start++];
                }
            }
            end++;
        }
        if(len>nums.length){
            return 0;
        }
        
        return len;
    }
}