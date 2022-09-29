class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        List<Integer> idx = new ArrayList<>();
        List<Integer> val = new ArrayList<>();
        for(int i=0; i<nums.size(); i++){
            idx.add(0);
            val.add(nums.get(i).get(0));
        }
        Collections.sort(val);
        HashMap<String,int[]> dp = new HashMap<>();
        return smallestRange(nums,idx,val,dp);
    }
    
    public int[] smallestRange(List<List<Integer>> nums, List<Integer> idx, List<Integer> val, HashMap<String,int[]> dp) {
        if(dp.containsKey(idx.toString())){
            return dp.get(idx.toString());
        }
        int[] result = new int[2];
        result[0] = val.get(0);
        result[1] = val.get(val.size()-1);
        List<Integer> nextIdx = new ArrayList<>(idx);
        List<Integer> nextVal = new ArrayList<>(val);
        for(int i = 0;i<nextVal.size(); i++){
            if(nextVal.get(0)==result[0]){
                nextVal.remove(0);
            }else{
                break;
            }
        }
        for(int i=0; i<idx.size(); i++){
            if(nums.get(i).get(idx.get(i)).equals(val.get(0))){
                if(idx.get(i)+1<nums.get(i).size()){
                    nextIdx.set(i,nextIdx.get(i)+1);
                    int num = nums.get(i).get(nextIdx.get(i));
                    int index = Collections.binarySearch(nextVal,num);
                    if(index<0){
                        index*=-1;
                        index--;
                    }
                    nextVal.add(index,num);
                }else{
                    return result;
                }
            }
        }
        int[] tmp = smallestRange(nums,nextIdx,nextVal,dp);
        if(tmp[1]-tmp[0]<result[1]-result[0]){
            result = tmp;
        }
        dp.put(idx.toString(),result);
        return result;
    }
}

