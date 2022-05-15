class Solution {
    public int[] productExceptSelf(int[] nums) {
        if(nums.length==1){
            return nums;
        }
        int[] result = new int[nums.length];
        int count = 0;
        int total = 1;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                count++;
            }else{
                total *= nums[i];
            }
        }
        if(count>1){
            return result;
        }else if(count==1){
            for(int i=0; i<nums.length; i++){
                if(nums[i]==0){
                    result[i]=total;
                }
            }
        }else{
            for(int i=0; i<nums.length; i++){
                result[i] = total / nums[i];
            }
        }
        
        return result;
    }
}