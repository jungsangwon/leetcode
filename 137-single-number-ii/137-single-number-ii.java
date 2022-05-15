class Solution {
    public int singleNumber(int[] nums) {
        int result = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        
        for(int i=0; i<nums.length; i++){
            if(map.containsKey(nums[i])){
                if(map.get(nums[i])==2){
                    map.remove(nums[i]);
                }else{
                    map.put(nums[i],map.getOrDefault(nums[i],0)+1);
                }
            }else{
                map.put(nums[i],map.getOrDefault(nums[i],0)+1);
            }
        }
        
        for(int i : map.keySet()){
            result = i;
        }
        return result;
    }
}