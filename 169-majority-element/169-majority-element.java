class Solution {
    public int majorityElement(int[] nums) {
        int max = nums.length/2;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
            if(map.get(nums[i])>max){
                return nums[i];
            }
        }
        return 0;
    }
}