class Solution {
    public int thirdMax(int[] nums) {
        TreeSet<Integer> treeSet = new TreeSet<>(Collections.reverseOrder());
        for(int i=0; i<nums.length; i++){
            treeSet.add(nums[i]);
        }
        int result = treeSet.first();
        int count = 0;
        for(int i : treeSet){
            count++;
            if(count==3){
                result = i;
            }
        }
        return result;
    }
}