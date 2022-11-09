class Solution {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int[] sum = new int[nums.length-k+1];
        for(int i=0; i<k; i++){
            sum[0] += nums[i];
        }
        for(int i=1; i<sum.length; i++){
            sum[i] = sum[i-1] - nums[i-1] + nums[i+k-1];
        }
        int[][] max = new int[sum.length][3];
        int[][][] idx = new int[sum.length][3][3];
        max[sum.length-1][2] = sum[sum.length-1];
        idx[sum.length-1][2][2] = sum.length-1;
        for(int i=sum.length-2; i>=0; i--){
            if(sum[i]>=max[i+1][2]){
                max[i][2] = sum[i];
                idx[i][2][2] = i;
            }else{
                max[i][2] = max[i+1][2];
                idx[i][2][2] = idx[i+1][2][2];
            }
        }
        maxSumOfThreeSubarrays(sum,k,0,0,max,idx);
        return idx[0][0];
    }
    
    public int maxSumOfThreeSubarrays(int[] sum, int k, int now, int count, int[][] max, int[][][] idx) {
        if(now>=sum.length){
            return -1;
        }
        if(max[now][count]!=0){
            return max[now][count];
        }
        int result = maxSumOfThreeSubarrays(sum,k,now+k,count+1,max,idx);
        if(result == -1){
            max[now][count] = -1;
            return -1;
        }else{
            result += sum[now];
        }
        int tmp = maxSumOfThreeSubarrays(sum,k,now+1,count,max,idx);
        if(result<tmp){
            max[now][count] = tmp;
            for(int i=0; i<3; i++){
                idx[now][count][i] = idx[now+1][count][i];
            }
            return tmp;
        }else{
            max[now][count] = result;
            for(int i=0; i<3; i++){
                idx[now][count][i] = idx[now+k][count+1][i];
            }
            idx[now][count][count] = now;
            return result;
        }
        
    }
}