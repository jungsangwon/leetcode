class Solution {
    public void sortColors(int[] nums) {
        int[] color = new int[3];
        for(int i=0; i<nums.length; i++){
            color[nums[i]]++;
        }
        int idx = 0;
        for(int i=0; i<3; i++){
            for(int j=0; j<color[i]; j++){
                nums[idx++] = i;
            }
        }
    }
}