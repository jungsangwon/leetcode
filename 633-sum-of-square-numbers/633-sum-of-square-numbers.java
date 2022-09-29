class Solution {
    public boolean judgeSquareSum(int c) {
        HashSet<Integer> hashSet = new HashSet<>();
        int limit = (int)Math.sqrt(c);
        for(int i=0; i<=limit; i++){
            hashSet.add(i*i);
        }
        for(int i : hashSet){
            if(hashSet.contains(c-i)){
                return true;
            }
        }
        return false;
    }
}