class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if(hand.length%groupSize!=0){
            return false;
        }
        TreeMap<Integer,Integer> count = new TreeMap<>();
        for(int i=0; i<hand.length; i++){
            count.put(hand[i],count.getOrDefault(hand[i],0)+1);
        }
        while(!count.isEmpty()){
            int key = count.firstKey();
            int tmp = count.get(key);
            count.remove(key);
            for(int i=1; i<groupSize; i++){
                if(count.containsKey(key+i)){
                    int check = count.get(key+i);
                    if(check<tmp){
                        return false;
                    }else if(check==tmp){
                        count.remove(key+i);
                    }else{
                        count.put(key+i,check-tmp);
                    }
                }else{
                    return false;
                }
            }
        }
        return true;
    }
}