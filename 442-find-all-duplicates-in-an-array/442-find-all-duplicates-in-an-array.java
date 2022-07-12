class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<>();
        for(int i=0; i<nums.length; i++){
            while(true){
                if(nums[i]==i+1 || nums[i] == -1){
                    break;
                }else{
                    if(nums[i] == nums[nums[i]-1]){
                        result.add(nums[i]);
                        nums[i] = -1;
                        break;
                    }
                    int tmp = nums[i];
                    nums[i] = nums[nums[i]-1];
                    nums[tmp-1] = tmp;
                }
            }
        }
        return result;
    }
}