class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        getSum(candidates,target,0,result,new ArrayList<>(),0);
        
        return result;
    }
    
    public void getSum(int[] candidates, int target, int sum, List<List<Integer>> result, List<Integer> now, int idx){
        if(sum == target){
            result.add(new ArrayList<>(now));
        }
        for(int i=idx; i<candidates.length; i++){
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