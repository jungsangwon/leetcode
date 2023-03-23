class Solution {
    public int flipgame(int[] fronts, int[] backs) {
        int result = Integer.MAX_VALUE;
        HashSet<Integer> hashSet = new HashSet<>();
        for(int i=0; i<fronts.length; i++){
            if(fronts[i]==backs[i]){
                hashSet.add(fronts[i]);
            }
        }
        Arrays.sort(fronts);
        Arrays.sort(backs);
        for(int i=0; i<fronts.length; i++){
            if(!hashSet.contains(fronts[i])){
                result = fronts[i];
                break;
            }
        }
        for(int i=0; i<backs.length; i++){
            if(backs[i]>=result){
                break;
            }
            if(!hashSet.contains(backs[i])){
                result = backs[i];
                break;
            }
        }
        
        if(result == Integer.MAX_VALUE){
            return 0;
        }else{
            return result;
        }
    }
}