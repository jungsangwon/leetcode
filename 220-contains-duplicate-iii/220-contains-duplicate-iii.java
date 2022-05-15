class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        //initialize a binary search tree
        TreeSet<Integer> set = new TreeSet<>();
		
		//go through each element in nums
        for(int i = 0; i< nums.length; i++){
		
			//check the successor for the current element; if there isn't a successor, s = null
            Integer s = set.ceiling(nums[i]);
			//if we find a pair of numbers that meet the condition, we are done
            if(s!= null && (long) s <= nums[i] + t)
                return true;
            
			//if there isn't a successor or the successor doesn't meet the requirement, continue to check the predecessor
            Integer p = set.floor(nums[i]);
            if(p != null && nums[i] <= (long) p + t)
                return true;
            
			//neither the successor or predecessor meet the condition, insert the current element and move on to the next one
            set.add(nums[i]);
            
			//make sure that there are only k elements in the tree
            if(set.size() > k){
                set.remove(nums[i-k]);
            }
        }
		
        return false;
    }
}