class Solution {
    public boolean xorGame(int[] nums) {
        int now = 0;
        List<Integer> list = new ArrayList<>();
        for(int a : nums){
            list.add(a);
            now = now ^ a;
        }
        
        return xorGame(list,now,true,new HashMap<>());
    }
    
    public boolean xorGame(List<Integer> nums, int now, boolean turn, HashMap<Integer,Boolean> dp){
        if(now == 0){
            if(turn){
                return true;
            }else{
                return false;
            }
        }else if(nums.size()==0){
            if(turn){
                return false;
            }else{
                return true;
            }
        }else{
            if(dp.containsKey(now)){
                return dp.get(now);
            }else{
                boolean result = false;
                if(!turn){
                    result = true;
                }
                int size = nums.size();
                for(int i=0; i<size; i++){
                    int num = nums.get(i);
                    nums.remove(i);
                    if(turn){
                        result = result || xorGame(nums,now^num,!turn,dp);
                        if(result){
                            nums.add(i,num);
                            break;
                        }
                    }else{
                        result = result && xorGame(nums,now^num,!turn,dp);
                        if(!result){
                            nums.add(i,num);
                            break;
                        }
                    }
                    nums.add(i,num);
                }
                dp.put(now,result);
                return result;
            }
        }
        
    }
}