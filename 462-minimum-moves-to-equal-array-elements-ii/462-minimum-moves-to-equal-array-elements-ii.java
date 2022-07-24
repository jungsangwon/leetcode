class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int median = nums[nums.length /2];
        int answer = 0;
        for(int i=0;i<nums.length;i++){
            answer += Math.abs(nums[i] - median);
        }
    
        return answer;
    }
}