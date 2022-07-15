class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();
        boolean[] check = new boolean[nums.length+1];
        for(int i=0; i<nums.length; i++){
            check[nums[i]]=true;
        }
        for(int i=1; i<=nums.length; i++){
            if(!check[i]){
                result.add(i);
            }
        }
        return result;
    }
}