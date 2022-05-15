class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        List<Integer> min = new ArrayList<>();
        min.add(triangle.get(0).get(0));
        
        for(int i=1; i<triangle.size(); i++){
            int before =min.get(0);
            List<Integer> tmp = triangle.get(i);
            min.add(min.get(min.size()-1)+tmp.get(tmp.size()-1));
            min.set(0,min.get(0)+tmp.get(0));
            for(int j=1; j<tmp.size()-1; j++){
                int num = Math.min(before,min.get(j));
                before = min.get(j);
                min.set(j,num+tmp.get(j));
            }
        }

        int result = Integer.MAX_VALUE;
        for(int i=0; i<min.size(); i++){
            if(result>min.get(i)){
                result = min.get(i);
            }
        }
        return result;
    }
}