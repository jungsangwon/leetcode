class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] index = new int[2];
        int len = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0; i<len; i++){
            if(map.containsKey(target-nums[i])){
                index[1] = i;
                index[0] = map.get(target-nums[i]);
                return index;
            }
            else{
                map.put(nums[i],i);
            }
        }
        
        return index;
    }

}