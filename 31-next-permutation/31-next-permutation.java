class Solution {
    public void nextPermutation(int[] nums) {
        int idx = -1;
        for(int i=nums.length-2; i>=0; i--){
            if(nums[i]<nums[i+1]){
                idx = i;
                break;
            }
        }
        if(idx>=0){
            for(int i=nums.length-1; i>idx; i--){
                if(nums[i]>nums[idx]){
                    int tmp = nums[idx];
                    nums[idx] = nums[i];
                    nums[i] = tmp;
                    break;
                }
            }
        }
        int left = idx +1;
        int right = nums.length-1;
        while(left<right){
            int tmp = nums[left];
            nums[left] = nums[right];
            nums[right] = tmp;
            left++;
            right--;
        }
    }
}