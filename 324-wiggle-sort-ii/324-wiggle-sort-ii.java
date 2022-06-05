class Solution {
    public void wiggleSort(int[] nums) {
        int[] count = new int[5001];
        for (int num : nums){
            count[num]++;
        }
        int idx = -1;
        int check = 0;
        for (int val = 5000; val >= 0; val--) {
            while (count[val] > 0) {
                idx+=2;
                if(idx >= nums.length){
                    idx = 0;
                }
                nums[idx] = val;
                count[val]--;
                check++;
                if (check == nums.length){
                    return;
                }
            }
        }
    }
}