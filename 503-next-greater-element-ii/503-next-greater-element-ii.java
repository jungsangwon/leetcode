class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int[] result = new int[nums.length];
        Arrays.fill(result,Integer.MIN_VALUE);
        for(int i= nums.length-1; i>=0; i--){
            int next = i+1;
            while(true){
                if(next==nums.length){
                    next=0;
                }
                if(next == i){
                    result[i] = -1;
                    break;
                }
                if(nums[next]>nums[i]){
                    result[i] = nums[next];
                    break;
                }else{
                    if(result[next]>nums[i]){  
                        result[i] = result[next];
                        break;
                    }else{
                        next++;
                    }
                }
            }
        }
        
        return result;
    }
}