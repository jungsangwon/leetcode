class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        getSum(candidates,target,0,result,new ArrayList<>(),-1);
        
        return result;
    }
    
    public void getSum(int[] candidates, int target, int sum, List<List<Integer>> result, List<Integer> now, int idx){
        if(sum == target){
            result.add(new ArrayList<>(now));
        }
        int before = -1;
        for(int i=idx+1; i<candidates.length; i++){
            if(before == candidates[i]){
                continue;
            }else{
                before = candidates[i];
            }
            if(sum+candidates[i]<=target){
                now.add(candidates[i]);
                getSum(candidates,target,sum+candidates[i],result,now, i);
                now.remove(now.size()-1);
            }else{
                break;
            }
        }  
    }
}
    

    
