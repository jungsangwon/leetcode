import java.util.*;
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new LinkedList<>();
        int left = 0;
        int right = nums.length-1;
        Arrays.sort(nums);
        while(right - left > 2){
            int nextLeft = left+1;
            int nextRight = right-1;
            checking(nums,target-nums[left]-nums[right],left,right,result);
            while(true){
                if(nextLeft>=right){
                    break;
                }else if(nums[nextLeft] == nums[nextLeft-1]){
                    nextLeft++;
                }else{
                    checking(nums,target-nums[nextLeft]-nums[right],nextLeft,right,result);
                    nextLeft++;
                }
            }
            while(true){
                if(left>=nextRight){
                    break;
                }
                else if(nums[nextRight] == nums[nextRight+1]){
                    nextRight--;
                }else{
                    checking(nums,target-nums[left]-nums[nextRight],left,nextRight,result);
                    nextRight--;
                }
            }
           
            nextLeft = left+1;
            nextRight = right-1;
            while(true){
                if(nextLeft<nums.length && nums[nextLeft] == nums[nextLeft-1]){
                    nextLeft++;
                }else{
                    break;
                }
            }
            while(true){
                if(nextRight>0 &&nums[nextRight] == nums[nextRight+1]){
                    nextRight--;
                }else{
                   break;
                }
            }
            if(nextRight - nextLeft < 2){
                break;
            }
            left = nextLeft;
            right = nextRight;
        }
        
        
        return result;
    }
    public void checking(int[] nums, int target, int baseLeft, int baseRight, List<List<Integer>> result){
        int left = baseLeft+1;
        int right = baseRight-1;
        while(left<right){
            int sum = target - nums[left] - nums[right];
            if(sum>0){
                left++;
                while(true){
                    if(left<nums.length && nums[left]==nums[left-1]){
                        left++;
                    }else{
                        break;
                    }
                }
            }else if(sum<0){
                right--;
                while(true){
                    if(right>0&&nums[right]==nums[right+1]){
                        right--;
                    }else{
                        break;
                    }
                }
                
            }else{
                result.add(Arrays.asList(nums[baseLeft], nums[left], nums[right], nums[baseRight]));
                left++;
                while(true){
                    if(left<nums.length && nums[left]==nums[left-1]){
                        left++;
                    }else{
                        break;
                    }
                }
                right--;
                while(true){
                    if(right>0&&nums[right]==nums[right+1]){
                        right--;
                    }else{
                        break;
                    }
                }
            }
        }
    }
}