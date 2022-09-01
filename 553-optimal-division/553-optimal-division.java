class Solution {
    public String optimalDivision(int[] nums) {
        if(nums.length==1){
            return String.valueOf(nums[0]);
        }
        double[][][] dp = new double[nums.length][nums.length][2];
        String[][][] str = new String[nums.length][nums.length][2];
        optimalDivision(nums,dp,str,0,nums.length-1);
        return str[0][nums.length-1][1].substring(1,str[0][nums.length-1][1].length()-1);
    }
    
    public void optimalDivision(int[] nums, double[][][] dp, String[][][] str, int left, int right){
        if(left+1==right){
            dp[left][right][0] = (double)nums[left]/nums[right];
            dp[left][right][1] = (double)nums[left]/nums[right];
            str[left][right][0] = "("+nums[left]+"/"+nums[right]+")";
            str[left][right][1] = "("+nums[left]+"/"+nums[right]+")";
        }else{
            optimalDivision(nums,dp,str,left+1,right);
            optimalDivision(nums,dp,str,left,right-1);
            double t0 = nums[left]/dp[left+1][right][0];
            double t1 = dp[left][right-1][1]/nums[right];
            if(t0>t1){
                dp[left][right][1] = t0;
                str[left][right][1] = "("+nums[left]+"/"+str[left+1][right][0]+")";
            }else{
                dp[left][right][1] = t1;
                str[left][right][1] = "("+str[left][right-1][1].substring(1,str[left][right-1][1].length()-1)+"/"+nums[right]+")";
            }
            t0 = nums[left]/dp[left+1][right][1];
            t1 = dp[left][right-1][0]/nums[right];
            if(t0>t1){
                dp[left][right][0] = t1;
                str[left][right][0] = "("+str[left][right-1][0].substring(1,str[left][right-1][0].length()-1)+"/"+nums[right]+")";
            }else{
                dp[left][right][0] = t0;
                str[left][right][0] = "("+nums[left]+"/"+str[left+1][right][1]+")";
            }
        }
    }
}