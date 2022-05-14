import java.util.*;
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        int len = nums.length;
        if(nums.length<=2){
            return result;
        }
        Arrays.sort(nums);
        for(int i=0; i<len-2; i++){
            int base = nums[i];
            int left = i+1;
            int right = len-1;
            while(left<right){
                int sum = nums[i] + nums[left] + nums[right];
                if(sum>0){
                    right--;
                }else if(sum<0){
                    left++;
                }else{
                    result.add(Arrays.asList(nums[i],nums[left],nums[right]));
                    right--;
                    left++;
                    while(true){
                        if(right-1>0 && nums[right] == nums[right+1]){
                            right--;
                        }else{
                            break;
                        }
                    }
                    while(true){
                        if(left+1<len && nums[left]==nums[left-1]){
                            left++;
                        }else{
                            break;
                        }
                    }
                }
            }
            while(true){
                if(i<len-2 && base == nums[i+1]){
                    i++;
                }else{
                    break;
                }
            }
        }
        return result;
    }
}
