import java.util.*;
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int result = nums[0]+nums[1]+nums[2];
        int len = nums.length;
        Arrays.sort(nums);
        for(int i=0; i<len; i++){
            int left = i+1;
            int right = len-1;
            while(left<right){
                if(result == target){
                    return result;
                }
                int sum = nums[i] + nums[left] + nums[right];
                int check = Math.abs(target - sum);
                int base = Math.abs(target - result);
                if(check<base){
                    result = sum;
                }
                if(sum>target){
                    right--;
                    while(true){
                        if(right>left&&nums[right]==nums[right+1]){
                            right--;
                        }else{
                            break;
                        }
                    }
                }else if(sum<target){
                    left++;
                    while(true){
                        if(left<right&&nums[left]==nums[left-1]){
                            left++;
                        }else{
                            break;
                        }
                    }
                }else{
                    right--;
                    while(true){
                        if(right>left&&nums[right]==nums[right+1]){
                            right--;
                        }else{
                            break;
                        }
                    }
                    left++;
                    while(true){
                        if(left<right&&nums[left]==nums[left-1]){
                            left++;
                        }else{
                            break;
                        }
                    }
                }
            }
        }
        
        return result;
    }
}