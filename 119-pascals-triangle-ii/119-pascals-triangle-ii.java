class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<>();
        result.add(1);
        for(int i=1; i<=rowIndex; i++){
            List<Integer> next = new ArrayList<>();
            next.add(1);
            if(result.size()>1){
                for(int j=0;j<result.size()-1;j++){
                    next.add(result.get(j)+result.get(j+1));
                }
            }
            next.add(1);
            result = next;
        }
        return result;
    }
}