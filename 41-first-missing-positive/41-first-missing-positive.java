class Solution {
    public int firstMissingPositive(int[] nums) {
        int result = 1;
        // HashMap<Integer, Integer> map = new HashMap<>();
        // for(int i=0; i<nums.length; i++){
        //     if(nums[i]>0 && nums[i]<=nums.length){
        //         if(nums[i] != result){
        //             map.put(nums[i],1);
        //         }else{
        //             map.put(nums[i],1);
        //             result++;
        //             while(map.containsKey(result)){
        //                 result++;
        //             }
        //         }
        //     }
        // }
        
        
        // Arrays.sort(nums);
        // for(int i=0;i<nums.length;i++){
        //     if(nums[i]>result){
        //         break;
        //     }else if(nums[i]==result){
        //         result++;
        //     }
        // }
        
        for(int i=0; i<nums.length; i++){
            while(nums[i]>0&&nums[i]<=nums.length&&nums[i] != i+1 && nums[nums[i]-1] != nums[i]){
                int tmp = nums[i];
                nums[i] = nums[nums[i]-1];
                nums[tmp-1] = tmp;
            }
        }
        
        for(int i=0; i<nums.length; i++){
            if(nums[i] != result){
                return result;
            }else{
                result++;
            }
        }
        
        return result;
    }
}