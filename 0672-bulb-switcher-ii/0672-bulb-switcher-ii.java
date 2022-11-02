class Solution {
    public int flipLights(int n, int presses) {
        if(presses==0){
            return 1;
        }
        HashSet<Integer> result = new HashSet<>();
        int limit = Math.min(6,n);
        int first = 0;
        int[] press = new int[4];
        for(int i=0; i<limit; i++){
            first = first << 1;
            first |= 1;
            for(int j=0; j<4; j++){
                press[j] = press[j] << 1;
            }
            press[0] |=1;
            if(i%2==0){
                press[1] |=1;
            }else{
                press[2] |=1;
            }
            if(i%3==0){
                press[3] |=1;
            }
        }
        HashSet<Integer> hashSet = new HashSet<>();
        hashSet.add(first);
        int time = Math.min(4,presses);
        for(int i=1; i<=time; i++){
            HashSet<Integer> next = new HashSet<>();
            for(int num : hashSet){
                for(int j=0; j<4; j++){
                    int tmp = num ^ press[j];
                    next.add(tmp);
                }
            }
            if(i+1 != presses){
                result.addAll(next);
            }
            hashSet = next;
        }
        
        
        
        return result.size();
    }
}