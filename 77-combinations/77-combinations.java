class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        
        addCombi(result,tmp,n,0,k);
        
        return result;
    }
    
    public void addCombi(List<List<Integer>> result, List<Integer> tmp, int n, int num, int k){
        if(k==0){
            result.add(new ArrayList<>(tmp));
        }
        for(int i=num+1; i<=n; i++){
            tmp.add(i);
            addCombi(result,tmp,n,i,k-1);
            tmp.remove(tmp.size()-1);
        }
    }
}