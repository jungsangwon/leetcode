class Solution {
    public int numberOfBoomerangs(int[][] points) {
        int result = 0;
        for(int i=0; i<points.length; i++){
            HashMap<Integer,Integer> map = new HashMap<>();
            for(int j=0; j<points.length; j++){
                int x = points[i][0] - points[j][0];
                int y = points[i][1] - points[j][1];
                int distance = (x*x)+(y*y);
                map.put(distance,map.getOrDefault(distance,0)+1);
            }
            for(int k : map.keySet()){
                int count = map.get(k);
                if(count>1){
                    result += count*(count-1);
                }
            }
        }
        
        return result;
    }
}