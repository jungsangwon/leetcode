class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        int left = 0;
        int right = nums.length-1;
        result[0] = -1;
        result[1] = -1;
        if(right < 0 || nums[left]>target || nums[right]<target){
            return result;
        }
        while(left<=right){
            int mid = (left+right)/2;
            if(nums[mid]==target){
                return findSameValue(nums,mid);
            }else if(nums[mid]<target){
                int[] tmp = findSameValue(nums,mid);
                left = tmp[1]+1;
            }else{
                int[] tmp = findSameValue(nums,mid);
                right = tmp[0]-1;
            }
        }
        
        
        return result;
    }
    
    public int[] findSameValue(int[] nums, int idx){
        int[] index = {idx,idx};
        int num = nums[idx];
        while(0<=index[0]){
            if(num == nums[index[0]]){
                index[0]--;
            }else{
                break;
            }
        }
        index[0]++;
        while(index[1]<nums.length){
            if(num == nums[index[1]]){
                index[1]++;
            }else{
                break;
            }
        }
        index[1]--;
        return index;
    }
}