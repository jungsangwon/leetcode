class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        if(nums.length<3){
            return 0;
        }
        int result = 0;
        int[] dif = new int[nums.length-1];
        for(int i=0;i<dif.length; i++){
            dif[i] = nums[i+1]-nums[i];
        }
        int count = 2;
        int before = dif[0];
        for(int i=1;i<dif.length; i++){
            if(before == dif[i]){
                count++;
            }else{
                int len = count;
                while(count>=3){
                    result += (len - count +1);
                    count--;
                }
                count=2;
                before=dif[i];
            }
        }
        int len = count;
        while(count>=3){
            result += (len - count +1);
            count--;
        }
        return result;
    }
}