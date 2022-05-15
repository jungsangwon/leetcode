class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> result = new ArrayList<>();
        Arrays.sort(nums);
        int num = nums[0];
        int count = 1;
        int limit = nums.length/3;
        for(int i=1 ;i<nums.length;i++){
            if(nums[i]==num){
                count++;
            }else{
                if(count>limit){
                    result.add(num);
                }
                count=1;
                num = nums[i];
            }
        }
        if(count>limit){
            result.add(num);
        }
        return result;
    }
}