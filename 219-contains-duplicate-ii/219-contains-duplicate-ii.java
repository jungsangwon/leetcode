class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashSet<Integer> hashSet = new HashSet<>();
        int limit = Math.min(nums.length-1,k);
        for(int j=0;j<=limit;j++){
            if(hashSet.contains(nums[j])){
                return true;
            }else{
                hashSet.add(nums[j]);
            }
        }
        int idx = 0;
        for(int i=limit+1; i<nums.length; i++){
            hashSet.remove(nums[idx++]);
            if(hashSet.contains(nums[i])){
                return true;
            }else{
                hashSet.add(nums[i]);
            }
        }

        return false;
    }
}