class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        getSubsequences(nums,0,new ArrayList<>(),result);
        return result;
    }
    
    public void getSubsequences(int[] nums, int idx, List<Integer> now, List<List<Integer>> result){
        if(now.size()>1){
            result.add(new ArrayList<>(now));
        }
        HashSet<Integer> hashSet = new HashSet<>();
        for(int i=idx; i<nums.length; i++){
            if(hashSet.contains(nums[i])){
                continue;
            }
            if(now.size()==0 || nums[i]>=now.get(now.size()-1)){
                now.add(nums[i]);
                getSubsequences(nums,i+1,now,result);
                now.remove(now.size()-1);
            }
            hashSet.add(nums[i]);
        }
    }
}