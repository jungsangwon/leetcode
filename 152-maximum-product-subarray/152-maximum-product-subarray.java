class Solution {
    public int maxProduct(int[] nums) {
        int result = nums[0];
        int start = 0;
        int minus = -1;
        int now = 1;
        if(nums.length==1){
            return nums[0];
        }
        while(start<nums.length){
            now = nums[start];
            if(now<0){
                minus = start;
            }else if(now==0){
                start++;
                if(result<0){
                    result = 0;
                }
                continue;
            }
            for(int i=start+1; i<nums.length; i++){
                if(nums[i]<0){
                    if(result<now){
                        result = now;
                    }
                    if(minus == -1){
                        minus = i;
                    }
                }else if(nums[i]==0){
                    if(result<now){
                        result = now;
                    }else if(result<0){
                        result = 0;
                    }
                    if(minus != -1 && now<0){
                        start = minus;
                    }else{
                        start = i;
                    }
                    break;
                }
                now *= nums[i];
                start=i;
            }
            start++;
            if(result<now){
                result = now;
            }
            if(minus != -1 && now<0){
                start = minus+1;
            }
            minus = -1;
        }
        
        return result;
    }
}