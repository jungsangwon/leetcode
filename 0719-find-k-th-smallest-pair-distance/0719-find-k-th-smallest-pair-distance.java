class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int left = 0;
        for(int i = 0; i<nums.length - 1; i++){
            left = Math.min(left,nums[i + 1]-nums[i]);
        }
        int right = nums[nums.length - 1] - nums[0];
        
        while(left<right){
            int mid = (left + right)/2;
            int count = 0;
            int j = 1;
            for(int i = 0; i<nums.length; i++){
                while(j < nums.length && nums[j] - nums[i] <= mid){
                    j++;
                }
                count += (j - i - 1); 
            }
            if(count<k){
                left = mid + 1;
            }else{
                right = mid;
            }
        }
        
        return left;
    }
}