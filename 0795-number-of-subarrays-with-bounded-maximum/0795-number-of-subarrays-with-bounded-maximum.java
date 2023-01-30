class Solution {
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        int result = 0;
        int start=0;
        int end = -1;
        for(int i=0; i<nums.length; i++){
            if(nums[i]>right){
                start = i+1;
                end = -1;
            }else if(nums[i]<=right && nums[i]>=left){
                int count = i - start + 1;
                int tmp = i+1;
                if(end == -1){
                    while(tmp<nums.length){
                        if(nums[tmp]>right){
                            break;
                        }
                        tmp++;
                    }
                    tmp--;
                    end = tmp;
                }
                
                count *= (end - i + 1);;
                // System.out.println(i+" : "+count+" "+start);
                result += count;
                start = i+1;
            }
        }
        return result;
    }
}