class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        if(nums.length==0){
            return result;
        }
        String tmp = "";
        int from = nums[0];
        int to = nums[0];
        for(int i=1; i<nums.length; i++){
            if(to+1 == nums[i]){
                to = nums[i];
            }else{
                if(from==to){
                    result.add(String.valueOf(from));
                }else{
                    result.add(String.valueOf(from)+"->"+String.valueOf(to));
                }
                from = nums[i];
                to = nums[i];
            }
        }
        if(from==to){
            result.add(String.valueOf(from));
        }else{
            result.add(String.valueOf(from)+"->"+String.valueOf(to));
        }
        return result;
    }
}