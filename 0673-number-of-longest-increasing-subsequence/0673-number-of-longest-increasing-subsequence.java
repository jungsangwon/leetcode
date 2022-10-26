class Solution {
    public int findNumberOfLIS(int[] nums) {
        TreeMap<Integer,Integer> map = new TreeMap<>();
        HashMap<Integer,Integer> count = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            boolean check = false;
            int max = 0;
            int cnt = 0;
            for(int key : map.keySet()){
                if(key<nums[i]){
                    if(max==map.get(key)){
                        cnt+=count.get(key);
                    }else if(max<map.get(key)){
                        max = map.get(key);
                        cnt= count.get(key);
                    }
                    check = true;
                }else{
                    break;
                }
            }
            if(check){
                if(max+1>map.getOrDefault(nums[i],0)){
                    map.put(nums[i],max+1);
                    count.put(nums[i],cnt);
                }else if(max+1 == map.getOrDefault(nums[i],0)){
                    count.put(nums[i],count.get(nums[i])+cnt);
                }
            }else{
                map.put(nums[i],1);
                count.put(nums[i],count.getOrDefault(nums[i],0)+1);
            }
        }
        
        int result = 1;
        int max = 0;
        for(int key : map.keySet()){
            // System.out.println(key+" ~ "+map.get(key)+" ~ "+count.get(key));
            if(max<map.get(key)){
                max = map.get(key);
                result = count.get(key);
            }else if(max==map.get(key)){
                result+=count.get(key);
            }
        }
        return result;
    }
}