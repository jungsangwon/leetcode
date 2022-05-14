class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        
        HashMap<Integer,Integer> hm = new HashMap<>();
        Queue<Integer> qu = new LinkedList<>();
        for(int i = 0; i<nums.length; i++){
            hm.put(nums[i],hm.getOrDefault(nums[i],0)+1);
        }
        for(int i : hm.keySet()){
            qu.add(i);
        }
        subsetsWithDup(hm,result,tmp,qu);
        
        return result;
    }
    
    public void subsetsWithDup(HashMap<Integer,Integer> hm,  List<List<Integer>> result, List<Integer> tmp, Queue<Integer> qu){
        if(qu.isEmpty()){
            result.add(tmp);
        }else{
            int key = qu.poll();
            int count = hm.get(key);
            subsetsWithDup(hm,result,new ArrayList<>(tmp),new LinkedList<>(qu));
            for(int i=0; i<count; i++){
                tmp.add(key);
                subsetsWithDup(hm,result,new ArrayList<>(tmp),new LinkedList<>(qu));
            }
        }
    }
}