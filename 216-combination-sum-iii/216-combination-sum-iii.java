class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        combinationSum3(k,n,k,new ArrayList<>(),result);
        return result;
    }
    
    public void combinationSum3(int k, int n, int size, List<Integer> now, List<List<Integer>>result) {
        int start = 1;
        if(k==0){
            if(n==0&&size==now.size()){
                result.add(now);
            }
        }else{
            if(!now.isEmpty()){
                start = now.get(now.size()-1)+1;
            }
            int end = 10-k;
            for(int i=start; i<=end; i++){
                if(n>=i){
                    List<Integer> tmp = new ArrayList<>(now);
                    tmp.add(i);
                    combinationSum3(k-1,n-i,size,tmp,result);
                }
            }
        }
    }
}