class Solution {
    HashMap<Integer,List<Integer>> map;

    public Solution(int[] nums) {
        map = new HashMap<>();
        for(int i=0; i<nums.length;i++){
            List<Integer> tmp = map.getOrDefault(nums[i],new ArrayList<>());
            tmp.add(i);
            map.put(nums[i],tmp);
        }
    }
    
    public int pick(int target) {
        List<Integer> tmp = map.get(target);
        Random random = new Random();
        return tmp.get(random.nextInt(tmp.size()));
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */