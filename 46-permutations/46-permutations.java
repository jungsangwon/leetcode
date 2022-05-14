class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        adding(nums,new ArrayList<>(),new int[nums.length],result);
        return result;
    }
    
    public void adding(int[] nums, List<Integer> now, int[] check, List<List<Integer>> result){
        if(now.size()==nums.length){
            result.add(new ArrayList<>(now));
        }else{
            for(int i=0; i<nums.length; i++){
                if(check[i]==0){
                    now.add(nums[i]);
                    check[i]=1;
                    adding(nums,now,check,result);
                    now.remove(now.size()-1);
                    check[i]=0;
                }
            }
        }
    }
}