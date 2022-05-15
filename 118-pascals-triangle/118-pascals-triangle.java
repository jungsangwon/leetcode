class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        tmp.add(1);
        result.add(tmp);
        for(int i=2;i<=numRows;i++){
            tmp = new ArrayList<>();
            tmp.add(1);
            List<Integer> before = result.get(result.size()-1);
            if(before.size()>=2){
                for(int j=0; j<before.size()-1; j++){
                    tmp.add(before.get(j)+before.get(j+1));
                }
            }
            tmp.add(1);
            result.add(tmp);
        }
        return result;
    }
}