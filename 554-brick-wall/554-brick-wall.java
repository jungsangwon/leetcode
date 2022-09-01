class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        int result = wall.size();
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0; i<wall.size(); i++){
            int now = 0;
            int len = wall.get(i).size()-1;
            for(int j=0; j<len; j++){
                now += wall.get(i).get(j);
                map.put(now,map.getOrDefault(now,0)+1);
            }
        }
        
        for(int key : map.keySet()){
            result = Math.min(result,wall.size()-map.get(key));
        }
        return result;
    }
}