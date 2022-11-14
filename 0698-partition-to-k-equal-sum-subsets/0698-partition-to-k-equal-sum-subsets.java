class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        HashMap<Integer,Integer> count = new HashMap<>();
        int sum = 0;
        for(int i=0; i<nums.length; i++){
            count.put(nums[i],count.getOrDefault(nums[i],0)+1);
            sum += nums[i];
        }
        if(sum%k==0){
            if(canPartitionKSubsets(count,sum/k)){
                return true;
            }else{
                return false;
            }
        }else{
            return false;
        }
    }
    
    public boolean canPartitionKSubsets(HashMap<Integer,Integer> count, int sum) {
        List<HashMap<Integer,Integer>> map = getList(count,sum);
        // for(HashMap<Integer,Integer> t : map){
        //     System.out.println(t.toString());
        // }
        return canPartitionKSubsets(count,map);
    }
    
    public boolean canPartitionKSubsets(HashMap<Integer,Integer> count, List<HashMap<Integer,Integer>> map) {
        if(count.isEmpty()){
            return true;
        }else{
            for(HashMap<Integer,Integer> t : map){
                boolean check = true;
                for(int num : t.keySet()){
                    if(!count.containsKey(num) || count.get(num)<t.get(num)){
                        check = false;
                        break;
                    }
                }
                if(check){
                    for(int num : t.keySet()){
                        if(count.get(num)==t.get(num)){
                            count.remove(num);
                        }else{
                            count.put(num,count.get(num)-t.get(num));
                        }
                    }
                    boolean result = canPartitionKSubsets(count,map);
                    if(result){
                        return result;
                    }
                    for(int num : t.keySet()){
                        count.put(num,count.getOrDefault(num,0)+t.get(num));
                    }
                }
            }
            return false;
        }
    }
    
    public List<HashMap<Integer,Integer>> getList(HashMap<Integer,Integer> count, int sum){
        List<HashMap<Integer,Integer>> result = new ArrayList<>();
        HashMap<Integer,Integer> next = new HashMap<>(count);
        for(int num : count.keySet()){
            if(sum>num){
                if(next.get(num)==1){
                    next.remove(num);
                }else{
                    next.put(num,next.get(num)-1);
                }
                List<HashMap<Integer,Integer>> now = getList(next,sum-num);
                for(HashMap<Integer,Integer> map : now){
                    map.put(num,map.getOrDefault(num,0)+1);
                    result.add(map);
                }
            }else if(sum==num){
                HashMap<Integer,Integer> now = new HashMap<>();
                now.put(num,1);
                result.add(now);
            }
            next.remove(num);
        }
        return result;
    }
}