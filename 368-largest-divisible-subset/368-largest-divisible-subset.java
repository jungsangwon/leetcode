class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            list.add(new ArrayList<>());
        }
        for(int i=0; i<nums.length; i++){
            List<Integer> max = new ArrayList<>();
            for(int j=0; j<i;j++){
                if(nums[i] % nums[j] == 0 && list.get(j).size()>max.size()){
                    max = list.get(j);
                }
            }
            list.get(i).addAll(max);
            list.get(i).add(nums[i]);
        }
        List<Integer> result = new ArrayList<>();
        for(int i=0; i<nums.length; i++){
            if(result.size()<list.get(i).size()){
                result = list.get(i);
            }
        }
        return result;
    }
}
