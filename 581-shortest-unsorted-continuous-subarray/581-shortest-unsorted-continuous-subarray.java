class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int[] min = new int[nums.length];
        int[] max = new int[nums.length];
        Arrays.fill(min,Integer.MAX_VALUE);
        Arrays.fill(max,Integer.MIN_VALUE);
        for(int i=1; i<nums.length; i++){
            max[i] = Math.max(max[i-1],nums[i-1]);
        }
        
        for(int i=nums.length-2;i>=0;i--){
            min[i] = Math.min(min[i+1],nums[i+1]);
        }
        
        int left = 0;
        for(int i=0; i<nums.length; i++){
            if(nums[left]<=min[left]){
                left++;
            }else{
                break;
            }
        }
        int right = nums.length-1;
        for(int i=nums.length-1; i>=0; i--){
            if(nums[right]>=max[right]){
                right--;
            }else{
                break;
            }
        }
        if(left<right){
            return right-left+1;
        }else{
            return 0;
        }
    }
}