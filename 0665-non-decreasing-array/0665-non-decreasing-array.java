class Solution {
    public boolean checkPossibility(int[] nums) {
        for(int i=1; i<nums.length; i++){
            if(nums[i]<nums[i-1]){
                if(i-1==0 || nums[i-2]<=nums[i]){
                    boolean check = true;
                    for(int j=i+1; j<nums.length; j++){
                        if(nums[j]<nums[j-1]){
                            check = false;
                            break;
                        }
                    }
                    if(check){
                        return true;
                    }
                }
                if(i==nums.length-1){
                    return true;
                }else{
                    nums[i] = nums[i-1];
                    boolean check = true;
                    for(int j=i+1; j<nums.length; j++){
                        if(nums[j]<nums[j-1]){
                            check = false;
                            break;
                        }
                    }
                    if(check){
                        return true;
                    }else{
                        return false;
                    }
                }
            }
        }
        return true;
    }
    
}