class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        subsets(nums,result,tmp,0);
        
        return result;
    }
    public void subsets(int[] nums, List<List<Integer>> result, List<Integer> tmp, int start){
        result.add(new ArrayList(tmp));
        for(int i=start; i<nums.length; i++){
            tmp.add(nums[i]);
            subsets(nums,result,tmp,i+1);
            tmp.remove(tmp.size()-1);
        }
    }
}